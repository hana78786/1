Create table coffe(
prodoct_name varchar2(20),
price number,
company varchar2(20));

insert into coffe values('¸Æ½ÉÄ¿ÇÇ',30000,'MAXIM');

select prodoct_name,price,company from coffe;

commit;
delete from coffe
where COMPANY = '½ºÅ¸¹÷½º';

insert into coffe values ('Ä«Æä¶ó¶¼',3000,'½ºÅ¸¹÷½º');
insert into coffe values ('Ä«Æä¶ó¶¼',1500,'ÀÌµð¾ßÄ¿ÇÇ');
insert into coffe values ('¼ö¹Ú¶ó¶¼',2000,'½ºÅ¸¹÷½º');
insert into coffe values ('¸Á°íºù¼ö',8000,'ÀÌµð¾ßÄ¿ÇÇ');

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
where name in ('Ä«Æä¶ó¶¼','¸Æ½ÉÄ¿ÇÇ');

update coffe
set cafein = 'N'
where NAME in ('¼ö¹Ú¶ó¶¼','¸Á°íºù¼ö');

select company||name,price|| '¿ø' 
from coffe;

select company||name "Ä¿ÇÇ¸í", price||'¿ø' "°¡°Ý"
from coffe;

select * from coffe
order by name;

select * from coffe
order by company asc;
