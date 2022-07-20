alter table department
add (lname varchar2(20));

alter table department
modify lname varchar2(21);

alter table demartment
drop column lname;

desc department;

alter table department
rename column locaion_name to location_name;

alter table department
add (lname varchar2(20));

alter table department
drop column lname;

show user;

desc employee;


desc department;

create table member(
member_id varchar2(20),
member_pwd varchar2(30),
memeber_age number,
member_date date);

alter table member rename to worker;

drop table worker;


insert into employee values(900,'장채현', '901123-2080503','jang_ch@kh.co.kr','01055569512','D1','J8','S3',430000,
0.2,'200',sysdate,null,default);

select * from employee;
select emp_name from employee;

select dept_id, dept_title from department;

update DEPARTMENT
set DEPT_TITLE = '전략기획팀'
where dept_id='D9';

select * from department;

delete from employee
where emp_name = '장채현';

