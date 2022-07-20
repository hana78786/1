create view emp_gender
as select emp_name, emp_no, decode(substr(emp_no,8,1),1,'남',3,'남','여')"성별" from employee;

select * from emp_gender
where "성별"='여';

create view emp_join_info
as select emp_name, dept_title from employee left join department on dept_code = dept_id;

select * from emp_join_info;

create or replace view emp_join_info
as select emp_name, dept_title, phone from employee left join department on dept_code = dept_id;

create force view emp_view
as select emp_id, emp_name, salary from nono;

select * from emp_view;

create or replace view emp_view_D5
as select emp_id, emp_name, salary, dept_code from employee
where dept_code = 'D5' with read only;
SELECT * from emp_view_D5;

update emp_view_D5 set dept_code='D2'
where salary >= 2500000;

update emp_view_d5 set salary = salary+500000;


--data dictionary
select *
from user_constraints
where table_name =  'employee';

select * from all_tables;

select * from dba_talbes;
--일반사용자인 kh는 DBA_XXX에 대한 권한이 없다.

DESC shop_member;


create sequence seQ_user_no
start with 1 --생략가능
increment by 1  -- 생략가능
maxvalue 10000 --nomaxvalue, 생략가능
cycle --nochycle --생략가능
nocache;

create sequence seq_user_no2
start with 1
increment by 1
nomaxvalue
nocycle
nocache;


INSERT INTO SHOP_MEMBER
VALUES(seq_user_no.nextval, 'khuser01', 'pass01',  '01092928383', 'khuser01@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser02', 'pass02',  '01082830494', 'khuser02@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser03', 'pass03', '01092983939', 'khuser03@iei.or.kr');
INSERT INTO SHOP_MEMBER
VALUES(SEQ_USER_NO.NEXTVAL, 'khuser04', 'pass04', '01092983939', 'khuser03@iei.or.kr');
SELECT * FROM SHOP_MEMBER;
DELETE from shop_member;
commit;
select seq_user_no.currval from dual;
rollback;

drop SEQUENCE seq_user_no;



--##  시퀀스 간단 예제 ##
--KH_MEMBER 테이블을 생성
--컬럼
--MEMBER_ID	NUNBER
--MEMBER_NAME	VARCHAR2(20)
--MEMBER_AGE	NUMBER
--MEMBER_JOIN_COM	NUMBER

--이때 해당 사원들의 정보를 INSERT 해야 함
--ID 값과 JOIN_COM은 SEQUENCE 를 이용하여 정보를 넣고자 함

--ID값은 500 번 부터 시작하여 10씩 증가하여 저장 하고자 함
--JOIN_COM 값은 1번부터 시작하여 1씩 증가하여 저장 해야 함
--(ID 값과 JOIN_COM 값의 MAX는 10000으로 설정)

--	MEMBER_ID	MEMBER_NAME	MEMBER_AGE	MEMBER_JOIN_COM	
--	500		홍길동		20		1
--	510		김말똥		30		2
--	520		삼식이		40		3
--	530		고길똥		24		4


create SEQUENCE seq_id 
start with 500
increment by 10
maxvalue 1000
nocycle
NOCACHE;

create SEQUENCE seq_join 
start with 1
increment by 1
maxvalue 1000
nocycle
NOCACHE;

create table kh_memeber(
member_id number,
member_name varchar2(20),
mamber_age number,
memeber_join_com number,
primary key(member_id, memeber_join_com));

insert into kh_memeber values(SEQ_ID.NEXTVAL,'홍길동',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'김말똥',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'삼식이',20,SEQ_JOIN.NEXTVAL);
insert into kh_memeber values(SEQ_ID.NEXTVAL,'고길동',24,SEQ_JOIN.NEXTVAL);

select * from kh_memeber;

update kh_memeber
set mamber_age=40
where member_name='삼식이';

commit;

select * from user_indexes 
where table_name = 'employee';

--한번도 만들지 않았으나 pk나 unq제약조건 컬럼은 자동으로 동일한 이름의 인덱스를 생성함

create index index_1 on employee(emp_id);

create index inx_emp_name on employee(emp_name);

select * from employee where emp_name= '송종기';
select * from employee where dept_code = 'D5';

drop index inx_emp_name;