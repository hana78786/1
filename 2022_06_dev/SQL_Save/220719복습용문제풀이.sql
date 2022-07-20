-- ex) �޿� ��հ� �̻��� �޿��� �޴� ����� �˻��Ͻÿ�
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




-- ex) ������ ������ ������ �̸��� ����Ͽ���.

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
            emp_name = '������'
    );



--@�ǽ����� 
--1. �����ؿ� �޿��� ���� ������� �˻��ؼ�,�����ȣ,����̸�,�޿��� ����϶�.

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
                emp_name = '������'
        )
    AND
        emp_name != '������';





--2. employee ���̺��� �⺻�޿��� ���� ���� ����� ���� ���� ����� ������ 
-- ���,�����,�⺻�޿��� ��Ÿ������.

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


--3. D1,D2�μ��� �ٹ��ϴ� ����� �߿���
--�⺻�޿��� D5 �μ� �������� '��տ���' ���� ���� ����鸸 
--�μ���ȣ,�����ȣ,�����,������ ��Ÿ������.

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
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ��� ��� ���

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
                '������','�ڳ���'
            )
    );





/*
select dept_code from employee
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ����� ��� ���

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
                '������','�ڳ���'
            )
    );





--3. ������ J1,J2,J3�� �ƴ� ����߿��� �ڽ��� �μ��� ��ձ޿����� ���� �޿��� �޴� ������.
-- �μ��ڵ�,�����,�޿�,�μ��� �޿����
-- join���� Ȱ��!!

SELECT
    a.dept_code,
    a.emp_name,
    a.salary,
    �μ����
FROM
    employee a
    JOIN (
        SELECT
            AVG(salary) "�μ����",
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
        salary > �μ����;




/*select*from(�ζ��κ�)
where ���� = "��"  --  �̸� ���� ���*/

SELECT
    *
FROM
    (
        SELECT
            DECODE(
                substr(emp_no,8,1),
                1,
                '��',
                3,
                '��',
                '��'
            ) "����",
            emp_name
        FROM
            employee
    )
WHERE
    ���� = '��';



-- rownum�� �̿��Ͽ� ��ŷ 5 ���ϱ�
--from���� �ζ��κ� ���

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




/*���������� �̿��� �μ�Ʈ�غ���
ǥ �����
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


--ǥ ����� id not null,name not null �ߺ�����,phone �����ĺ���,email �����ĺ���
--���۷����� ǥ ����� shop list ���۷����� id���� id�� �θ�ǥ�� �����ϸ� idĭ�� ������� �� 
--�������ǿ� ������ �̸����̱�!

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



--�θ�ǥ�� �ڷ� �ֱ�
--�ڽ�ǥ�� �ڷ� �ֱ�

INSERT INTO test_sub VALUES (
    'a',
    'aa',
    '111',
    'aaa'
);

INSERT INTO test_list VALUES ( 'aa','125' );

DELETE test_sub WHERE
    name = 'aa';

SELECT
    *
FROM
    test_list;


--�ڽ�ǥ�� ��� �������� �����ϱ�
--�������� �����ϱ� 
-- �������� ������ Ȱ��ȭ ��Ȱ���� �ϱ�

alter table test_list
drop constraint list_name;

alter table test_list
add constraint list_name FOREIGN KEY(name) references test_sub(name) on delete cascade;

delete test_list where list = 123;

delete test_sub where name ='aa';



--



--@�ǽ�����
--���� ��ǰ�ֹ��� ����� ���̺� TBL_ORDER�� �����,������ ���� �÷��� �����ϼ���
-- ORDER_NO(�ֹ�NO) : PK
-- USER_ID(�����̵�)
-- PRODUCT_ID(�ֹ���ǰ���̵�)
-- PRODUCT_CNT(�ֹ�����) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_oder(
order_no number constraint on_pk primary key,
user_id varchar2(20) not null,
prodouct_id varchar2(50),
product_cnt number,
order_date date default sysdate);



-- ORDER_NO�� ������ SEQ_ORDER_NO�� �����,���� �����͸� �߰��ϼ���.(����ð� ����)
-- * kang���� saewookkang��ǰ�� 5�� �ֹ��ϼ̽��ϴ�.
-- * gam���� gamjakkang��ǰ�� 30�� �ֹ��ϼ̽��ϴ�.
-- * ring���� onionring��ǰ�� 50�� �ֹ��ϼ̽��ϴ�.
create sequence seq_order_no
start with 10
increment by 10
MAXVALUE 100
cycle
nocache;

drop sequence seq_order_no;

insert into tbl_order values(seq_order_no.nextval,'ksang','12d',30,default);

select * from tbl_order;

drop table tbl_order;



--@�ǽ�����
--kh���� ������ �� employee,job,department���̺��� �Ϻ������� ����ڿ��� �����Ϸ��� �Ѵ�.
-- ������̵�,�����,���޸�,�μ���,�����ڸ�,�Ի����� �÷������� �� v_emp_info�� �б� �������� �����ϰ�,
-- �信 ���� ��ȸ������ ����ڷ� role_public_emp�� ���� ����� tester���� �ο��Ͻÿ�.


create view v_emp_info 
as select a.emp_id, a.emp_name, dept_title, job_name,
(select emp_name from employee where a.manager_id = emp_id)manager_name,
hire_date
from employee a 
join department
on dept_id = dept_code
join job
using (job_code) with read only;

drop view v_emp_info;

select * from v_emp_info;

