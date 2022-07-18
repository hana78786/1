--@실습문제 
--1. 윤은해와 급여가 같은 사원들을 검색해서, 사원번호,사원이름, 급여를 출력하라.

select emp_name, emp_id, salary from employee e
where salary=(select salary from employee where emp_name = '윤은해')
and emp_name != '윤은해';

--2. employee 테이블에서 기본급여가 제일 많은 사람과 제일 적은 사람의 정보를 
-- 사번, 사원명, 기본급여를 나타내세요.

select * from employee a
where not exists (select 1 from employee where salary> a.salary)
or not exists (select 1 from employee where salary< a.salary);



--3. D1, D2부서에 근무하는 사원들 중에서
--기본급여가 D5 부서 직원들의 '평균월급' 보다 많은 사람들만 

select * from employee
where dept_code in ('D1','D2') and salary>
(select avg(salary) from employee where dept_code ='D5');

select avg(salary) from employee where dept_code ='D5';


-- 서브쿼리 실습 문제
--문제1
--기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오

select emp_name, dept_code, salary from employee
where dept_code = (select dept_id from department where dept_title = '기술지원부');


--문제2
--기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오

select emp_name, dept_code, salary from employee a
where  dept_code = (select dept_id from department where dept_title = '기술지원부')
and
not exists (select * from employee where salary > a.salary  and dept_code = 'D8');


--문제3
--매니저가 있는 사원중에 월급이 전체사원 평균을 넘고 
--사번,이름,매니저 이름,월급(만원단위부터)을 구하시오
 --* 단, JOIN을 이용하시오
 
 select a.emp_id, a.emp_name, b.emp_name "매니저",salary/10000||'만원' "월급" from employee a
 join (select emp_name, emp_id from employee)b
 on a.manager_id = b.emp_id
 where manager_id is not NULL and salary >
 (select avg(salary) from employee);

--문제4
--부서 별 각 직급마다 급여 등급이 가장 높은 직원의 이름, 직급코드, 급여, 급여등급 조회

select dept_code, emp_name, job_code, salary, sal_level from employee a
where not exists (select * from employee where salary> a.salary
and job_code = a.job_code and dept_code = a.dept_code)
order by dept_code;


--문제5
--부서별 평균 급여가 2200000 이상인 부서명, 평균 급여 조회
--단, 평균 급여는 소수점 버림

select (select dept_title from department where dept_id = a.dept_code) , floor(avg(salary)) from employee a
group by dept_code
having (select dept_title from department where dept_id = a.dept_code) is not null and floor(avg(salary)) >= 2200000;


--문제6
--직급의 연봉 평균보다 적게 받는 여자사원의
--사원명,직급코드,부서코드,연봉을 이름 오름차순으로 조회하시오
--연봉 계산 => (급여+(급여*보너스))*12    
-- 사원명,직급명,부서명,연봉은 EMPLOYEE 테이블을 통해 출력이 가능함 
-- 직급별 연봉

select emp_name, job_code, dept_code, salary+(salary*nvl(bonus,0))*12 "연봉" from employee a
where substr(emp_no,8,1) in (2,4) and salary+(salary*nvl(bonus,0))*12 <
(select avg(salary+(salary*nvl(bonus,0))*12) from employee where job_code=a.job_code group by job_code) 
order by 1;
