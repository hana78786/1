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


/*8. �� ������б��� 2000 �⵵ ���� �����ڵ��� �й��� A �� �����ϰ� �Ǿ��ִ�. 2000 �⵵
�̠� �й��� ���� �л����� �й��� �̸��� �����ִ� SQL ������ �ۼ��Ͻÿ�.
STUDENT_NO STUDENT_NAME
---------- --------------------
9919024 ��迵
9831163 �̱ǹ�
��
��
9811251 �����
9911206 ������
52 rows selected
*/

select student_no, student_name from tb_student
where student_no not like'A%';

/*9. �й��� A517178 �� ���Ƹ� �л��� ���� �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. ��,
�̶� ��� ȭ���� ����� "����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ���� ��
�ڸ������� ǥ������.
����
----------
 3.6
1 ���� ���� ���õǾ����ϴ�.
*/

select round(avg(point),1)"����" from tb_grade
group by student_no
having student_no='A517178';


/*10. �а��� �л����� ���Ͽ� "�а���ȣ", "�л���(��)" �� ���·� ����� ����� �������
��µǵ��� �Ͻÿ�.
�а���ȣ �л���(��)
---------- ----------
001 14
002 3
��
��
061 7
062 8 
62 rows selected
*/

select department_no"�а���ȣ", count(*)"�л���(��)" from tb_student
group by department_no
order by 1;

/*11. ���� ������ �������� ���� �л��� ���� �� �� ���� �Ǵ� �˾Ƴ��� SQL ����
�ۼ��Ͻÿ�.
COUNT(*)
----------
 */
 
 select count(*) from tb_student
 group by COACH_PROFESSOR_NO
 having COACH_PROFESSOR_NO is null;
 
 
 /*12. �й��� A112113 �� ���� �л��� �⵵ �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. ��, 
�̶� ��� ȭ���� ����� "�⵵", "�⵵ �� ����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ�
�Ҽ��� ���� �� �ڸ������� ǥ������.
�⵵ �⵵ �� ����
-------- ------------
2001 2.8
2002 2.3
2003 4
2004 3.5
*/

select substr(TERM_NO,1,4) "�⵵",round(avg(point),1) from tb_grade
where student_no = 'A112113'
group by substr(TERM_NO,1,4)
order by 1;

/*13. �а� �� ���л� ���� �ľ��ϰ��� ����. �а� ��ȣ�� ���л� ���� ǥ���ϴ� SQL ������
�ۼ��Ͻÿ�.
�а��ڵ�� ���л� ��
------------- ------------------------------
001 2
002 0
003 1
061 2
062 2
62 rows selected
*/

select DEPARTMENT_NO"�а��ڵ�",
count(case when absence_yn='Y' then 1 end)
"���л���" from tb_student
group by DEPARTMENT_NO
order by 1;

/*14. �� ���б��� �ٴϴ� ��������(��٣���) �л����� �̸��� ã���� ����. � SQL 
������ ����ϸ� �����ϰڴ°�?
�����̸� ������ ��
-------------------- ----------
���� 2
���ö 2
��
��
������ 2
��ȿ�� 2
20 rows selected*/

select student_name,count(student_name) from tb_student
group by student_name
having count(student_name)>1
order by 1;


/*15. �й��� A112113 �� ���� �л��� �⵵, �б� �� ������ �⵵ �� ���� ���� , ��
������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. (��, ������ �Ҽ��� 1 �ڸ������� �ݿø��Ͽ�
ǥ������.)
�⵵ �б� ����
-------- ---- ------------
2001 01 2.5
2001 02 3
2001 2.8
2002 01 2
2002 02 2.5
2002 2.3
2003 01 3.5
2003 02 4.5
2003 03 4
2003 4
2004 01 4
2004 02 3
2004 3.5
3.2*/

select nvl(substr(term_no,1,4),'�հ�')"�⵵", nvl(substr(term_no,5,2),' ')"�б�", round(avg(point),1)"����" from tb_grade
where student_no = 'A112113'
group by rollup(substr(term_no,1,4),substr(term_no,5,2))
order by 1;

 
 /*1. �л��̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� "�л� �̸�", "�ּ���"�� �ϰ�,
������ �̸����� �������� ǥ���ϵ��� ����.
�л� �̸� �ּ���
-------------------- ----------------------------------------------------------
������ ���ﰭ�����̵�691-3�ο�@102-505
������ ��⵵ �����ν� �ζ��� 694 ��鸶�� �븲����Ʈ 404-1404
��
Ȳ��ö ���� ��õ�� ���� ����� 106/407 T.061-772-2101
Ȳȿ�� ��õ�ü��� ������ 564-4����
588 rows selected
*/

select student_name"�л�", student_address"�ּ�" from tb_student
order by 1 asc;

/*2. �������� �л����� �̸��� �ֹι�ȣ�� ���̰� ���� ������ ȭ�鿡 ����Ͻÿ�.
STUDENT_NAME STUDENT_SSN
-------------------- --------------
����� 871222-1124648
Ȳȿ�� 871125-1129980
��ȿ�� 871030-2176192
����ȣ 871013-1140536
��
��
91 rows selected*/

select student_name, student_ssn from tb_student
where ABSENCE_YN = 'Y'
order by 2 desc;


/*3. �ּ����� �������� ��⵵�� �л��� �� 1900 ��� �й��� ���� �л����� �̸��� �й�, 
�ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�. ��, ���������� "�л��̸�","�й�",
"������ �ּ�" �� ��µǵ��� ����.
�л��̸� �й� ������ �ּ�
-------------------- ---------- -------------------------------------------------------------
��迵 9919024 ��⵵ ���ν� ������ ǳ��õ2�� �������� �ӱ� 305-1703ȣ
�ڱԻ� 9931111 ��⵵ ������ �д籸 ž���� 526 �泲����Ʈ 710-1302
�ۃA�� 9931165 ��⵵ ��õ�� ���̱� ��2�� 386-1186 ��������Ʈ 1701-405
������ 9995148 ��⵵ �����ֽ� ���� �ο��׸�Ÿ�� 306-2304
�̱�� 9931248 ��⵵ ������ �꺻�� �����þ���Ʈ1224-2002
������ 9811176 ��⵵ ���� �ϻ걸 �ϻ굿1107�İ��1209-705
���⼺ 9931277 ��⵵ ���ν� ������ ǳ��õ�� 239-3 �߾Ӻ��� 3��
����� 9931285 ��⵵ ������ �д籸 ��ž�� ������Ʈ 307-801ȣ
����ȯ 9931312 ��⵵ ����� ��ȭ�� 194-1 ��������Ʈ 1-305
9 rows selected*/

select student_name"�л��̸�", student_no"�й�", student_address"������ �ּ�" from tb_student
where (STUDENT_ADDRESS like '%��⵵%' or STUDENT_ADDRESS like '%������%') and substr(student_no,1,2) between '90' and '99'
order by 1 asc;

/*. ���� ���а� ���� �� ���� ���̰� ���� ������� �̸��� Ȯ���� �� �ִ� SQL ������
�ۼ��Ͻÿ�. (���а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã��
������ ����)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
ȫ���� 540304-1112251
�輱�� 551030-2159000
������ 640125-1143548
�̹̰� 741016-2103506*/

select professor_name , professor_ssn from TB_PROFESSOR
join tb_department
using (department_no)
where department_name = '���а�'
order by 2;

/*5. 2004 �� 2 �б⿡ 'C3118100' ������ ������ �л����� ������ ��ȸ�Ϸ��� ����. ������
���� �л����� ǥ���ϰ�, ������ ������ �й��� ���� �л����� ǥ���ϴ� ������
�ۼ��غ��ÿ�.
STUDENT_NO POINT
---------- -----
A352017 4.00
A115270 3.50
A215247 3.00
A417074 3.00
A131046 2.50
A219089 2.50
A331076 2.00 
7 rows selected*/
select student_no, point from tb_grade
where class_no = 'C3118100' and term_no = '200402'
order by point desc, student_no asc;

/*6. �л� ��ȣ, �л� �̸�, �а� �̸��� �л� �̸����� �������� �����Ͽ� ����ϴ� SQL 
���� �ۼ��Ͻÿ�.
STUDENT_NO STUDENT_NAME DEPARTMENT_NAME
---------- -------------------- --------------------
A213046 ������ �߾��߹��а�
A445008 ������ �����а�
��
��
A241056 ������ ���ݾƾ��а�
A241004 ������ ���½ý��۰��а�
588 rows selecte*/

select student_no, student_name, department_name from tb_student
join tb_department
using (department_no)
order by 2;

/*7. �� ������б��� ���� �̸��� ������ �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
�����ð���Ư�� ������а�
������֎�Ư�� ������а�
���������п��� ������а�
��
��
������1 ü���а�
������2 ü���а�
882 rows selecte*/

select class_name, department_name from tb_class
join TB_DEPARTMENT
using (DEPARTMENT_NO);


/*8. ���� ���� �̸��� ã������ ����. ���� �̸��� ���� �̸��� ����ϴ� SQL ����
�ۼ��Ͻÿ�.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
�����ð���Ư�� �輱��
������֎�Ư�� �輱��
���������п��� �輱��
��
��
������1 ������
776 rows selected
*/

select class_name, professor_name from TB_PROFESSOR
join TB_CLASS
using (department_no);

/*9. 8 ���� ��� �� ���ι���ȸ�� �迭�� ���� ������ ���� �̸��� ã������ ����. �̿�
�ش��ϴ� ���� �̸��� ���� �̸��� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
�����ð���Ư�� �輱��
������֎�Ư�� �輱��
��
��
������2 ����
197 rows selected*/
select class_name, professor_name,category from TB_PROFESSOR
join TB_CLASS
using (department_no)
join tb_department
using(department_no)
where category= '�ι���ȸ';



/*10. �������а��� �л����� ������ ���Ϸ��� ����. �����а� �л����� "�й�", "�л� �̸�", 
"��ü ����"�� ����ϴ� SQL ������ �ۼ��Ͻÿ�. (��, ������ �Ҽ��� 1 �ڸ�������
�ݿø��Ͽ� ǥ������.)
�й� �л� �̸� ��ü ����
---------- -------------------- ----------
9931310 ������ 4.1
A354020 ���翵 3.5
A411116 ����ȭ 3.6
A415245 ������ 3.2
A431021 ������ 3.9
A431358 ������ 3.7
A557031 ������ 3.3
A612052 �߱��� 4.1
8 rows selected
*/

select student_no, student_name, round(avg(point),1) from tb_grade
join tb_student
using (student_no)
where department_no = 059
group by student_no, student_name
order by 1;



/*11. �й��� A313047 �� �л��� �б��� ������ ���� �ʴ�. ���� �������� ������ �����ϱ�
���� �а� �̸�, �л� �̸��� ���� ���� �̸��� �ʿ��ϴ�. �̶� ����� SQL ����
�ۼ��Ͻÿ�. ��, �������� ?�а��̸�?, ?�л��̸�?, ?���������̸�?����
��µǵ��� ����.
�а��̸� �л��̸� ���������̸�
-------------------- -------------------- --------------------
�����а� �հǿ� ����ȯ*/

select department_name, student_name, professor_name from TB_DEPARTMENT
join tb_professor
using (department_no)
join tb_student
on COACH_PROFESSOR_NO = PROFESSOR_NO
where student_no = 'A313047';


/*12. 2007 �⵵�� '�΁A�����' ������ ������ �л��� ã�� �л��̸��� �����б⸧ ǥ���ϴ�
SQL ������ �ۼ��Ͻÿ�.
STUDENT_NAME TERM_NAME
-------------------- --------------------
������ 200701
������ 200701
����ȣ 200703
*/

select student_name, term_no, class_name, tb_class.CLASS_NO from tb_grade
join tb_student
using(student_no)
join tb_class
using (department_no)
where term_no like '2007__' and class_name = '�ΰ������';

/*13. ��ü�� �迭 ���� �� ���� ��米���� �� �� �������� ���� ������ ã�� �� ����
�̸��� �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
����� �̼��а�
�̼�����,�濵�� �̼��а�
��
��
�ó�濬�� ü���а�
�غ��н��� ü���а�
44 rows selected*/

select class_name, department_name from TB_PROFESSOR
right join tb_class
using (department_no)
right outer join TB_department
using(department_no)
where category = '��ü��' and professor_no is null;


/*14. �� ������б� ���ݾƾ��а� �л����� ���������� �Խ��ϰ��� ����. �л��̸���
�������� �̸��� ã�� ���� ���� ������ ���� �л��� ��� "�������� ������? ����
ǥ���ϵ��� �ϴ� SQL ���� �ۼ��Ͻÿ�. ��, �������� ? �л��̸�? , ? ��������? ��
ǥ���ϸ� ���й� �л��� ���� ǥ�õǵ��� ����.
�л��̸� ��������
-------------------- --------------------
���ϳ� �㹮ǥ
������ �����
�� ��
��ö�� �����
14 rows selected*/


select student_name"�л��̸�", nvl(professor_name,'�������� ������')"��������" from tb_student a
left outer join TB_PROFESSOR
on COACH_PROFESSOR_NO = TB_PROFESSOR.PROFESSOR_NO
where a.DEPARTMENT_NO =(select department_no from TB_DEPARTMENT where department_name = '���ݾƾ��а�')
order by student_no desc;


