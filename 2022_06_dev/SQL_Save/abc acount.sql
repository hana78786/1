create table abc(
name VARCHAR2(10),
age number,
address varchar2(30));

insert into ABC (NAME, AGE, ADDRESS)
values ('홍길동',12,'서울시 종로구');

insert into abc( age, name, address)
values (50,'우영우','서울시 강남구');

select name, age, address from abc;

insert into abc values ('동구라미',15,'강원도 서촌');

insert into abc values ('동그라',20,'강원도 서촌');

update abc
set name = '동그란'
where name = '동그라';

select * from abc;