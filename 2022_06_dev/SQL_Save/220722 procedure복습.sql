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
    dbms_output.put_line(p_emp_id||'번 사원을 삭제했습니다');
end;
/

execute proc_del_emp_id(&사원번호);

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
    
    
-- 실습1) JOB테이블에 INSERT를 할 때 같은 직급코드가 있으면 UPDATE를 수행하고 없으면
-- 그대로 INSERT를 하는 PROCEDURE를 작성하시오.
-- 1단계. JOB테이블에 INSERT하는 프로시저를 작성
-- 2단계. 요구사항에 맞게 조건문을 추가하여 변경

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
    dbms_output.put_line(v_job_code||'를 '||v_job_name||'으로 수정하였습니다');
    else
    insert into copy_job values(v_job_code, v_job_name);
    dbms_output.put_line(v_job_code||'를 '||v_job_name||'으로 추가하였습니다');
    end if;
end;
/
    
    exec proc_job_up('J8','수습');
    
    set serveroutput on;
    
    select * from copy_job;
    
    delete copy_job
    where job_name ='인턴';
    
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


--@실습문제
--1.사원번호를 입력받아서 성별을 리턴하는 저장함수 FN_GET_GENDER를 생성하고, 실행하세요.
 create or replace function fun_gen(f_emp_id varchar2)
 return varchar2
 is
 gender varchar2(20);
 begin
 select decode
 (substr(emp_no,8,1),'1','남','여')
 into gender
 from employee
 where emp_id=f_emp_id;
 
 return gender;
 end;
 /

var result varchar2(20);

exec : result := fun_gen('&사번');
print result;

