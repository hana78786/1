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

