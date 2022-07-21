set serveroutput on;

    --예제 2)
--사원번호를 입력 받아서 사원의 사원번호,이름,급여,입사일을 출력하시오
declare
vempid employee.emp_id%type;
vname employee.emp_name%type;
vsalary employee.salary%type;
vhire   employee.hire_date%type;

begin
select emp_name, emp_id, salary, hire_date
into vname, vempid, vsalary, vhire
from employee

where emp_id = '&id';

dbms_output.put_line(vname||vempid||vsalary||vhire);

end;
/



    
--문제1)
--사원 번호를 입력 받아서 받은 사원의 사원번호,이름,부서코드,부서명을 출력하도록 하시오

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode employee.dept_code%type;
vdtitle department.dept_title%type;

begin
select emp_id, emp_name, dept_code, dept_title
into vid, vname, vdcode, vdtitle
from employee
left join department
on dept_code = dept_id
where emp_id = '&사번';

dbms_output.put_line(vid||vname||vdcode||vdtitle);

end;
/

   
   

--## 간단 실습 1 ##
-- 사원 번호를 가지고 해당 사원을 조회
-- 이때 사원명,부서명 을 출력하여라.
-- 만약 부서가 없다면 부서명을 출력하지 않고,
-- '부서가 없는 사원 입니다' 를 출력하고
-- 부서가 있다면 부서명을 출력하여라.

declare
vname employee.emp_name%type;
vdtitle department.dept_title%type;

begin
select  emp_name, dept_title
into  vname,  vdtitle
from employee
left join department
on dept_code = dept_id
where emp_id = '&사번';

if(vdtitle is null)
then vdtitle := '부서없음';
end if;
dbms_output.put_line(vname||vdtitle);

end;
/



   
   
   --## 실습 문제 ##
--사번을 입력 받은 후 급여에 따라 등급을 나누어 출력하도록 하시오 
--그때 출력 값은 사번,이름,급여,급여등급을 출력하시오

--0만원 ~ 99만원 : F
--100만원 ~ 199만원 : E
--200만원 ~ 299만원 : D
--300만원 ~ 399만원 : C
--400만원 ~ 499만원 : B
--500만원 이상(그외) : A


declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode employee.dept_code%type;
vdtitle department.dept_title%type;
vsal employee.salary%type;
vsal_level char(1);

begin
select emp_id, emp_name, dept_code, dept_title, salary,
 (select (
case floor(salary/1000000)
when 0 then 'f'
when 1 then 'e'
when 2 then 'd'
when 3 then 'c'
when 4 then 'b'
else 'a'
end) "등급" from employee where emp_id = a.emp_id)

into vid, vname, vdcode, vdtitle, vsal, vsal_level
from employee a



left join department
on dept_code = dept_id
where emp_id = '&사번';


dbms_output.put_line(vid||vname||vsal||vdtitle||vsal_level);

end;
/






    

--ex) 200
--사번 : 200
--이름 : 선동일
--급여 : 8000000
--등급 : A







-- 표 생성하기

create table emp_id_name
as select emp_id, emp_name from employee where 1=0;

select * from emp_id_name;


--표에 값 넣기

insert into emp_id_name values('300','김뫄뫄');
insert into emp_id_name values('301','김뫄뫄');
insert into emp_id_name values('302','김뫄뫄');


--표 특정 값 삭제하기

delete emp_id_name
where emp_id = '300';



-- 컬럼 자료형 수정하기

alter table emp_id_name
add constraint id_n_pk primary key (emp_id);

alter table emp_id_name
modify emp_name varchar2(30);


--컬럼 내용 삭제하기
delete emp_id_name;


--컬럼에 constraint없이 제약조건 입력하기
alter table emp_id_name
add primary key (emp_id);


--컬럼에 constraint입력해서 제약조건 바꾸기
alter table emp_id_name
add constraint name_u unique (emp_name);

alter table emp_id_name
drop constraint name_u;


--컬럼 내용 수정하기

update emp_id_name
set emp_id = '400'
where emp_id = '300';

select * from emp_id_name;

--뷰만들기

create or replace view v_a
as select emp_name, salary, bonus from employee where dept_code in ('J1','J5');



--시퀀스 만들기

create sequence seq_ab
start with 1
increment by 10
maxvalue 200
nominvalue
cycle
nocache;

--시퀀스 사용

insert into emp_id_name values(seq_ab.nextval,'이름2');

select * from emp_id_name;


/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서에 사원 출력

*/
select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기','박나라'));


/*
select dept_code from employee
where emp_name in ('송종기','박나라');
서브쿼리로 만들기

송중기 박나라가 속한 부서외의 사원 출력

*/
select * from employee
where dept_code not in (select dept_code from employee where emp_name in ('송종기','박나라'));




--3. 직급이 J1,J2,J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드,사원명,급여,부서별 급여평균
-- join으로 활용!!


select * from employee a
join (select avg(salary)"평균",dept_code from employee group by dept_code)b
on b.dept_code = a.dept_code
where salary>평균 and job_code not in ('J1','J2','J3');


/*select*from(인라인뷰)
where 성별 = "남"  --  이름 성별 출력*/


select * from (select decode(substr(emp_no,8,1),1,'남',3,'남','여')"성별", emp_name from employee)
where 성별 = '여';




-- rownum을 이용하여 랭킹 5 구하기
--from절에 인라인뷰 사용


select rownum, salary, emp_name from (select salary,emp_name from employee order by salary desc)
where rownum<6;


/*서브쿼리를 이용한 인서트해보기
표 만들기
*/

create table copy_employee
as select * from employee where 1=0;


--표 만들기 id not null,name not null 중복금지,phone 고유식별자,email 고유식별자
--레퍼런스로 표 만들기 shop list 레퍼런스로 id연결 id는 부모표가 삭제하면 id칸만 사라지게 함 
--제약조건에 무조건 이름붙이기!

create table test (
id varchar2(20) not null,
name varchar2(20) not null unique,
phone varchar2(50),
email varchar2(50),
constraint te_pk primary key(phone, email));

create table list(
name varchar2(20) references test(name)on delete set null,
list varchar2(30));



--부모표에 자료 넣기
--자식표에 자료 넣기

insert into test values('c','ccc','3333',seq_ab.nextval);

select * from test;

insert into list values('aaa','abc');
insert into list values('aaa','abc');
insert into list values('bbb','abc');
insert into list values('ccc','abc');




--자식표에 모든 제약조건 삭제하기
--제약조건 수정하기 
-- 제약조건 수정뒤 활성화 비활성해 하기

alter table list
drop constraint SYS_C007179;

alter table list
add constraint list_ab foreign key (name) references test(name) on delete cascade;

delete test
where name = 'bbb';

select * from list;

alter table list
drop constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
disable constraint list_ab;



alter table list
disable constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
enable constraint list_ab;

alter table list
disable constraint list_ab;

insert into list values ('a','abc');

delete list
where name ='a';

alter table list
enable constraint list_ab;

--

-- or replace로 view 만들기

create or replace view v_emp_id
as select emp_id, emp_name from employee;


drop view v_emp_id;


--where절의 값 수정하지 못하게 하기
create or replace view v_emp_id
as select emp_id, emp_name, dept_code from employee
where dept_code in ('D5','D6') with CHECK OPTION;


--수정하지 못하게 한 값 수정해 보기

update v_emp_id
set dept_code = 'D7'
where dept_code = 'D5';

select * from v_emp_id;





--인덱스 만들어서 칼럼에 걸기
drop index in_test;
create index in_test on test(id);



--인덱스 삭제하기




--@실습문제
--고객이 상품주문시 사용할 테이블 TBL_ORDER를 만들고,다음과 같이 컬럼을 구성하세요
-- ORDER_NO(주문NO) : PK
-- USER_ID(고객아이디)
-- PRODUCT_ID(주문상품아이디)
-- PRODUCT_CNT(주문개수) 
-- ORDER_DATE : DEFAULT SYSDATE

create table tbl_order(
order_no number primary key,
user_id varchar2(30),
prodouct_id varchar2(30),
prodouct_cnt number,
order_date date default sysdate);

drop table tbl_order;




-- ORDER_NO은 시퀀스 SEQ_ORDER_NO을 만들고,다음 데이터를 추가하세요.(현재시각 기준)
-- * kang님이 saewookkang상품을 5개 주문하셨습니다.
-- * gam님이 gamjakkang상품을 30개 주문하셨습니다.
-- * ring님이 onionring상품을 50개 주문하셨습니다.

drop sequence seq_order_no;
create sequence seq_order_no
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

insert into tbl_order values(seq_order_no.nextval, '깡' ,'새우깡',5,default);
insert into tbl_order values(seq_order_no.nextval, '깡' ,'새우깡',20,'20200722');
insert into tbl_order values(seq_order_no.nextval, '링' ,'양파링',5,'20101101');

select * from tbl_order;


--@실습문제
--kh계정 소유의 한 employee,job,department테이블의 일부정보를 사용자에게 공개하려고 한다.
-- 사원아이디,사원명,직급명,부서명,관리자명,입사일의 컬럼정보를 뷰 v_emp_info를 읽기 전용으로 생성하고,
-- 뷰에 대한 조회권한을 사용자롤 role_public_emp을 만들어서 사용자 tester에게 부여하시오.
drop view v_emp_info;

create view v_emp_info 
as select emp_id,emp_name,hire_date,(select emp_name from employee where emp_id = a.manager_id)manager_name, dept_title, job_name from employee a
left join department
on dept_code = dept_id
left join job
using (job_code) with read only;





-- 1. JOB테이블에서 JOB_NAME의 정보만 출력되도록 하시오
select job_name from job;


-- 2. DEPARTMENT테이블의 내용 전체를 출력하는 SELECT문을 작성하시오
select * from department;


-- 3. EMPLOYEE 테이블에서 이름(EMP_NAME),이메일(EMAIL),
-- 전화번호(PHONE),고용일(HIRE_DATE)만 출력하시오

select emp_name, email, phone, hire_date from employee;



-- 4. EMPLOYEE 테이블에서 고용일(HIRE_DATE) 이름(EMP_NAME),월급(SALARY)를 출력하시오
select hire_date,emp_name,salary from employee;


-- 5. EMPLOYEE 테이블에서 월급(SALARY)이 2,500,000원이상인 사람의 
-- EMP_NAME 과 SAL_LEVEL을 출력하시오 

select emp_name, sal_level from employee where salary>2500000;



-- (힌트 : >(크다) , <(작다) 를 이용)
-- (힌트 : AND(그리고) , OR (또는))

-- 6. EMPLOYEE 테이블에서 월급(SALARY)이 350만원 이상이면서 
-- JOB_CODE가 'J3' 인 사람의 
-- 이름(EMP_NAME)과 전화번호(PHONE)를 출력하시오
-- (힌트 : AND(그리고) , OR (또는))
select emp_name, phone from employee where salary>3500000 and job_code = 'J3';


-- 간단 실습 문제
--1. EMPLOYEE 테이블에서 이름,연봉, 총수령액(보너스포함), 
-- 실수령액(총 수령액-(월급*세금 3%*12))
--가 출력되도록 하시오

select emp_name, salary*12+salary*nvl(bonus,0), salary*12+salary*nvl(bonus,0)-(salary*0.3*12) from employee;



--2. EMPLOYEE 테이블에서 이름, 근무 일수를 출력해보시오 
--(SYSDATE를 사용하면 현재 시간 출력)
select emp_name, sysdate-hire_date from employee where ent_yn='N';



--3. EMPLOYEE 테이블에서 20년 이상 근속자의 이름,월급,보너스율를 출력하시오.

select emp_name, bonus, salary from employee where (sysdate-hire_date)/365 >=20;


-- DISTINCT 
-- 컬럼에 포함된 중복 값을 한번씩만 표시하고자 할 때 사용

select distinct dept_code from employee;


-- 논리연산자(AND, OR)
-- 부서코드가 D6이고 급여를 2,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오.

select emp_name, salary, dept_code from employee where dept_code='D5' and salary>=2000000;


-- 부서코드가 D5 또는 급여를 3,000,000보다 많이 받는 
-- 사원의 이름, 부서코드, 급여를 조회하시오

select emp_name, salary, dept_code from employee where dept_code='D5' and salary>=3000000;


-- 연결 연산자(||)
-- 여러 컬럼을 하나의 컬럼인 것 처럼 연결하거나 컬럼과 리터럴 연결






-- 비교연산자 ( >, >=, <, <=, .... )
-- BETWEEN A AND B
-- 급여를 3500000원 이상 받고 6000000원 이하로 받는 직원의 이름과 급여
-- 조회하시오

select emp_name, salary from employee where salary between 3500000 and 6000000; 


-- BETWEEN AND
-- EMPLOYEE 테이블에서 고용일이 90/01/01 ~ 01/01/01인 사원의
-- 전체 내용을 출력하시오

select * from employee where hire_date between '900101' and '010101';




-- 실습문제
--1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오
select emp_name from employee where emp_name like '%연';


--2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를
--출력하시오
select emp_name, phone from employee where phone not like '010%'; 



--3. EMPLOYEE 테이블에서 메일주소의 's'가 들어가면서, DEPT_CODE가 D9 또는 D6이고
--고용일이 90/01/01 ~ 01/12/01이면서, 월급이 270만원이상인 사원의 전체 정보를 출력하시오
select * from employee where email like '%s%' and dept_code in ('D9','D6') and
(hire_date between '900101' and '011201') and salary > 2700000;



--4. EMPLOYEE 테이블에서 EMAIL ID 중 @ 앞자리가 5자리인 직원을 조회한다면?
select * from employee where email  like '__#_%'escape '#';




--5. EMPLOYEE 테이블에서 EMAIL ID 중 '_' 앞자리가 3자리인 직원을 조회한다면?




-- 1. 관리자(MANAGER_ID)도 없고 부서 배치(DEPT_CODE)도 받지 않은 
-- 직원의 이름 조회
select emp_name from employee where manager_id is null and dept_code is null;


-- 2. 부서배치를 받지 않았지만 보너스를 지급하는 직원 전체 정보 조회

select emp_name from employee where manager_id is null and bonus is not null;

-- 정렬 ORDER BY
-- SELECT한 컬럼에 대해 정렬을 할 때 사용하는 구문
-- SELECT 구문의 가장 마지막에 작성(☆) 실행순서도 가장 마지막에 수행됨
--          ASC : 오름차순 정렬, DESC : 내림차순 정렬
-- DATE asc - > 옛날 -최신 desc -최신 ->옛날
-- NULL asc - null나중 desc -  null먼저



-- SELECT 실행 순서
-- FROM - WHERE - (GROUP BY - HAVING) - SELECT - ORDER BY




