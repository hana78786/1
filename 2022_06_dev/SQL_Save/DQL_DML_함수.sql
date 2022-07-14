INSERT INTO employee VALUES (
    '900',
    '��ä��',
    '901123-2080503',
    'jang_ch@kh.or.kr',
    '01055569512',
    'D1',
    'J8',
    'S3',
    4300000,
    0.2,
    '200',
    SYSDATE,
    NULL,
    'N'
);

COMMIT;

ROLLBACK;

DELETE FROM employee WHERE
    emp_name = '��ä��';

SELECT
    SYSDATE
FROM
    dual;

SELECT
    length('hello')
FROM
    dual;

SELECT
    length(email)
FROM
    employee;

--���ڿ��� ����,���ڿ��� ����Ʈ ����
--length lengthb

SELECT
    emp_name,
    lengthb(emp_name),
    length(emp_name)
FROM
    employee;

--���ڿ��� ��ġ
--instr instrb
--instr(data,str,1,1) -> 1����-1������ ,1(���ʿ������� ��������)���°�� ã������

SELECT
    instr(
        'hello world hi high',
        'h',
        -1,
        2
    ),
    instr(
        'hello world hi high',
        'h',
        -1,
        3
    ),
    instr(
        'hello world hi high',
        'h',
        -1,
        4
    )
FROM
    dual; --������ ���̺�

-- EMPLOYEE���̺��� EMAIL �÷��� ���ڿ� �� '@'�� ��ġ�� ���Ͻÿ�

SELECT
    instr(
        email,
        '@',
        1,
        1
    ) -- emailĮ������ @�� ���ʱ������� ù��°�ΰ� �����°�� �����ϴ���
--�⺻���̶� (1,1)�� ���� ����!
FROM
    employee;

-- lapd/prad -left right(����)

SELECT
    email,
    rpad(email,20,'#'),
    lpad(email,20,'*')
FROM
    employee;
-- ltrtim/rtrim

SELECT
    ltrim('    kh')
FROM
    dual;

SELECT
    ltrim('00001234','0')
FROM
    dual;

SELECT
    rtrim('123456-1002300','00')
FROM
    dual;

SELECT
    ltrim('abadcsdkhab','abcds')
FROM
    dual;
--���� ������ ���ع��ڸ� �����ϴٰ� �����Ҽ� ���� ���ڰ� ������ ��������
--trim

SELECT
    TRIM('   kh     '),
    TRIM('z' FROM 'zzzzzkhzzzzzz')
FROM
    dual;

SELECT
    TRIM(LEADING 'z' FROM 'zzzzzkhzzzzz'),
    TRIM(TRAILING 'z' FROM 'zzzzkhzzzzz')
FROM
    dual;

-- �ǽ� ���� 1
-- Hello KH Java ���ڿ��� Hello KH �� ��µǰ� �Ͽ���.

SELECT
    rtrim('Hello KH java','java')
FROM
    dual;


-- �ǽ� ���� 2
-- Hello KH Java ���ڿ��� KH Java �� ��µǰ� �Ͽ���.

SELECT
    ltrim('Hello Kh java','Hello')
FROM
    dual;


-- �ǽ� ���� 3 (TRIM���� �غ�����)
-- DEPARTMENT ���̺��� DEPT_TITLE�� ����Ͽ���
-- �̶�,������ �� ���ڸ� ���� ��µǵ��� �Ͽ��� / ex)ȸ������� -> ȸ�����

SELECT
    TRIM(TRAILING '��' FROM dept_title)
FROM
    department;

-- �ǽ� ���� 4
-- �������ڿ����� �յ� ��� ���ڸ� �����ϼ���.
-- '982341678934509hello89798739273402'

SELECT
    rtrim(
        ltrim('982341678934509hello89798739273402','1234567890'),
        '1234567890'
    ) AS "���ڿ�"
FROM
    dual;

--substr

SELECT
    substr('show me the meony',6)
FROM
    dual; -- me the money

SELECT
    substr('show me the money',6,2)
FROM
    dual; --me

SELECT
    substr('show me the money',-8,2)
FROM
    dual; --he (-8�� �ڿ��� 6��°)

-- �ǽ�����1
-- ������� ���� ���������� ����ϼ���
-- (���� ��������� �ߺ����̵� ����غ�����)

SELECT DISTINCT
    substr(emp_name,0,1) AS "��"
FROM
    employee
ORDER BY "��" ASC;
     



-- �ǽ�����2
-- EMPLOYEE ���̺��� ���ڸ� �����ȣ,�����,�ֹι�ȣ,������ ����ϼ���
-- ��,�ֹι�ȣ �� 6�ڸ��� * ó���ϼ���.

SELECT
    emp_id,
    emp_name,
    rpad(
        substr(emp_no,1,8),
        14,
        '*'
    ) "�ֹι�ȣ",
    salary * 12 "����"
FROM
    employee
WHERE
    emp_no LIKE '______-1%';
  
  --replace 

SELECT
    replace('kh hate','hate','love')
FROM
    dual;

SELECT
    replace('kn@naver.com','naver.com','iei.or.kr')
FROM
    dual;

-- �ǽ�����
-- EMPLOYEE ���̺��� ��� ������ �̸�,�ֹι�ȣ,EMAIL�� ����Ͻÿ�
-- ��,��½� EMAIL�� �ּҸ� kh.or.kr���� iei.or.kr�� �����Ͽ� ����Ͻÿ�.
-- ��,id�� kh�� ������ ������� �ʵ��� �Ͻÿ�

SELECT
    emp_name,
    emp_no,
    substr(
        email,
        1,
        instr(
            email,
            '@',
            1,
            1
        ) - 1
    )
     || replace(
        substr(
            email,
            instr(
                email,
                '@',
                1,
                1
            )
        ),
        'kh',
        'iei'
    ) "�̸���"
-- �ڸ���(email����,1����,a -1����)
-- a: ã�´�(email����,'@'��,���ʺ��� ,ù��°) 
-- ��ü�Ѵ� (b����,'kh'��,'iei'��)
-- b:�ڸ���(email����,c����)
-- c:ã�´�(email����,'@'��,���ʺ���.ù��°)
FROM
    employee;

SELECT
    substr(
        email,
        1,
        instr(
            email,
            '@',
            1,
            1
        ) - 1
    )
     || replace(
        substr(
            email,
            instr(
                email,
                '@',
                1,
                1
            )
        ),
        'kh',
        'iei'
    )
FROM
    employee;

SELECT
    substr(
        email,
        1,
        instr(email,'@',1)
    )
     || replace(
        substr(
            email,
            instr(email,'@',1) + 1
        ),
        'kh',
        'hello'
    )
FROM
    employee;

-- �����Լ�
-- abs,mod,round,floor,trunc,ceil

SELECT
    round(123.456)
FROM
    dual; --123
--round ������ �ݿø�

SELECT
    round(123.456,1)
FROM
    dual; -- 123.5 /1-> �Ҽ��� 2��° �ڸ� 

SELECT
    round(123.456,2)
FROM
    dual;  -- 123.46

SELECT
    round(123.456,-1)
FROM
    dual; -- 120,/-1-> ����1�ڸ� �ݿø�

SELECT
    trunc(123.456,1)
FROM
    dual; --123.4 ����,1-> �Ҽ��� 2°�ڸ� ����

SELECT
    trunc(123.456,2)
FROM
    dual;-- 123.45

SELECT
    ceil(123.456)
FROM
    dual; --124 -> ������ �ø�

SELECT
    ceil(123.456,1)
FROM
    dual; -- ���� �Ҽ��� �ȵ�

SELECT
    emp_name,
    round(SYSDATE - hire_date),---> �ٹ��ϼ��� �ݿø��Ҽ��ִ�.
    trunc(SYSDATE - hire_date),--> �ٹ��ϼ� �Ҽ��� �ڸ� ����
    floor(SYSDATE - hire_date),
    ceil(SYSDATE - hire_date)
FROM
    employee;

SELECT
    SYSDATE
FROM
    dual;
--Months_between
--�� ��¥�� ������ -> �ٹ�������

SELECT
    ceil(months_between(SYSDATE,hire_date) ) "�ٹ�������"
FROM
    employee; --<-�ø�����
--add_months(���ް��� ��¥,����)

SELECT
    add_months(SYSDATE,3)
FROM
    dual;

SELECT
    add_months(hire_date,3)
FROM
    employee; --> �Ի��ϰ� 3���� �� ��¥
-- next_day
-- ���� ��¥�� �������� ������ ���� ������ ��¥�� �˷��ش� (���� 14�� �����: ���� �������? ->21��)

SELECT
    next_day(SYSDATE,'������'),
    next_day(SYSDATE,'��'),
    next_day(SYSDATE,3) --<- 3�� ��,��,ȭ 3���� ���� ȭ������ ����
FROM
    dual;

-- Last_day

SELECT
    last_day(SYSDATE)
FROM
    dual; -- �̹����� ������ ���� ��ȸ

SELECT
    last_day(hire_date)
FROM
    employee; --�Ի��� ���� ������ ���� ��ȸ

/*
    ���࿡ �ڽ��� ���� ���뿡 ���ٰ� �սô�.
    ������ �Ⱓ�� 1�� 6�����̶�� �����ϸ�
    1. �������ڰ� �������� ���ϰ�
    2. �������ڱ��� �Ծ���ϴ� «���� �׸����� ���غ�����
    (��,1�� 3�� ������ �Դ´ٰ� �����մϴ�)
    ���̺��� DUAL�� �ϼ���.
*/

SELECT
    SYSDATE "�Դ���",
    add_months(SYSDATE,18) "��������",
    ( add_months(SYSDATE,18) - SYSDATE ) * 3 "�׸���"
FROM
    dual;

-- @ �ǽ����� 1
-- EMPLOYEE ���̺��� ����� �̸�,�Ի���,������ ����Ͽ���. 
-- ��,�Ի����� YYYY��M��D�Ϸ� ����ϵ��� �Ͽ���.
-- ���� ����� �Ҽ��� �ϰ�� �ø����� �Ͽ� ����Ͽ���. (28.144 -> 29����)
-- (��½� ������ �Ի��� �������� ��������)

SELECT
    emp_name "�̸�",
    EXTRACT(YEAR FROM hire_date)
     || '�⵵'
     || EXTRACT(MONTH FROM hire_date)
     || '��'
     || EXTRACT(DAY FROM hire_date)
     || '��' "�Ի���",
    ceil( (SYSDATE - hire_date) / 365) "����"
FROM
    employee;

-- @ �ǽ����� 2
-- Ư�� ���ʽ��� �����ϱ� ���Ͽ� �ڷᰡ �ʿ��ϴ�
-- �Ի����� �������� ������ 1�� ���� 6������ ����Ͽ� 
-- ����Ͻÿ� (�̸�,�Ի���,������,������+6,���ش�(��))
-- ex) 90��2��6�� �Ի� -> 90��3��1�� ���� ���
-- ex) 90��2��26�� �Ի� -> 90��3��1�� ���� ���
-- ex) 97��12��1�� �Ի� -> 98��1��1�� ���� ���
-- ��½� �Ի��� �������� �����Ͻÿ�

SELECT
    emp_name "�̸�",
    EXTRACT(YEAR FROM hire_date)
     || '�⵵'
     || EXTRACT(MONTH FROM hire_date)
     || '��'
     || EXTRACT(DAY FROM hire_date)
     || '��' "�Ի���",
    EXTRACT(YEAR FROM last_day(hire_date) + 1)
     || '�⵵'
     || EXTRACT(MONTH FROM last_day(hire_date) + 1)
     || '��'
     || EXTRACT(DAY FROM last_day(hire_date) + 1)
     || '��' "������",
    EXTRACT(YEAR FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '�⵵'
     || EXTRACT(MONTH FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '��'
     || EXTRACT(DAY FROM add_months(
        last_day(hire_date) + 1,
        6
    ) )
     || '��' "6����",--->6�������,�Ի��Ѵ��� �������� +1�Ϻ���
    EXTRACT(MONTH FROM(last_day(hire_date) + 1) )
     || '��' "���ش�"
FROM
    employee;

SELECT
    TO_CHAR(SYSDATE,'YYYY-MM-DD'),--2022-07-14
    TO_CHAR(SYSDATE,'YYYY-MM-DD AMHH12"��"Mi"��"SS"��"') --2022-07-14 ����02��43��30��
FROM
    dual;

-- EMPLOYEE ���̺��� �����,�����(ex. 1990/02/06(ȭ))�� ����ϼ���.

SELECT
    TO_CHAR(hire_date,'YYYY/MM/DD(DY)')
FROM
    employee;

SELECT
    TO_DATE(20220613)
FROM
    dual;

SELECT
    TO_DATE(20220613,'YYYYMMDD')
FROM
    dual;  --���Ʒ� ����� ����

SELECT
    TO_DATE(22220613040501,'YYYYMMDDHH24MISS')
FROM
    dual;

-- to_number
-- number������ ���� �� ��ȯ
-- ���� ����
-- ,(9,999) : �޸��������� ��ȯ
-- . (99.99) : �Ҽ��� �������� ��ȯ
-- 0:�ǿ��ʿ� 0�� ����,$:$��ȭ�� ǥ��,L:������ȭ�� ǥ��(�ѱ��� \)
-- ���� ǥ�� ������ �� ������ ����� ũ�� ũ�⸦ ��ƾ� ��.

SELECT
    to_number('90,000','999,999,999'),--90000
    TO_CHAR(90000,'000,000,000'),-- 000,090,000
    TO_CHAR(90000,'999,999,999') --      90,000
FROM
    dual;

SELECT
    to_number('1,000,000','9,999,999') - to_number('550,000','9,999,999') -- 500,000�� 500000���� �ν��ϱ����� ���� 9,999,999�� �ٿ��ذ�
FROM
    dual; --�� tonumber-�� tonumber��

SELECT
    bonus * 100
FROM
    employee;

SELECT
    nvl(bonus,0) * 100
FROM
    employee; --null�� ���� 0���� �ν���!!!

SELECT
    salary * 12 + salary * nvl(bonus,0)
FROM
    employee;

SELECT
    emp_id,
    emp_name,
    (
        CASE
            WHEN
                substr(emp_no,8,1) = 1
            OR
                substr(emp_no,8,1) = 3
            THEN '��'
            WHEN
                substr(emp_no,8,1) = 2
            OR
                substr(emp_no,8,1) = 4
            THEN '��'
            ELSE '����'
        END
    ) "����"
FROM
    employee;

-- EMPLOYEE ���̺��� ����⵵ ���� 60��� �� ������ ���Ͽ� 
-- 65������ ����ڴ� 60��� �ʹ�,65�� ���� ����ڴ� 60��� �Ĺ��̶�� ����Ͻÿ�

SELECT
    emp_id,
    emp_name,
    emp_no,
        CASE
            WHEN substr(emp_no,0,2) < 65  THEN '60��� �ʹ�'
            WHEN substr(emp_no,0,2) >= 65 THEN '60��� �Ĺ�'
            ELSE '�ش����'
        END
    "����"
FROM
    employee
WHERE
    substr(emp_no,0,2) BETWEEN 60 AND 69;

SELECT
    emp_id,
    emp_name,
    emp_no,
        CASE
            WHEN
                substr(emp_no,0,2) >= 60
            AND
                substr(emp_no,0,2) < 70
            AND
                substr(emp_no,0,2) < 65
            THEN '60��� �ʹ�'
            WHEN
                substr(emp_no,0,2) >= 60
            AND
                substr(emp_no,0,2) < 70
            AND
                substr(emp_no,0,2) >= 65
            THEN '60��� �Ĺ�'
            ELSE '�ش����'
        END
    "����"
FROM
    employee;

SELECT
    DECODE(
        substr(emp_no,8,1),
        '1',
        '��',
        '2',
        '��',
        '3',
        '��',
        '4',
        '��',
        '����'
    ) "����"
FROM
    employee;

-- ������ �����ڵ忡 ���� �ش����޸��� ����ϼ���. (job���̺�����)

SELECT
    emp_name "�����",
    job_code "�����ڵ�",
    DECODE(
        job_code,
        'J1',
        '��ǥ',
        'J2',
        '�λ���',
        'J3',
        '����',
        'J4',
        '����',
        'J5',
        '����',
        'J6',
        '�븮',
        'J7',
        '���',
        '�ش����'
    ) "���޸�"
FROM
    employee;

SELECT
    job_code,
    job_name
FROM
    job;
    
    
    
    -- ���� �ǽ� ����
-- ����1. 
-- �Ի����� 5�� �̻�,10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���

SELECT
    emp_name,
    emp_no,
    salary,
    hire_date
FROM
    employee
WHERE
    ( SYSDATE - hire_date ) / 365 BETWEEN 5 AND 10;



-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ�,�����,�ٹ��Ⱓ,�������� �˻��Ͽ��� 
--(��� ���� : ENT_YN)

SELECT
    emp_name,
    dept_code,
    ent_date - hire_date,
    ent_date
FROM
    employee
WHERE
    ent_yn = 'Y';


-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ��(�Ҽ���X)�� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
-- ��,�޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.

SELECT
    emp_name,
    salary * 1.5,
    ceil( (SYSDATE - hire_date) / 365) "�ټӳ��"
FROM
    employee
WHERE
    ceil( (SYSDATE - hire_date) / 365) >= 10
ORDER BY "�ټӳ��" ASC;



-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�

SELECT
    emp_name,
    emp_no,
    phone,
    salary,
    hire_date
FROM
    employee
WHERE
    hire_date BETWEEN '990101' AND '100101';

-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
-- ��,�μ��ڵ尡 null�� ����� �μ��ڵ尡 '����' ���� ��� �Ͽ���.

SELECT
    emp_name,
    emp_no,
    nvl(dept_code,'����') "�μ��ڵ�",
    salary
FROM
    employee
WHERE
    (
        salary BETWEEN 2000000 AND 3000000
    ) AND
        substr(emp_no,8,1) = 2
ORDER BY emp_no DESC;



-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��,�̸� ������ ���� ���� �����Ͽ� ����Ͽ���.

select emp_name,salary,
trunc((sysdate-hire_date)/1000)*(salary*0.1) "Ư�����ʽ�"
from employee
where substr(emp_no,8,1)=1 and bonus is null
order by emp_name asc;



-- @�Լ� �����ǽ�����
--1. ������� �̸��� ,�̸��� ���̸� ����Ͻÿ�
--		  �̸�	    �̸���		�̸��ϱ���
--	ex) 	ȫ�浿 ,hong@kh.or.kr   	  13

select emp_name,email, length(email)"���ϱ���" from employee;


--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����Ͻÿ�
--	ex) ���ö	no_hc
--	ex) ������	jung_jh
select emp_name,
substr(email,1,
instr(email,'@',1)-1
)"�̸��Ͼ��̵�"
from employee;

--3. 60��뿡 �¾ ������� ���,���ʽ� ���� ����Ͻÿ�. �׶� ���ʽ� ���� null�� ��쿡�� 0 �̶�� ��� �ǰ� ����ÿ�
--	    ������    ���      ���ʽ�
--	ex) ������	    1962	    0.3
--	ex) ������	    1963  	    0

select emp_name, 19||substr(emp_no,1,2)"���",nvl(bonus,0)"���ʽ�" from employee
where substr(emp_no,1,2)<70 and substr(emp_no,1,2)>59;


--4. '010' �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����Ͻÿ� (�ڿ� ������ ���� ���̽ÿ�)
--	   �ο�
--	ex) 3��

select group by ||'��' "�ο�" from EMPLOYEE;


--5. ������� �Ի����� ����Ͻÿ� 
--	��,�Ʒ��� ���� ��µǵ��� ����� ���ÿ�
--	    ������		�Ի���
--	ex) ������		2012�� 12��
--	ex) ������		1997�� 3��


select emp_name "������", to_char(hire_date,'YYYY"��" MM"��') "�Ի���" from employee;



--6. ������� �ֹι�ȣ�� ��ȸ�Ͻÿ�
--	��,�ֹι�ȣ 9��° �ڸ����� �������� '*' ���ڷ� ä������� �Ͻÿ�
--	ex) ȫ�浿 771120-1******

select emp_name "������", 
rpad(substr(emp_no,1,8),14,'*') "�ֹι�ȣ"
from employee;


--7. ������,�����ڵ�,����(��) ��ȸ
--  ��,������ ��57,000,000 ���� ǥ�õǰ� ��
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���

select emp_name, job_code, to_char((salary*12),'L999,999,999') "����" from employee;


--8. �μ��ڵ尡 D5,D9�� ������ �߿��� 2004�⵵�� �Ի��� �����߿� ��ȸ��.
--   ��� ����� �μ��ڵ� �Ի���

select emp_id,emp_name, dept_code, hire_date,
extract(year from hire_date)
from employee
where (dept_code in('D5','D9')) and 
(extract(year from hire_date)=2004);

--9. ������,�Ի���,���ñ����� �ٹ��ϼ� ��ȸ 
--	* �ָ��� ���� ,�Ҽ��� �Ʒ��� ����
select emp_name, hire_date, trunc(sysdate-hire_date) from employee;



--10. ������,�μ��ڵ�,�������,����(��) ��ȸ
--   ��,��������� �ֹι�ȣ���� �����ؼ�,
--   ���������� ������ �����Ϸ� ��µǰ� ��.
--   ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����,�����
--	* �ֹι�ȣ�� �̻��� ������� ���ܽ�Ű�� ���� �ϵ���(200,201,214 �� ����)
--	* HINT : NOT IN ���

select emp_name, dept_code,to_char(to_date(substr(emp_no,1,6)),'YYYY"��"MM"��"DD"��"')"����",
extract(Year from sysdate)- extract(Year from(to_date(substr(emp_no,1,6))))"����"
from employee
where emp_id not in (200,201,204);



--11. ������,�μ����� ����ϼ���.
--   �μ��ڵ尡 D5�̸� �ѹ���,D6�̸� ��ȹ��,D9�̸� �����η� ó���Ͻÿ�.(case ���)
--   ��,�μ��ڵ尡 D5,D6,D9 �� ������ ������ ��ȸ�ϰ�,�μ��ڵ� �������� �������� ������.

select emp_name, 
(case
when
dept_code ='D5' then '�ѹ���'
when dept_code = 'D6' then '��ȹ��'
when dept_code = 'D9' then '������'
END)"�μ���"
from employee
where dept_code in ('D5','D6','D9')
order by dept_code asc;