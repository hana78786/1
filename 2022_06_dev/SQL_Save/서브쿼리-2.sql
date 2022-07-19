-- ex) �޿� ��հ� �̻��� �޿��� �޴� ����� �˻��Ͻÿ�
select * from employee
where salary>= (select avg(salary) from employee);



-- ex) ������ ������ ������ �̸��� ����Ͽ���.

select emp_name from employee a
where emp_id = (select manager_id from employee
where emp_name ='������');



--@�ǽ����� 
--1. �����ؿ� �޿��� ���� ������� �˻��ؼ�, �����ȣ,����̸�, �޿��� ����϶�.
select * from employee 
where salary = (select salary from employee where emp_name = '������') and
emp_name != '������';




--2. employee ���̺��� �⺻�޿��� ���� ���� ����� ���� ���� ����� ������ 
-- ���, �����, �⺻�޿��� ��Ÿ������.

select * from employee a where
salary = (select max(salary) from employee) or
not exists (select 1 from employee where a.salary>salary);



--3. D1, D2�μ��� �ٹ��ϴ� ����� �߿���
--�⺻�޿��� D5 �μ� �������� '��տ���' ���� ���� ����鸸 
--�μ���ȣ, �����ȣ, �����, ������ ��Ÿ������.

select * from employee 
where salary > (
select avg(salary) from employee where dept_code = 'D5');

/*
select dept_code from employee
where emp_name in ('������', '�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ��� ��� ���

*/

select * from employee
where dept_code in (select dept_code from employee where emp_name in ('���߱�','�ڳ���'));



/*
select dept_code from employee
where emp_name in ('������', '�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ����� ��� ���

*/

select * from employee
where dept_code not in (select dept_code from employee where emp_name in ('���߱�','�ڳ���'));



select * from employee
where dept_code in (select dept_code from employee where emp_name in ('������','�ڳ���'));




--3. ������ J1, J2, J3�� �ƴ� ����߿��� �ڽ��� �μ��� ��ձ޿����� ���� �޿��� �޴� ������.
-- �μ��ڵ�, �����, �޿�, �μ��� �޿����
-- join���� Ȱ��!!

select dept_code, emp_name, salary, 
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code)"�μ����޿�"
 from employee a
where job_code not in ('J1','J2','J3') and salary>
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code);

select a.dept_code, emp_name, salary from employee e
join (select dept_code, round(avg(salary))"���" from employee group by dept_code)a
on a.dept_code = e.dept_code
where job_code not in ('J1','J2','J3') and salary> ���;

select e.dept_code, emp_name, salary from employee e 
join (select dept_code, round(avg(salary))"���" from employee group by dept_code)a
on e.dept_code = a.dept_code
where job_code not in ('J1','J2','J3') and salary > "���";


/*select*from(�ζ��κ�)
where ���� = "��"  --  �̸� ���� ���*/

select * from 
(select emp_name, decode(substr(emp_no,8,1),1,'��',3,'��','��')"����" from employee)
where ���� = '��';

-- rownum�� �̿��Ͽ� ��ŷ 5 ���ϱ�
--from���� �ζ��κ� ���

select rownum, emp_name, salary from (select emp_name, salary from employee order by salary)
where rownum between 1 and 9;


/*���������� �̿��� �μ�Ʈ�غ���*/


