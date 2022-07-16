
-- ���� �ǽ� ����
-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���

select emp_name, emp_no, hire_date from employee
where floor((sysdate-hire_date)/365) between 5 and 10;

-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ�, �����, �ٹ��Ⱓ, �������� �˻��Ͽ��� 
--(��� ���� : ENT_YN)

select emp_name, dept_code, hire_date, ent_date-hire_date, ent_date
from employee
where ent_yn='Y';

-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ��(�Ҽ���X)�� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.

select emp_name, salary*1.5 , floor((sysdate-hire_date)/365)"�ټӳ��"
from employee
where floor((sysdate-hire_date)/365) > 10
order by "�ټӳ��" asc;



-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�

select emp_name, emp_no, email, phone, salary, hire_date from employee
where (hire_date between '990101' and '100101') and salary<=2000000;

-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
-- ��, �μ��ڵ尡 null�� ����� �μ��ڵ尡 '����' ���� ��� �Ͽ���.

select emp_name, salary, nvl(dept_code,'����'), emp_no from employee
where (salary between 2000000 and 3000000) and (substr(emp_no,8,1))in(2,4)
and (substr(emp_no,3,2)=04)
order by emp_no desc;


-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����Ͽ���.

select emp_name,
(floor((sysdate-hire_date)/1000))*(salary*0.1)"Ư�� ���ʽ�"
from employee
where substr(emp_no,8,1) in (1,3) and bonus is null;
order by emp_name asc;

-- @�Լ� �����ǽ�����
--1. ������� �̸��� , �̸��� ���̸� ����Ͻÿ�
--		  �̸�	    �̸���		�̸��ϱ���
--	ex) 	ȫ�浿 , hong@kh.or.kr   	  13

select emp_name, email, length(email)"�̸��ϱ���" from employee;


--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����Ͻÿ�
--	ex) ���ö	no_hc
--	ex) ������	jung_jh

select emp_name , substr(email,1,instr(email,'@',1)-1) from employee;


--3. 60��뿡 �¾ ������� ���, ���ʽ� ���� ����Ͻÿ�. �׶� ���ʽ� ���� null�� ��쿡�� 0 �̶�� ��� �ǰ� ����ÿ�
--	    ������    ���      ���ʽ�
--	ex) ������	    1962	    0.3
--	ex) ������	    1963  	    0

select emp_name, nvl(bonus,0),extract(YEAR from to_date(substr(emp_no,1,6))) from employee
where substr(emp_no,1,2) between 60 and 69;


--4. '010' �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����Ͻÿ� (�ڿ� ������ ���� ���̽ÿ�)
--	   �ο�
--	ex) 3��


--5. ������� �Ի����� ����Ͻÿ� 
--	��, �Ʒ��� ���� ��µǵ��� ����� ���ÿ�
--	    ������		�Ի���
--	ex) ������		2012�� 12��
--	ex) ������		1997�� 3��

select emp_name, to_char(hire_date,'YYYY"��"MM"��"')"�Ի���" from employee;


--6. ������� �ֹι�ȣ�� ��ȸ�Ͻÿ�
--	��, �ֹι�ȣ 9��° �ڸ����� �������� '*' ���ڷ� ä������� �Ͻÿ�
--	ex) ȫ�浿 771120-1******
select emp_name, rpad(substr(emp_no,1,8),14,'*') from employee;


--7. ������, �����ڵ�, ����(��) ��ȸ
--  ��, ������ ��57,000,000 ���� ǥ�õǰ� ��
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
select emp_name, job_code,to_char(salary*12,'l999,999,999') "����" from employee;



--8. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� �����߿� ��ȸ��.
--   ��� ����� �μ��ڵ� �Ի���

select emp_id, emp_name, dept_code, hire_date from employee
where dept_code in('D5','D9') and extract(year from hire_date) =2004;

--9. ������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ 
--	* �ָ��� ���� , �Ҽ��� �Ʒ��� ����

select emp_name, hire_date, trunc(sysdate-hire_date) from employee;


--10. ������, �μ��ڵ�, �������, ����(��) ��ȸ
--   ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--   ���������� ������ �����Ϸ� ��µǰ� ��.
--   ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, �����
--	* �ֹι�ȣ�� �̻��� ������� ���ܽ�Ű�� ���� �ϵ���(200,201,214 �� ����)
--	* HINT : NOT IN ���

select emp_name, dept_code,to_char(to_date(substr(emp_no,1,6)),'YYYY"��" MM"��" DD"��"')"����",
extract(year from sysdate) - extract(year from to_date(substr(emp_no,1,6))) "����"
from employee
where emp_id not in (200,201,204);




--11. ������, �μ����� ����ϼ���.
--   �μ��ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�.(case ���)
--   ��, �μ��ڵ尡 D5, D6, D9 �� ������ ������ ��ȸ�ϰ�, �μ��ڵ� �������� �������� ������.
case

select emp_name, 
(case dept_code
when 'D5' then '�ѹ���'
when 'D6' then '��ȹ��'
when 'D9' then '������' end) "�μ���"
from employee
where dept_code in ('D5','D6','D9');










-- ���� �ǽ� ����
-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���
select emp_name, emp_no, salary, hire_date from employee
where floor((sysdate-hire_date)/365) between 5 and 10;



-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ�, �����, �ٹ��Ⱓ, �������� �˻��Ͽ��� 
--(��� ���� : ENT_YN)
select emp_name, dept_code, hire_date, ent_date-hire_date "�ٹ��Ⱓ",
ent_date from employee
where ent_yn = 'Y';




-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ��(�Ҽ���X)�� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.

select emp_name,salary*1.5, floor((sysdate-hire_date)/365) from employee
where floor((sysdate-hire_date)/365)>=10
order by 2;



-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�
select emp_name, emp_no, email, phone, salary from employee
where (hire_date between '990101' and '100101') and salary>=2000000;


-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
-- ��, �μ��ڵ尡 null�� ����� �μ��ڵ尡 '����' ���� ��� �Ͽ���.

select emp_name, emp_no, salary, nvl(dept_code,'����') from employee
where (salary between 2000000 and 3000000) and substr(emp_no,8,1) in (2,4)
and substr(emp_no,3,2)=04;





-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����Ͽ���.

select emp_name, 
floor((sysdate-hire_date)/365) * salary*0.1
from employee
where bonus is null and substr(emp_no,8,1) in (1,3);



-- @�Լ� �����ǽ�����
--1. ������� �̸��� , �̸��� ���̸� ����Ͻÿ�
--		  �̸�	    �̸���		�̸��ϱ���
--	ex) 	ȫ�浿 , hong@kh.or.kr   	  13

select emp_name, email, length(email) from employee;


--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����Ͻÿ�
--	ex) ���ö	no_hc
--	ex) ������	jung_jh

select emp_name, substr(email,1,instr(email,'@',1,1)-1) from employee;



--3. 60��뿡 �¾ ������� ���, ���ʽ� ���� ����Ͻÿ�. �׶� ���ʽ� ���� null�� ��쿡�� 0 �̶�� ��� �ǰ� ����ÿ�
--	    ������    ���      ���ʽ�
--	ex) ������	    1962	    0.3
--	ex) ������	    1963  	    0
select emp_name, extract(year from to_date(substr(emp_no,1,6)))"���", nvl(bonus,0) from employee
where  extract(year from to_date(substr(emp_no,1,6))) between 1960 and 1969 ;



--4. '010' �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����Ͻÿ� (�ڿ� ������ ���� ���̽ÿ�)
--	   �ο�
--	ex) 3��
select count(*) from employee
where phone not like '010%';


--5. ������� �Ի����� ����Ͻÿ� 
--	��, �Ʒ��� ���� ��µǵ��� ����� ���ÿ�
--	    ������		�Ի���
--	ex) ������		2012�� 12��
--	ex) ������		1997�� 3��

select emp_name, to_char(hire_date,'YYYY"��" MM"��"')from employee;



--6. ������� �ֹι�ȣ�� ��ȸ�Ͻÿ�
--	��, �ֹι�ȣ 9��° �ڸ����� �������� '*' ���ڷ� ä������� �Ͻÿ�
--	ex) ȫ�浿 771120-1******

select emp_name, 

rpad(substr(emp_no,1,8),14,'*') 

from employee;



--7. ������, �����ڵ�, ����(��) ��ȸ
--  ��, ������ ��57,000,000 ���� ǥ�õǰ� ��
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���

select emp_name, job_code, to_char(salary*12,'l999,999,999')||'��' from employee;



--8. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� �����߿� ��ȸ��.
--   ��� ����� �μ��ڵ� �Ի���

select emp_id, emp_name, dept_code, hire_date from employee
where dept_code in ('D5','D9') and extract(year from hire_date) = 2004;

--9. ������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ 
--	* �ָ��� ���� , �Ҽ��� �Ʒ��� ����

select emp_name, hire_date, trunc(sysdate-hire_date) from employee;


--10. ������, �μ��ڵ�, �������, ����(��) ��ȸ
--   ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--   ���������� ������ �����Ϸ� ��µǰ� ��.
--   ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, �����
--	* �ֹι�ȣ�� �̻��� ������� ���ܽ�Ű�� ���� �ϵ���(200,201,214 �� ����)
--	* HINT : NOT IN ���

select emp_name, dept_code, to_char(to_date(substr(emp_no,1,6)),'YYYY"��" MM"��" DD"��"')"����",
extract(year from sysdate)- extract(year from to_date(substr(emp_no,1,6)))"����" from employee
where emp_id not in (200,201,214);




--11. ������, �μ����� ����ϼ���.
--   �μ��ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�.(case ���)
--   ��, �μ��ڵ尡 D5, D6, D9 �� ������ ������ ��ȸ�ϰ�, �μ��ڵ� �������� �������� ������.

select emp_name, decode(dept_code,'D5','�ѹ���','D6','��ȹ��','D9','������') from employee
where dept_code in ('D5','D6','D9');


