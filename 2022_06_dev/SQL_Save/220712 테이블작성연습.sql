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

delete form abc;

delete from abc
where name = '우영우';

insert into abc values('우영우',100,'우영우 김밥 - 서울');

update abc 
set name = '홍길순'
where name = '홍길동';

update abc
set age = 10
where age = 20;

update abc
set address = '서울시 우영우 김밥'
where name = '우영우';

update abc
set age = 30
where name = '우영우';

drop table abc;

create table abc(
name varchar2(30),
age number,
address varchar2(50));

insert into abc (name, age, address)
values ('우영우',29,'서울시 종로구 우영우 김밥');

insert into abc (name, age, address)
values ('동그라미',29,'서울시 강남구');

insert into abc values('동동삼','60','강원도 서천');

update abc
set name = '동동일'
where name = '동동삼';

update abc
set name = '동동이'
where name = '동동일';

delete from abc where age= 60;

insert into abc values ('동동삼',60,'강원도 서촌');

insert into abc values('동동일',70,'서울시 강남구');

delete from abc where name ='동동일';

drop table abc;