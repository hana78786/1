create table abc(
name varchar2(50),
age number,
address varchar2(50));

insert into abc(name,age,address)
values('우영우',27,'우영우 김밥 맛있는 곳');
insert into abc(age,name)
values(40,'우영우 김밥 잘 만드는 곳');
insert into abc values ('동그라미',28,'김초밥 잘 만드는 곳에 살지');

select name,age,address from abc;

update abc
set name = '우상제'
where age =40;

update abc
set address = '우영우 김밥 맛있는 곳'
where name = '우상제';

delete abc
where name = '우영우';

insert into abc values('우영우',75,'우영우 김밥 먹고있는 옆집');