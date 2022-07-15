/*1. �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��,��� ����� "�а� ��","�迭" 
���� ǥ���ϵ��� ����.
�а� �� �迭
-------------------- --------------------
������а� �ι���ȸ
������а� �ι���ȸ
���а� �ι���ȸ
ö�а� �ι���ȸ
���а� �ι���ȸ
�����а� �ι���ȸ
��
��
ü���а� ��ü��*/
SELECT
    department_name "�а� ��",
    category "�迭"
FROM
    tb_department;


/*2. �а��� �а� ������ ������ ���� ���·� ȭ�鿡 �������.
�а��� ����
------------------------------------------------
������а��� ������ 20 �� �Դϴ�.
������а��� ������ 36 �� �Դϴ�. 
���а��� ������ 28 �� �Դϴ�.
ö�а��� ������ 28 �� �Դϴ�. 
...
... 
63 rows selected*/

SELECT
    department_name
     || '�� ������'
     || capacity
     || ' �� �Դϴ�' "�а��� ����"
FROM
    tb_department;


/*3. "������а�" �� �ٴϴ� ���л� �� ���� �������� ���л��� ã�ƴ޶�� ��û��
���Դ�. �����ΰ�? (�����а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ�
ã�� ������ ����)
STUDENT_NAME
--------------------
������
*/

SELECT
    student_name,
    student_ssn
FROM
    tb_student
WHERE
        department_no = 001
    AND
        substr(student_ssn,8,1) IN (
            2,4
        );


/*4. ���������� ���� ���� ��� ��ü�� ���� ã�� �̸��� �Խ��ϰ��� ����. �� ����ڵ���
�й��� ������ ���� �� ����ڵ��� ã�� ������ SQL ������ �ۼ��Ͻÿ�.
A513079,A513090,A513091,A513110,A513119
STUDENT_NAME
--------------------
ȫ����
�ְ���
������
����ȯ
�̰�
*/

SELECT
    student_name
FROM
    tb_student
WHERE
    student_no IN (
        'A513079','A513090','A513091','A513110','A513119'
    )
ORDER BY student_name DESC;


/*5. ���������� 20 �� �̻� 30 �� ������ �а����� �а� �̸��� �迭�� ����Ͻÿ�.
DEPARTMENT_NAME CATEGORY
-------------------- --------------------
������а� �ι���ȸ
���а� �ι���ȸ
ö�а� �ι���ȸ
��
��
�̼��а� ��ü��
����������а� ��ü��
ü���а� ��ü��*/

SELECT
    department_name,
    category
FROM
    tb_department
WHERE
    capacity BETWEEN 20 AND 30;


/*6. �� ������б��� ������ �����ϰ� ��� �������� �Ҽ� �а��� ������ �ִ�. �׷� ��
������б� ������ �̸��� �˾Ƴ� �� �ִ� SQL ������ �ۼ��Ͻÿ�.
PROFESSOR_NAME
--------------------
������*/

SELECT
    professor_name
FROM
    tb_professor
WHERE
    department_no IS NULL;



/*7. Ȥ�� ������� ������ �а��� �����Ǿ� ���� ���� �л��� �ִ��� Ȯ���ϰ��� ����. 
��� SQL ������ ����ϸ� �� ������ �ۼ��Ͻÿ�.*/

SELECT
    student_name
FROM
    tb_student
WHERE
    department_no IS NULL;




/*8. ������û�� �Ϸ��� ����. �������� ���θ� Ȯ���ؾ� �ϴµ�,���������� �����ϴ�
������� � �������� �����ȣ�� ��ȸ�غ��ÿ�.
CLASS_NO
----------
C0405500
C0409000
C3745400
C0432500
C3051900
C3221500 
6 rows selected*/

SELECT
    class_no
FROM
    tb_class
WHERE
    preattending_class_no IS NOT NULL;
 
/*    
9. �� ���п��� � �迭(CATEGORY)���� �ִ��� ��ȸ�غ��ÿ�.
CATEGORY
--------------------
����
��ü��
����
�ι���ȸ
�ڿ�����*/

select DISTINCT category from tb_department;


/*10. 02 �й� ���� �����ڵ��� ������ ������� ����. ������ ������� ������ ��������
�л����� �й�, �̸�, �ֹι�ȣ�� ����ϴ� ������ �ۼ��Ͻÿ�.
STUDENT_NO STUDENT_NAME STUDENT_SSN
---------- -------------------- --------------
A217005 ����� 821119-2122202
��
��
A211375 ������ 841102-1154425 
11 rows selected*/

select student_no, student_name, student_ssn, entrance_date from tb_student
where ENTRANCE_DATE like '02/%' and ABSENCE_YN = 'N' and student_address like '���ֽ�%';


/*1. ������а�(�а��ڵ� 002) �л����� �й��� �̸�, ���� �⵵�� ���� �⵵�� ����
������ ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.( ��, ����� "�й�", "�̸�", "���г⵵" ��
ǥ�õǵ��� ����.)
�й� �̸� ���г⵵
---------- -------------------- -----------
9973003 ���A 1999-03-01
A473015 ���� 2004-03-01
A517105 �̚߿� 2005-03-01*/

select student_name, student_no, entrance_date from tb_student
where department_no = 002
order by entrance_date asc;

/*2. �� ������б��� ���� �� �̸��� �� ���ڰ� �ƴ� ������ �� �� �ִٰ� ����. �� ������
�̸��� �ֹι�ȣ�� ȭ�鿡 ����ϴ� SQL ������ �ۼ��� ����. (* �̶� �ùٸ��� �ۼ��� SQL 
������ ��� ���� ����� �ٸ��� ���� �� �ִ�. ������ �������� �����غ� ��)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
���� 601004-1100528
�ڰ��Ƹ� 681201-2134896*/

select professor_name, professor_ssn from tb_professor
where professor_name not like '___';

/*3. �� ������б��� ���� �������� �̸��� ���̸� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��
�̶� ���̰� ���� ������� ���� ��� ������ ȭ�鿡 ��µǵ��� ����ÿ�. (��, ���� ��
2000 �� ���� ����ڴ� ������ ��� ����� "�����̸�", "����"�� ����. ���̴� ����������
�������.)
�����̸� ����
-------------------- ----------
����ö 28
�ֿ��� 28
��� 30
�߿�ȣ 30
������ 32
��
75 rows selected*/

select professor_name"�����̸�",
extract(year from sysdate)-((subStr(professor_ssn,1,2))+1900)
"����" 
from tb_professor
where substr(professor_ssn,8,1)=1
order by "����" desc;

/*4. �������� �̸� �� ���� ������ �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��� �����
?�̸�? �� �������� ����. (���� 2 ���� ���� ������ ���ٰ� �����Ͻÿ�)
�̸�
--------------------------------------
����
����
��
��
�ؿ�
��ȣ
114 rows selected
*/

select substr(professor_name,2) from tb_professor;

/*5. �� ������б��� ����� �����ڸ� ���Ϸ��� ����. ��� ã�Ƴ� ���ΰ�? �̶�, 
19 �쿡 �����ϸ� ����� ���� ���� ������ �A������.
STUDENT_NO STUDENT_NAME
---------- --------------------
A513035 �ڰ��
A513065 �̰���
��
��
A241053 �����
A241056 ������
204 rows selected*/

select student_no, student_name from tb_student
where ceil(extract(year from(entrance_date)) - 
extract(year from (to_date(substr(student_ssn,1,6))))) > 19 ;

/*6. 2020 �� ũ���������� ���� �����ΰ�?*/
select to_char(to_date(20201225),'day') from dual;


/*7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') �� ���� �� �� ��
�� �� ���� �ǹ�����? �� TO_DATE('99/10/11','RR/MM/DD'), 
TO_DATE('49/10/11','RR/MM/DD') �� ���� �� �� �� �� �� ���� �ǹ�����?*/

select to_char(TO_DATE('99/10/11','YY/MM/DD'),'YYYY"��"MM"��"DD"��"'),
to_char(TO_DATE('49/10/11','YY/MM/DD'),'YYYY"��"MM"��"DD"��"'),
to_char(TO_DATE('49/10/11','RR/MM/DD'),'YYYY"��"MM"��"DD"��"') from dual;




    