
-- storde procedure ����
create table emp_dup
as select * from employee;
drop table emp_dup;
select*from emp_dup;
--����



--����
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
    dbms_output.put_line(p_emp_id||'�� ����� �����߽��ϴ�.');
end;
/

execute proc_del_emp_id(&�����ȣ);

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

-- ��ƺ���
var result varchar2(100);
exec :result := (:b_emp_name|| ' '|| :b_salary ||' '|| :b_bonus);

print result;

exec PROC_SELECT_EMP_ID ('200',p_);



-- �ǽ�1) JOB���̺� INSERT�� �� �� ���� �����ڵ尡 ������ UPDATE�� �����ϰ� ������
-- �״�� INSERT�� �ϴ� PROCEDURE�� �ۼ��Ͻÿ�.
-- 1�ܰ�. JOB���̺� INSERT�ϴ� ���ν����� �ۼ�
-- 2�ܰ�. �䱸���׿� �°� ���ǹ��� �߰��Ͽ� ����

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

exec insert_job('J8','����');

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

exec PROC_ADD_JOB_DUP ('J8','����');

select * from copy_job;


--����� �����

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

exec :result := make_headphone('(��^?^��)');
print result;

begin
dbms_output.put_line(make_headphone('&��'));
end;
/

--����1. ����� �Է� �޾� �ش� ����� ������ ����Ͽ� �����ϴ� �����Լ��� ����� ����Ͻÿ�

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


--@�ǽ�����
--1.�����ȣ�� �Է¹޾Ƽ� ������ �����ϴ� �����Լ� FN_GET_GENDER�� �����ϰ�, �����ϼ���.

create or replace function fn_get_gender (v_emp_id varchar2)
return varchar2
is
gender varchar2(20);

begin
    select decode(substr(emp_no,8,1),1,'��',3,'��','��') 
    into gender
    from employee
    where emp_id = v_emp_id;
    return gender;
    
end;
/

var result varchar2;
exec :result := fn_get_gender('212');
print result;






--2. ����ڷκ��� �Է¹��� ��������� �˻��Ͽ� �ش����� ���޸��� ��� ���� �����Լ�
-- FN_GET_JOB_NAME�� �ۼ��ϼ���. (�ش����� ���ٸ� '�ش�������' ���)

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
when no_data_found then return('�ش�������');
end;
/

exec :result :=fn_get_job_name('&�̸�');
print result;


--3. ������� Ư���󿩱�(���ʽ�)�� �����Ϸ��� �ϴµ�, �Ի��ϱ������� ���� �����Ϸ� �Ѵ�.
-- �Ի��ϱ��� 10���̻��̸� 150%, 3���̻� 10��̸��̸� 125%, 3��̸��̸� 50%�� ������.
-- �����Լ��� : FN_BONUS_CALC, FN_GET_WORKING_DAYS(HIRE_DATE)
-- ��ȸ�÷� : ���, �����, �Ի���, �ٹ��Ⱓ(~�� ~����), ���ʽ��ݾ�

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
    end)/100*salary "���ʽ�"
    INTO
    v_bonus
    FROM employee

    WHERE emp_id = v_empid;
    v_result := v_bonus;
    return v_result;
END;
/
var result2 varchar2;
exec :result2 :=fn_bonus_calc('&���');
print result2;






declare
v_name employee.emp_name%type;
v_num number;

begin
select emp_name, emp_id
into v_name, v_num
from employee
where emp_id = v_num;

dbms_output.put_line('�̸� :'||v_name||'���ʽ� �ݾ� : '||fn_bonus_calc('&���'));
end;
/






--@�ǽ�����
--�����μ����̺��� DEPT_ID, DEPT_TITLE�� ������ DEPT_COPY�� �����Ѵ�.
--DEPT_ID �÷� PK�߰�. DEPT_ID �÷� Ȯ�� CHAR(3)
--DEPT_COPY�� �����ϴ� ���ν��� PROC_MAN_DEPT_COPY�� �����Ѵ�.
-- ù��° ���ڷ� ����FLAG�� UPDATE/DELETE�� �޴´�.
-- UPDATE��, �����Ͱ� �������� ������ INSERT, �����Ͱ� �����ϸ�, UPDATE
-- DELETE��, �ش�μ��� ����� �����ϴ����� �˻��ؼ�, �����ϸ�, ���޼����� �Բ� ���������. �׷��� ������, ����.
-- ���ν����� �Ű������� �⺻���� �����ϸ�, ����������.


CREATE OR REPLACE PROCEDURE PROC_MAN_DEPT_COPY()
IS
BEGIN
END;
/

--���� ��� ���̺� ���ο� �����Ͱ� ������ "���Ի���� �Ի��Ͽ����ϴ�' ����ϱ�

create or replace trigger trg_emp_new
    after
    insert on employee
    for each row
begin
    dbms_output.put_line('���� ����� �Ի��߽��ϴ�.');
end;
/

insert into employee (emp_name,emp_id,emp_no,job_code,sal_level)
values ('������','301',000000000,'J8','L5');
commit;

delete employee 
where emp_name = '������';

-- ����2. �޿����� ���������� ȭ�鿡 ����ϴ� Ʈ���Ÿ� �����غ���

create table emp_sal
as select * from employee;

create or replace trigger trg_salary_update
    before
    update on emp_sal
    for each row
begin
    dbms_output.put_line('������ : ' ||:old.salary ||' ������ : '|| :new.salary);
end;
/


update emp_sal
set salary = 2000000
where emp_id=220;
commit;


--����3 ��ǰ ���̺��� �������ϰ� ��ǰ �԰�� ��ǰ��� ���̺� ��ġ�� �����غ���
-- Ʈ���Ÿ� ����� ��� ������ �ڵ����� ��� �Էµǵ��� �غ���
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
  STATUS VARCHAR2(10) CHECK (STATUS IN ('�԰�', '���')),
  CONSTRAINT FK_PRODUCT_IO FOREIGN KEY (PCODE) REFERENCES PRODUCT(PCODE)
);

--SEQUENCE ����
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



--Ʈ���� ����
--�԰�, ���� �� procudt ���̺� stock�� ���� ������Ʈ�� �Ǿ�� ��
--insert stock+1 �԰�
--��� stock-1




CREATE OR REPLACE TRIGGER TRG_PRODUCT_STOCK
    AFTER
    INSERT ON PRODUCT_IO
    FOR EACH ROW
BEGIN
    IF :NEW.STATUS = '�԰�'
    THEN UPDATE PRODUCT SET STOCK = STOCK + :NEW.AMOUNT WHERE PCODE = :NEW.PCODE;
    ELSE UPDATE PRODUCT SET STOCK = STOCK - :NEW.AMOUNT WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

commit;

select * from product_io;
select * from product;
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,1,sysdate, 5,'�԰�');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,2, sysdate, 5,'�԰�');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,3, sysdate, 15,'�԰�');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,1,sysdate, 20,'���');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,2, sysdate, 5,'���');
insert into product_IO values(SEQ_PRODUCTIO_IOCODE.nextval,3, sysdate, 5,'���');

rollback;
commit;



--@�ǽ�����
--1. EMPLOYEE���̺��� ����ڰ����� ������ ���̺� TBL_EMP_QUIT���� �Ϸ��� �Ѵ�.
--������ ���� TBL_EMP_JOIN, TBL_EMP_QUIT���̺��� �����ϰ�, TBL_EMP_JOIN���� DELETE�� �ڵ����� ����� �����Ͱ� TBL_EMP_QUIT�� INSERT�ǵ��� Ʈ���Ÿ� �����϶�.

--TBL_EMP_JOIN ���̺� ���� : QUIT_DATE, QUIT_YN ����






















