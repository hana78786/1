create table abc(
name VARCHAR2(10),
age number,
address varchar2(30));

insert into ABC (NAME, AGE, ADDRESS)
values ('ȫ�浿',12,'����� ���α�');

insert into abc( age, name, address)
values (50,'�쿵��','����� ������');

select name, age, address from abc;

insert into abc values ('�������',15,'������ ����');

insert into abc values ('���׶�',20,'������ ����');

update abc
set name = '���׶�'
where name = '���׶�';

select * from abc;

delete form abc;

delete from abc
where name = '�쿵��';

insert into abc values('�쿵��',100,'�쿵�� ��� - ����');

update abc 
set name = 'ȫ���'
where name = 'ȫ�浿';

update abc
set age = 10
where age = 20;

update abc
set address = '����� �쿵�� ���'
where name = '�쿵��';

update abc
set age = 30
where name = '�쿵��';

drop table abc;

create table abc(
name varchar2(30),
age number,
address varchar2(50));

insert into abc (name, age, address)
values ('�쿵��',29,'����� ���α� �쿵�� ���');

insert into abc (name, age, address)
values ('���׶��',29,'����� ������');

insert into abc values('������','60','������ ��õ');

update abc
set name = '������'
where name = '������';

update abc
set name = '������'
where name = '������';

delete from abc where age= 60;

insert into abc values ('������',60,'������ ����');

insert into abc values('������',70,'����� ������');

delete from abc where name ='������';

drop table abc;