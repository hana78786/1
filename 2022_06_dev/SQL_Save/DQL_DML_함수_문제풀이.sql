
-- 최종 실습 문제
-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라

select emp_name, emp_no, hire_date from employee
where floor((sysdate-hire_date)/365) between 5 and 10;

-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드, 고용일, 근무기간, 퇴직일을 검색하여라 
--(퇴사 여부 : ENT_YN)

select emp_name, dept_code, hire_date, ent_date-hire_date, ent_date
from employee
where ent_yn='Y';

-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수(소수점X)를 근속년수가 오름차순으로 정렬하여 출력하여라
-- 단, 급여는 50% 인상된 급여로 출력되도록 하여라.

select emp_name, salary*1.5 , floor((sysdate-hire_date)/365)"근속년수"
from employee
where floor((sysdate-hire_date)/365) > 10
order by "근속년수" asc;



-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오

select emp_name, emp_no, email, phone, salary, hire_date from employee
where (hire_date between '990101' and '100101') and salary<=2000000;

-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
-- 단, 부서코드가 null인 사람은 부서코드가 '없음' 으로 출력 하여라.

select emp_name, salary, nvl(dept_code,'없음'), emp_no from employee
where (salary between 2000000 and 3000000) and (substr(emp_no,8,1))in(2,4)
and (substr(emp_no,3,2)=04)
order by emp_no desc;


-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하여라.

select emp_name,
(floor((sysdate-hire_date)/1000))*(salary*0.1)"특별 보너스"
from employee
where substr(emp_no,8,1) in (1,3) and bonus is null;
order by emp_name asc;

-- @함수 최종실습문제
--1. 직원명과 이메일 , 이메일 길이를 출력하시오
--		  이름	    이메일		이메일길이
--	ex) 	홍길동 , hong@kh.or.kr   	  13

select emp_name, email, length(email)"이메일길이" from employee;


--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
--	ex) 노옹철	no_hc
--	ex) 정중하	jung_jh

select emp_name , substr(email,1,instr(email,'@',1)-1) from employee;


--3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오. 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
--	    직원명    년생      보너스
--	ex) 선동일	    1962	    0.3
--	ex) 송은희	    1963  	    0

select emp_name, nvl(bonus,0),extract(YEAR from to_date(substr(emp_no,1,6))) from employee
where substr(emp_no,1,2) between 60 and 69;


--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
--	   인원
--	ex) 3명


--5. 직원명과 입사년월을 출력하시오 
--	단, 아래와 같이 출력되도록 만들어 보시오
--	    직원명		입사년월
--	ex) 전형돈		2012년 12월
--	ex) 전지연		1997년 3월

select emp_name, to_char(hire_date,'YYYY"년"MM"월"')"입사년월" from employee;


--6. 직원명과 주민번호를 조회하시오
--	단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오
--	ex) 홍길동 771120-1******
select emp_name, rpad(substr(emp_no,1,8),14,'*') from employee;


--7. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
select emp_name, job_code,to_char(salary*12,'l999,999,999') "연봉" from employee;



--8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
--   사번 사원명 부서코드 입사일

select emp_id, emp_name, dept_code, hire_date from employee
where dept_code in('D5','D9') and extract(year from hire_date) =2004;

--9. 직원명, 입사일, 오늘까지의 근무일수 조회 
--	* 주말도 포함 , 소수점 아래는 버림

select emp_name, hire_date, trunc(sysdate-hire_date) from employee;


--10. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--	* 주민번호가 이상한 사람들은 제외시키고 진행 하도록(200,201,214 번 제외)
--	* HINT : NOT IN 사용

select emp_name, dept_code,to_char(to_date(substr(emp_no,1,6)),'YYYY"년" MM"월" DD"일"')"생일",
extract(year from sysdate) - extract(year from to_date(substr(emp_no,1,6))) "나이"
from employee
where emp_id not in (200,201,204);




--11. 사원명과, 부서명을 출력하세요.
--   부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.(case 사용)
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
case

select emp_name, 
(case dept_code
when 'D5' then '총무부'
when 'D6' then '기획부'
when 'D9' then '영업부' end) "부서명"
from employee
where dept_code in ('D5','D6','D9');










-- 최종 실습 문제
-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라
select emp_name, emp_no, salary, hire_date from employee
where floor((sysdate-hire_date)/365) between 5 and 10;



-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드, 고용일, 근무기간, 퇴직일을 검색하여라 
--(퇴사 여부 : ENT_YN)
select emp_name, dept_code, hire_date, ent_date-hire_date "근무기간",
ent_date from employee
where ent_yn = 'Y';




-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수(소수점X)를 근속년수가 오름차순으로 정렬하여 출력하여라
-- 단, 급여는 50% 인상된 급여로 출력되도록 하여라.

select emp_name,salary*1.5, floor((sysdate-hire_date)/365) from employee
where floor((sysdate-hire_date)/365)>=10
order by 2;



-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오
select emp_name, emp_no, email, phone, salary from employee
where (hire_date between '990101' and '100101') and salary>=2000000;


-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
-- 단, 부서코드가 null인 사람은 부서코드가 '없음' 으로 출력 하여라.

select emp_name, emp_no, salary, nvl(dept_code,'없음') from employee
where (salary between 2000000 and 3000000) and substr(emp_no,8,1) in (2,4)
and substr(emp_no,3,2)=04;





-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하여라.

select emp_name, 
floor((sysdate-hire_date)/365) * salary*0.1
from employee
where bonus is null and substr(emp_no,8,1) in (1,3);



-- @함수 최종실습문제
--1. 직원명과 이메일 , 이메일 길이를 출력하시오
--		  이름	    이메일		이메일길이
--	ex) 	홍길동 , hong@kh.or.kr   	  13

select emp_name, email, length(email) from employee;


--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
--	ex) 노옹철	no_hc
--	ex) 정중하	jung_jh

select emp_name, substr(email,1,instr(email,'@',1,1)-1) from employee;



--3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오. 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
--	    직원명    년생      보너스
--	ex) 선동일	    1962	    0.3
--	ex) 송은희	    1963  	    0
select emp_name, extract(year from to_date(substr(emp_no,1,6)))"년생", nvl(bonus,0) from employee
where  extract(year from to_date(substr(emp_no,1,6))) between 1960 and 1969 ;



--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
--	   인원
--	ex) 3명
select count(*) from employee
where phone not like '010%';


--5. 직원명과 입사년월을 출력하시오 
--	단, 아래와 같이 출력되도록 만들어 보시오
--	    직원명		입사년월
--	ex) 전형돈		2012년 12월
--	ex) 전지연		1997년 3월

select emp_name, to_char(hire_date,'YYYY"년" MM"월"')from employee;



--6. 직원명과 주민번호를 조회하시오
--	단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오
--	ex) 홍길동 771120-1******

select emp_name, 

rpad(substr(emp_no,1,8),14,'*') 

from employee;



--7. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임

select emp_name, job_code, to_char(salary*12,'l999,999,999')||'원' from employee;



--8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
--   사번 사원명 부서코드 입사일

select emp_id, emp_name, dept_code, hire_date from employee
where dept_code in ('D5','D9') and extract(year from hire_date) = 2004;

--9. 직원명, 입사일, 오늘까지의 근무일수 조회 
--	* 주말도 포함 , 소수점 아래는 버림

select emp_name, hire_date, trunc(sysdate-hire_date) from employee;


--10. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--	* 주민번호가 이상한 사람들은 제외시키고 진행 하도록(200,201,214 번 제외)
--	* HINT : NOT IN 사용

select emp_name, dept_code, to_char(to_date(substr(emp_no,1,6)),'YYYY"년" MM"월" DD"일"')"생일",
extract(year from sysdate)- extract(year from to_date(substr(emp_no,1,6)))"나이" from employee
where emp_id not in (200,201,214);




--11. 사원명과, 부서명을 출력하세요.
--   부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.(case 사용)
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.

select emp_name, decode(dept_code,'D5','총무부','D6','기획부','D9','영업부') from employee
where dept_code in ('D5','D6','D9');


