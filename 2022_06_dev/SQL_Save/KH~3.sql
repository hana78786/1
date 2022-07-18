select job_name from job;

select * from department;

-- 1. JOB���̺��� JOB_NAME�� ������ ��µǵ��� �Ͻÿ�
select job_name from job;



-- 2. DEPARTMENT���̺��� ���� ��ü�� ����ϴ� SELECT���� �ۼ��Ͻÿ�
select * from department;



-- 3. EMPLOYEE ���̺��� �̸�(EMP_NAME),�̸���(EMAIL),
-- ��ȭ��ȣ(PHONE),�����(HIRE_DATE)�� ����Ͻÿ�

select emp_name,email,phone,hire_date from employee;




-- 4. EMPLOYEE ���̺��� �����(HIRE_DATE) �̸�(EMP_NAME),����(SALARY)�� ����Ͻÿ�
select hire_date, emp_name, salary from employee;


-- 5. EMPLOYEE ���̺��� ����(SALARY)�� 2,500,000���̻��� ����� 
-- EMP_NAME �� SAL_LEVEL�� ����Ͻÿ� 

select emp_name, sal_level from employee
where salary>2500000;





-- (��Ʈ : >(ũ��) , <(�۴�) �� �̿�)
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))

-- 6. EMPLOYEE ���̺��� ����(SALARY)�� 350���� �̻��̸鼭 
-- JOB_CODE�� 'J3' �� ����� 
-- �̸�(EMP_NAME)�� ��ȭ��ȣ(PHONE)�� ����Ͻÿ�
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))

select emp_name,phone from employee
where salary>=3500000 and job_code ='J3';



-- ���� �ǽ� ����
--1. EMPLOYEE ���̺��� �̸�,����, �Ѽ��ɾ�(���ʽ�����), 
-- �Ǽ��ɾ�(�� ���ɾ�-(����*���� 3%*12))
--�� ��µǵ��� �Ͻÿ�

select emp_name "�̸�", salary*12 "����", salary*bonus + salary*12 "�� ���ɾ�",
salary*bonus + salary*12 - (salary*0.03*12) "�Ǽ��ɾ�" from employee;


--2. EMPLOYEE ���̺��� �̸�, �ٹ� �ϼ��� ����غ��ÿ� 
--(SYSDATE�� ����ϸ� ���� �ð� ���)

select emp_name "�̸�", sysdate-hire_date from employee;





--3. EMPLOYEE ���̺��� 20�� �̻� �ټ����� �̸�,����,���ʽ����� ����Ͻÿ�.
select emp_name,salary,bonus from employee
where (sysdate-hire_date)/365 >=20;

-- �ߺ����� ���ڵ� ���
select distinct job_code from employee
order by job_code;

-- ��������(AND, OR)
-- �μ��ڵ尡 D6�̰� �޿��� 2,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�.

select emp_name, dept_code from employee
where dept_code='D9' and salary >= 200000;


-- �μ��ڵ尡 D5 �Ǵ� �޿��� 3,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�
select emp_name, dept_code, salary from employee
where dept_code='D5' or salary >= 300000;


-- �񱳿����� ( >, >=, <, <=, .... )
-- BETWEEN A AND B ( A�̻� B���� )
-- �޿��� 3500000�� �̻� �ް� 6000000�� ���Ϸ� �޴� ������ �̸��� �޿�
-- ��ȸ�Ͻÿ�

select emp_name,salary from employee
where salary between 3500000 and 6000000;




-- BETWEEN AND
-- EMPLOYEE ���̺��� ������� 90/01/01 ~ 01/01/01�� �����
-- ��ü ������ ����Ͻÿ�

select * from employee
where hire_date between '90/01/01' and '01/01/01';



-- �ǽ�����
--1. EMPLOYEE ���̺��� �̸� ���� ������ ������ ����� �̸��� ����Ͻÿ�
select emp_name from employee
where emp_name like '%��';


--2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ��
--����Ͻÿ�

select emp_name,phone from employee
where phone not like '010%';



--3. EMPLOYEE ���̺��� �����ּ��� 's'�� ���鼭, DEPT_CODE�� D9 �Ǵ� D6�̰�
--������� 90/01/01 ~ 01/12/01�̸鼭, ������ 270�����̻��� ����� ��ü ������ ����Ͻÿ�
select * from employee
where email like '%s%' and dept_code in ('D9','D6') and 
(hire_date between '90/01/01' and '01/12/01') and salary>=2700000;


--4. EMPLOYEE ���̺��� EMAIL ID �� @ ���ڸ��� 5�ڸ��� ������ ��ȸ�Ѵٸ�?
select * from employee
where email like '_____@%';


--5. EMPLOYEE ���̺��� EMAIL ID �� '_' ���ڸ��� 3�ڸ��� ������ ��ȸ�Ѵٸ�?

select * from employee
where email like '___#_%' ESCAPE '#';





-- �� ������ ( IN )
-- ���Ϸ��� �� ��Ͽ� ��ġ�ϴ� ���� ������ TRUE�� ��ȯ�ϴ� ������
-- EMPLOYEE ���̺��� DEPT_CODE�� D9 �Ǵ� D6�� ������ �̸�, �޿��� ���
-- �Ͻÿ�.

select emp_name,salary from employee
where dept_code in ('D9','D6');




-- �� ������ ( IS NULL / IS NOT NULL )
-- NULL ���θ� ���ϴ� ������


-- 1. ������(MANAGER_ID)�� ���� �μ� ��ġ(DEPT_CODE)�� ���� ���� ������ �̸� ��ȸ

select emp_name from employee
where manager_id is null and dept_code is null;



-- 2. �μ���ġ�� ���� �ʾ����� ���ʽ��� �����ϴ� ���� ��ü ���� ��ȸ
select * from employee
where dept_code is null and bonus is not null;



-- ���ʽ��� �������� ��������/ �������� �����ϱ�
select emp_name from employee
order by bonus asc;

select emp_name from employee
order by bonus desc;


