

--[EMPLOYEE] ���̺��� �μ��ڵ� �׷캰 �޿��� �հ�,�׷캰 �޿��� ���(����ó��),
--�ο����� ��ȸ�ϰ�,�μ��ڵ� ������ ����

select dept_code,  sum(salary), ceil(avg(salary)), count(*) from employee
group by dept_code
order by dept_code;


--[EMPLOYEE] ���̺��� �μ��ڵ� �׷캰,���ʽ��� ���޹޴� ��� ���� ��ȸ�ϰ� �μ��ڵ� ������ ����
--BONUS�÷��� ���� �����Ѵٸ�,�� ���� 1�� ī����.
--���ʽ��� ���޹޴� ����� ���� �μ��� ����.
select dept_code, count(bonus) from employee
group by dept_code
order by dept_code;




--@�ǽ�����
--EMPLOYEE ���̺��� ������ J1�� �����ϰ�,���޺� ����� �� ��ձ޿��� ����ϼ���.

select job_name"����", trunc(avg(salary),2)"�޿����" from employee
join job
using(job_code)
group by job_name
having job_name != '��ǥ';



--EMPLOYEE���̺��� ������ J1�� �����ϰ�, �Ի�⵵�� �ο����� ��ȸ�ؼ�,�Ի�� �������� �������� �����ϼ���.

select extract(year from hire_date)"�Ի�⵵", count(*)"�ο���" from employee
group by extract(year from hire_date)
order by 1;


--[EMPLOYEE] ���̺��� EMP_NO�� 8��° �ڸ��� 1,3 �̸� '��',2,4 �̸� '��'�� ����� ��ȸ�ϰ�,
-- ������ �޿��� ���(����ó��),�޿��� �հ�,�ο����� ��ȸ�� �� �ο����� ���������� ���� �Ͻÿ�
select decode(substr(emp_no,8,1),1,'��',2,'��',3,'��',4,'��')"����",
round(avg(salary),1)"���", sum(salary)"�հ�", count(*)"�ο�" from employee
group by decode(substr(emp_no,8,1),1,'��',2,'��',3,'��',4,'��')
order by 4 desc;



--@�ǽ�����
--�μ��� ���� �ο����� ���ϼ���.
select decode(substr(emp_no,8,1),1,'��',2,'��',3,'��',4,'��')"����", count(*) from employee
group by decode(substr(emp_no,8,1),1,'��',2,'��',3,'��',4,'��');


--�μ��� �޿� ����� 3,000,000��(��������) �̻���  �μ��鿡 ���ؼ� �μ���, �޿������ ����ϼ���.
-- �μ����� �׷��� ������, �׷캰 �޿������ ������, ������ ������.
select dept_title"�μ���", trunc(avg(salary),2)"��ձ޿�" from employee
join department
on dept_code=dept_id
group by dept_title
having floor(avg(salary))>3000000;






--@�ǽ�����
--�μ��� �ο��� 5���� ���� �μ��� �ο����� ����ϼ���.

select dept_code,count(*) from employee
group by dept_code
having count(*) >5;



--�μ��� ���޺� �ο����� 3���̻��� ������ �μ��ڵ�, �����ڵ�, �ο����� ����ϼ���.
select dept_code, job_code, count(*) from employee
group by dept_code, job_code
having count(*)>=3;




--�Ŵ����� �����ϴ� ����� 2���̻��� �Ŵ������̵�� �����ϴ� ������� ����ϼ���.

select manager_id, count(*) from employee
group by manager_id 
having count(*)>2 and manager_id is not null;




-- rollup() : ��ȣ�� �׷��� �����ڵ带 ��� 
-- �μ���, ���޺� �޿��� �հ�� �μ��� �հ� ���ϱ�

select dept_code, job_code, trunc(avg(salary)) from employee
group by rollup(dept_code,job_code)
order by dept_code;



--cube() �׷�(1,2)���� 1�� �� 2�� 1+2�� �� ���
--�μ���, ���޺� �޿��� �հ�� �μ��� �հ�, ������ �հ豸�ϱ�

select dept_code, job_code, sum(salary) from employee
group by cube(dept_code,job_code)
order by dept_code;

--grouping
--���� �հ��� ���޺� �μ��� ���к��̱�
select dept_code, job_code, sum(salary) ,
(case when grouping (dept_code)=0 and grouping(job_code)=1 then '�μ����հ�'
when grouping(dept_code)=1 and grouping(job_code)=0 then '���޺��հ�'
when grouping (dept_code)=1 and grouping(job_code)=1 then '���հ�'
else '�μ�+�����հ�'
end) "����"
from employee
group by cube(dept_code,job_code)
order by dept_code;

-- JOIN ����
-- SELECT FROM 
-- JOIN ���̺�� ON (�÷�1 = �÷�2)
-- > ANSI ǥ�� ����(��� DBMS������ ��� ����)



-- > Oracle ���� ���� (����Ŭ DBMS������ ��� ����)



--@���νǽ�����_kh
--1. 2020�� 12�� 25���� ���� �������� ��ȸ�Ͻÿ�.
select to_char(to_date(20201225),'DAY') from dual;


--2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
select emp_name"�̸�", emp_no"�ֹι�ȣ", dept_title"�μ���", job_name"����" from employee
join department
on dept_code= dept_id
join job
using (job_code)
where substr(emp_no,8,1) in (2,4);




--3. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.

select emp_id, emp_name, dept_title from employee
join department
on dept_code = dept_id
where emp_name like '%��%';




--5. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.

select emp_name, dept_code, job_name, dept_title from employee
join department
on dept_code = dept_id
join job
using (job_code)
where location_id not like 'L1';




--6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.

select emp_name,bonus,dept_title,national_name from employee
join department
on dept_code =dept_id
join location
on location_id = local_code
join national
using (national_code)
where bonus is not null;



--7. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.

select emp_name, job_name, dept_title, national_name from employee
join department
on dept_code = dept_id
join job
using(job_code)
join location
on location_id = local_code
join national
using(national_code)
where dept_code = 'D2';





--8. �޿�������̺��� �ִ�޿�(MAX_SAL)���� ���� �޴� �������� �����, ���޸�, �޿�, ������ ��ȸ�Ͻÿ�.
-- (������̺�� �޿�������̺��� SAL_LEVEL�÷��������� ������ ��)
select emp_name"�����" , job_name "���޸�" , salary"�޿�" , salary*12"����" from employee
join job
using(job_code)
join department
on dept_code=dept_id
join sal_grade
using(sal_level)
where salary>max_sal;





--9. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, ������, �������� ��ȸ�Ͻÿ�.
select emp_name"�����", dept_title"�μ���",local_name"������",national_name"������" from employee
join department
on dept_code = dept_id
join location
on location_id =local_code
join national
using(national_code)
where national_code in ('KO','JP');



--10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�. ��, join�� IN ����� ��
select emp_name, job_name, salary from employee
join job
using (job_code)
where bonus is null and job_code in('J4','J7');



--11. �������� ������ ����� ������ ���� ��ȸ�Ͻÿ�.


