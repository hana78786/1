

-- ex) �޿� ��հ� �̻��� �޿��� �޴� ����� �˻��Ͻÿ�
select * from employee
where salary >=  (select avg(salary) from employee);


-- ex) ������ ������ ������ �̸��� ����Ͽ���.

select emp_name from employee
where emp_id = (select manager_id from employee where emp_name = '������');


--@�ǽ����� 
--1. �����ؿ� �޿��� ���� ������� �˻��ؼ�,�����ȣ,����̸�,�޿��� ����϶�.

select * from employee where salary = (select salary from employee where emp_name = '������')
and emp_name != '������';





--2. employee ���̺��� �⺻�޿��� ���� ���� ����� ���� ���� ����� ������ 
-- ���,�����,�⺻�޿��� ��Ÿ������.

select * from employee where salary = (
select max(salary) from employee) or salary = (select min(salary) from employee);




--3. D1,D2�μ��� �ٹ��ϴ� ����� �߿���
--�⺻�޿��� D5 �μ� �������� '��տ���' ���� ���� ����鸸 
--�μ���ȣ,�����ȣ,�����,������ ��Ÿ������.

select * from employee where
salary > = (
select avg(salary) from employee group by dept_code having dept_code = 'D5')
and dept_code in ('D1','D2');




/*
select dept_code from employee
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ��� ��� ���

*/

select * from employee
where dept_code in (
select dept_code from employee where emp_name in ('������','�ڳ���')); 



/*
select dept_code from employee
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ����� ��� ���

*/

select * from employee
where dept_code not in (
select dept_code from employee where emp_name in ('������','�ڳ���')); 



--3. ������ J1,J2,J3�� �ƴ� ����߿��� �ڽ��� �μ��� ��ձ޿����� ���� �޿��� �޴� ������.
-- �μ��ڵ�,�����,�޿�,�μ��� �޿����
-- join���� Ȱ��!!

select a.dept_code, salary, emp_name, ��� from employee a
join (select avg(salary)"���", dept_code from employee group by dept_code)b
on b.dept_code = a.dept_code
where job_code not in ('J1','J2','J3') and salary>=���;





/*select*from(�ζ��κ�)
where ���� = "��"  --  �̸� ���� ���*/

select * from (
select decode(substr(emp_no,8,1),1,'��',3,'��','��')"����", emp_name from employee)
where ���� = '��';






-- rownum�� �̿��Ͽ� ��ŷ 5 ���ϱ�
--from���� �ζ��κ� ���
select rownum, salary, emp_name from(
select emp_name, salary from employee order by 2 desc)
where rownum<6;





/*���������� �̿��� �μ�Ʈ�غ���
ǥ �����
*/

create table test 
as select emp_name, emp_id, salary from employee;

select * from test;

drop table test;



--ǥ ����� id not null,name not null �ߺ�����,phone �����ĺ���,email �����ĺ���
--���۷����� ǥ ����� shop list ���۷����� id���� id�� �θ�ǥ�� �����ϸ� idĭ�� ������� �� 
--�������ǿ� ������ �̸����̱�!

create table test(
id varchar2(20) constraint ts_id not null,
name varchar2(20) constraint ts_name not null unique,
phone varchar2(50),
email varchar2(50),
constraint ts_pk primary key(phone, email)
);

create table ts_li(
name varchar2(20) constraint foky references test(name) on delete set null,
list varchar2(50) constraint li not null);



--�θ�ǥ�� �ڷ� �ֱ�
--�ڽ�ǥ�� �ڷ� �ֱ�
insert into test values('a','a','123','123');
insert into test values('b','b','1234','1234');
insert into test values('c','c','12345','12345');
insert into test values('d','d','123145','121345');
insert into ts_li values ('a','123');
insert into ts_li values ('b','123');
insert into ts_li values ('c','123');
insert into ts_li values ('d','123');


delete test where id = 'a';

select * from ts_li;



--�ڽ�ǥ�� ��� �������� �����ϱ�
--�������� �����ϱ� 
-- �������� ������ Ȱ��ȭ ��Ȱ���� �ϱ�

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key(name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key (name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key (name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foke foreign key (name) references test(name) on delete cascade;

delete test
where name = 'b';

select * from ts_li;

alter table ts_li
drop constraint foke;

alter table ts_li
add constraint foky foreign key (name) references test(name) on delete cascade; 

drop table test;
drop table ts_li;




--

-- or replace�� view �����
create or replace view v_emp
as select emp_name, salary, emp_id from employee where job_code in ('J7','J1');


select * from v_emp;


--where���� �� �������� ���ϰ� �ϱ�
create or  replace view v_emp
as select emp_name, emp_id, salary from employee where salary>5000000 with check option;

--�������� ���ϰ� �� �� ������ ����

select * from v_emp;

update v_emp
set salary = 100
where emp_id = 201;





--�ε��� ���� Į���� �ɱ�

create index test_index on employee(salary);

select salary from employee;
select emp_id from employee;

--�ε��� �����ϱ�
drop index test_index;




--@�ǽ�����
--���� ��ǰ�ֹ��� ����� ���̺� TBL_ORDER�� �����,������ ���� �÷��� �����ϼ���
-- ORDER_NO(�ֹ�NO) : PK
-- USER_ID(�����̵�)
-- PRODUCT_ID(�ֹ���ǰ���̵�)
-- PRODUCT_CNT(�ֹ�����) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number constraint od_no primary key,
user_id varchar2(20),
product_id varchar2(30),
product_cnt number,
order_date date default sysdate
);


-- ORDER_NO�� ������ SEQ_ORDER_NO�� �����,���� �����͸� �߰��ϼ���.(����ð� ����)
-- * kang���� saewookkang��ǰ�� 5�� �ֹ��ϼ̽��ϴ�.
-- * gam���� gamjakkang��ǰ�� 30�� �ֹ��ϼ̽��ϴ�.
-- * ring���� onionring��ǰ�� 50�� �ֹ��ϼ̽��ϴ�.

drop sequence seq_order_no;
create sequence seq_order_no
start with 5
increment by 3
maxvalue 30
cycle
nocache;

insert into tbl_order values(seq_order_no.nextval,'Ĳ','�����',5,default);
insert into tbl_order values(seq_order_no.nextval,'��','���ڱ�',30,default);
insert into tbl_order values(seq_order_no.nextval,'��','���ĸ�',50,default);

select * from tbl_order;

--@�ǽ�����
--kh���� ������ �� employee,job,department���̺��� �Ϻ������� ����ڿ��� �����Ϸ��� �Ѵ�.
-- ������̵�,�����,���޸�,�μ���,�����ڸ�,�Ի����� �÷������� �� v_emp_info�� �б� �������� �����ϰ�,
-- �信 ���� ��ȸ������ ����ڷ� role_public_emp�� ���� ����� tester���� �ο��Ͻÿ�.

drop view v_emp_info;

create view v_emp_info
as select emp_name, job_name, dept_title, (
select emp_name from employee where a.manager_id = emp_id)"�Ŵ����̸�", hire_date
from employee a
left join department
on dept_code= dept_id
left join job
using (job_code) with read only;

select * from v_emp_info;



