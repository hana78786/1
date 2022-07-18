alter table department
add (lname varchar2(20));

alter table department
modify lname varchar2(21);

alter table demartment
drop column lname;

desc department;

alter table department
rename column locaion_name to location_name;

alter table department
add (lname varchar2(20));

alter table department
drop column lname;

show user;

desc employee;


desc department;

create table member(
member_id varchar2(20),
member_pwd varchar2(30),
memeber_age number,
member_date date);

alter table member rename to worker;

drop table worker;


insert into employee values(900,'장채현', '901123-2080503','jang_ch@kh.co.kr','01055569512','D1','J8','S3',430000,
0.2,'200',sysdate,null,default);

select * from employee;
select emp_name from employee;

select dept_id, dept_title from department;

update DEPARTMENT
set DEPT_TITLE = '전략기획팀'
where dept_id='D9';

select * from department;

delete from employee
where emp_name = '장채현';


select emp_id, emp_name, salary from employee;

SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE,
JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE
, ENT_DATE, ENT_YN
FROM EMPLOYEE;

select emp_name, salary , salary*12 as "연봉",'원' "단위"
from employee;

-- 1. JOB테이블에서 JOB_NAME의 정보만 출력되도록 하시오

select job_name from job;

-- 2. DEPARTMENT테이블의 내용 전체를 출력하는 SELECT문을 작성하시오

select * from department;

-- 3. EMPLOYEE 테이블에서 이름(EMP_NAME),이메일(EMAIL),
-- 전화번호(PHONE),고용일(HIRE_DATE)만 출력하시오

select emp_name,email,phone,hire_date from employee;

-- 4. EMPLOYEE 테이블에서 고용일(HIRE_DATE) 이름(EMP_NAME),월급(SALARY)를 출력하시오

select hire_date, emp_name,salary from employee;

-- 5. EMPLOYEE 테이블에서 월급(SALARY)이 2,500,000원이상인 사람의 
-- EMP_NAME 과 SAL_LEVEL을 출력하시오 

select  emp_name, sal_level from employee
where salary>=2500000;

-- (힌트 : >(크다) , <(작다) 를 이용)
-- (힌트 : AND(그리고) , OR (또는))

-- 6. EMPLOYEE 테이블에서 월급(SALARY)이 350만원 이상이면서 
-- JOB_CODE가 'J3' 인 사람의 
-- 이름(EMP_NAME)과 전화번호(PHONE)를 출력하시오
-- (힌트 : AND(그리고) , OR (또는))

SELECT emp_name, phone from EMPLOYEE
where job_code='J3' and salary >= 3500000;


-- 간단 실습 문제
--1. EMPLOYEE 테이블에서 이름,연봉, 총수령액(보너스포함), 
-- 실수령액(총 수령액-(월급*세금 3%*12))
--가 출력되도록 하시오

select emp_name "이름", salary*12 as "연봉", salary*bonus+salary*12 "총수령액(보너스포함)",
salary*bonus+salary*12-(salary*0.03*12) "실수령액"
from employee;

--2. EMPLOYEE 테이블에서 이름, 근무 일수를 출력해보시오 
--(SYSDATE를 사용하면 현재 시간 출력)
select hire_date, ent_date, ent_yn from employee;

select emp_name "이름" ,Sysdate - hire_date "근무일수", (Sysdate - hire_date)/365 "근속연수"
from employee;
 


--3. EMPLOYEE 테이블에서 20년 이상 근속자의 이름,월급,보너스율를 출력하시오.
select emp_name "이름" ,salary "월급", bonus "보너스율"
from employee
where (Sysdate - hire_date)/365 >= 20;


-- DISTINCT 
-- 컬럼에 포함된 중복 값을 한번씩만 표시하고자 할 때 사용
select distinct Job_code from employee;


-- 논리연산자(AND, OR)
-- 부서코드가 D6이고 급여를 2,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오.
select EMP_name "이름", Dept_code "부서코드",salary "급여"
from employee
where dept_code = 'D6' and salary>=2000000;


-- 부서코드가 D5 또는 급여를 3,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오
select emp_name, dept_code,salary
from employee
where dept_code ='D5' or salary >=3000000;


-- 연결 연산자(||)
-- 여러 컬럼을 하나의 컬럼인 것 처럼 연결하거나 컬럼과 리터럴 연결

select EMP_NAME || dept_code "이름부서", SALARY || '원'
from employee;


-- 비교연산자 ( >, >=, <, <=, .... )
-- BETWEEN A AND B
-- 급여를 3500000원 이상 받고 6000000원 이하로 받는 직원의 이름과 급여
-- 조회하시오

select EMP_name, salary
from employee
where salary between 3500000 and 6000000;


-- BETWEEN AND
-- EMPLOYEE 테이블에서 고용일이 90/01/01 ~ 01/01/01인 사원의
-- 전체 내용을 출력하시오

select * from employee
where hire_date between '90/01/01' and '01/01/01';


select emp_name, salary
from employee
where emp_name not like '%전%';

select emp_name, salary
from employee
where emp_name like '전__';

-- 실습문제
--1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오
select emp_name
from employee 
where emp_name like '__연';

--2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를
--출력하시오
select emp_name, phone
from employee
where phone not like'010%';

--3. EMPLOYEE 테이블에서 메일주소의 's'가 들어가면서, DEPT_CODE가 D9 또는 D6이고
--고용일이 90/01/01 ~ 01/12/01이면서, 월급이 270만원이상인 사원의 전체 정보를 출력하시오
select * from employee
where (hire_date between '90/01/01' and '01/12/01') and salary>=2700000 and email like '%s%'
and (dept_code = 'D9' or dept_code = 'D6');

--4. EMPLOYEE 테이블에서 EMAIL ID 중 @ 앞자리가 5자리인 직원을 조회한다면?
select * from employee
where email like '_____@%';

--5. EMPLOYEE 테이블에서 EMAIL ID 중 '_' 앞자리가 3자리인 직원을 조회한다면?
select emp_name from employee
where email like '___#_%' escape '#';

select * from employee
where dept_code in('D6','D9'); --or 대신

select bonus, manager_id
from employee
where bonus is null;

select bonus, manager_id
from employee
where bonus is not null;

-- 1. 관리자(MANAGER_ID)도 없고 부서 배치(DEPT_CODE)도 받지 않은 
-- 직원의 이름 조회
select emp_name from employee
where manager_id is null and dept_code is null;

-- 2. 부서배치를 받지 않았지만 보너스를 지급하는 직원 전체 정보 조회

select * from employee
where dept_code is null and bonus is not null;

-- 정렬 ORDER BY
-- SELECT한 컬럼에 대해 정렬을 할 때 사용하는 구문
-- SELECT 구문의 가장 마지막에 작성(☆) 실행순서도 가장 마지막에 수행됨
--          ASC : 오름차순 정렬, DESC : 내림차순 정렬
-- DATE asc - > 옛날 -최신 desc -최신 ->옛날
-- NULL asc - null나중 desc -  null먼저

select emp_name, salary, hire_date, bonus from employee
order by bonus, hire_date asc; -- asc 오름차순 desc 내림차순

-- SELECT 실행 순서
-- FROM - WHERE - (GROUP BY - HAVING) - SELECT - ORDER BY


