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