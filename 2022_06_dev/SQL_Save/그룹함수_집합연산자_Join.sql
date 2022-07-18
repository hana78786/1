-- �׷��Լ� --
SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code;

SELECT
    job_code,
    SUM(salary)
FROM
    employee
GROUP BY
    job_code;

--[EMPLOYEE] ���̺��� �μ��ڵ� �׷캰 �޿��� �հ�,�׷캰 �޿��� ���(����ó��),
--�ο����� ��ȸ�ϰ�,�μ��ڵ� ������ ����

SELECT
    dept_code,
    SUM(salary) "�޿��հ�",
    floor(AVG(salary) ) "�޿����",
    COUNT(*) "�ο���"
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;

--[EMPLOYEE] ���̺��� �μ��ڵ� �׷캰,���ʽ��� ���޹޴� ��� ���� ��ȸ�ϰ� �μ��ڵ� ������ ����
--BONUS�÷��� ���� �����Ѵٸ�,�� ���� 1�� ī����.
--���ʽ��� ���޹޴� ����� ���� �μ��� ����.

SELECT
    dept_code,
    COUNT(bonus)
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;



--@�ǽ�����
--EMPLOYEE ���̺��� ������ J1�� �����ϰ�,���޺� ����� �� ��ձ޿��� ����ϼ���.

SELECT
    job_code,
    COUNT(job_code),
    AVG(salary)
FROM
    employee
WHERE
    job_code != 'J1'
GROUP BY
    job_code;



--EMPLOYEE���̺��� ������ J1�� �����ϰ�, �Ի�⵵�� �ο����� ��ȸ�ؼ�,�Ի�� �������� �������� �����ϼ���.

SELECT
    EXTRACT(YEAR FROM(hire_date) ) "�Ի�⵵",
    COUNT(*)
FROM
    employee
GROUP BY
    EXTRACT(YEAR FROM(hire_date) )
ORDER BY "�Ի�⵵" ASC;


--[EMPLOYEE] ���̺��� EMP_NO�� 8��° �ڸ��� 1,3 �̸� '��',2,4 �̸� '��'�� ����� ��ȸ�ϰ�,
-- ������ �޿��� ���(����ó��),�޿��� �հ�,�ο����� ��ȸ�� �� �ο����� ���������� ���� �Ͻÿ�

SELECT
    DECODE(
        substr(emp_no,8,1),
        '1',
        '��',
        '3',
        '��',
        '2',
        '��',
        '4',
        '��'
    ) "����",
    trunc(AVG(salary),2),
    SUM(salary),
    COUNT(*)
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        '1',
        '��',
        '3',
        '��',
        '2',
        '��',
        '4',
        '��'
    );

SELECT
    dept_code,
    job_code,
    COUNT(bonus)
FROM
    employee
GROUP BY
    dept_code,
    job_code;

--@�ǽ�����
--�μ��� ���� �ο����� ���ϼ���.

SELECT
    dept_code,
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��',
        3,
        '��',
        4,
        '��'
    ) "����",
    COUNT(*) "�ο���"
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��',
        3,
        '��',
        4,
        '��'
    ),
    dept_code
ORDER BY dept_code;

--�μ��� �޿� ����� 3,000,000��(��������) �̻���  �μ��鿡 ���ؼ� �μ���, �޿������ ����ϼ���.
-- �μ����� �׷��� ������, �׷캰 �޿������ ������, ������ ������.


select dept_title, FLOOR(avg(salary)) from EMPLOYEE
left outer join department
on dept_code = dept_id
group by dept_title
having floor(avg(salary)) >= 3000000;


--@�ǽ�����
--�μ��� �ο��� 5���� ���� �μ��� �ο����� ����ϼ���.

select dept_title"�μ���", count(dept_title)"�ο���" from employee
left outer join department
on dept_code=dept_id
group by dept_title
having count(dept_title)>5;


--�μ��� ���޺� �ο����� 3���̻��� ������ �μ��ڵ�, �����ڵ�, �ο����� ����ϼ���.

select job_code, dept_code, count(*) from employee
group by job_code, dept_code
order by job_code;



--�Ŵ����� �����ϴ� ����� 2���̻��� �Ŵ������̵�� �����ϴ� ������� ����ϼ���.

select manager_id, COUNT(*) from employee
group by manager_id
-- where manager_id is not null
having count(*)>=2 and manager_id is not null
order by 1;


-- rollup() : ��ȣ�� �׷��� �����ڵ带 ��� 
SELECT DEPT_CODE, JOB_CODE, sum(salary)
FROM EMPLOYEE
GROUP BY cube(DEPT_CODE, JOB_CODE)
order by dept_code;

select
 DEPT_CODE,
    JOB_CODE,
    SUM(SALARY),
    CASE WHEN GROUPING(DEPT_CODE) = 0 AND GROUPING(JOB_CODE) = 1 THEN '�μ����հ�'
        WHEN GROUPING(DEPT_CODE) = 1 AND GROUPING(JOB_CODE) = 0 THEN '���޺��հ�'
        WHEN GROUPING(DEPT_CODE) = 1 AND GROUPING(JOB_CODE) = 1 THEN '���հ�'
        ELSE '�׷캰�հ�'
    END AS "����"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;


select emp_name, emp_id from employee
where dept_code='D5'

minus

select emp_name, emp_id from employee
where salary>=2400000;


select * from employee
join department
on dept_code= dept_id;

SELECT * FROM EMPLOYEE
join job
on job_code = job_code;

-- JOIN ����
-- SELECT FROM 
-- JOIN ���̺�� ON (�÷�1 = �÷�2)
-- > ANSI ǥ�� ����(��� DBMS������ ��� ����)
SELECT * FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;
-- > Oracle ���� ���� (����Ŭ DBMS������ ��� ����)
SELECT * FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;


SELECT job_name, emp_name FROM EMPLOYEE E
join job using(job_code);

select job_name, emp_name from employee 
join job on employee.job_code = job.job_code;

select * from employee 
right OUTER join  department
on dept_code = dept_id;

select * from employee 
left OUTER join  department
on dept_code = dept_id;


select * from employee 
inner join  department
on dept_code = dept_id
inner join job using(job_code);

select emp_name, dept_title, local_name from employee
inner join DEPARTMENT
on dept_code= dept_id
inner join location
on location_id = local_code;


--@���νǽ�����_kh
--1. 2020�� 12�� 25���� ���� �������� ��ȸ�Ͻÿ�.
select to_char(to_date('20201225'), 'DY"����"') from dual;


--2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
select emp_name, emp_no,job_name, dept_title from employee
inner join department
on dept_code = dept_id
inner join job
on employee.job_code = job.job_code
where substr(emp_no,1,2) between 70 and 79;




--3. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.

select emp_id, emp_name, dept_title from employee
join DEPARTMENT
on dept_code = dept_id
where emp_name like '%��%';




--5. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.

select emp_name, job_name, dept_code, dept_title, local_name from employee e
join department
on dept_code=dept_id
join job
on e.job_code = job.job_code
join location
on location_id = local_code
where location_id != 'L1';




--6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.

select emp_name, dept_title,bonus, local_name from employee
join department
on dept_code= dept_id
join location
on location_id = local_code
where bonus is not null;



--7. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.


select emp_name, dept_title, job_name, local_name from employee
join department 
on dept_code=dept_id
join job
using(job_code)
join location on location_id = local_code
where dept_code = 'D2';




--8. �޿�������̺��� �ִ�޿�(MAX_SAL)���� ���� �޴� �������� �����, ���޸�, �޿�, ������ ��ȸ�Ͻÿ�.
-- (������̺�� �޿�������̺��� SAL_LEVEL�÷��������� ������ ��)

select emp_name, salary, salary*12 from employee
join sal_grade
using(sal_level);



--9. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, ������, �������� ��ȸ�Ͻÿ�.
select emp_name, dept_title, national_name from employee
join DEPARTMENT
on dept_code=dept_id
join Location
on local_code = location_id
join national
using(national_code)
where national_code in ('KO','JP');

--10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�. ��, join�� IN ����� ��
select emp_name, job_name, salary from employee
join job
using (job_code)
where bonus is null and job_code in ('J4','J7');

--11. �������� ������ ����� ������ ���� ��ȸ�Ͻÿ�.

select 
decode(ent_yn,'Y','���','N','����') "��������",
count(*) from employee
group by decode(ent_yn,'Y','���','N','����');
