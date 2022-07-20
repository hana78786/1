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


/*���������� �̿��� �μ�Ʈ�غ���
ǥ �����
*/

create table emp_copy
as select emp_name, emp_no, dept_code from employee where job_code in ('J7','J5');

delete emp_copy;

insert into emp_copy (select emp_name, emp_no, dept_code from employee);

select * from emp_copy;

drop table emp_copy;

create table emp_copy
as select emp_name, emp_no, dept_code from employee where job_code ='J7';

create table emp_copy
as select * from employee where 1=0;

insert into emp_copy (select * from employee where dept_code between 'D1' and 'D3');

--ǥ ����� id not null, name not null �ߺ�����, phone �����ĺ���, email �����ĺ���
--���۷����� ǥ ����� shop list ���۷����� id���� id�� �θ�ǥ�� �����ϸ� idĭ�� ������� �� 
--�������ǿ� ������ �̸����̱�!

create table test_parent(
user_id varchar2(20) constraint nnull not null,
user_name varchar2(20) constraint nnullu not null unique,
user_pwd varchar(50) constraint nnull2 not null,
phone varchar2(40),
email varchar2(50),
constraint pk_pe primary key (phone, email));

create table test_child(
user_name varchar2(20) references test_parent(user_name)on delete set null,
buy_list varchar2(50));

drop table test_child;

--�θ�ǥ�� �ڷ� �ֱ�
--�ڽ�ǥ�� �ڷ� �ֱ�
insert into test_parent values('user01','������','123','0000000000','00@com');
insert into test_child values('������','���');

delete from test_parent where user_id = 'user01';

select * from test_child;

--�ڽ�ǥ�� ��� �������� �����ϱ�
--�������� �����ϱ� 
-- �������� ������ Ȱ��ȭ ��Ȱ���� �ϱ�

alter table test_parent 
drop constraint nnull;

alter table test_parent
add constraint pa_unique unique(user_id);

alter table test_parent enable constraint pa_unique;

alter table test_parent disable constraint pa_unique;



--



--@�ǽ�����
--���� ��ǰ�ֹ��� ����� ���̺� TBL_ORDER�� �����, ������ ���� �÷��� �����ϼ���
-- ORDER_NO(�ֹ�NO) : PK
-- USER_ID(�����̵�)
-- PRODUCT_ID(�ֹ���ǰ���̵�)
-- PRODUCT_CNT(�ֹ�����) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number constraint orderno_pk primary key,
user_id varchar2(20),
product_id varchar(20),
product_cnt number,
order_date date default sysdate);

-- ORDER_NO�� ������ SEQ_ORDER_NO�� �����, ���� �����͸� �߰��ϼ���.(����ð� ����)
-- * kang���� saewookkang��ǰ�� 5�� �ֹ��ϼ̽��ϴ�.
-- * gam���� gamjakkang��ǰ�� 30�� �ֹ��ϼ̽��ϴ�.
-- * ring���� onionring��ǰ�� 50�� �ֹ��ϼ̽��ϴ�.

create sequence seq_order_no;
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'kang', 'seawookkang',5,default);
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'gam', 'gamjakkang',30,default);
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'ring', 'onionring',50,default);

select * from tbl_order;

delete tbl_order where user_id = 'ring';

--@�ǽ�����
--kh���� ������ �� employee, job, department���̺��� �Ϻ������� ����ڿ��� �����Ϸ��� �Ѵ�.
-- ������̵�, �����, ���޸�, �μ���, �����ڸ�, �Ի����� �÷������� �� v_emp_info�� �б� �������� �����ϰ�,
-- �信 ���� ��ȸ������ ����ڷ� role_public_emp�� ���� ����� tester���� �ο��Ͻÿ�.

create view v_emp_info
as select emp_id, emp_name, (select dept_title from department where dept_id = a.dept_code)"�μ���", (select job_name from job where job_code = a.job_code)"���޸�",
(select emp_name from employee where emp_id = a.manager_id)"�����ڸ�",hire_date from employee a
with read only;

drop view v_emp_info;


select * from v_emp_info;
commit;
