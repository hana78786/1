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

--2. 사용자로부터 입력받은 사원명으로 검색하여 해당사원의 직급명을 얻어 오는 저장함수
-- FN_GET_JOB_NAME를 작성하세요. (해당사원이 없다면 '해당사원없음' 출력)


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
when no_data_found then return('해당사원없음');
end;
/

exec : result := fn_in_job('&사번');
print result;

--3. 사원에게 특별상여금(보너스)를 지급하려고 하는데, 입사일기준으로 차등 지급하려 한다.
-- 입사일기준 10년이상이면 150%, 3년이상 10년미만이면 125%, 3년미만이면 50%를 지급함.
-- 저장함수명 : FN_BONUS_CALC, FN_GET_WORKING_DAYS(HIRE_DATE)
-- 조회컬럼 : 사번, 사원명, 입사일, 근무기간(~년 ~개월), 보너스금액

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
select floor((sysdate-hire_date)/365)||'년'||floor(((sysdate-hire_date)/360-floor((sysdate-hire_date)/365))*10)||'개월'
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
then v_result := '퇴사한 사원입니다.';
else
v_result := f_emp_id||' '|| f_emp_name ||' '|| f_hire ||' '||f_sys_hire||' '||f_bonus;
end if;
return v_result;
end;
/

var result varcha2;
exec :result:= fn_bonus(&사번);
print result;

select * from employee where ent_yn='Y';

--@실습문제
--기존부서테이블의 DEPT_ID, DEPT_TITLE만 복제한 DEPT_COPY를 생성한다.
--DEPT_ID 컬럼 PK추가. DEPT_ID 컬럼 확장 CHAR(3)
--DEPT_COPY를 관리하는 프로시져 PROC_MAN_DEPT_COPY를 생성한다.
-- 첫번째 인자로 동장FLAG값 UPDATE/DELETE를 받는다.
-- UPDATE시, 데이터가 존재하지 않으면 INSERT, 데이터가 존재하면, UPDATE
-- DELETE시, 해당부서에 사원이 존재하는지를 검사해서, 존재하면, 경고메세지와 함께 실행취소함. 그렇지 않으면, 삭제.
-- 프로시저의 매개변수에 기본값을 지정하면, 생략가능함.

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
            dbms_output.put_line(v_dept_id ||'에 ' || v_dept_title ||'수정');
    else
        insert into dept_copy values (v_dept_id, v_dept_title);
        dbms_output.put_line(v_dept_id ||'에 ' || v_dept_title ||'삽입');
        end if;
        

elsif(up_or_de='delete')
    then select count(*)
    into v_count from employee 
    where dept_code = v_dept_id;
 
    
    if(v_count>0)
    then dbms_output.put_line('이 부서에는 사원이 있습니다');
    else
    delete dept_copy
    where dept_id = v_dept_id;
    dbms_output.put_line('이 부서를 삭제했습니다');
    end if;
    
    end if;
end;
/

select * from dept_copy;

exec proc_man_dept_copy ('delete', 'D9','abd');

set SERVEROUTPUT ON;
