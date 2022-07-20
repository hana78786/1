create table EMP(
EMPNO NUMBER,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER,
HIREDATE date,
SAL number,
COMM number,
DEPTON number);

create table DEPT(
DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13));

create table BONUS(
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
SAL Number,
COMM NUMBER);

create table SALGRADE(
GRAED number,
LOSAL number,
HISAL number);

SELECT * FROM DEPT;


desc EMP;
desc dept;
