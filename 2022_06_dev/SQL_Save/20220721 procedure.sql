
-- storde procedure 예제
create table emp_dup
as select * from employee;
drop table emp_dup;
select*from emp_dup;
--생성



--실행
execute del_all_emp;
create procedure del_all_emp
is

begin
    delete from emp_dup;
    commit;
end;
/
select * 
from user_source
where name = 'DEL_ALL_EMP';

SELECT *
FROM USER_SOURCE
WHERE NAME = 'DEL_ALL_EMP';


create procedure proc_del_emp_id(p_emp_id emp_dup.emp_id%type)
is
begin
    delete from emp_dup where emp_id = p_emp_id;
    commit;
    dbms_output.put_line(p_emp_id||'번 사원을 삭제했습니다.');
end;
/

execute proc_del_emp_id(&사원번호);

set serveroutput on;


create procedure proc_select_emp_id (
p_emp_id in employee.emp_id%type,
p_emp_name out employee.emp_name%type,
p_salary out employee.salary%type,
p_bonus out employee.bonus%type
) 
is
begin
    select emp_name,salary, nvl(bonus,0)
    into p_emp_name,p_salary, p_bonus
    from employee
    where emp_id=p_emp_id;
end;
/


var b_emp_name varchar2(20);
var b_salary number;
var b_bonus number;

exec proc_select_emp_id('202', :b_emp_name, :b_salary, :b_bonus);

print b_emp_name;

-- 모아보기
var result varchar2(100);
exec :result := (:b_emp_name|| ' '|| :b_salary ||' '|| :b_bonus);

print result;

exec PROC_SELECT_EMP_ID ('200',p_);



-- 실습1) JOB테이블에 INSERT를 할 때 같은 직급코드가 있으면 UPDATE를 수행하고 없으면
-- 그대로 INSERT를 하는 PROCEDURE를 작성하시오.
-- 1단계. JOB테이블에 INSERT하는 프로시저를 작성
-- 2단계. 요구사항에 맞게 조건문을 추가하여 변경

create table copy_job
as select * from job;
drop table copy_job;




 drop procedure insert_job;
 
create procedure insert_job(
p_job_code in job.job_code%type,
p_job_name in job.job_name%type
)

is

begin
 insert into copy_job values(p_job_code, p_job_name);
 commit;

end;
/

exec insert_job('J8','인턴');

select * from copy_job;

alter table copy_job
add constraint py  primary key (job_code);


delete copy_job
where job_code ='J8';

alter table copy_job
drop constraint  py;

alter table copy_job
add constraint jcode_pk primary key (job_code);

select count(job_code) from copy_job
where job_code='D9';

CREATE OR REPLACE PROCEDURE PROC_ADD_JOB_DUP(
    P_JOB_CODE IN copy_job.JOB_CODE%TYPE,
    P_JOB_NAME IN copy_job.JOB_NAME%TYPE
)
IS
    V_CNT NUMBER := 0;
BEGIN
    SELECT COUNT(*)
    INTO V_CNT
    FROM copy_job
    WHERE JOB_CODE = P_JOB_CODE;
    
    IF(V_CNT > 0)
    THEN 
        UPDATE copy_job SET JOB_NAME = P_JOB_NAME
        WHERE JOB_CODE = P_JOB_CODE;
    ELSE
        INSERT INTO copy_job VALUES(P_JOB_CODE, P_JOB_NAME);
    END IF;
    COMMIT;
END;
/

exec PROC_ADD_JOB_DUP ('J8','인턴');

select * from copy_job;


--헤드폰 씌우기

create or replace function make_headphone(p_str varchar2)
return varchar2
is
    madeheadphone varchar2(32767);
begin
    madeheadphone := 'd'||p_str||'b';
    return madeheadphone;
end;
/

var result varchar2;

exec :result := make_headphone('(●^?^●)');
print result;

begin
dbms_output.put_line(make_headphone('&얼굴'));
end;
/

--예제1. 사번을 입력 받아 해당 사원의 연봉을 계산하여 리턴하는 저장함수를 만들어 출력하시오

CREATE OR REPLACE FUNCTION FN_BONUS_CALC(V_EMPID VARCHAR2)
RETURN NUMBER
IS
    V_SAL EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
    CALC_SAL NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO V_SAL, V_BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = V_EMPID;
    --RETURN (V_SAL * 12 + V_SAL * V_BONUS);
    CALC_SAL := (V_SAL * 12 + V_SAL * V_BONUS);
    RETURN CALC_SAL;
END;
/


--@실습문제
--1.사원번호를 입력받아서 성별을 리턴하는 저장함수 FN_GET_GENDER를 생성하고, 실행하세요.

create or replace function fn_get_gender (v_emp_id varchar2)
return varchar2
is
gender varchar2(20);

begin
    select decode(substr(emp_no,8,1),1,'남',3,'남','여') 
    into gender
    from employee
    where emp_id = v_emp_id;
    return gender;
    
end;
/

var result varchar2;
exec :result := fn_get_gender('212');
print result;






--2. 사용자로부터 입력받은 사원명으로 검색하여 해당사원의 직급명을 얻어 오는 저장함수
-- FN_GET_JOB_NAME를 작성하세요. (해당사원이 없다면 '해당사원없음' 출력)

create or replace function fn_get_job_name(v_emp_name varchar2)
return varchar2
is
v_jobname job.job_name%type;
begin
    select job_name   
    into v_jobname
    from employee
    left join job
    using (job_code)
    where emp_name = v_emp_name;
    return v_jobname;
exception
when no_data_found then return('해당사원없음');
end;
/

exec :result :=fn_get_job_name('&이름');
print result;


--3. 사원에게 특별상여금(보너스)를 지급하려고 하는데, 입사일기준으로 차등 지급하려 한다.
-- 입사일기준 10년이상이면 150%, 3년이상 10년미만이면 125%, 3년미만이면 50%를 지급함.
-- 저장함수명 : FN_BONUS_CALC, FN_GET_WORKING_DAYS(HIRE_DATE)
-- 조회컬럼 : 사번, 사원명, 입사일, 근무기간(~년 ~개월), 보너스금액

create or replace function fn_bonus_calc(v_empid varchar2)
RETURN NUMBER
IS
v_bonus employee.bonus%type;
v_result varchar2(500);
BEGIN
    SELECT 
   ( case 
    when floor((sysdate-hire_date)/365)>=10 then 150
    when floor((sysdate-hire_date)/365) between 3 and 10 then 125
    when floor((sysdate-hire_date)/365)<3 then 50
    end)/100*salary "보너스"
    INTO
    v_bonus
    FROM employee

    WHERE emp_id = v_empid;
    v_result := v_bonus;
    return v_result;
END;
/
var result2 varchar2;
exec :result2 :=fn_bonus_calc('&사번');
print result2;






declare
v_name employee.emp_name%type;
v_num number;

begin
select emp_name, emp_id
into v_name, v_num
from employee
where emp_id = v_num;

dbms_output.put_line('이름 :'||v_name||'보너스 금액 : '||fn_bonus_calc('&사번'));
end;
/






--@실습문제
--기존부서테이블의 DEPT_ID, DEPT_TITLE만 복제한 DEPT_COPY를 생성한다.
--DEPT_ID 컬럼 PK추가. DEPT_ID 컬럼 확장 CHAR(3)
--DEPT_COPY를 관리하는 프로시져 PROC_MAN_DEPT_COPY를 생성한다.
-- 첫번째 인자로 동장FLAG값 UPDATE/DELETE를 받는다.
-- UPDATE시, 데이터가 존재하지 않으면 INSERT, 데이터가 존재하면, UPDATE
-- DELETE시, 해당부서에 사원이 존재하는지를 검사해서, 존재하면, 경고메세지와 함께 실행취소함. 그렇지 않으면, 삭제.
-- 프로시저의 매개변수에 기본값을 지정하면, 생략가능함.


CREATE OR REPLACE PROCEDURE PROC_MAN_DEPT_COPY()
IS
BEGIN
END;
/

--예제 사원 테이블에 새로운 데이터가 들어오면 "신입사원이 입사하였습니다' 출력하기

create or replace trigger trg_emp_new
    after
    insert on employee
    for each row
begin
    dbms_output.put_line('신입 사원이 입사했습니다.');
end;
/

insert into employee (emp_name,emp_id,emp_no,job_code,sal_level)
values ('가나다','301',000000000,'J8','L5');
commit;

delete employee 
where emp_name = '가나다';

-- 예제2. 급여변경 전후정보를 화면에 출력하는 트리거를 생성해보자

create table emp_sal
as select * from employee;

create or replace trigger trg_salary_update
    before
    update on emp_sal
    for each row
begin
    dbms_output.put_line('변경전 : ' ||:old.salary ||' 변경후 : '|| :new.salary);
end;
/


update emp_sal
set salary = 2000000
where emp_id=220;
commit;


--예제3 제품 테이블을 생ㄷ성하고 제품 입고시 상품재고 테이블 수치를 관리해보자
-- 트리거를 사용해 재고가 입출고시 자동으로 재고가 입력되도록 해보자
CREATE TABLE PRODUCT(
  PCODE NUMBER PRIMARY KEY,
  PNAME VARCHAR2(30),
  BRAND VARCHAR2(30),
  PRICE NUMBER,
  STOCK NUMBER DEFAULT 0
);


CREATE TABLE PRODUCT_IO(
  IOCODE NUMBER PRIMARY KEY,
  PCODE NUMBER,
  PDATE DATE,
  AMOUNT NUMBER,
  STATUS VARCHAR2(10) CHECK (STATUS IN ('입고', '출고')),
  CONSTRAINT FK_PRODUCT_IO FOREIGN KEY (PCODE) REFERENCES PRODUCT(PCODE)
);

--SEQUENCE 생성
CREATE SEQUENCE SEQ_PRODUCT_PCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOMINVALUE
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_PRODUCTIO_IOCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOMINVALUE
NOCYCLE
NOCACHE;



--트리거 생성
--입고, 출고될 때 procudt 테이블에 stock의 값이 업데이트가 되어야 함
--insert stock+1 입고
--출고 stock-1




CREATE OR REPLACE TRIGGER TRG_PRODUCT_STOCK
    AFTER
    INSERT ON PRODUCT_IO
    FOR EACH ROW
BEGIN
    IF :NEW.STATUS = '입고'
    THEN UPDATE PRODUCT SET STOCK = STOCK + :NEW.AMOUNT WHERE PCODE = :NEW.PCODE;
    ELSE UPDATE PRODUCT SET STOCK = STOCK - :NEW.AMOUNT WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

commit;

select * from product_io;
select * from product;
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,1,sysdate, 5,'입고');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,2, sysdate, 5,'입고');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,3, sysdate, 15,'입고');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,1,sysdate, 20,'출고');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,2, sysdate, 5,'출고');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,3, sysdate, 5,'출고');

rollback;
commit;



--@실습문제
--1. EMPLOYEE테이블의 퇴사자관리를 별도의 테이블 TBL_EMP_QUIT에서 하려고 한다.
--다음과 같이 TBL_EMP_JOIN, TBL_EMP_QUIT테이블을 생성하고, TBL_EMP_JOIN에서 DELETE시 자동으로 퇴사자 데이터가 TBL_EMP_QUIT에 INSERT되도록 트리거를 생성하라.

--TBL_EMP_JOIN 테이블 생성 : QUIT_DATE, QUIT_YN 제외






















