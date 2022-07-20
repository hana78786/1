SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('Hello PL/SQL');
END;
/

DECLARE
    empno   NUMBER := 1720;
    ename   VARCHAR2(20) := '�տ���';
BEGIN
    dbms_output.put_line('��� : ' || empno);
    dbms_output.put_line('�̸� : ' || ename);
END;
/

DECLARE
    user_name    CONSTANT VARCHAR2(20) := '�Ͽ���';
    user_name2   VARCHAR2(20) := '�̿���';
BEGIN
    dbms_output.put_line('����� : ' || user_name);
    dbms_output.put_line('������ : ' || user_name2);
    user_name2 := '�����';
    dbms_output.put_line('������ : ' || user_name2);
    dbms_output.put_line('����� : ' || user_name);
END;
/


-- ps/sql���� select��
--> sql���� ����ϴ� ��ɾ �״�� ����� �� ������ select���� ����� ���°��� ������ �Ҵ��ϱ� ���� �����

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
        emp_name = '������';

    dbms_output.put_line('�ֹε�Ϲ�ȣ : ' || vempno);
    dbms_output.put_line('�̸� : ' || vename);
END;
/
    
    
    --���� 2)
--�����ȣ�� �Է� �޾Ƽ� ����� �����ȣ,�̸�,�޿�,�Ի����� ����Ͻÿ�

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

    dbms_output.put_line('��� : ' || vemp_id);
    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('�޿� : ' || vsalary);
    dbms_output.put_line('�Ի��� : ' || vhire_date);
END;
/
    
--����1)
--��� ��ȣ�� �Է� �޾Ƽ� ���� ����� �����ȣ,�̸�,�μ��ڵ�,�μ����� ����ϵ��� �Ͻÿ�

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
        emp_id = &����Է�;

    dbms_output.put_line('��� : ' || vemp_id);
    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('�μ��ڵ� : ' || vdept_code);
    dbms_output.put_line('�μ��� : ' || vdept_title);
END;
/
    
    
    
   /* ## ���� �ǽ� 1 ##
-- �ش� ����� �����ȣ�� �Է½�
-- �̸�,�μ��ڵ�,�����ڵ尡 ��µǵ��� PL/SQL�� ����� ���ÿ� 
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
        emp_id = &�����ȣ;

    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('�μ��ڵ� : ' || vdept_code);
    dbms_output.put_line('���� : ' || vjob_code);
END;
/

    


/*
## ���� �ǽ� 2 ##
-- �ش� ����� �����ȣ�� �Է½�
-- �̸�,�μ���,���޸��� ��µǵ��� PL/SQL�� ����� ���ÿ�
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
        emp_id = &���;

    dbms_output.put_line('�̸�: ' || vemp_name);
    dbms_output.put_line('�μ���: ' || vdept_code);
    dbms_output.put_line('����: ' || vjob_name);
END;
/
   
   
   --����) �����ȣ�� ������ ����� ���,�̸�,�޿�,���ʽ����� ����ϰ�
-- ���ʽ����� ������ '���ʽ��� ���޹��� �ʴ� ����Դϴ�' �� ����Ͻÿ�

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
        emp_id = &���;

    dbms_output.put_line('���: ' || vemp_id);
    dbms_output.put_line('�̸�: ' || vemp_name);
    dbms_output.put_line('�޿�: ' || vsalary);
    IF
        ( vbonus = 0 )
    THEN
        dbms_output.put_line('���ʽ��� ���޹��� �ʴ� ����Դϴ�');
    ELSE
        dbms_output.put_line('���ʽ�: '
         || vbonus * 100
         || '%');
    END IF;

END;
/
   
   --����) ��� �ڵ带 �Է� �޾����� ���,�̸�,�����ڵ�,���޸�,�Ҽ� ���� ����Ͻÿ�
    --�׶�,�ҼӰ��� J1,J2 �� �ӿ���,�׿ܿ��� �Ϲ��������� ��µǰ� �Ͻÿ�

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
        emp_id = &���;

    IF
        (
            vjob_code IN (
                'J1','J2'
            )
        )
    THEN
        vjob_in := '�ӿ���';
    ELSE
        vjob_in := '�Ϲ�����';
    END IF;

    dbms_output.put_line('��� : ' || vemp_id);
    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('�����ڵ� : ' || vjob_code);
    dbms_output.put_line('���� : ' || vjob_name);
    dbms_output.put_line('�Ҽ� : ' || vjob_in);
END;
/
    
    
    

--## ���� �ǽ� 1 ##
-- ��� ��ȣ�� ������ �ش� ����� ��ȸ
-- �̶� �����,�μ��� �� ����Ͽ���.
-- ���� �μ��� ���ٸ� �μ����� ������� �ʰ�,
-- '�μ��� ���� ��� �Դϴ�' �� ����ϰ�
-- �μ��� �ִٸ� �μ����� ����Ͽ���.

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
        emp_id = &���;

    dbms_output.put_line('����� : ' || vname);
    IF
        (
            vdecode IS NULL
        )
    THEN
        dbms_output.put_line('�μ��� �����ϴ�');
    ELSE
        dbms_output.put_line('�μ��� : ' || vdename);
    END IF;

END;
/

   
   
   --## �ǽ� ���� ##
--����� �Է� ���� �� �޿��� ���� ����� ������ ����ϵ��� �Ͻÿ� 
--�׶� ��� ���� ���,�̸�,�޿�,�޿������ ����Ͻÿ�

--0���� ~ 99���� : F
--100���� ~ 199���� : E
--200���� ~ 299���� : D
--300���� ~ 399���� : C
--400���� ~ 499���� : B
--500���� �̻�(�׿�) : A

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
        emp_id = &���;

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

    dbms_output.put_line('��� : ' || vemp_id);
    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('���� : ' || vsalary);
    dbms_output.put_line('��� : ' || vsal_level);
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
        emp_id = &���;

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

    dbms_output.put_line('��� : ' || vemp_id);
    dbms_output.put_line('�̸� : ' || vemp_name);
    dbms_output.put_line('���� : ' || vsalary);
    dbms_output.put_line('��� : ' || vsal_level);
END;
/
  
    
    

--ex) 200
--��� : 200
--�̸� : ������
--�޿� : 8000000
--��� : A


-- ���� ) 1~3������ ���� �Է¹ް� 1�� �Է¹����� 	'1�� �Է��Ͽ����ϴ�',2�� �Է� ������ '2�� �Է��Ͽ����ϴ�',
-- 3�� �Է¹����� '3�� �Է��Ͽ����ϴ�'�� ����Ͻÿ�. �׿� ���� �Է½� �߸� �Է��Ͽ����ϴٸ� ���

DECLARE
    inputn   NUMBER;
BEGIN
    inputn := '&�Է¼���';
    CASE
        inputn
        WHEN 1 THEN
            dbms_output.put_line(inputn);
        WHEN 2 THEN
            dbms_output.put_line(inputn);
        WHEN 3 THEN
            dbms_output.put_line(inputn);
        ELSE
            dbms_output.put_line('�Է¿���!');
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

        dbms_output.put_line('�̸�:' || name);
        dbms_output.put_line('����:' || vsalary);
    END LOOP;
END;
/

SELECT
    *
FROM
    employee
WHERE
    emp_id = '200';
        
        
-- ����) 1~10 ���� �ݺ��Ͽ� TEST1 ���̺� �����Ͱ� ����ǰ� �Ͻÿ�
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




-- �ǽ�����
-- ����ڷκ��� 2~9������ ���� �Է¹޾� ������ ����Ͻÿ�

DECLARE
    no   NUMBER;
BEGIN
    no := '&2����9����';
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
    no := '&2����9����';
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
    else dbms_output.put_line('�߸��� �Է��Դϴ�');
    end if;

END;
/




DECLARE
    DAN NUMBER;
    N NUMBER := 1;
BEGIN
    DAN := '&��';
    IF DAN BETWEEN 2 AND 9 THEN
        WHILE N <= 9 LOOP
            IF N = 1 THEN
                DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || DAN*N);       
            END IF;
            N := N + 1;
            CONTINUE WHEN MOD(N,2) = 0;
            DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || DAN*N);   
        END LOOP;    
    ELSE DBMS_OUTPUT.PUT_LINE('2 ~ 9 ������ ���ڸ� �Է��ϼ���. bye~');
    END IF;    
END;
/
-- ���� �� ���ڰ� �ƴϸ� �ٽ� �Է¹޾Ƽ� ������ ����




-- TOP N �м��� ���� PL/SQL�� ������
-- '�޿�' / '���ʽ�' / '�Ի���'
-- ������ 1��~5�� ������ ����ϴ� PL/SQL�� ������.


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
--1. �޿�, �̸�, �̸��� ���

declare
vsalary employee.salary%type;
vbonus employee.bonus%type;
vhire_date employee.hire_date%type;
begin
select salary,bonus,hire_date 
into vsalary, vbonus, vhire_date
from employee
where emp_id = &�����ȣ;
dbms_output.put_line('�޿� : '||vsalary);
dbms_output.put_line('���ʽ� : ' ||vbonus);
dbms_output.put_line('�Ի��� : ' ||vhire_date);

exception
    when no_data_found then dbms_output.put_line('�������� �ʴ� ���');
end;
/



--2. �̹� �����ϴ� ����� �̿��ڸ� �߰��Ҷ�

begin
  insert into employee
  values (200,'�Ͽ���','889900-1234567','aaa','123123123','D5','J4','s4',
  30000000,0.3,203,sysdate,default,default);
exception 
    when dup_val_on_index then dbms_output.put_line('�̹� �����ϴ� ����Դϴ�.');
end;
/

