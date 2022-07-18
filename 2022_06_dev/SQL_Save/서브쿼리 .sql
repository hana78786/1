--@�ǽ����� 
--1. �����ؿ� �޿��� ���� ������� �˻��ؼ�, �����ȣ,����̸�, �޿��� ����϶�.

select emp_name, emp_id, salary from employee e
where salary=(select salary from employee where emp_name = '������')
and emp_name != '������';

--2. employee ���̺��� �⺻�޿��� ���� ���� ����� ���� ���� ����� ������ 
-- ���, �����, �⺻�޿��� ��Ÿ������.

select * from employee a
where not exists (select 1 from employee where salary> a.salary)
or not exists (select 1 from employee where salary< a.salary);



--3. D1, D2�μ��� �ٹ��ϴ� ����� �߿���
--�⺻�޿��� D5 �μ� �������� '��տ���' ���� ���� ����鸸 

select * from employee
where dept_code in ('D1','D2') and salary>
(select avg(salary) from employee where dept_code ='D5');

select avg(salary) from employee where dept_code ='D5';


-- �������� �ǽ� ����
--����1
--��������ο� ���� ������� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�

select emp_name, dept_code, salary from employee
where dept_code = (select dept_id from department where dept_title = '���������');


--����2
--��������ο� ���� ����� �� ���� ������ ���� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�

select emp_name, dept_code, salary from employee a
where  dept_code = (select dept_id from department where dept_title = '���������')
and
not exists (select * from employee where salary > a.salary  and dept_code = 'D8');


--����3
--�Ŵ����� �ִ� ����߿� ������ ��ü��� ����� �Ѱ� 
--���,�̸�,�Ŵ��� �̸�,����(������������)�� ���Ͻÿ�
 --* ��, JOIN�� �̿��Ͻÿ�
 
 select a.emp_id, a.emp_name, b.emp_name "�Ŵ���",salary/10000||'����' "����" from employee a
 join (select emp_name, emp_id from employee)b
 on a.manager_id = b.emp_id
 where manager_id is not NULL and salary >
 (select avg(salary) from employee);

--����4
--�μ� �� �� ���޸��� �޿� ����� ���� ���� ������ �̸�, �����ڵ�, �޿�, �޿���� ��ȸ

select dept_code, emp_name, job_code, salary, sal_level from employee a
where not exists (select * from employee where salary> a.salary
and job_code = a.job_code and dept_code = a.dept_code)
order by dept_code;


--����5
--�μ��� ��� �޿��� 2200000 �̻��� �μ���, ��� �޿� ��ȸ
--��, ��� �޿��� �Ҽ��� ����

select (select dept_title from department where dept_id = a.dept_code) , floor(avg(salary)) from employee a
group by dept_code
having (select dept_title from department where dept_id = a.dept_code) is not null and floor(avg(salary)) >= 2200000;


--����6
--������ ���� ��պ��� ���� �޴� ���ڻ����
--�����,�����ڵ�,�μ��ڵ�,������ �̸� ������������ ��ȸ�Ͻÿ�
--���� ��� => (�޿�+(�޿�*���ʽ�))*12    
-- �����,���޸�,�μ���,������ EMPLOYEE ���̺��� ���� ����� ������ 
-- ���޺� ����

select emp_name, job_code, dept_code, salary+(salary*nvl(bonus,0))*12 "����" from employee a
where substr(emp_no,8,1) in (2,4) and salary+(salary*nvl(bonus,0))*12 <
(select avg(salary+(salary*nvl(bonus,0))*12) from employee where job_code=a.job_code group by job_code) 
order by 1;
