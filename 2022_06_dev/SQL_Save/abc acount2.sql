create table abc(
name varchar2(50),
age number,
address varchar2(50));

insert into abc(name,age,address)
values('�쿵��',27,'�쿵�� ��� ���ִ� ��');
insert into abc(age,name)
values(40,'�쿵�� ��� �� ����� ��');
insert into abc values ('���׶��',28,'���ʹ� �� ����� ���� ����');

select name,age,address from abc;

update abc
set name = '�����'
where age =40;

update abc
set address = '�쿵�� ��� ���ִ� ��'
where name = '�����';

delete abc
where name = '�쿵��';

insert into abc values('�쿵��',75,'�쿵�� ��� �԰��ִ� ����');