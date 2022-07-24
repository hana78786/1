create table emp_dup
as select * from employee;

create procedure del_all_emp
is
begin
    delete from emp_dup;
    commit;
end;
/
execute del_all_emp;
set serveroutput on;

delete emp_dup
where emp_id = 212;

ROLLBACK;

select * from emp_dup;

drop table emp_dup;

create procedure proc_del_emp_id (p_emp_id emp_dup.emp_id%type)
is
begin
    delete emp_dup where emp_id = p_emp_id;
    commit;
    dbms_output.put_line(p_emp_id||'�� ����� �����߽��ϴ�');
end;
/

execute proc_del_emp_id(&�����ȣ);

create procedure proc_select_emp_id(
p_emp_id in employee.emp_id%type,
p_emp_name out employee.emp_name%type,
p_salary out employee.salary%type,
p_bonus out employee.bonus%type)
is
begin 
    select emp_name,salary, nvl(bonus,0)
    into p_emp_name,p_salary,p_bonus
    from employee
    where emp_id=p_emp_id;
end;
/

var name varchar2(20);
var b_salary number;
var b_bonus number;

exec proc_select_emp_id('200', :name, :b_salary, :b_bonus);

print name 
print b_salary;
print b_bonus;
    
    
-- �ǽ�1) JOB���̺� INSERT�� �� �� ���� �����ڵ尡 ������ UPDATE�� �����ϰ� ������
-- �״�� INSERT�� �ϴ� PROCEDURE�� �ۼ��Ͻÿ�.
-- 1�ܰ�. JOB���̺� INSERT�ϴ� ���ν����� �ۼ�
-- 2�ܰ�. �䱸���׿� �°� ���ǹ��� �߰��Ͽ� ����

create table copy_job 
as select * from job;

drop table copy_job;
create or replace procedure proc_job_up (
v_job_code job.job_code%type,
v_job_name job.job_name%type)
is
n_count number;
begin
    select count(*)
    into  n_count
    from copy_job
    where job_code = v_job_code;
    
    if(n_count>0)
    then update copy_job
    set job_name = v_job_name
    where job_code = v_job_code;
    dbms_output.put_line(v_job_code||'�� '||v_job_name||'���� �����Ͽ����ϴ�');
    else
    insert into copy_job values(v_job_code, v_job_name);
    dbms_output.put_line(v_job_code||'�� '||v_job_name||'���� �߰��Ͽ����ϴ�');
    end if;
end;
/
    
    exec proc_job_up('J8','����');
    
    set serveroutput on;
    
    select * from copy_job;
    
    delete copy_job
    where job_name ='����';
    
alter table copy_job
add unique (job_code);

create or replace function make_hpone(p_str varchar2)
return varchar2
is
hpone varchar2(500);

begin
 hpone := 'd'||p_str||'b';
 return hpone;

end;
/

var result varchar2;
exec : result := make_hpone('(*>?<*)');
print result;


--@�ǽ�����
--1.�����ȣ�� �Է¹޾Ƽ� ������ �����ϴ� �����Լ� FN_GET_GENDER�� �����ϰ�, �����ϼ���.
 create or replace function fun_gen(f_emp_id varchar2)
 return varchar2
 is
 gender varchar2(20);
 begin
 select decode
 (substr(emp_no,8,1),'1','��','��')
 into gender
 from employee
 where emp_id=f_emp_id;
 
 return gender;
 end;
 /

var result varchar2(20);

exec : result := fun_gen('&���');
print result;

--2. ����ڷκ��� �Է¹��� ��������� �˻��Ͽ� �ش����� ���޸��� ��� ���� �����Լ�
-- FN_GET_JOB_NAME�� �ۼ��ϼ���. (�ش����� ���ٸ� '�ش�������' ���)


create or replace function fn_in_job(f_emp_id varchar2)
return varchar2
is
f_job job.job_name%type;

begin

select job_name
into f_job 
from job
left join employee
using (job_code)
where emp_id = f_emp_id
group by job_name;

return f_job;

exception
when no_data_found then return('�ش�������');
end;
/

exec : result := fn_in_job('&���');
print result;

--3. ������� Ư���󿩱�(���ʽ�)�� �����Ϸ��� �ϴµ�, �Ի��ϱ������� ���� �����Ϸ� �Ѵ�.
-- �Ի��ϱ��� 10���̻��̸� 150%, 3���̻� 10��̸��̸� 125%, 3��̸��̸� 50%�� ������.
-- �����Լ��� : FN_BONUS_CALC, FN_GET_WORKING_DAYS(HIRE_DATE)
-- ��ȸ�÷� : ���, �����, �Ի���, �ٹ��Ⱓ(~�� ~����), ���ʽ��ݾ�

create or replace function fn_bonus (f_emp_id varchar2)
return varchar2
is
f_emp_name employee.emp_name%type;
f_hire employee.hire_date%type;
f_sys_hire varchar2(50);
f_bonus number;
f_ent employee.ent_yn%type;
v_result varchar2(200);
begin
select emp_name, hire_date, (
select floor((sysdate-hire_date)/365)||'��'||floor(((sysdate-hire_date)/360-floor((sysdate-hire_date)/365))*10)||'����'
from employee
where emp_id = f_emp_id
),
ent_yn, 
(case 
when floor((sysdate-hire_date)/365) >=10 then 150
when floor((sysdate-hire_date)/365) between 3 and 9 then 125
when floor((sysdate-hire_date)/365) between 0 and 2 then 50
end)/100*salary

into f_emp_name, f_hire, f_sys_hire, f_ent, f_bonus
from employee
where emp_id = f_emp_id;

if (f_ent = 'Y')
then v_result := '����� ����Դϴ�.';
else
v_result := f_emp_id||' '|| f_emp_name ||' '|| f_hire ||' '||f_sys_hire||' '||f_bonus;
end if;
return v_result;
end;
/

var result varcha2;
exec :result:= fn_bonus(&���);
print result;

select * from employee where ent_yn='Y';

--@�ǽ�����
--�����μ����̺��� DEPT_ID, DEPT_TITLE�� ������ DEPT_COPY�� �����Ѵ�.
--DEPT_ID �÷� PK�߰�. DEPT_ID �÷� Ȯ�� CHAR(3)
--DEPT_COPY�� �����ϴ� ���ν��� PROC_MAN_DEPT_COPY�� �����Ѵ�.
-- ù��° ���ڷ� ����FLAG�� UPDATE/DELETE�� �޴´�.
-- UPDATE��, �����Ͱ� �������� ������ INSERT, �����Ͱ� �����ϸ�, UPDATE
-- DELETE��, �ش�μ��� ����� �����ϴ����� �˻��ؼ�, �����ϸ�, ���޼����� �Բ� ���������. �׷��� ������, ����.
-- ���ν����� �Ű������� �⺻���� �����ϸ�, ����������.

create table dept_copy
as select dept_id, dept_title from department;

alter table dept_copy
modify dept_id char(3) primary key;

create or replace procedure proc_man_dept_copy(up_or_de varchar2, v_dept_id dept_copy.dept_id%type, v_dept_title dept_copy.dept_title%type default null )
is
v_count number;

begin
if(up_or_de = 'update')
    then select count(*)
    into v_count from dept_copy where dept_id = v_dept_id;
    if(v_count>0)
        then update dept_copy
            set dept_title = v_dept_title
            where dept_id = v_dept_id;
            dbms_output.put_line(v_dept_id ||'�� ' || v_dept_title ||'����');
    else
        insert into dept_copy values (v_dept_id, v_dept_title);
        dbms_output.put_line(v_dept_id ||'�� ' || v_dept_title ||'����');
        end if;
        

elsif(up_or_de='delete')
    then select count(*)
    into v_count from employee 
    where dept_code = v_dept_id;
 
    
    if(v_count>0)
    then dbms_output.put_line('�� �μ����� ����� �ֽ��ϴ�');
    else
    delete dept_copy
    where dept_id = v_dept_id;
    dbms_output.put_line('�� �μ��� �����߽��ϴ�');
    end if;
    
    end if;
end;
/

select * from dept_copy;

exec proc_man_dept_copy ('delete', 'D9','abd');

set SERVEROUTPUT ON;



--���� ��� ���̺� ���ο� �����Ͱ� ������ "���Ի���� �Ի��Ͽ����ϴ�' ����ϱ�

create or replace trigger trg_emp_new
    after
    insert on employee
    for each row
  begin 
    dbms_output.put_line('���Ի���� �Ի��߽��ϴ�');
    end;
    /
    
    select * from employee;
    
    insert into employee values ('251','�쿵��','999999-123456','u0u@gim.bab','01000000000',null,'J0','S0',1000000,0.5,null,'220724',null,'N');
    commit;
    
    delete employee
    where emp_name = '�쿵��';
    
    -- ����2. �޿����� ���������� ȭ�鿡 ����ϴ� Ʈ���Ÿ� �����غ���
    
    create table emp_sal
   as select * from employee;
    
    create or replace trigger trg_sal_change
    before 
    update on emp_sal
    for each row
    begin
    dbms_output.put_line('������ ' || :old.salary || ' ������ '|| :new.salary);
    end;
    /
    
    update emp_sal
    set salary = '300000'
    where emp_id = 212;
    commit;
    
--����3 ��ǰ ���̺��� �������ϰ� ��ǰ �԰�� ��ǰ��� ���̺� ��ġ�� �����غ���
-- Ʈ���Ÿ� ����� ��� ������ �ڵ����� ��� �Էµǵ��� �غ���

create table prodouct(
pcode number primary key,
pname varchar2(20),
brand varchar2(30),
price number,
stock number default 0);

create table pro_io(
icode number primary key,
pcode number,
pdate date,
amount number,
status varchar2(10) check(status in ('�԰�','���')),
constraint fk_pro_io foreign key (pcode) references prodouct(pcode));

create sequence seq_pro;
create sequence seq_pro_io;

--Ʈ���� ����
--�԰�, ���� �� procudt ���̺� stock�� ���� ������Ʈ�� �Ǿ�� ��
--insert stock+1 �԰�
--��� stock-1

create or replace trigger trg_pro_sto
    after
    insert on pro_io
    for each row
    
begin
    if :new.status = '�԰�'
    then update prodouct set stock = stock+ :new.amount where pcode = :new.pcode;
    else update prodouct set stock = stock - :new.amount where pcode = :new.pcode;
    end if;
end;
/

insert into prodouct values (seq_pro.nextval,'������','����',200000,default);
insert into prodouct values (seq_pro.nextval,'������','�Ｚ',200000,default);

select * from prodouct;
insert into pro_io values (seq_pro_io.nextval,1,sysdate,10,'�԰�');
insert into pro_io values (seq_pro_io.nextval,2,sysdate,40,'�԰�');
insert into pro_io values (seq_pro_io.nextval,2,sysdate,5,'���');


--@�ǽ�����
--1. EMPLOYEE���̺��� ����ڰ����� ������ ���̺� TBL_EMP_QUIT���� �Ϸ��� �Ѵ�.
--������ ���� TBL_EMP_JOIN, TBL_EMP_QUIT���̺��� �����ϰ�, TBL_EMP_JOIN���� DELETE�� �ڵ����� ����� �����Ͱ� TBL_EMP_QUIT�� INSERT�ǵ��� Ʈ���Ÿ� �����϶�.

create table emp_join
as select * from employee;

alter table emp_qu
drop column ent_date;


create table emp_qu
as select * from employee where 1=0;
select * from emp_qu; 
create or replace trigger trg_emp_qu
    after
    delete on emp_join
    for each row
    
    begin
    insert into emp_qu values (:old.emp_id, :old.emp_name, :old.emp_no, :old.email, :old.phone,:old.dept_code, :old.job_code, :old.sal_level, :old.salary, :old.bonus, :old.manager_id, :old.hire_date);
    dbms_output.put_line(:old.emp_name||'���� ����߽��ϴ�');
    end;
    /
    
    delete emp_join
    where emp_id = 202;
    commit;
    
    
    

--TBL_EMP_JOIN ���̺� ���� : QUIT_DATE, QUIT_YN ����
    
    
    
--2. ������泻���� ����ϴ� emp_log���̺��� �����ϰ�, ������̺��� insert, update�� ���� ������ �űԵ����͸� ����ϴ� Ʈ���Ÿ� �����϶�.
--�α����̺�� emp_log : �÷� log_no(��������ü�κ��� ä����. pk), log_date(�⺻�� sysdate, not null), emp���̺��� ��� �÷�
--Ʈ���Ÿ� trg_emp_log

create table emp_log
as select * from emp_join where 1=0;


alter table emp_log
add  log_date date default sysdate not null;

create sequence sqe_log
start with 1
increment by 1
nomaxvalue
nocycle
nocache;


create or replace trigger trg_emp_log
    before
    insert or update on emp_join
    for each row
begin
    insert into emp_log values (:new.emp_id, :new.emp_name, :new.emp_no, :new.email, :new.phone,:new.dept_code, 
    :new.job_code, :new.sal_level, :new.salary, :new.bonus, :new.manager_id, :new.hire_date,sqe_log.nextval,default);
    dbms_output.put_line('���������͸� �Է��߽��ϴ�.');
    
    end;
    /
    
    insert into emp_join values ('254','abc����','000000-00000','abc@cac','0001111111','D9','J9','S2',300000,0.5,200,sysdate);
    update emp_join
    set emp_id= 251
    where emp_id=250;
    commit;
    select * from emp_log;