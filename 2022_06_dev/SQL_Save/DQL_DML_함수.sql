INSERT INTO employee VALUES (
    '900',
    '장채현',
    '901123-2080503',
    'jang_ch@kh.or.kr',
    '01055569512',
    'D1',
    'J8',
    'S3',
    4300000,
    0.2,
    '200',
    SYSDATE,
    NULL,
    'N'
);

COMMIT;

ROLLBACK;

DELETE FROM employee WHERE
    emp_name = '장채현';

SELECT
    SYSDATE
FROM
    dual;

SELECT
    length('hello')
FROM
    dual;

SELECT
    length(email)
FROM
    employee;

--문자열의 길이,문자열의 바이트 길이
--length lengthb

SELECT
    emp_name,
    lengthb(emp_name),
    length(emp_name)
FROM
    employee;

--문자열의 위치
--instr instrb
--instr(data,str,1,1) -> 1왼쪽-1오른쪽 ,1(왼쪽오른쪽을 기준으로)몇번째를 찾을건지

SELECT
    instr(
        'hello world hi high',
        'h',
        -1,
        2
    ),
    instr(
        'hello world hi high',
        'h',
        -1,
        3
    ),
    instr(
        'hello world hi high',
        'h',
        -1,
        4
    )
FROM
    dual; --가상의 테이블

-- EMPLOYEE테이블에서 EMAIL 컬럼의 문자열 중 '@'의 위치를 구하시오

SELECT
    instr(
        email,
        '@',
        1,
        1
    ) -- email칼럼에서 @를 왼쪽기준으로 첫번째인건 몇글자째에 존재하는지
--기본값이라 (1,1)은 생략 가능!
FROM
    employee;

-- lapd/prad -left right(기준)

SELECT
    email,
    rpad(email,20,'#'),
    lpad(email,20,'*')
FROM
    employee;
-- ltrtim/rtrim

SELECT
    ltrim('    kh')
FROM
    dual;

SELECT
    ltrim('00001234','0')
FROM
    dual;

SELECT
    rtrim('123456-1002300','00')
FROM
    dual;

SELECT
    ltrim('abadcsdkhab','abcds')
FROM
    dual;
--왼쪽 오른쪽 기준문자를 삭제하다가 삭제할수 없는 문자가 나오면 삭제종료
--trim

SELECT
    TRIM('   kh     '),
    TRIM('z' FROM 'zzzzzkhzzzzzz')
FROM
    dual;

SELECT
    TRIM(LEADING 'z' FROM 'zzzzzkhzzzzz'),
    TRIM(TRAILING 'z' FROM 'zzzzkhzzzzz')
FROM
    dual;

-- 실습 문제 1
-- Hello KH Java 문자열을 Hello KH 가 출력되게 하여라.

SELECT
    rtrim('Hello KH java','java')
FROM
    dual;


-- 실습 문제 2
-- Hello KH Java 문자열을 KH Java 가 출력되게 하여라.

SELECT
    ltrim('Hello Kh java','Hello')
FROM
    dual;


-- 실습 문제 3 (TRIM으로 해보세요)
-- DEPARTMENT 테이블에서 DEPT_TITLE을 출력하여라
-- 이때,마지막 부 글자를 빼고 출력되도록 하여라 / ex)회계관리부 -> 회계관리

SELECT
    TRIM(TRAILING '부' FROM dept_title)
FROM
    department;

-- 실습 문제 4
-- 다음문자열에서 앞뒤 모든 숫자를 제거하세요.
-- '982341678934509hello89798739273402'

SELECT
    rtrim(
        ltrim('982341678934509hello89798739273402','1234567890'),
        '1234567890'
    ) AS "문자열"
FROM
    dual;

--substr

SELECT
    substr('show me the meony',6)
FROM
    dual; -- me the money

SELECT
    substr('show me the money',6,2)
FROM
    dual; --me

SELECT
    substr('show me the money',-8,2)
FROM
    dual; --he (-8은 뒤에서 6번째)

-- 실습문제1
-- 사원명에서 성만 사전순으로 출력하세요
-- (성만 출력했으면 중복없이도 출력해보세요)

SELECT DISTINCT
    substr(emp_name,0,1) AS "성"
FROM
    employee
ORDER BY "성" ASC;
     



-- 실습문제2
-- EMPLOYEE 테이블에서 남자만 사원번호,사원명,주민번호,연봉을 출력하세요
-- 단,주민번호 뒤 6자리는 * 처리하세요.

SELECT
    emp_id,
    emp_name,
    rpad(
        substr(emp_no,1,8),
        14,
        '*'
    ) "주민번호",
    salary * 12 "연봉"
FROM
    employee
WHERE
    emp_no LIKE '______-1%';
  
  --replace 

SELECT
    replace('kh hate','hate','love')
FROM
    dual;

SELECT
    replace('kn@naver.com','naver.com','iei.or.kr')
FROM
    dual;

-- 실습문제
-- EMPLOYEE 테이블의 모든 직원의 이름,주민번호,EMAIL을 출력하시오
-- 단,출력시 EMAIL의 주소를 kh.or.kr에서 iei.or.kr로 변경하여 출력하시오.
-- 단,id에 kh가 있으면 변경되지 않도록 하시오

SELECT
    emp_name,
    emp_no,
    substr(
        email,
        1,
        instr(
            email,
            '@',
            1,
            1
        ) - 1
    )
     || replace(
        substr(
            email,
            instr(
                email,
                '@',
                1,
                1
            )
        ),
        'kh',
        'iei'
    ) "이메일"
-- 자른다(email에서,1부터,a -1까지)
-- a: 찾는다(email에서,'@'를,왼쪽부터 ,첫번째) 
-- 교체한다 (b에서,'kh'를,'iei'로)
-- b:자른다(email에서,c부터)
-- c:찾는다(email에서,'@'를,왼쪽부터.첫번째)
FROM
    employee;

SELECT
    substr(
        email,
        1,
        instr(
            email,
            '@',
            1,
            1
        ) - 1
    )
     || replace(
        substr(
            email,
            instr(
                email,
                '@',
                1,
                1
            )
        ),
        'kh',
        'iei'
    )
FROM
    employee;

SELECT
    substr(
        email,
        1,
        instr(email,'@',1)
    )
     || replace(
        substr(
            email,
            instr(email,'@',1) + 1
        ),
        'kh',
        'hello'
    )
FROM
    employee;

-- 숫자함수
-- abs,mod,round,floor,trunc,ceil

SELECT
    round(123.456)
FROM
    dual; --123
--round 정수로 반올림

SELECT
    round(123.456,1)
FROM
    dual; -- 123.5 /1-> 소숫점 2번째 자리 

SELECT
    round(123.456,2)
FROM
    dual;  -- 123.46

SELECT
    round(123.456,-1)
FROM
    dual; -- 120,/-1-> 정수1자리 반올림

SELECT
    trunc(123.456,1)
FROM
    dual; --123.4 버림,1-> 소숫점 2째자리 버림

SELECT
    trunc(123.456,2)
FROM
    dual;-- 123.45

SELECT
    ceil(123.456)
FROM
    dual; --124 -> 정수로 올림

SELECT
    ceil(123.456,1)
FROM
    dual; -- 오류 소숫점 안됨

SELECT
    emp_name,
    round(SYSDATE - hire_date),---> 근무일수를 반올림할수있다.
    trunc(SYSDATE - hire_date),--> 근무일수 소숫점 자리 버림
    floor(SYSDATE - hire_date),
    ceil(SYSDATE - hire_date)
FROM
    employee;

SELECT
    SYSDATE
FROM
    dual;
--Months_between
--두 날짜의 개월수 -> 근무개월수

SELECT
    ceil(months_between(SYSDATE,hire_date) ) "근무개월수"
FROM
    employee; --<-올림했음
--add_months(전달값은 날짜,숫자)

SELECT
    add_months(SYSDATE,3)
FROM
    dual;

SELECT
    add_months(hire_date,3)
FROM
    employee; --> 입사하고 3개월 후 날짜
-- next_day
-- 오늘 날짜를 기준으로 다음주 오늘 요일의 날짜를 알려준다 (오늘 14일 목요일: 다음 목요일은? ->21일)

SELECT
    next_day(SYSDATE,'월요일'),
    next_day(SYSDATE,'목'),
    next_day(SYSDATE,3) --<- 3은 일,월,화 3일이 지난 화요일을 뜻함
FROM
    dual;

-- Last_day

SELECT
    last_day(SYSDATE)
FROM
    dual; -- 이번달의 마지막 날을 조회

SELECT
    last_day(hire_date)
FROM
    employee; --입사한 달의 마지막 날을 조회

/*
    만약에 자신이 오늘 군대에 간다고 합시다.
    군복무 기간은 1년 6개월이라고 가정하면
    1. 제대일자가 언제인지 구하고
    2. 제대일자까지 먹어야하는 짬밥의 그릇수를 구해보세요
    (단,1일 3끼 무조건 먹는다고 가정합니다)
    테이블은 DUAL로 하세요.
*/

SELECT
    SYSDATE "입대일",
    add_months(SYSDATE,18) "제대일자",
    ( add_months(SYSDATE,18) - SYSDATE ) * 3 "그릇수"
FROM
    dual;

-- @ 실습문제 1
-- EMPLOYEE 테이블에서 사원의 이름,입사일,년차를 출력하여라. 
-- 단,입사일은 YYYY년M월D일로 출력하도록 하여라.
-- 년차 출력은 소수점 일경우 올림으로 하여 출력하여라. (28.144 -> 29년차)
-- (출력시 정렬은 입사일 기준으로 오름차순)

SELECT
    emp_name "이름",
    EXTRACT(YEAR FROM hire_date)
     || '년도'
     || EXTRACT(MONTH FROM hire_date)
     || '월'
     || EXTRACT(DAY FROM hire_date)
     || '일' "입사일",
    ceil( (SYSDATE - hire_date) / 365) "년차"
FROM
    employee;

-- @ 실습문제 2
-- 특별 보너스를 지급하기 위하여 자료가 필요하다
-- 입사일을 기점으로 다음달 1일 부터 6개월을 계산하여 
-- 출력하시오 (이름,입사일,기준일,기준일+6,기준달(월))
-- ex) 90년2월6일 입사 -> 90년3월1일 부터 계산
-- ex) 90년2월26일 입사 -> 90년3월1일 부터 계산
-- ex) 97년12월1일 입사 -> 98년1월1일 부터 계산
-- 출력시 입사일 기준으로 정렬하시오

SELECT
    emp_name "이름",
    EXTRACT(YEAR FROM hire_date)
     || '년도'
     || EXTRACT(MONTH FROM hire_date)
     || '월'
     || EXTRACT(DAY FROM hire_date)
     || '일' "입사일",
    EXTRACT(YEAR FROM last_day(hire_date) + 1)
     || '년도'
     || EXTRACT(MONTH FROM last_day(hire_date) + 1)
     || '월'
     || EXTRACT(DAY FROM last_day(hire_date) + 1)
     || '일' "기준일",
    EXTRACT(YEAR FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '년도'
     || EXTRACT(MONTH FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '월'
     || EXTRACT(DAY FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '일' "6개월",--->6개월계산,입사한달의 마지막날 +1일부터
    EXTRACT(MONTH FROM(last_day(hire_date) + 1) )
     || '월' "기준달"
FROM
    employee;

SELECT
    TO_CHAR(SYSDATE,'YYYY-MM-DD'),--2022-07-14
    TO_CHAR(SYSDATE,'YYYY-MM-DD AMHH12"시"Mi"분"SS"초"') --2022-07-14 오후02시43분30초
FROM
    dual;

-- EMPLOYEE 테이블에서 사원명,고용일(ex. 1990/02/06(화))로 출력하세요.

SELECT
    TO_CHAR(hire_date,'YYYY/MM/DD(DY)')
FROM
    employee;

SELECT
    TO_DATE(20220613)
FROM
    dual;

SELECT
    TO_DATE(20220613,'YYYYMMDD')
FROM
    dual;  --위아래 결과값 같음

SELECT
    TO_DATE(22220613040501,'YYYYMMDDHH24MISS')
FROM
    dual;

-- to_number
-- number연산을 위한 형 변환
-- 숫자 형식
-- ,(9,999) : 콤마형식으로 변환
-- . (99.99) : 소수점 형식으로 변환
-- 0:맨왼쪽에 0을 삽입,$:$통화로 표시,L:로컬통화로 표시(한국은 \)
-- 숫자 표시 단위를 쓸 때에는 충분히 크게 크기를 잡아야 함.

SELECT
    to_number('90,000','999,999,999'),--90000
    TO_CHAR(90000,'000,000,000'),-- 000,090,000
    TO_CHAR(90000,'999,999,999') --      90,000
FROM
    dual;

SELECT
    to_number('1,000,000','9,999,999') - to_number('550,000','9,999,999') -- 500,000를 500000으로 인식하기위해 위에 9,999,999를 붙여준것
FROM
    dual; --앞 tonumber-뒤 tonumber값

SELECT
    bonus * 100
FROM
    employee;

SELECT
    nvl(bonus,0) * 100
FROM
    employee; --null을 전부 0으로 인식함!!!

SELECT
    salary * 12 + salary * nvl(bonus,0)
FROM
    employee;

SELECT
    emp_id,
    emp_name,
    (
        CASE
            WHEN
                substr(emp_no,8,1) = 1
            OR
                substr(emp_no,8,1) = 3
            THEN '남'
            WHEN
                substr(emp_no,8,1) = 2
            OR
                substr(emp_no,8,1) = 4
            THEN '여'
            ELSE '없음'
        END
    ) "성별"
FROM
    employee;

-- EMPLOYEE 테이블에서 출생년도 기준 60년대 생 직원에 대하여 
-- 65년이전 출생자는 60년생 초반,65년 이후 출생자는 60년생 후반이라고 출력하시오

SELECT
    emp_id,
    emp_name,
    emp_no,
        CASE
            WHEN substr(emp_no,0,2) < 65  THEN '60년생 초반'
            WHEN substr(emp_no,0,2) >= 65 THEN '60년생 후반'
            ELSE '해당없음'
        END
    "나이"
FROM
    employee
WHERE
    substr(emp_no,0,2) BETWEEN 60 AND 69;

SELECT
    emp_id,
    emp_name,
    emp_no,
        CASE
            WHEN
                substr(emp_no,0,2) >= 60
            AND
                substr(emp_no,0,2) < 70
            AND
                substr(emp_no,0,2) < 65
            THEN '60년생 초반'
            WHEN
                substr(emp_no,0,2) >= 60
            AND
                substr(emp_no,0,2) < 70
            AND
                substr(emp_no,0,2) >= 65
            THEN '60년생 후반'
            ELSE '해당없음'
        END
    "나이"
FROM
    employee;

SELECT
    DECODE(
        substr(emp_no,8,1),
        '1',
        '남',
        '2',
        '여',
        '3',
        '남',
        '4',
        '여',
        '없음'
    ) "성별"
FROM
    employee;

-- 사원명과 직급코드에 따른 해당직급명을 출력하세요. (job테이블참조)

SELECT
    emp_name "사원명",
    job_code "직급코드",
    DECODE(
        job_code,
        'J1',
        '대표',
        'J2',
        '부사장',
        'J3',
        '부장',
        'J4',
        '차장',
        'J5',
        '과장',
        'J6',
        '대리',
        'J7',
        '사원',
        '해당없음'
    ) "직급명"
FROM
    employee;

SELECT
    job_code,
    job_name
FROM
    job;
    
    
    
    -- 최종 실습 문제
-- 문제1. 
-- 입사일이 5년 이상,10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라

SELECT
    emp_name,
    emp_no,
    salary,
    hire_date
FROM
    employee
WHERE
    ( SYSDATE - hire_date ) / 365 BETWEEN 5 AND 10;



-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드,고용일,근무기간,퇴직일을 검색하여라 
--(퇴사 여부 : ENT_YN)

SELECT
    emp_name,
    dept_code,
    ent_date - hire_date,
    ent_date
FROM
    employee
WHERE
    ent_yn = 'Y';


-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수(소수점X)를 근속년수가 오름차순으로 정렬하여 출력하여라
-- 단,급여는 50% 인상된 급여로 출력되도록 하여라.

SELECT
    emp_name,
    salary * 1.5,
    ceil( (SYSDATE - hire_date) / 365) "근속년수"
FROM
    employee
WHERE
    ceil( (SYSDATE - hire_date) / 365) >= 10
ORDER BY "근속년수" ASC;



-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오

SELECT
    emp_name,
    emp_no,
    phone,
    salary,
    hire_date
FROM
    employee
WHERE
    hire_date BETWEEN '990101' AND '100101';

-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
-- 단,부서코드가 null인 사람은 부서코드가 '없음' 으로 출력 하여라.

SELECT
    emp_name,
    emp_no,
    nvl(dept_code,'없음') "부서코드",
    salary
FROM
    employee
WHERE
    (
        salary BETWEEN 2000000 AND 3000000
    ) AND
        substr(emp_no,8,1) = 2
ORDER BY emp_no DESC;



-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단,이름 순으로 오름 차순 정렬하여 출력하여라.

select emp_name,salary,
trunc((sysdate-hire_date)/1000)*(salary*0.1) "특별보너스"
from employee
where substr(emp_no,8,1)=1 and bonus is null
order by emp_name asc;



-- @함수 최종실습문제
--1. 직원명과 이메일 ,이메일 길이를 출력하시오
--		  이름	    이메일		이메일길이
--	ex) 	홍길동 ,hong@kh.or.kr   	  13

select emp_name,email, length(email)"메일길이" from employee;


--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
--	ex) 노옹철	no_hc
--	ex) 정중하	jung_jh
select emp_name,
substr(email,1,
instr(email,'@',1)-1
)"이메일아이디"
from employee;

--3. 60년대에 태어난 직원명과 년생,보너스 값을 출력하시오. 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
--	    직원명    년생      보너스
--	ex) 선동일	    1962	    0.3
--	ex) 송은희	    1963  	    0

select emp_name, 19||substr(emp_no,1,2)"년생",nvl(bonus,0)"보너스" from employee
where substr(emp_no,1,2)<70 and substr(emp_no,1,2)>59;


--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
--	   인원
--	ex) 3명

select group by ||'명' "인원" from EMPLOYEE;


--5. 직원명과 입사년월을 출력하시오 
--	단,아래와 같이 출력되도록 만들어 보시오
--	    직원명		입사년월
--	ex) 전형돈		2012년 12월
--	ex) 전지연		1997년 3월


select emp_name "직원명", to_char(hire_date,'YYYY"년" MM"월') "입사년월" from employee;



--6. 직원명과 주민번호를 조회하시오
--	단,주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오
--	ex) 홍길동 771120-1******

select emp_name "직원명", 
rpad(substr(emp_no,1,8),14,'*') "주민번호"
from employee;


--7. 직원명,직급코드,연봉(원) 조회
--  단,연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임

select emp_name, job_code, to_char((salary*12),'L999,999,999') "연봉" from employee;


--8. 부서코드가 D5,D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
--   사번 사원명 부서코드 입사일

select emp_id,emp_name, dept_code, hire_date,
extract(year from hire_date)
from employee
where (dept_code in('D5','D9')) and 
(extract(year from hire_date)=2004);

--9. 직원명,입사일,오늘까지의 근무일수 조회 
--	* 주말도 포함 ,소수점 아래는 버림
select emp_name, hire_date, trunc(sysdate-hire_date) from employee;



--10. 직원명,부서코드,생년월일,나이(만) 조회
--   단,생년월일은 주민번호에서 추출해서,
--   ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음,계산함
--	* 주민번호가 이상한 사람들은 제외시키고 진행 하도록(200,201,214 번 제외)
--	* HINT : NOT IN 사용

select emp_name, dept_code,to_char(to_date(substr(emp_no,1,6)),'YYYY"년"MM"월"DD"일"')"생일",
extract(Year from sysdate)- extract(Year from(to_date(substr(emp_no,1,6))))"나이"
from employee
where emp_id not in (200,201,204);



--11. 사원명과,부서명을 출력하세요.
--   부서코드가 D5이면 총무부,D6이면 기획부,D9이면 영업부로 처리하시오.(case 사용)
--   단,부서코드가 D5,D6,D9 인 직원의 정보만 조회하고,부서코드 기준으로 오름차순 정렬함.

select emp_name, 
(case
when
dept_code ='D5' then '총무부'
when dept_code = 'D6' then '기획부'
when dept_code = 'D9' then '영업부'
END)"부서명"
from employee
where dept_code in ('D5','D6','D9')
order by dept_code asc;