set serveroutput on;

    --���� 2)
--�����ȣ�� �Է� �޾Ƽ� ����� �����ȣ,�̸�,�޿�,�Ի����� ����Ͻÿ�
declare
vempid employee.emp_id%type;
vname employee.emp_name%type;
vsalary employee.salary%type;
vhire   employee.hire_date%type;

begin
select emp_name, emp_id, salary, hire_date
into vname, vempid, vsalary, vhire
from employee

where emp_id = '&id';

dbms_output.put_line(vname||vempid||vsalary||vhire);

end;
/



    
--����1)
--��� ��ȣ�� �Է� �޾Ƽ� ���� ����� �����ȣ,�̸�,�μ��ڵ�,�μ����� ����ϵ��� �Ͻÿ�

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode employee.dept_code%type;
vdtitle department.dept_title%type;

begin
select emp_id, emp_name, dept_code, dept_title
into vid, vname, vdcode, vdtitle
from employee
left join department
on dept_code = dept_id
where emp_id = '&���';

dbms_output.put_line(vid||vname||vdcode||vdtitle);

end;
/

   
   

--## ���� �ǽ� 1 ##
-- ��� ��ȣ�� ������ �ش� ����� ��ȸ
-- �̶� �����,�μ��� �� ����Ͽ���.
-- ���� �μ��� ���ٸ� �μ����� ������� �ʰ�,
-- '�μ��� ���� ��� �Դϴ�' �� ����ϰ�
-- �μ��� �ִٸ� �μ����� ����Ͽ���.

declare
vname employee.emp_name%type;
vdtitle department.dept_title%type;

begin
select  emp_name, dept_title
into  vname,  vdtitle
from employee
left join department
on dept_code = dept_id
where emp_id = '&���';

if(vdtitle is null)
then vdtitle := '�μ�����';
end if;
dbms_output.put_line(vname||vdtitle);

end;
/



   
   
   --## �ǽ� ���� ##
--����� �Է� ���� �� �޿��� ���� ����� ������ ����ϵ��� �Ͻÿ� 
--�׶� ��� ���� ���,�̸�,�޿�,�޿������ ����Ͻÿ�

--0���� ~ 99���� : F
--100���� ~ 199���� : E
--200���� ~ 299���� : D
--300���� ~ 399���� : C
--400���� ~ 499���� : B
--500���� �̻�(�׿�) : A


declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode employee.dept_code%type;
vdtitle department.dept_title%type;
vsal employee.salary%type;
vsal_level char(1);

begin
select emp_id, emp_name, dept_code, dept_title, salary,
 (select (
case floor(salary/1000000)
when 0 then 'f'
when 1 then 'e'
when 2 then 'd'
when 3 then 'c'
when 4 then 'b'
else 'a'
end) "���" from employee where emp_id = a.emp_id)

into vid, vname, vdcode, vdtitle, vsal, vsal_level
from employee a



left join department
on dept_code = dept_id
where emp_id = '&���';


dbms_output.put_line(vid||vname||vsal||vdtitle||vsal_level);

end;
/






    

--ex) 200
--��� : 200
--�̸� : ������
--�޿� : 8000000
--��� : A







-- ǥ �����ϱ�

create table emp_id_name
as select emp_id, emp_name from employee where 1=0;

select * from emp_id_name;


--ǥ�� �� �ֱ�

insert into emp_id_name values('300','�����');
insert into emp_id_name values('301','�����');
insert into emp_id_name values('302','�����');


--ǥ Ư�� �� �����ϱ�

delete emp_id_name
where emp_id = '300';



-- �÷� �ڷ��� �����ϱ�

alter table emp_id_name
add constraint id_n_pk primary key (emp_id);

alter table emp_id_name
modify emp_name varchar2(30);


--�÷� ���� �����ϱ�
delete emp_id_name;


--�÷��� constraint���� �������� �Է��ϱ�
alter table emp_id_name
add primary key (emp_id);


--�÷��� constraint�Է��ؼ� �������� �ٲٱ�
alter table emp_id_name
add constraint name_u unique (emp_name);

alter table emp_id_name
drop constraint name_u;


--�÷� ���� �����ϱ�

update emp_id_name
set emp_id = '400'
where emp_id = '300';

select * from emp_id_name;

--�丸���

create or replace view v_a
as select emp_name, salary, bonus from employee where dept_code in ('J1','J5');



--������ �����

create sequence seq_ab
start with 1
increment by 10
maxvalue 200
nominvalue
cycle
nocache;

--������ ���

insert into emp_id_name values(seq_ab.nextval,'�̸�2');

select * from emp_id_name;


/*
select dept_code from employee
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ��� ��� ���

*/
select * from employee
where dept_code in (select dept_code from employee where emp_name in ('������','�ڳ���'));


/*
select dept_code from employee
where emp_name in ('������','�ڳ���');
���������� �����

���߱� �ڳ��� ���� �μ����� ��� ���

*/
select * from employee
where dept_code not in (select dept_code from employee where emp_name in ('������','�ڳ���'));




--3. ������ J1,J2,J3�� �ƴ� ����߿��� �ڽ��� �μ��� ��ձ޿����� ���� �޿��� �޴� ������.
-- �μ��ڵ�,�����,�޿�,�μ��� �޿����
-- join���� Ȱ��!!


select * from employee a
join (select avg(salary)"���",dept_code from employee group by dept_code)b
on b.dept_code = a.dept_code
where salary>��� and job_code not in ('J1','J2','J3');


/*select*from(�ζ��κ�)
where ���� = "��"  --  �̸� ���� ���*/


select * from (select decode(substr(emp_no,8,1),1,'��',3,'��','��')"����", emp_name from employee)
where ���� = '��';




-- rownum�� �̿��Ͽ� ��ŷ 5 ���ϱ�
--from���� �ζ��κ� ���


select rownum, salary, emp_name from (select salary,emp_name from employee order by salary desc)
where rownum<6;


/*���������� �̿��� �μ�Ʈ�غ���
ǥ �����
*/

create table copy_employee
as select * from employee where 1=0;


--ǥ ����� id not null,name not null �ߺ�����,phone �����ĺ���,email �����ĺ���
--���۷����� ǥ ����� shop list ���۷����� id���� id�� �θ�ǥ�� �����ϸ� idĭ�� ������� �� 
--�������ǿ� ������ �̸����̱�!

create table test (
id varchar2(20) not null,
name varchar2(20) not null unique,
phone varchar2(50),
email varchar2(50),
constraint te_pk primary key(phone, email));

create table list(
name varchar2(20) references test(name)on delete set null,
list varchar2(30));



--�θ�ǥ�� �ڷ� �ֱ�
--�ڽ�ǥ�� �ڷ� �ֱ�

insert into test values('c','ccc','3333',seq_ab.nextval);

select * from test;

insert into list values('aaa','abc');
insert into list values('aaa','abc');
insert into list values('bbb','abc');
insert into list values('ccc','abc');




--�ڽ�ǥ�� ��� �������� �����ϱ�
--�������� �����ϱ� 
-- �������� ������ Ȱ��ȭ ��Ȱ���� �ϱ�

alter table list
drop constraint SYS_C007179;

alter table list
add constraint list_ab foreign key (name) references test(name) on delete cascade;

delete test
where name = 'bbb';

select * from list;

alter table list
drop constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
disable constraint list_ab;



alter table list
disable constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
disable constraint list_ab;

insert into list values ('a','abc');

delete list
where name ='a';

alter table list
enable constraint list_ab;

--

-- or replace�� view �����

create or replace view v_emp_id
as select emp_id, emp_name from employee;


drop view v_emp_id;


--where���� �� �������� ���ϰ� �ϱ�
create or replace view v_emp_id
as select emp_id, emp_name, dept_code from employee
where dept_code in ('D5','D6') with CHECK OPTION;


--�������� ���ϰ� �� �� ������ ����

update v_emp_id
set dept_code = 'D7'
where dept_code = 'D5';

select * from v_emp_id;





--�ε��� ���� Į���� �ɱ�
drop index in_test;
create index in_test on test(id);



--�ε��� �����ϱ�




--@�ǽ�����
--���� ��ǰ�ֹ��� ����� ���̺� TBL_ORDER�� �����,������ ���� �÷��� �����ϼ���
-- ORDER_NO(�ֹ�NO) : PK
-- USER_ID(�����̵�)
-- PRODUCT_ID(�ֹ���ǰ���̵�)
-- PRODUCT_CNT(�ֹ�����) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number primary key,
user_id varchar2(30),
prodouct_id varchar2(30),
prodouct_cnt number,
order_date date default sysdate);

drop table tbl_order;




-- ORDER_NO�� ������ SEQ_ORDER_NO�� �����,���� �����͸� �߰��ϼ���.(����ð� ����)
-- * kang���� saewookkang��ǰ�� 5�� �ֹ��ϼ̽��ϴ�.
-- * gam���� gamjakkang��ǰ�� 30�� �ֹ��ϼ̽��ϴ�.
-- * ring���� onionring��ǰ�� 50�� �ֹ��ϼ̽��ϴ�.

drop sequence seq_order_no;
create sequence seq_order_no
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

insert into tbl_order values(seq_order_no.nextval, '��' ,'�����',5,default);
insert into tbl_order values(seq_order_no.nextval, '��' ,'�����',20,'20200722');
insert into tbl_order values(seq_order_no.nextval, '��' ,'���ĸ�',5,'20101101');

select * from tbl_order;


--@�ǽ�����
--kh���� ������ �� employee,job,department���̺��� �Ϻ������� ����ڿ��� �����Ϸ��� �Ѵ�.
-- ������̵�,�����,���޸�,�μ���,�����ڸ�,�Ի����� �÷������� �� v_emp_info�� �б� �������� �����ϰ�,
-- �信 ���� ��ȸ������ ����ڷ� role_public_emp�� ���� ����� tester���� �ο��Ͻÿ�.
drop view v_emp_info;

create view v_emp_info 
as select emp_id,emp_name,hire_date,(select emp_name from employee where emp_id = a.manager_id)manager_name, dept_title, job_name from employee a
left join department
on dept_code = dept_id
left join job
using (job_code) with read only;





-- 1. JOB���̺��� JOB_NAME�� ������ ��µǵ��� �Ͻÿ�
select job_name from job;


-- 2. DEPARTMENT���̺��� ���� ��ü�� ����ϴ� SELECT���� �ۼ��Ͻÿ�
select * from department;


-- 3. EMPLOYEE ���̺��� �̸�(EMP_NAME),�̸���(EMAIL),
-- ��ȭ��ȣ(PHONE),�����(HIRE_DATE)�� ����Ͻÿ�

select emp_name, email, phone, hire_date from employee;



-- 4. EMPLOYEE ���̺��� �����(HIRE_DATE) �̸�(EMP_NAME),����(SALARY)�� ����Ͻÿ�
select hire_date,emp_name,salary from employee;


-- 5. EMPLOYEE ���̺��� ����(SALARY)�� 2,500,000���̻��� ����� 
-- EMP_NAME �� SAL_LEVEL�� ����Ͻÿ� 

select emp_name, sal_level from employee where salary>2500000;



-- (��Ʈ : >(ũ��) , <(�۴�) �� �̿�)
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))

-- 6. EMPLOYEE ���̺��� ����(SALARY)�� 350���� �̻��̸鼭 
-- JOB_CODE�� 'J3' �� ����� 
-- �̸�(EMP_NAME)�� ��ȭ��ȣ(PHONE)�� ����Ͻÿ�
-- (��Ʈ : AND(�׸���) , OR (�Ǵ�))
select emp_name, phone from employee where salary>3500000 and job_code = 'J3';


-- ���� �ǽ� ����
--1. EMPLOYEE ���̺��� �̸�,����, �Ѽ��ɾ�(���ʽ�����), 
-- �Ǽ��ɾ�(�� ���ɾ�-(����*���� 3%*12))
--�� ��µǵ��� �Ͻÿ�

select emp_name, salary*12+salary*nvl(bonus,0), salary*12+salary*nvl(bonus,0)-(salary*0.3*12) from employee;



--2. EMPLOYEE ���̺��� �̸�, �ٹ� �ϼ��� ����غ��ÿ� 
--(SYSDATE�� ����ϸ� ���� �ð� ���)
select emp_name, sysdate-hire_date from employee where ent_yn='N';



--3. EMPLOYEE ���̺��� 20�� �̻� �ټ����� �̸�,����,���ʽ����� ����Ͻÿ�.

select emp_name, bonus, salary from employee where (sysdate-hire_date)/365 >=20;


-- DISTINCT 
-- �÷��� ���Ե� �ߺ� ���� �ѹ����� ǥ���ϰ��� �� �� ���

select distinct dept_code from employee;


-- ��������(AND, OR)
-- �μ��ڵ尡 D6�̰� �޿��� 2,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�.

select emp_name, salary, dept_code from employee where dept_code='D5' and salary>=2000000;


-- �μ��ڵ尡 D5 �Ǵ� �޿��� 3,000,000���� ���� �޴� 
-- ����� �̸�, �μ��ڵ�, �޿��� ��ȸ�Ͻÿ�

select emp_name, salary, dept_code from employee where dept_code='D5' and salary>=3000000;


-- ���� ������(||)
-- ���� �÷��� �ϳ��� �÷��� �� ó�� �����ϰų� �÷��� ���ͷ� ����






-- �񱳿����� ( >, >=, <, <=, .... )
-- BETWEEN A AND B
-- �޿��� 3500000�� �̻� �ް� 6000000�� ���Ϸ� �޴� ������ �̸��� �޿�
-- ��ȸ�Ͻÿ�

select emp_name, salary from employee where salary between 3500000 and 6000000; 


-- BETWEEN AND
-- EMPLOYEE ���̺��� ������� 90/01/01 ~ 01/01/01�� �����
-- ��ü ������ ����Ͻÿ�

select * from employee where hire_date between '900101' and '010101';




-- �ǽ�����
--1. EMPLOYEE ���̺��� �̸� ���� ������ ������ ����� �̸��� ����Ͻÿ�
select emp_name from employee where emp_name like '%��';


--2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ��
--����Ͻÿ�
select emp_name, phone from employee where phone not like '010%'; 



--3. EMPLOYEE ���̺��� �����ּ��� 's'�� ���鼭, DEPT_CODE�� D9 �Ǵ� D6�̰�
--������� 90/01/01 ~ 01/12/01�̸鼭, ������ 270�����̻��� ����� ��ü ������ ����Ͻÿ�
select * from employee where email like '%s%' and dept_code in ('D9','D6') and
(hire_date between '900101' and '011201') and salary > 2700000;



--4. EMPLOYEE ���̺��� EMAIL ID �� @ ���ڸ��� 5�ڸ��� ������ ��ȸ�Ѵٸ�?
select * from employee where email  like '__#_%'escape '#';




--5. EMPLOYEE ���̺��� EMAIL ID �� '_' ���ڸ��� 3�ڸ��� ������ ��ȸ�Ѵٸ�?




-- 1. ������(MANAGER_ID)�� ���� �μ� ��ġ(DEPT_CODE)�� ���� ���� 
-- ������ �̸� ��ȸ
select emp_name from employee where manager_id is null and dept_code is null;


-- 2. �μ���ġ�� ���� �ʾ����� ���ʽ��� �����ϴ� ���� ��ü ���� ��ȸ

select emp_name from employee where manager_id is null and bonus is not null;

-- ���� ORDER BY
-- SELECT�� �÷��� ���� ������ �� �� ����ϴ� ����
-- SELECT ������ ���� �������� �ۼ�(��) ��������� ���� �������� �����
--          ASC : �������� ����, DESC : �������� ����
-- DATE asc - > ���� -�ֽ� desc -�ֽ� ->����
-- NULL asc - null���� desc -  null����



-- SELECT ���� ����
-- FROM - WHERE - (GROUP BY - HAVING) - SELECT - ORDER BY




