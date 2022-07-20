alter table department
add (lname varchar2(20));

alter table department
modify lname varchar2(21);

alter table demartment
drop column lname;

desc department;

alter table department
rename column locaion_name to location_name;

alter table department
add (lname varchar2(20));

alter table department
drop column lname;

show user;

desc employee;


desc department;

create table member(
member_id varchar2(20),
member_pwd varchar2(30),
memeber_age number,
member_date date);

alter table member rename to worker;

drop table worker;


insert into employee values(900,'��ä��', '901123-2080503','jang_ch@kh.co.kr','01055569512','D1','J8','S3',430000,
0.2,'200',sysdate,null,default);

select * from employee;
select emp_name from employee;

select dept_id, dept_title from department;

update DEPARTMENT
set DEPT_TITLE = '������ȹ��'
where dept_id='D9';

select * from department;

delete from employee
where emp_name = '��ä��';


select emp_id, emp_name, salary from employee;

SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE,
JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE
, ENT_DATE, ENT_YN
FROM EMPLOYEE;

select emp_name, salary , salary*12 as "����",'��' "����"
from employee;

-- 1. JOB���̺��� JOB_NAME�� ������ ��µǵ��� �Ͻÿ�

select job_name from job;

-- 2. DEPARTMENT���̺��� ���� ��ü�� ����ϴ� SELECT���� �ۼ��Ͻÿ�

select * from department;

-- 3. EMPLOYEE ���̺��� �̸�(EMP_NAME),�̸���(EMAIL),
-- ��ȭ��ȣ(PHONE),�����(HIRE_DATE)�� ����Ͻÿ�

select emp_name,email,phone,hire_date from employee;

-- 4. EMPLOYEE ���̺��� �����(HIRE_DATE) �̸�(EMP_NAME),����(SALARY)�� ����Ͻÿ�

select hire_date, emp_name,salary from employee;

-- 5. EMPLOYEE ���̺��� ����(SALARY)�� 2,500,000���̻��� ����� 
-- EMP_NAME �� SAL_LEVEL�� ����Ͻÿ� 

select  emp_name, sal_level from employee
where salary>=2500000;

-- (��Ʈ : >(ũ��) , <(�۴�) �� �̿�)
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))

-- 6. EMPLOYEE ���̺��� ����(SALARY)�� 350���� �̻��̸鼭 
-- JOB_CODE�� 'J3' �� ����� 
-- �̸�(EMP_NAME)�� ��ȭ��ȣ(PHONE)�� ����Ͻÿ�
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))

SELECT emp_name, phone from EMPLOYEE
where job_code='J3' and salary >= 3500000;


-- ���� �ǽ� ����
--1. EMPLOYEE ���̺��� �̸�,����, �Ѽ��ɾ�(���ʽ�����), 
-- �Ǽ��ɾ�(�� ���ɾ�-(����*���� 3%*12))
--�� ��µǵ��� �Ͻÿ�

select emp_name "�̸�", salary*12 as "����", salary*bonus+salary*12 "�Ѽ��ɾ�(���ʽ�����)",
salary*bonus+salary*12-(salary*0.03*12) "�Ǽ��ɾ�"
from employee;

--2. EMPLOYEE ���̺��� �̸�, �ٹ� �ϼ��� ����غ��ÿ� 
--(SYSDATE�� ����ϸ� ���� �ð� ���)
select hire_date, ent_date, ent_yn from employee;

select emp_name "�̸�" ,Sysdate - hire_date "�ٹ��ϼ�", (Sysdate - hire_date)/365 "�ټӿ���"
from employee;
 


--3. EMPLOYEE ���̺��� 20�� �̻� �ټ����� �̸�,����,���ʽ����� ����Ͻÿ�.
select emp_name "�̸�" ,salary "����", bonus "���ʽ���"
from employee
where (Sysdate - hire_date)/365 >= 20;


-- DISTINCT 
-- �÷��� ���Ե� �ߺ� ���� �ѹ����� ǥ���ϰ��� �� �� ���
select distinct Job_code from employee;


-- ��������(AND, OR)
-- �μ��ڵ尡 D6�̰� �޿��� 2,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�.
select EMP_name "�̸�", Dept_code "�μ��ڵ�",salary "�޿�"
from employee
where dept_code = 'D6' and salary>=2000000;


-- �μ��ڵ尡 D5 �Ǵ� �޿��� 3,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�
select emp_name, dept_code,salary
from employee
where dept_code ='D5' or salary >=3000000;


-- ���� ������(||)
-- ���� �÷��� �ϳ��� �÷��� �� ó�� �����ϰų� �÷��� ���ͷ� ����

select EMP_NAME || dept_code "�̸��μ�", SALARY || '��'
from employee;


-- �񱳿����� ( >, >=, <, <=, .... )
-- BETWEEN A AND B
-- �޿��� 3500000�� �̻� �ް� 6000000�� ���Ϸ� �޴� ������ �̸��� �޿�
-- ��ȸ�Ͻÿ�

select EMP_name, salary
from employee
where salary between 3500000 and 6000000;


-- BETWEEN AND
-- EMPLOYEE ���̺��� ������� 90/01/01 ~ 01/01/01�� �����
-- ��ü ������ ����Ͻÿ�

select * from employee
where hire_date between '90/01/01' and '01/01/01';


select emp_name, salary
from employee
where emp_name not like '%��%';

select emp_name, salary
from employee
where emp_name like '��__';

-- �ǽ�����
--1. EMPLOYEE ���̺��� �̸� ���� ������ ������ ����� �̸��� ����Ͻÿ�
select emp_name
from employee 
where emp_name like '__��';

--2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ��
--����Ͻÿ�
select emp_name, phone
from employee
where phone not like'010%';

--3. EMPLOYEE ���̺��� �����ּ��� 's'�� ���鼭, DEPT_CODE�� D9 �Ǵ� D6�̰�
--������� 90/01/01 ~ 01/12/01�̸鼭, ������ 270�����̻��� ����� ��ü ������ ����Ͻÿ�
select * from employee
where (hire_date between '90/01/01' and '01/12/01') and salary>=2700000 and email like '%s%'
and (dept_code = 'D9' or dept_code = 'D6');

--4. EMPLOYEE ���̺��� EMAIL ID �� @ ���ڸ��� 5�ڸ��� ������ ��ȸ�Ѵٸ�?
select * from employee
where email like '_____@%';

--5. EMPLOYEE ���̺��� EMAIL ID �� '_' ���ڸ��� 3�ڸ��� ������ ��ȸ�Ѵٸ�?
select emp_name from employee
where email like '___#_%' escape '#';

select * from employee
where dept_code in('D6','D9'); --or ���

select bonus, manager_id
from employee
where bonus is null;

select bonus, manager_id
from employee
where bonus is not null;

-- 1. ������(MANAGER_ID)�� ���� �μ� ��ġ(DEPT_CODE)�� ���� ���� 
-- ������ �̸� ��ȸ
select emp_name from employee
where manager_id is null and dept_code is null;

-- 2. �μ���ġ�� ���� �ʾ����� ���ʽ��� �����ϴ� ���� ��ü ���� ��ȸ

select * from employee
where dept_code is null and bonus is not null;

-- ���� ORDER BY
-- SELECT�� �÷��� ���� ������ �� �� ����ϴ� ����
-- SELECT ������ ���� �������� �ۼ�(��) ��������� ���� �������� �����
--          ASC : �������� ����, DESC : �������� ����
-- DATE asc - > ���� -�ֽ� desc -�ֽ� ->����
-- NULL asc - null���� desc -  null����

select emp_name, salary, hire_date, bonus from employee
order by bonus, hire_date asc; -- asc �������� desc ��������

-- SELECT ���� ����
-- FROM - WHERE - (GROUP BY - HAVING) - SELECT - ORDER BY


