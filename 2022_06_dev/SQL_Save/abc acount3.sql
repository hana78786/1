Create table coffe(
prodoct_name varchar2(20),
price number,
company varchar2(20));

insert into coffe values('�ƽ�Ŀ��',30000,'MAXIM');

select prodoct_name,price,company from coffe;

commit;
delete from coffe
where COMPANY = '��Ÿ����';

insert into coffe values ('ī���',3000,'��Ÿ����');
insert into coffe values ('ī���',1500,'�̵��Ŀ��');
insert into coffe values ('���ڶ�',2000,'��Ÿ����');
insert into coffe values ('�������',8000,'�̵��Ŀ��');

select distinct company from coffe;
select distinct prodoct_name from coffe;

alter table coffe
rename column prodoct_name to name;

select distinct name from coffe;

select distinct price from coffe;
select * from coffe;

select distinct company from coffe;

alter table coffe
modify name varchar2(25);

alter table coffe
add cafein varchar2(10);

select * from coffe;

update COFFE
set cafein = 'Y'
where name in ('ī���','�ƽ�Ŀ��');

update coffe
set cafein = 'N'
where NAME in ('���ڶ�','�������');

select company||name,price|| '��' 
from coffe;

select company||name "Ŀ�Ǹ�", price||'��' "����"
from coffe;

select * from coffe
order by name;

select * from coffe
order by company asc;
