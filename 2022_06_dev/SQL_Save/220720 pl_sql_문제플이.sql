
    --예제 2)
--사원번호를 입력 받아서 사원의 사원번호,이름,급여,입사일을 출력하시오

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vhire employee.hire_date%type;

begin
select emp_id, emp_name, salary, hire_date
into vid, vname, vsal, vhire
from employee
where emp_id = '&사번';

dbms_output.put_line('사번'||vid||'이름'||vname||'급여'||vsal||'입사일'||vhire);

end;
/


--문제1)
--사원 번호를 입력 받아서 받은 사원의 사원번호,이름,부서코드,부서명을 출력하도록 하시오

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode EMPLOYEE.DEPT_CODE%type;
vdtitle DEPARTMENT.DEPT_TITLE%type;
begin
select
emp_id, emp_name, dept_code, 
(select dept_title from department where a.dept_code = dept_id)
into
vid, vname, vdcode, vdtitle
from
employee a
where
emp_id = '&사번';

dbms_output.put_line('사번'||vid||'이름'||vname||'부서코드'||vdcode||'부서명'||vdtitle);

end;
/


    
    
   /* ## 간단 실습 1 ##
-- 해당 사원의 사원번호를 입력시
-- 이름,부서코드,직급코드가 출력되도록 PL/SQL로 만들어 보시오 
*/


declare
vname employee.emp_name%type;
vdcode EMPLOYEE.DEPT_CODE%type;
vjcode EMPLOYEE.JOB_CODE%type;

begin
select
emp_name, dept_code, job_code
into
vname, vdcode, vjcode
from
EMPLOYEE
where
emp_id = &사번;

dbms_output.put_line(vname||vdcode||vjcode);

end;
/
    


/*
## 간단 실습 2 ##
-- 해당 사원의 사원번호를 입력시
-- 이름,부서명,직급명이 출력되도록 PL/SQL로 만들어 보시오
*/

declare
vname employee.emp_name%type;
vdtitle department.dept_title%type;
vjname job.job_name%type;

begin

select
emp_name, dept_title, job_name
into
vname, vdtitle, vjname

from employee a

left join department
on dept_id = dept_title
left join JOB
using (job_code)
where
emp_id = '&사번';

dbms_output.put_line(vname||vdtitle||vjname);



end;
/

   
   
   --예제) 사원번호를 가지고 사원의 사번,이름,급여,보너스율을 출력하고
-- 보너스율이 없으면 '보너스를 지급받지 않는 사원입니다' 를 출력하시오

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vbo employee.bonus%type;

begin
select emp_id, emp_name, salary, bonus
into vid, vname, vsal, vbo

from employee
where
emp_id = '&사번';

dbms_output.put_line(vid||vname||vsal);
if(vbo is null)
then dbms_output.put_line('보너스 없음');
else dbms_output.put_line(vbo*100||'%');
end if;
end;
/


   
   --예시) 사원 코드를 입력 받았을때 사번,이름,직급코드,직급명,소속 값을 출력하시오
    --그때,소속값은 J1,J2 는 임원진,그외에는 일반직원으로 출력되게 하시오
declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vjcode employee.job_code%type;
vjname job.job_name%type;
vin varchar2(20);

begin

select
emp_id, emp_name, job_code, job_name
into
vid, vname, vjcode,vjname
from
employee a
left join job
using (job_code)
where emp_id = '&사번';

if(vjcode in ('J1','J2'))
then vin:= '임원진';
else vin:= '일반사원';
end if;

dbms_output.put_line(vid||vname||vjcode||vjname||vin);


end;
/

    
    

--## 간단 실습 1 ##
-- 사원 번호를 가지고 해당 사원을 조회
-- 이때 사원명,부서명 을 출력하여라.
-- 만약 부서가 없다면 부서명을 출력하지 않고,
-- '부서가 없는 사원 입니다' 를 출력하고
-- 부서가 있다면 부서명을 출력하여라.

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdtitle department.dept_title%type;
vdcode employee.dept_code%type;

begin
select
emp_id, emp_name, dept_title, dept_code
into
vid, vname, vdtitle, vdcode
from
employee a
left join department
on dept_code=dept_id
where
emp_id = '&사번';

if(vdcode is null)
then vdtitle:= '부서없음';
end if;

dbms_output.put_line(vid||vname||vdtitle);

end;
/


   
   
   --## 실습 문제 ##
--사번을 입력 받은 후 급여에 따라 등급을 나누어 출력하도록 하시오 
--그때 출력 값은 사번,이름,급여,급여등급을 출력하시오

--0만원 ~ 99만원 : F
--100만원 ~ 199만원 : E
--200만원 ~ 299만원 : D
--300만원 ~ 399만원 : C
--400만원 ~ 499만원 : B
--500만원 이상(그외) : A

declare
vid  employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vsal_level char(1);

begin
select emp_id, emp_name,salary
into vid, vname, vsal
from employee
where emp_id = '&사번';

case floor(vsal/1000000)
when 0 then vsal_level := 'f';
when 1 then vsal_level := 'e';
when 2 then vsal_level := 'd';
when 3 then vsal_level := 'c';
when 4 then vsal_level := 'b';
else vsal_level := 'a';
end case;

dbms_output.put_line (vid||vname||vsal||vsal_level);

end;
/



    

--ex) 200
--사번 : 200
--이름 : 선동일
--급여 : 8000000
--등급 : A


-- 예시 ) 1~3까지의 수를 입력받고 1을 입력받으면 	'1을 입력하였습니다',2를 입력 받으면 '2를 입력하였습니다',
-- 3을 입력받으면 '3을 입력하였습니다'를 출력하시오. 그외 숫자 입력시 잘못 입력하였습니다를 출력

declare
no  number;
begin
no := &숫자;
case 
when  no between 1 and 3 then dbms_output.put_line(no);
else dbms_output.put_line('잘못입력하셨습니다');
end case;


end;
/



        
-- 예제) 1~10 까지 반복하여 TEST1 테이블에 데이터가 저장되게 하시오
-- TEST1(BUNHO,B_DATE)
drop table test1;
create table test1(
bunho number,
b_date date);


begin

for n in 1..10 loop
insert into test1 values (n,sysdate);
end loop;

end;
/
select * from test1;



-- 실습문제
-- 사용자로부터 2~9사이의 수를 입력받아 구구단 출력하시오

declare 
no number;
begin
no := &no;
for n in 2..9 loop
dbms_output.put_line(no*n);
end loop;
end;
/

declare 
no number;
n number := 1;
begin
no := &no;
if(no between 1 and 9)
then

while n<=9 loop

if(n=1) then dbms_output.put_line(no*n);
end if;
n:= n+1;
continue when not mod(n,2)=1;
dbms_output.put_line(no*n);

end loop;

else 
dbms_output.put_line('입력오류');

end if;
end;
/


-- 범위 내 숫자가 아니면 다시 입력받아서 구구단 진행




-- TOP N 분석을 위한 PL/SQL을 만들어라
-- '급여' / '보너스' / '입사일'
-- 무조건 1위~5위 까지를 출력하는 PL/SQL을 만들어라.

declare 
vname employee.emp_name%type;
vsal employee.salary%type;
vbonus employee.bonus%type;
vhire employee.hire_date%type;
vnum number;
a varchar2(30);

begin
for n in 1..5 loop
a := '&순위';


if (a='월급') then
select 랭크, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,RANK() OVER (ORDER BY
salary DESC)"랭크" from employee order by 1)
where 랭크 = n;

dbms_output.put_line('------'||a||n||'위-----');
if(vnum = n) then
dbms_output.put_line('이름 '||vname);
dbms_output.put_line('급여 '||vsal);
end if;
 
 elsif (a='보너스') then
 select 랭크, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,DENSE_RANK() OVER (ORDER BY
bonus desc,emp_name desc)"랭크" from employee where bonus is not null)
where 랭크 = n;
dbms_output.put_line('------'||a||n||'위-----');
if(vnum = n) then
dbms_output.put_line('이름 '||vname);
dbms_output.put_line('보너스 '||vbonus*100||'%');
end if;

elsif (a='입사일') then
 select 랭크, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,RANK() OVER (ORDER BY
hire_date ASC)"랭크" from employee order by 1)
where 랭크 = n;
dbms_output.put_line('------'||a||n||'위-----');
if(vnum = n) then
dbms_output.put_line('이름 '||vname);
dbms_output.put_line('입사일 '||vhire);
end if;

end if;

end loop;
end;
/

select salary, bonus, hire_date, emp_name,DENSE_RANK() OVER (ORDER BY
bonus, salary desc)"랭크" from employee where bonus is not null;


--no_data_found
--1. 급여, 이름, 이메일 출력

declare 
name employee.emp_name%type;

begin
select emp_name
into name
from employee
where emp_name = '&name';

dbms_output.put_line(name);

exception
 when no_data_found then dbms_output.put_line('자료없음');


end;
/



--2. 이미 존재하는 사번에 이용자를 추가할때 dup_val_on_index



begin

insert into employee (emp_id,emp_name,emp_no,job_code,sal_level)
values ('200', '이용자','12345','j1','as');

exception
 when dup_val_on_index then dbms_output.put_line('데이터중복');
end;
/

set serveroutput on;

