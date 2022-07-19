-- ex) 급여 평균값 이상의 급여를 받는 사원을 검색하시오
select * from employee
where salary>= (select avg(salary) from employee);



-- ex) 전지연 직원의 관리자 이름을 출력하여라.

select emp_name from employee a
where emp_id = (select manager_id from employee
where emp_name ='전지연');



--@실습문제 
--1. 윤은해와 급여가 같은 사원들을 검색해서, 사원번호,사원이름, 급여를 출력하라.
select * from employee 
where salary = (select salary from employee where emp_name = '윤은해') and
emp_name != '윤은해';




--2. employee 테이블에서 기본급여가 제일 많은 사람과 제일 적은 사람의 정보를 
-- 사번, 사원명, 기본급여를 나타내세요.

select * from employee a where
salary = (select max(salary) from employee) or
not exists (select 1 from employee where a.salary>salary);



--3. D1, D2부서에 근무하는 사원들 중에서
--기본급여가 D5 부서 직원들의 '평균월급' 보다 많은 사람들만 
--부서번호, 사원번호, 사원명, 월급을 나타내세요.

select * from employee 
where salary > (
select avg(salary) from employee where dept_code = 'D5');

/*
select dept_code from employee
where emp_name in ('송종기', '박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서에 사원 출력

*/

select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송중기','박나라'));



/*
select dept_code from employee
where emp_name in ('송종기', '박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서외의 사원 출력

*/

select * from employee
where dept_code not in (select dept_code from employee where emp_name in ('송중기','박나라'));



select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기','박나라'));




--3. 직급이 J1, J2, J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균
-- join으로 활용!!

select dept_code, emp_name, salary, 
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code)"부서별급여"
 from employee a
where job_code not in ('J1','J2','J3') and salary>
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code);

select a.dept_code, emp_name, salary from employee e
join (select dept_code, round(avg(salary))"평균" from employee group by dept_code)a
on a.dept_code = e.dept_code
where job_code not in ('J1','J2','J3') and salary> 평균;

select e.dept_code, emp_name, salary from employee e 
join (select dept_code, round(avg(salary))"평균" from employee group by dept_code)a
on e.dept_code = a.dept_code
where job_code not in ('J1','J2','J3') and salary > "평균";


/*select*from(인라인뷰)
where 성별 = "남"  --  이름 성별 출력*/

select * from 
(select emp_name, decode(substr(emp_no,8,1),1,'남',3,'남','여')"성별" from employee)
where 성별 = '남';

-- rownum을 이용하여 랭킹 5 구하기
--from절에 인라인뷰 사용

select rownum, emp_name, salary from (select emp_name, salary from employee order by salary)
where rownum between 1 and 9;


/*서브쿼리를 이용한 인서트해보기*/


