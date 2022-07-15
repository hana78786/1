-- 그룹함수 --
SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code;

SELECT
    job_code,
    SUM(salary)
FROM
    employee
GROUP BY
    job_code;

--[EMPLOYEE] 테이블에서 부서코드 그룹별 급여의 합계,그룹별 급여의 평균(정수처리),
--인원수를 조회하고,부서코드 순으로 정렬

SELECT
    dept_code,
    SUM(salary) "급여합계",
    floor(AVG(salary) ) "급여평균",
    COUNT(*) "인원수"
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;

--[EMPLOYEE] 테이블에서 부서코드 그룹별,보너스를 지급받는 사원 수를 조회하고 부서코드 순으로 정렬
--BONUS컬럼의 값이 존재한다면,그 행을 1로 카운팅.
--보너스를 지급받는 사원이 없는 부서도 있음.

SELECT
    dept_code,
    COUNT(bonus)
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;



--@실습문제
--EMPLOYEE 테이블에서 직급이 J1을 제외하고,직급별 사원수 및 평균급여를 출력하세요.

SELECT
    job_code,
    COUNT(job_code),
    AVG(salary)
FROM
    employee
WHERE
    job_code != 'J1'
GROUP BY
    job_code;



--EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서,입사년 기준으로 오름차순 정렬하세요.

SELECT
    EXTRACT(YEAR FROM(hire_date) ) "입사년도",
    COUNT(*)
FROM
    employee
GROUP BY
    EXTRACT(YEAR FROM(hire_date) )
ORDER BY "입사년도" ASC;


--[EMPLOYEE] 테이블에서 EMP_NO의 8번째 자리가 1,3 이면 '남',2,4 이면 '여'로 결과를 조회하고,
-- 성별별 급여의 평균(정수처리),급여의 합계,인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오

SELECT
    DECODE(
        substr(emp_no,8,1),
        '1',
        '남',
        '3',
        '남',
        '2',
        '여',
        '4',
        '여'
    ) "성별",
    trunc(AVG(salary),2),
    SUM(salary),
    COUNT(*)
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        '1',
        '남',
        '3',
        '남',
        '2',
        '여',
        '4',
        '여'
    );

SELECT
    dept_code,
    job_code,
    COUNT(bonus)
FROM
    employee
GROUP BY
    dept_code,
    job_code;

--@실습문제
--부서내 성별 인원수를 구하세요.

SELECT
    dept_code,
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여',
        3,
        '남',
        4,
        '여'
    ) "성별",
    COUNT(*) "인원수"
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여',
        3,
        '남',
        4,
        '여'
    ),
    dept_code
ORDER BY dept_code;

--부서별 급여 평균이 3,000,000원(버림적용) 이상인  부서들에 대해서 부서명, 급여평균을 출력하세요.
-- 부서별로 그룹을 나누고, 그룹별 급여평균을 구한후, 조건을 제시함.


select dept_title, FLOOR(avg(salary)) from EMPLOYEE
left outer join department
on dept_code = dept_id
group by dept_title
having floor(avg(salary)) >= 3000000;


--@실습문제
--부서별 인원이 5명보다 많은 부서와 인원수를 출력하세요.

select dept_title"부서명", count(dept_title)"인원수" from employee
left outer join department
on dept_code=dept_id
group by dept_title
having count(dept_title)>5;


--부서별 직급별 인원수가 3명이상인 직급의 부서코드, 직급코드, 인원수를 출력하세요.

select job_code, dept_code, count(*) from employee
group by job_code, dept_code
order by job_code;



--매니져가 관리하는 사원이 2명이상인 매니져아이디와 관리하는 사원수를 출력하세요.

select manager_id, COUNT(*) from employee
group by manager_id
-- where manager_id is not null
having count(*)>=2 and manager_id is not null
order by 1;


-- rollup() : 괄호속 그룹의 숫자코드를 출력 
SELECT DEPT_CODE, JOB_CODE, sum(salary)
FROM EMPLOYEE
GROUP BY cube(DEPT_CODE, JOB_CODE)
order by dept_code;

select
 DEPT_CODE,
    JOB_CODE,
    SUM(SALARY),
    CASE WHEN GROUPING(DEPT_CODE) = 0 AND GROUPING(JOB_CODE) = 1 THEN '부서별합계'
        WHEN GROUPING(DEPT_CODE) = 1 AND GROUPING(JOB_CODE) = 0 THEN '직급별합계'
        WHEN GROUPING(DEPT_CODE) = 1 AND GROUPING(JOB_CODE) = 1 THEN '총합계'
        ELSE '그룹별합계'
    END AS "구분"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;


select emp_name, emp_id from employee
where dept_code='D5'

minus

select emp_name, emp_id from employee
where salary>=2400000;


select * from employee
join department
on dept_code= dept_id;

SELECT * FROM EMPLOYEE
join job
on job_code = job_code;

-- JOIN 사용법
-- SELECT FROM 
-- JOIN 테이블명 ON (컬럼1 = 컬럼2)
-- > ANSI 표준 구문(어느 DBMS에서나 사용 가능)
SELECT * FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;
-- > Oracle 전용 구문 (오라클 DBMS에서만 사용 가능)
SELECT * FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;


SELECT job_name, emp_name FROM EMPLOYEE E
join job using(job_code);

select job_name, emp_name from employee 
join job on employee.job_code = job.job_code;

select * from employee 
right OUTER join  department
on dept_code = dept_id;

select * from employee 
left OUTER join  department
on dept_code = dept_id;


select * from employee 
inner join  department
on dept_code = dept_id
inner join job using(job_code);

select emp_name, dept_title, local_name from employee
inner join DEPARTMENT
on dept_code= dept_id
inner join location
on location_id = local_code;


--@조인실습문제_kh
--1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select to_char(to_date('20201225'), 'DY"요일"') from dual;


--2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select emp_name, emp_no,job_name, dept_title from employee
inner join department
on dept_code = dept_id
inner join job
on employee.job_code = job.job_code
where substr(emp_no,1,2) between 70 and 79;




--3. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.

select emp_id, emp_name, dept_title from employee
join DEPARTMENT
on dept_code = dept_id
where emp_name like '%형%';




--5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.

select emp_name, job_name, dept_code, dept_title, local_name from employee e
join department
on dept_code=dept_id
join job
on e.job_code = job.job_code
join location
on location_id = local_code
where location_id != 'L1';




--6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.

select emp_name, dept_title,bonus, local_name from employee
join department
on dept_code= dept_id
join location
on location_id = local_code
where bonus is not null;



--7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.


select emp_name, dept_title, job_name, local_name from employee
join department 
on dept_code=dept_id
join job
using(job_code)
join location on location_id = local_code
where dept_code = 'D2';




--8. 급여등급테이블의 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 조인할 것)

select emp_name, salary, salary*12 from employee
join sal_grade
using(sal_level);



--9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select emp_name, dept_title, national_name from employee
join DEPARTMENT
on dept_code=dept_id
join Location
on local_code = location_id
join national
using(national_code)
where national_code in ('KO','JP');

--10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 IN 사용할 것
select emp_name, job_name, salary from employee
join job
using (job_code)
where bonus is null and job_code in ('J4','J7');

--11. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.

select 
decode(ent_yn,'Y','퇴사','N','재직') "재직여부",
count(*) from employee
group by decode(ent_yn,'Y','퇴사','N','재직');
