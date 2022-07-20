

-- ex) 급여 평균값 이상의 급여를 받는 사원을 검색하시오
select * from employee
where salary >=  (select avg(salary) from employee);


-- ex) 전지연 직원의 관리자 이름을 출력하여라.

select emp_name from employee
where emp_id = (select manager_id from employee where emp_name = '전지연');


--@실습문제 
--1. 윤은해와 급여가 같은 사원들을 검색해서,사원번호,사원이름,급여를 출력하라.

select * from employee where salary = (select salary from employee where emp_name = '윤은해')
and emp_name != '윤은해';





--2. employee 테이블에서 기본급여가 제일 많은 사람과 제일 적은 사람의 정보를 
-- 사번,사원명,기본급여를 나타내세요.

select * from employee where salary = (
select max(salary) from employee) or salary = (select min(salary) from employee);




--3. D1,D2부서에 근무하는 사원들 중에서
--기본급여가 D5 부서 직원들의 '평균월급' 보다 많은 사람들만 
--부서번호,사원번호,사원명,월급을 나타내세요.

select * from employee where
salary > = (
select avg(salary) from employee group by dept_code having dept_code = 'D5')
and dept_code in ('D1','D2');




/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서에 사원 출력

*/

select * from employee
where dept_code in (
select dept_code from employee where emp_name in ('송종기','박나라')); 



/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서외의 사원 출력

*/

select * from employee
where dept_code not in (
select dept_code from employee where emp_name in ('송종기','박나라')); 



--3. 직급이 J1,J2,J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드,사원명,급여,부서별 급여평균
-- join으로 활용!!

select a.dept_code, salary, emp_name, 평균 from employee a
join (select avg(salary)"평균", dept_code from employee group by dept_code)b
on b.dept_code = a.dept_code
where job_code not in ('J1','J2','J3') and salary>=평균;





/*select*from(인라인뷰)
where 성별 = "남"  --  이름 성별 출력*/

select * from (
select decode(substr(emp_no,8,1),1,'남',3,'남','여')"성별", emp_name from employee)
where 성별 = '남';






-- rownum을 이용하여 랭킹 5 구하기
--from절에 인라인뷰 사용
select rownum, salary, emp_name from(
select emp_name, salary from employee order by 2 desc)
where rownum<6;





/*서브쿼리를 이용한 인서트해보기
표 만들기
*/

create table test 
as select emp_name, emp_id, salary from employee;

select * from test;

drop table test;



--표 만들기 id not null,name not null 중복금지,phone 고유식별자,email 고유식별자
--레퍼런스로 표 만들기 shop list 레퍼런스로 id연결 id는 부모표가 삭제하면 id칸만 사라지게 함 
--제약조건에 무조건 이름붙이기!

create table test(
id varchar2(20) constraint ts_id not null,
name varchar2(20) constraint ts_name not null unique,
phone varchar2(50),
email varchar2(50),
constraint ts_pk primary key(phone, email)
);

create table ts_li(
name varchar2(20) constraint foky references test(name) on delete set null,
list varchar2(50) constraint li not null);



--부모표에 자료 넣기
--자식표에 자료 넣기
insert into test values('a','a','123','123');
insert into test values('b','b','1234','1234');
insert into test values('c','c','12345','12345');
insert into test values('d','d','123145','121345');
insert into ts_li values ('a','123');
insert into ts_li values ('b','123');
insert into ts_li values ('c','123');
insert into ts_li values ('d','123');


delete test where id = 'a';

select * from ts_li;



--자식표에 모든 제약조건 삭제하기
--제약조건 수정하기 
-- 제약조건 수정뒤 활성화 비활성해 하기

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key(name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key (name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foky foreign key (name) references test(name);

alter table ts_li
drop constraint foky;

alter table ts_li
add constraint foke foreign key (name) references test(name) on delete cascade;

delete test
where name = 'b';

select * from ts_li;

alter table ts_li
drop constraint foke;

alter table ts_li
add constraint foky foreign key (name) references test(name) on delete cascade; 

drop table test;
drop table ts_li;




--

-- or replace로 view 만들기
create or replace view v_emp
as select emp_name, salary, emp_id from employee where job_code in ('J7','J1');


select * from v_emp;


--where절의 값 수정하지 못하게 하기
create or  replace view v_emp
as select emp_name, emp_id, salary from employee where salary>5000000 with check option;

--수정하지 못하게 한 값 수정해 보기

select * from v_emp;

update v_emp
set salary = 100
where emp_id = 201;





--인덱스 만들어서 칼럼에 걸기

create index test_index on employee(salary);

select salary from employee;
select emp_id from employee;

--인덱스 삭제하기
drop index test_index;




--@실습문제
--고객이 상품주문시 사용할 테이블 TBL_ORDER를 만들고,다음과 같이 컬럼을 구성하세요
-- ORDER_NO(주문NO) : PK
-- USER_ID(고객아이디)
-- PRODUCT_ID(주문상품아이디)
-- PRODUCT_CNT(주문개수) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number constraint od_no primary key,
user_id varchar2(20),
product_id varchar2(30),
product_cnt number,
order_date date default sysdate
);


-- ORDER_NO은 시퀀스 SEQ_ORDER_NO을 만들고,다음 데이터를 추가하세요.(현재시각 기준)
-- * kang님이 saewookkang상품을 5개 주문하셨습니다.
-- * gam님이 gamjakkang상품을 30개 주문하셨습니다.
-- * ring님이 onionring상품을 50개 주문하셨습니다.

drop sequence seq_order_no;
create sequence seq_order_no
start with 5
increment by 3
maxvalue 30
cycle
nocache;

insert into tbl_order values(seq_order_no.nextval,'캉','새우깡',5,default);
insert into tbl_order values(seq_order_no.nextval,'감','감자깡',30,default);
insert into tbl_order values(seq_order_no.nextval,'링','양파링',50,default);

select * from tbl_order;

--@실습문제
--kh계정 소유의 한 employee,job,department테이블의 일부정보를 사용자에게 공개하려고 한다.
-- 사원아이디,사원명,직급명,부서명,관리자명,입사일의 컬럼정보를 뷰 v_emp_info를 읽기 전용으로 생성하고,
-- 뷰에 대한 조회권한을 사용자롤 role_public_emp을 만들어서 사용자 tester에게 부여하시오.

drop view v_emp_info;

create view v_emp_info
as select emp_name, job_name, dept_title, (
select emp_name from employee where a.manager_id = emp_id)"매니저이름", hire_date
from employee a
left join department
on dept_code= dept_id
left join job
using (job_code) with read only;

select * from v_emp_info;



