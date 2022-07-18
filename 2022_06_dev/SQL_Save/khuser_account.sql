Create table coffee(
prodoct_name varchar2(20),
price number,
company varchar2(20));

insert into coffee values('맥심커피',30000,'MAXIM');
insert into coffee (prodoct_name, price, company)
values ('카누커피',50000,'MAXIM');
insert into coffee values ('네스카페',40000,'NESCAFE');

select * from coffee;


commit;


