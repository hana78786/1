CREATE TABLE USER_PRIMARYKEY(
USER_NO NUMBER PRIMARY KEY,
USER_ID VARCHAR2(20) UNIQUE,
USER_PWD VARCHAR2(30) NOT NULL,
USER_NAME VARCHAR2(30),
GENDER VARCHAR2(10),
PHONE VARCHAR2(30),
EMAIL VARCHAR2(50)
);

insert into user_primarykey
values(1,'khuser01','pass01','�Ͽ���','��','01028283933','khuser01@naver.com');

insert into user_primarykey
values(null,'khuser02','pass02','�̿���','��','01028221321','khuser02@naver.com');

create table pirmarykey2(
user_no number,
user_id varchar2(20),
primary key(user_no, user_id)
);

alter table pirmarykey2 add user_name varchar2(30);

commit;

create table shop_memeber(
user_no number unique,
user_id varchar(20) primary key,
user_pwd varchar(30) not null,
user_name varchar2(30),
gender char(1),
phone varchar2(20),
email varchar2(30)
);

create table shop_buy(
buy_no number primary key,
user_id varchar2(20) references shop_memeber(user_id),
proucdt_name varchar2(20),
reg_date date default sysdate);


insert into shop_memeber 
values(1,'khuser01','pass01','�Ͽ���','M','0100000000','khuser01@iei.or.kr');
insert into shop_memeber 
values(2,'khuser02','pass02','�̿���','F','0110000000','khuser02@iei.or.kr');
insert into shop_memeber 
values(3,'khuser03','pass03','�����','M','0120000000','khuser01@iei.or.kr');
insert into shop_member 
values(4,'user01','pass03','�����','M','0120000000','khuser01@iei.or.kr');


commit;

insert into shop_buy
values(1,'khuser01','�౸ȭ',default);
insert into shop_buy
values(2,'khuser02','��ȭ',default);
insert into shop_buy
values(3,'khuser03','����ȭ',default);
insert into shop_buy
values(4,'user01','�Ǳ�ȭ',default);

alter table shop_memeber rename to shop_member;

desc shop_buy;

delete from shop_member
where user_id = 'user01';

DELETE FROM SHOP_BuY
WHERE USER_ID = 'user01';

create table shop_buy(
buy_no number CONSTRAINT buy_no_pk primary key ,
user_id varchar2(20) references shop_member(user_id) on delete cascade,
proucdt_name varchar2(20),
reg_date date default sysdate
);



drop table shop_member;

select * from shop_buy;

alter table employee_copy add emp_name1 varchar2(40);
--�÷��߰�

alter table employee_copy modify emp_name1 number;
--�÷� ����

alter table employee_copy drop column emp_name1;
--�÷� ����

alter table shop_buy 
rename column user_id to new_user_id; 

--�÷� �̸� ����

--�������� �߰�, ����, ����, �̸�����


drop table shop_member;

create table shop_member(
user_no number, --unique
user_id varchar(30), --primary key
user_pwd varchar(40), --not null
phone varchar2(20),
email varchar2(50)
);

insert into shop_member values(1,'khuser01','pass01','0000000000','khuser01@ioi.or.kr');


alter table shop_member
add constraint pk_user_id primary key(user_id);


alter table shop_member
add constraint uno_user_no unique(user_no);

alter table shop_member
modify user_pwd not null;

alter table employee_copy
drop constraint SYS_C007049;

desc shop_member;
commit;

alter table shop_member rename constraint pk_user_id to user_id_pk;

create table shop_buy(
buy_no number,  --p
user_id varchar2(20), --r
product_name varchar2(50),
reg_date date); --default sysdate


alter table shop_buy 
add constraint pk_buy_no primary key(buy_no);

alter table shop_buy
add constraint r_user_id_shop_member 
foreign key (user_id) references shop_member(user_id);

alter table shop_buy
modify reg_date default sysdate;


--�������� Ȱ��ȭ/��Ȱ��ȭ
alter table shop_buy enable constraint r_user_id_shop_member;
--Ȱ��ȭ
--alter table ���̺��̸� enable constraint ������Ʈ�̸�;

alter table shop_buy disable constraint r_user_id_shop_member;
--��Ȱ��ȭ
--alter table ���̺��̸� disable constraint ������Ʈ�̸�;


select * from (select emp_name, emp_no, decode(substr(emp_no,8,1),'1','��',3,'��','��') "����"
from employee)
where "����" = '��';