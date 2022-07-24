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
