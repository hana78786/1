-- ex) 급여 평균값 이상의 급여를 받는 사원을 검색하시오
SELECT
    *
FROM
    employee
WHERE
    salary >= (
        SELECT
            AVG(salary)
        FROM
            employee
    );




-- ex) 전지연 직원의 관리자 이름을 출력하여라.

SELECT
    emp_name
FROM
    employee
WHERE
    emp_id = (
        SELECT
            manager_id
        FROM
            employee
        WHERE
            emp_name = '전지연'
    );



--@실습문제 
--1. 윤은해와 급여가 같은 사원들을 검색해서,사원번호,사원이름,급여를 출력하라.

SELECT
    emp_id,
    emp_name,
    salary
FROM
    employee
WHERE
        salary = (
            SELECT
                salary
            FROM
                employee
            WHERE
                emp_name = '윤은해'
        )
    AND
        emp_name != '윤은해';





--2. employee 테이블에서 기본급여가 제일 많은 사람과 제일 적은 사람의 정보를 
-- 사번,사원명,기본급여를 나타내세요.

SELECT
    emp_id,
    emp_name,
    salary
FROM
    employee
WHERE
        salary = (
            SELECT
                MAX(salary)
            FROM
                employee
        )
    OR
        salary = (
            SELECT
                MIN(salary)
            FROM
                employee
        );


--3. D1,D2부서에 근무하는 사원들 중에서
--기본급여가 D5 부서 직원들의 '평균월급' 보다 많은 사람들만 
--부서번호,사원번호,사원명,월급을 나타내세요.

SELECT
    emp_id,
    dept_code,
    emp_name,
    salary
FROM
    employee
WHERE
        dept_code IN (
            'D1','D2'
        )
    AND
        salary > (
            SELECT
                AVG(salary)
            FROM
                employee
            GROUP BY
                dept_code
            HAVING
                dept_code = 'D5'
        );



/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서에 사원 출력

*/

SELECT
    *
FROM
    employee
WHERE
    dept_code IN (
        SELECT
            dept_code
        FROM
            employee
        WHERE
            emp_name IN (
                '송종기','박나라'
            )
    );





/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서외의 사원 출력

*/

SELECT
    *
FROM
    employee
WHERE
    dept_code NOT IN (
        SELECT
            dept_code
        FROM
            employee
        WHERE
            emp_name IN (
                '송종기','박나라'
            )
    );





--3. 직급이 J1,J2,J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드,사원명,급여,부서별 급여평균
-- join으로 활용!!

SELECT
    a.dept_code,
    a.emp_name,
    a.salary,
    부서평균
FROM
    employee a
    JOIN (
        SELECT
            AVG(salary) "부서평균",
            dept_code
        FROM
            employee
        GROUP BY
            dept_code
    ) b ON a.dept_code = b.dept_code
WHERE
        job_code NOT IN (
            'J1','J2','J3'
        )
    AND
        salary > 부서평균;




/*select*from(인라인뷰)
where 성별 = "남"  --  이름 성별 출력*/

SELECT
    *
FROM
    (
        SELECT
            DECODE(
                substr(emp_no,8,1),
                1,
                '남',
                3,
                '남',
                '여'
            ) "성별",
            emp_name
        FROM
            employee
    )
WHERE
    성별 = '남';



-- rownum을 이용하여 랭킹 5 구하기
--from절에 인라인뷰 사용

SELECT
    ROWNUM,
    salary,
    emp_name
FROM
    (
        SELECT
            salary,
            emp_name,
            dept_code,
            job_code
        FROM
            employee
        ORDER BY 1 DESC
    )
WHERE
    ROWNUM < 6;




/*서브쿼리를 이용한 인서트해보기
표 만들기
*/

CREATE TABLE test_sub
    AS
        SELECT
            emp_name,
            emp_no,
            salary
        FROM
            employee
        WHERE
            substr(emp_no,8,1) = 2;

SELECT
    *
FROM
    test_sub;

DROP TABLE test_sub;


--표 만들기 id not null,name not null 중복금지,phone 고유식별자,email 고유식별자
--레퍼런스로 표 만들기 shop list 레퍼런스로 id연결 id는 부모표가 삭제하면 id칸만 사라지게 함 
--제약조건에 무조건 이름붙이기!

CREATE TABLE test_sub (
    id      VARCHAR2(20)
        CONSTRAINT test_id NOT NULL,
    name    VARCHAR(20)
        CONSTRAINT test_name UNIQUE,
    phone   VARCHAR(50),
    email   VARCHAR(50),
    CONSTRAINT test_pk PRIMARY KEY ( phone,email )
);

CREATE TABLE test_list (
    name   VARCHAR2(50)
        CONSTRAINT list_name
            REFERENCES test_sub ( name )
                ON DELETE SET NULL,
    list   VARCHAR2(50)
        CONSTRAINT list_uni_nnull NOT NULL
    UNIQUE
);



--부모표에 자료 넣기
--자식표에 자료 넣기

INSERT INTO test_sub VALUES (
    'a',
    'aa',
    '111',
    'aaa'
);

INSERT INTO test_list VALUES ( 'aa','123' );

DELETE test_sub WHERE
    name = 'aa';

SELECT
    *
FROM
    test_list;


--자식표에 모든 제약조건 삭제하기
--제약조건 수정하기 
-- 제약조건 수정뒤 활성화 비활성해 하기





--



--@실습문제
--고객이 상품주문시 사용할 테이블 TBL_ORDER를 만들고,다음과 같이 컬럼을 구성하세요
-- ORDER_NO(주문NO) : PK
-- USER_ID(고객아이디)
-- PRODUCT_ID(주문상품아이디)
-- PRODUCT_CNT(주문개수) 
-- ORDER_DATE : DEFAULT SYSDATE



-- ORDER_NO은 시퀀스 SEQ_ORDER_NO을 만들고,다음 데이터를 추가하세요.(현재시각 기준)
-- * kang님이 saewookkang상품을 5개 주문하셨습니다.
-- * gam님이 gamjakkang상품을 30개 주문하셨습니다.
-- * ring님이 onionring상품을 50개 주문하셨습니다.



--@실습문제
--kh계정 소유의 한 employee,job,department테이블의 일부정보를 사용자에게 공개하려고 한다.
-- 사원아이디,사원명,직급명,부서명,관리자명,입사일의 컬럼정보를 뷰 v_emp_info를 읽기 전용으로 생성하고,
-- 뷰에 대한 조회권한을 사용자롤 role_public_emp을 만들어서 사용자 tester에게 부여하시오.