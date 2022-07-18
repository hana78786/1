select job_name from job;

select * from department;

-- 1. JOB테이블에서 JOB_NAME의 정보만 출력되도록 하시오
select job_name from job;



-- 2. DEPARTMENT테이블의 내용 전체를 출력하는 SELECT문을 작성하시오
select * from department;



-- 3. EMPLOYEE 테이블에서 이름(EMP_NAME),이메일(EMAIL),
-- 전화번호(PHONE),고용일(HIRE_DATE)만 출력하시오

select emp_name,email,phone,hire_date from employee;




-- 4. EMPLOYEE 테이블에서 고용일(HIRE_DATE) 이름(EMP_NAME),월급(SALARY)를 출력하시오
select hire_date, emp_name, salary from employee;


-- 5. EMPLOYEE 테이블에서 월급(SALARY)이 2,500,000원이상인 사람의 
-- EMP_NAME 과 SAL_LEVEL을 출력하시오 

select emp_name, sal_level from employee
where salary>2500000;





-- (힌트 : >(크다) , <(작다) 를 이용)
-- (힌트 : AND(그리고) , OR (또는))

-- 6. EMPLOYEE 테이블에서 월급(SALARY)이 350만원 이상이면서 
-- JOB_CODE가 'J3' 인 사람의 
-- 이름(EMP_NAME)과 전화번호(PHONE)를 출력하시오
-- (힌트 : AND(그리고) , OR (또는))

select emp_name,phone from employee
where salary>=3500000 and job_code ='J3';



-- 간단 실습 문제
--1. EMPLOYEE 테이블에서 이름,연봉, 총수령액(보너스포함), 
-- 실수령액(총 수령액-(월급*세금 3%*12))
--가 출력되도록 하시오

select emp_name "이름", salary*12 "연봉", salary*bonus + salary*12 "총 수령액",
salary*bonus + salary*12 - (salary*0.03*12) "실수령액" from employee;


--2. EMPLOYEE 테이블에서 이름, 근무 일수를 출력해보시오 
--(SYSDATE를 사용하면 현재 시간 출력)

select emp_name "이름", sysdate-hire_date from employee;





--3. EMPLOYEE 테이블에서 20년 이상 근속자의 이름,월급,보너스율를 출력하시오.
select emp_name,salary,bonus from employee
where (sysdate-hire_date)/365 >=20;

-- 중복없이 잡코드 출력
select distinct job_code from employee
order by job_code;

-- 논리연산자(AND, OR)
-- 부서코드가 D6이고 급여를 2,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오.

select emp_name, dept_code from employee
where dept_code='D9' and salary >= 200000;


-- 부서코드가 D5 또는 급여를 3,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오
select emp_name, dept_code, salary from employee
where dept_code='D5' or salary >= 300000;


-- 비교연산자 ( >, >=, <, <=, .... )
-- BETWEEN A AND B ( A이상 B이하 )
-- 급여를 3500000원 이상 받고 6000000원 이하로 받는 직원의 이름과 급여
-- 조회하시오

select emp_name,salary from employee
where salary between 3500000 and 6000000;




-- BETWEEN AND
-- EMPLOYEE 테이블에서 고용일이 90/01/01 ~ 01/01/01인 사원의
-- 전체 내용을 출력하시오

select * from employee
where hire_date between '90/01/01' and '01/01/01';



-- 실습문제
--1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오
select emp_name from employee
where emp_name like '%연';


--2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를
--출력하시오

select emp_name,phone from employee
where phone not like '010%';



--3. EMPLOYEE 테이블에서 메일주소의 's'가 들어가면서, DEPT_CODE가 D9 또는 D6이고
--고용일이 90/01/01 ~ 01/12/01이면서, 월급이 270만원이상인 사원의 전체 정보를 출력하시오
select * from employee
where email like '%s%' and dept_code in ('D9','D6') and 
(hire_date between '90/01/01' and '01/12/01') and salary>=2700000;


--4. EMPLOYEE 테이블에서 EMAIL ID 중 @ 앞자리가 5자리인 직원을 조회한다면?
select * from employee
where email like '_____@%';


--5. EMPLOYEE 테이블에서 EMAIL ID 중 '_' 앞자리가 3자리인 직원을 조회한다면?

select * from employee
where email like '___#_%' ESCAPE '#';





-- 비교 연산자 ( IN )
-- 비교하려는 값 목록에 일치하는 값이 있으면 TRUE를 반환하는 연산자
-- EMPLOYEE 테이블에서 DEPT_CODE가 D9 또는 D6인 직원의 이름, 급여를 출력
-- 하시오.

select emp_name,salary from employee
where dept_code in ('D9','D6');




-- 비교 연산자 ( IS NULL / IS NOT NULL )
-- NULL 여부를 비교하는 연산자


-- 1. 관리자(MANAGER_ID)도 없고 부서 배치(DEPT_CODE)도 받지 않은 직원의 이름 조회

select emp_name from employee
where manager_id is null and dept_code is null;



-- 2. 부서배치를 받지 않았지만 보너스를 지급하는 직원 전체 정보 조회
select * from employee
where dept_code is null and bonus is not null;



-- 보너스를 기준으로 오름차순/ 내림차순 정렬하기
select emp_name from employee
order by bonus asc;

select emp_name from employee
order by bonus desc;


