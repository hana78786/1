Create table coffee(
prodoct_name varchar2(20),
price number,
company varchar2(20));

insert into coffee values('�ƽ�Ŀ��',30000,'MAXIM');
insert into coffee (prodoct_name, price, company)
values ('ī��Ŀ��',50000,'MAXIM');
insert into coffee values ('�׽�ī��',40000,'NESCAFE');

select * from coffee;


commit;


