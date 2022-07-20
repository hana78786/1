SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('Hello PL/SQL');
END;
/

DECLARE
    empno   NUMBER := 1720;
    ename   VARCHAR2(20) := '손예진';
BEGIN
    dbms_output.put_line('사번 : ' || empno);
    dbms_output.put_line('이름 : ' || ename);
END;
/

DECLARE
    user_name    CONSTANT VARCHAR2(20) := '일용자';
    user_name2   VARCHAR2(20) := '이용자';
BEGIN
    dbms_output.put_line('상수값 : ' || user_name);
    dbms_output.put_line('변수값 : ' || user_name2);
    user_name2 := '삼용자';
    dbms_output.put_line('변수값 : ' || user_name2);
    dbms_output.put_line('상수값 : ' || user_name);
END;
/


-- ps/sql에서 select문
--> sql에서 사용하는 명령어를 그대로 사용할 수 있으며 select쿼리 결과로 나온값을 변수에 할당하기 위해 사용함

/*select emp_id,emp_name
into empid,ename
from employee
DBMS_OUTPUT.PUT_LINE(EMPID||ENAME);*/

DECLARE
    vempno   employee.emp_no%TYPE;
    vename   employee.emp_name%TYPE;
BEGIN
    SELECT
        emp_no,
        emp_name
    INTO
        vempno,vename
    FROM
        employee
    WHERE
        emp_name = '송종기';

    dbms_output.put_line('주민등록번호 : ' || vempno);
    dbms_output.put_line('이름 : ' || vename);
END;
/
    
    
    --예제 2)
--사원번호를 입력 받아서 사원의 사원번호,이름,급여,입사일을 출력하시오

DECLARE
    vemp_id      employee.emp_id%TYPE;
    vemp_name    employee.emp_name%TYPE;
    vsalary      employee.salary%TYPE;
    vhire_date   employee.hire_date%TYPE;
BEGIN
    SELECT
        emp_id,
        emp_name,
        salary,
        hire_date
    INTO
        vemp_id,vemp_name,vsalary,vhire_date
    FROM
        employee
    WHERE
        emp_id = 200;

    dbms_output.put_line('사번 : ' || vemp_id);
    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('급여 : ' || vsalary);
    dbms_output.put_line('입사일 : ' || vhire_date);
END;
/
    
--문제1)
--사원 번호를 입력 받아서 받은 사원의 사원번호,이름,부서코드,부서명을 출력하도록 하시오

DECLARE
    vemp_id       employee.emp_id%TYPE;
    vemp_name     employee.emp_name%TYPE;
    vdept_code    employee.dept_code%TYPE;
    vdept_title   department.dept_title%TYPE;
BEGIN
    SELECT
        emp_id,
        emp_name,
        dept_code,
        (
            SELECT
                dept_title
            FROM
                department
            WHERE
                dept_id = a.dept_code
        )
    INTO
        vemp_id,vemp_name,vdept_code,vdept_title
    FROM
        employee a
    WHERE
        emp_id = &사번입력;

    dbms_output.put_line('사번 : ' || vemp_id);
    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('부서코드 : ' || vdept_code);
    dbms_output.put_line('부서명 : ' || vdept_title);
END;
/
    
    
    
   /* ## 간단 실습 1 ##
-- 해당 사원의 사원번호를 입력시
-- 이름,부서코드,직급코드가 출력되도록 PL/SQL로 만들어 보시오 
*/

DECLARE
    vemp_name    employee.emp_name%TYPE;
    vdept_code   employee.dept_code%TYPE;
    vjob_code    employee.dept_code%TYPE;
BEGIN
    SELECT
        emp_name,
        dept_code,
        job_code
    INTO
        vemp_name,vdept_code,vjob_code
    FROM
        employee
    WHERE
        emp_id = &사원번호;

    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('부서코드 : ' || vdept_code);
    dbms_output.put_line('직급 : ' || vjob_code);
END;
/

    


/*
## 간단 실습 2 ##
-- 해당 사원의 사원번호를 입력시
-- 이름,부서명,직급명이 출력되도록 PL/SQL로 만들어 보시오
*/

DECLARE
    vemp_name    employee.emp_name%TYPE;
    vdept_code   department.dept_title%TYPE;
    vjob_name    job.job_name%TYPE;
BEGIN
    SELECT
        emp_name,
        dept_title,
        job_name
    INTO
        vemp_name,vdept_code,vjob_name
    FROM
        employee
        LEFT JOIN job USING ( job_code )
        LEFT JOIN department ON dept_code = dept_id
    WHERE
        emp_id = &사번;

    dbms_output.put_line('이름: ' || vemp_name);
    dbms_output.put_line('부서명: ' || vdept_code);
    dbms_output.put_line('직급: ' || vjob_name);
END;
/
   
   
   --예제) 사원번호를 가지고 사원의 사번,이름,급여,보너스율을 출력하고
-- 보너스율이 없으면 '보너스를 지급받지 않는 사원입니다' 를 출력하시오

DECLARE
    vemp_id     employee.emp_id%TYPE;
    vemp_name   employee.emp_name%TYPE;
    vsalary     employee.salary%TYPE;
    vbonus      employee.bonus%TYPE;
BEGIN
    SELECT
        emp_id,
        emp_name,
        salary,
        nvl(bonus,0)
    INTO
        vemp_id,vemp_name,vsalary,vbonus
    FROM
        employee
    WHERE
        emp_id = &사번;

    dbms_output.put_line('사번: ' || vemp_id);
    dbms_output.put_line('이름: ' || vemp_name);
    dbms_output.put_line('급여: ' || vsalary);
    IF
        ( vbonus = 0 )
    THEN
        dbms_output.put_line('보너스를 지급받지 않는 사원입니다');
    ELSE
        dbms_output.put_line('보너스: '
         || vbonus * 100
         || '%');
    END IF;

END;
/
   
   --예시) 사원 코드를 입력 받았을때 사번,이름,직급코드,직급명,소속 값을 출력하시오
    --그때,소속값은 J1,J2 는 임원진,그외에는 일반직원으로 출력되게 하시오

DECLARE
    vemp_id     employee.emp_id%TYPE;
    vemp_name   employee.emp_name%TYPE;
    vjob_code   employee.job_code%TYPE;
    vjob_name   job.job_name%TYPE;
    vjob_in     VARCHAR2(20);
BEGIN
    SELECT
        emp_id,
        emp_name,
        job_code,
        (
            SELECT
                job_name
            FROM
                job
            WHERE
                job_code = a.job_code
        )
    INTO
        vemp_id,vemp_name,vjob_code,vjob_name
    FROM
        employee a
    WHERE
        emp_id = &사번;

    IF
        (
            vjob_code IN (
                'J1','J2'
            )
        )
    THEN
        vjob_in := '임원진';
    ELSE
        vjob_in := '일반직원';
    END IF;

    dbms_output.put_line('사번 : ' || vemp_id);
    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('직급코드 : ' || vjob_code);
    dbms_output.put_line('직급 : ' || vjob_name);
    dbms_output.put_line('소속 : ' || vjob_in);
END;
/
    
    
    

--## 간단 실습 1 ##
-- 사원 번호를 가지고 해당 사원을 조회
-- 이때 사원명,부서명 을 출력하여라.
-- 만약 부서가 없다면 부서명을 출력하지 않고,
-- '부서가 없는 사원 입니다' 를 출력하고
-- 부서가 있다면 부서명을 출력하여라.

DECLARE
    vname     employee.emp_name%TYPE;
    vdename   department.dept_title%TYPE;
    vdecode   employee.dept_code%TYPE;
BEGIN
    SELECT
        emp_name,
        dept_title,
        dept_code
    INTO
        vname,vdename,vdecode
    FROM
        employee
        LEFT JOIN department ON dept_id = dept_code
    WHERE
        emp_id = &사번;

    dbms_output.put_line('사원명 : ' || vname);
    IF
        (
            vdecode IS NULL
        )
    THEN
        dbms_output.put_line('부서가 없습니다');
    ELSE
        dbms_output.put_line('부서명 : ' || vdename);
    END IF;

END;
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

DECLARE
    vemp_id      employee.emp_id%TYPE;
    vemp_name    employee.emp_name%TYPE;
    vsalary      employee.salary%TYPE;
    vsal_level   CHAR(1);
BEGIN
    SELECT
        emp_id,
        emp_name,
        salary
    INTO
        vemp_id,vemp_name,vsalary
    FROM
        employee
    WHERE
        emp_id = &사번;

    IF
        (
            vsalary / 10000 BETWEEN 0 AND 99
        )
    THEN
        vsal_level := 'f';
    ELSIF (
        vsalary / 10000 BETWEEN 100 AND 199
    ) THEN
        vsal_level := 'e';
    ELSIF (
        vsalary / 10000 BETWEEN 200 AND 299
    ) THEN
        vsal_level := 'd';
    ELSIF (
        vsalary / 10000 BETWEEN 300 AND 399
    ) THEN
        vsal_level := 'c';
    ELSIF (
        vsalary / 10000 BETWEEN 400 AND 499
    ) THEN
        vsal_level := 'b';
    ELSE
        vsal_level := 'a';
    END IF;

    dbms_output.put_line('사번 : ' || vemp_id);
    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('월급 : ' || vsalary);
    dbms_output.put_line('등급 : ' || vsal_level);
END;
/

DECLARE
    vemp_id      employee.emp_id%TYPE;
    vemp_name    employee.emp_name%TYPE;
    vsalary      employee.salary%TYPE;
    vsal_level   CHAR(1);
BEGIN
    SELECT
        emp_id,
        emp_name,
        salary
    INTO
        vemp_id,vemp_name,vsalary
    FROM
        employee
    WHERE
        emp_id = &사번;

    CASE
        WHEN
            vsalary / 10000 BETWEEN 0 AND 99
        THEN
            vsal_level := 'f';
        WHEN
            vsalary / 10000 BETWEEN 100 AND 199
        THEN
            vsal_level := 'e';
        WHEN
            vsalary / 10000 BETWEEN 200 AND 299
        THEN
            vsal_level := 'd';
        WHEN
            vsalary / 10000 BETWEEN 300 AND 399
        THEN
            vsal_level := 'c';
        WHEN
            vsalary / 10000 BETWEEN 400 AND 499
        THEN
            vsal_level := 'b';
        ELSE
            vsal_level := 'a';
    END CASE;

    dbms_output.put_line('사번 : ' || vemp_id);
    dbms_output.put_line('이름 : ' || vemp_name);
    dbms_output.put_line('월급 : ' || vsalary);
    dbms_output.put_line('등급 : ' || vsal_level);
END;
/
  
    
    

--ex) 200
--사번 : 200
--이름 : 선동일
--급여 : 8000000
--등급 : A


-- 예시 ) 1~3까지의 수를 입력받고 1을 입력받으면 	'1을 입력하였습니다',2를 입력 받으면 '2를 입력하였습니다',
-- 3을 입력받으면 '3을 입력하였습니다'를 출력하시오. 그외 숫자 입력시 잘못 입력하였습니다를 출력

DECLARE
    inputn   NUMBER;
BEGIN
    inputn := '&입력숫자';
    CASE
        inputn
        WHEN 1 THEN
            dbms_output.put_line(inputn);
        WHEN 2 THEN
            dbms_output.put_line(inputn);
        WHEN 3 THEN
            dbms_output.put_line(inputn);
        ELSE
            dbms_output.put_line('입력오류!');
    END CASE;

END;
/

BEGIN
    FOR n IN REVERSE 1..5 LOOP
        dbms_output.put_line(n);
    END LOOP;
END;
/

BEGIN
    FOR n IN 1..5 LOOP
        dbms_output.put_line(n);
    END LOOP;
END;
/

DECLARE
    name      employee.emp_name%TYPE;
    vsalary   employee.salary%TYPE;
BEGIN
    FOR n IN 0..4 LOOP
        SELECT
            emp_name,
            salary
        INTO
            name,vsalary
        FROM
            employee
        WHERE
            emp_id = 200 + n;

        dbms_output.put_line('이름:' || name);
        dbms_output.put_line('월급:' || vsalary);
    END LOOP;
END;
/

SELECT
    *
FROM
    employee
WHERE
    emp_id = '200';
        
        
-- 예제) 1~10 까지 반복하여 TEST1 테이블에 데이터가 저장되게 하시오
-- TEST1(BUNHO,B_DATE)

CREATE TABLE test1 (
    bunho    NUMBER PRIMARY KEY,
    b_date   DATE DEFAULT SYSDATE
);

BEGIN
    FOR n IN 1..10 LOOP
        INSERT INTO test1 VALUES ( n,DEFAULT );

    END LOOP;

    COMMIT;
END;
/

SELECT
    *
FROM
    test1;

ROLLBACK;




-- 실습문제
-- 사용자로부터 2~9사이의 수를 입력받아 구구단 출력하시오

DECLARE
    no   NUMBER;
BEGIN
    no := '&2에서9까지';
    FOR n IN 2..9 LOOP
        dbms_output.put_line(no
         || 'x'
         || n
         || '='
         || no * n);
    END LOOP;

END;
/

DECLARE
    no   NUMBER;
    n number :=1;
BEGIN
    no := '&2에서9까지';
        if no between 2 and 9 then
    WHILE n <= 9 LOOP
    if(n in (1,3,5,7)) then 
            dbms_output.put_line(no
         || 'x'
         || n
         || '='
         || no * n);
      
        end if;
        n := n + 1;
    END LOOP;
    else dbms_output.put_line('잘못된 입력입니다');
    end if;

END;
/




DECLARE
    DAN NUMBER;
    N NUMBER := 1;
BEGIN
    DAN := '&단';
    IF DAN BETWEEN 2 AND 9 THEN
        WHILE N <= 9 LOOP
            IF N = 1 THEN
                DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || DAN*N);       
            END IF;
            N := N + 1;
            CONTINUE WHEN MOD(N,2) = 0;
            DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || DAN*N);   
        END LOOP;    
    ELSE DBMS_OUTPUT.PUT_LINE('2 ~ 9 사이의 숫자를 입력하세요. bye~');
    END IF;    
END;
/
-- 범위 내 숫자가 아니면 다시 입력받아서 구구단 진행




-- TOP N 분석을 위한 PL/SQL을 만들어라
-- '급여' / '보너스' / '입사일'
-- 무조건 1위~5위 까지를 출력하는 PL/SQL을 만들어라.


SELECT empname, salary, bonus, 
     RANK() OVER (ORDER BY salary aSC ) as rk
     FROM emp; 
     
     

declare
vsalary employee.salary%type;
vbonus employee.bonus%type;
vhire employee.hire_date%type;
vname employee.emp_name%type;
vrownum number;

begin

    
if(vrownum =1) then 
bdms_output.put_line(vname);
end if;



end;
/




--no_data_found
--1. 급여, 이름, 이메일 출력

declare
vsalary employee.salary%type;
vbonus employee.bonus%type;
vhire_date employee.hire_date%type;
begin
select salary,bonus,hire_date 
into vsalary, vbonus, vhire_date
from employee
where emp_id = &사원번호;
dbms_output.put_line('급여 : '||vsalary);
dbms_output.put_line('보너스 : ' ||vbonus);
dbms_output.put_line('입사일 : ' ||vhire_date);

exception
    when no_data_found then dbms_output.put_line('존재하지 않는 사원');
end;
/



--2. 이미 존재하는 사번에 이용자를 추가할때

begin
  insert into employee
  values (200,'일용자','889900-1234567','aaa','123123123','D5','J4','s4',
  30000000,0.3,203,sysdate,default,default);
exception 
    when dup_val_on_index then dbms_output.put_line('이미 존재하는 사번입니다.');
end;
/

