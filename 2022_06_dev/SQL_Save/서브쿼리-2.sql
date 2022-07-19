-- ex) 급여 평균값 이상의 급여를 받는 사원을 검색하시오
select * from employee
where salary>= (select avg(salary) from employee);



-- ex) 전지연 직원의 관리자 이름을 출력하여라.

select emp_name from employee a
where emp_id = (select manager_id from employee
where emp_name ='전지연');



--@실습문제 
--1. 윤은해와 급여가 같은 사원들을 검색해서, 사원번호,사원이름, 급여를 출력하라.
select * from employee 
where salary = (select salary from employee where emp_name = '윤은해') and
emp_name != '윤은해';




--2. employee 테이블에서 기본급여가 제일 많은 사람과 제일 적은 사람의 정보를 
-- 사번, 사원명, 기본급여를 나타내세요.

select * from employee a where
salary = (select max(salary) from employee) or
not exists (select 1 from employee where a.salary>salary);



--3. D1, D2부서에 근무하는 사원들 중에서
--기본급여가 D5 부서 직원들의 '평균월급' 보다 많은 사람들만 
--부서번호, 사원번호, 사원명, 월급을 나타내세요.

select * from employee 
where salary > (
select avg(salary) from employee where dept_code = 'D5');

/*
select dept_code from employee
where emp_name in ('송종기', '박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서에 사원 출력

*/

select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송중기','박나라'));



/*
select dept_code from employee
where emp_name in ('송종기', '박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서외의 사원 출력

*/

select * from employee
where dept_code not in (select dept_code from employee where emp_name in ('송중기','박나라'));



select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기','박나라'));




--3. 직급이 J1, J2, J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균
-- join으로 활용!!

select dept_code, emp_name, salary, 
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code)"부서별급여"
 from employee a
where job_code not in ('J1','J2','J3') and salary>
(select avg(salary) from employee group by dept_code
having dept_code = a.dept_code);

select a.dept_code, emp_name, salary from employee e
join (select dept_code, round(avg(salary))"평균" from employee group by dept_code)a
on a.dept_code = e.dept_code
where job_code not in ('J1','J2','J3') and salary> 평균;

select e.dept_code, emp_name, salary from employee e 
join (select dept_code, round(avg(salary))"평균" from employee group by dept_code)a
on e.dept_code = a.dept_code
where job_code not in ('J1','J2','J3') and salary > "평균";


/*select*from(인라인뷰)
where 성별 = "남"  --  이름 성별 출력*/

select * from 
(select emp_name, decode(substr(emp_no,8,1),1,'남',3,'남','여')"성별" from employee)
where 성별 = '남';

-- rownum을 이용하여 랭킹 5 구하기
--from절에 인라인뷰 사용

select rownum, emp_name, salary from (select emp_name, salary from employee order by salary)
where rownum between 1 and 9;


/*서브쿼리를 이용한 인서트해보기
표 만들기
*/

create table emp_copy
as select emp_name, emp_no, dept_code from employee where job_code in ('J7','J5');

delete emp_copy;

insert into emp_copy (select emp_name, emp_no, dept_code from employee);

select * from emp_copy;

drop table emp_copy;

create table emp_copy
as select emp_name, emp_no, dept_code from employee where job_code ='J7';

create table emp_copy
as select * from employee where 1=0;

insert into emp_copy (select * from employee where dept_code between 'D1' and 'D3');

--표 만들기 id not null, name not null 중복금지, phone 고유식별자, email 고유식별자
--레퍼런스로 표 만들기 shop list 레퍼런스로 id연결 id는 부모표가 삭제하면 id칸만 사라지게 함 
--제약조건에 무조건 이름붙이기!

create table test_parent(
user_id varchar2(20) constraint nnull not null,
user_name varchar2(20) constraint nnullu not null unique,
user_pwd varchar(50) constraint nnull2 not null,
phone varchar2(40),
email varchar2(50),
constraint pk_pe primary key (phone, email));

create table test_child(
user_name varchar2(20) references test_parent(user_name)on delete set null,
buy_list varchar2(50));

drop table test_child;

--부모표에 자료 넣기
--자식표에 자료 넣기
insert into test_parent values('user01','가나다','123','0000000000','00@com');
insert into test_child values('가나다','사과');

delete from test_parent where user_id = 'user01';

select * from test_child;

--자식표에 모든 제약조건 삭제하기
--제약조건 수정하기 
-- 제약조건 수정뒤 활성화 비활성해 하기

alter table test_parent 
drop constraint nnull;

alter table test_parent
add constraint pa_unique unique(user_id);

alter table test_parent enable constraint pa_unique;

alter table test_parent disable constraint pa_unique;



--



--@실습문제
--고객이 상품주문시 사용할 테이블 TBL_ORDER를 만들고, 다음과 같이 컬럼을 구성하세요
-- ORDER_NO(주문NO) : PK
-- USER_ID(고객아이디)
-- PRODUCT_ID(주문상품아이디)
-- PRODUCT_CNT(주문개수) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number constraint orderno_pk primary key,
user_id varchar2(20),
product_id varchar(20),
product_cnt number,
order_date date default sysdate);

-- ORDER_NO은 시퀀스 SEQ_ORDER_NO을 만들고, 다음 데이터를 추가하세요.(현재시각 기준)
-- * kang님이 saewookkang상품을 5개 주문하셨습니다.
-- * gam님이 gamjakkang상품을 30개 주문하셨습니다.
-- * ring님이 onionring상품을 50개 주문하셨습니다.

create sequence seq_order_no;
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'kang', 'seawookkang',5,default);
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'gam', 'gamjakkang',30,default);
insert into tbl_order values (SEQ_ORDER_NO.NEXTVAL, 'ring', 'onionring',50,default);

select * from tbl_order;

delete tbl_order where user_id = 'ring';

--@실습문제
--kh계정 소유의 한 employee, job, department테이블의 일부정보를 사용자에게 공개하려고 한다.
-- 사원아이디, 사원명, 직급명, 부서명, 관리자명, 입사일의 컬럼정보를 뷰 v_emp_info를 읽기 전용으로 생성하고,
-- 뷰에 대한 조회권한을 사용자롤 role_public_emp을 만들어서 사용자 tester에게 부여하시오.

create view v_emp_info
as select emp_id, emp_name, (select dept_title from department where dept_id = a.dept_code)"부서명", (select job_name from job where job_code = a.job_code)"직급명",
(select emp_name from employee where emp_id = a.manager_id)"관리자명",hire_date from employee a
with read only;

drop view v_emp_info;


select * from v_emp_info;
commit;
