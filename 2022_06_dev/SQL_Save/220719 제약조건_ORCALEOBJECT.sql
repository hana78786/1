create view emp_gender
as select emp_name, emp_no, decode(substr(emp_no,8,1),1,'��',3,'��','��')"����" from employee;

select * from emp_gender
where "����"='��';

create view emp_join_info
as select emp_name, dept_title from employee left join department on dept_code = dept_id;

select * from emp_join_info;

create or replace view emp_join_info
as select emp_name, dept_title, phone from employee left join department on dept_code = dept_id;

create force view emp_view
as select emp_id, emp_name, salary from nono;

select * from emp_view;

create or replace view emp_view_D5
as select emp_id, emp_name, salary, dept_code from employee
where dept_code = 'D5' with read only;
SELECT * from emp_view_D5;

update emp_view_D5 set dept_code='D2'
where salary >= 2500000;

update emp_view_d5 set salary = salary+500000;


--data dictionary
select *
from user_constraints
where table_name =  'employee';

select * from all_tables;

select * from dba_talbes;
--�Ϲݻ������ kh�� DBA_XXX�� ���� ������ ����.

DESC shop_member;


create sequence seQ_user_no
start with 1 --��������
increment by 1  -- ��������
maxvalue 10000 --nomaxvalue, ��������
cycle --nochycle --��������
nocache;

create sequence seq_user_no2
start with 1
increment by 1
nomaxvalue
nocycle
nocache;


INSERT INTO SHOP_MEMBER
VALUES(seq_user_no.nextval, 'khuser01', 'pass01',  '01092928383', 'khuser01@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser02', 'pass02',  '01082830494', 'khuser02@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser03', 'pass03', '01092983939', 'khuser03@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser04', 'pass04', '01092983939', 'khuser03@iei.or.kr');
SELECT * FROM SHOP_MEMBER;
DELETE from shop_member;
commit;
select seq_user_no.currval from dual;
rollback;

drop SEQUENCE seq_user_no;



--##  ������ ���� ���� ##
--KH_MEMBER ���̺��� ����
--�÷�
--MEMBER_ID	NUNBER
--MEMBER_NAME	VARCHAR2(20)
--MEMBER_AGE	NUMBER
--MEMBER_JOIN_COM	NUMBER

--�̶� �ش� ������� ������ INSERT �ؾ� ��
--ID ���� JOIN_COM�� SEQUENCE �� �̿��Ͽ� ������ �ְ��� ��

--ID���� 500 �� ���� �����Ͽ� 10�� �����Ͽ� ���� �ϰ��� ��
--JOIN_COM ���� 1������ �����Ͽ� 1�� �����Ͽ� ���� �ؾ� ��
--(ID ���� JOIN_COM ���� MAX�� 10000���� ����)

--	MEMBER_ID	MEMBER_NAME	MEMBER_AGE	MEMBER_JOIN_COM	
--	500		ȫ�浿		20		1
--	510		�踻��		30		2
--	520		�����		40		3
--	530		����		24		4


create SEQUENCE seq_id 
start with 500
increment by 10
maxvalue 1000
nocycle
NOCACHE;

create SEQUENCE seq_join 
start with 1
increment by 1
maxvalue 1000
nocycle
NOCACHE;

create table kh_memeber(
member_id number,
member_name varchar2(20),
mamber_age number,
memeber_join_com number,
primary key(member_id, memeber_join_com));

insert into kh_memeber values(SEQ_ID.NEXTVAL,'ȫ�浿',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'�踻��',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'�����',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'��浿',24,SEQ_JOIN.NEXTVAL);

select * from kh_memeber;

update kh_memeber
set mamber_age=40
where member_name='�����';

commit;

select * from user_indexes 
where table_name = 'employee';

--�ѹ��� ������ �ʾ����� pk�� unq�������� �÷��� �ڵ����� ������ �̸��� �ε����� ������

create index index_1 on employee(emp_id);

create index inx_emp_name on employee(emp_name);

select * from employee where emp_name= '������';
select * from employee where dept_code = 'D5';

drop index inx_emp_name;