/*1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단,출력 헤더는 "학과 명","계열" 
으로 표시하도록 핚다.
학과 명 계열
-------------------- --------------------
국어국문학과 인문사회
영어영문학과 인문사회
사학과 인문사회
철학과 인문사회
법학과 인문사회
행정학과 인문사회
…
…
체육학과 예체능*/
SELECT
    department_name "학과 명",
    category "계열"
FROM
    tb_department;


/*2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력핚다.
학과별 정원
------------------------------------------------
국어국문학과의 정원은 20 명 입니다.
영어영문학과의 정원은 36 명 입니다. 
사학과의 정원은 28 명 입니다.
철학과의 정원은 28 명 입니다. 
...
... 
63 rows selected*/

SELECT
    department_name
     || '의 정원은'
     || capacity
     || ' 명 입니다' "학과별 정원"
FROM
    tb_department;


/*3. "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이
들어왔다. 누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서
찾아 내도록 하자)
STUDENT_NAME
--------------------
핚수현
*/

SELECT
    student_name,
    student_ssn
FROM
    tb_student
WHERE
        department_no = 001
    AND
        substr(student_ssn,8,1) IN (
            2,4
        );


/*4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 핚다. 그 대상자들의
학번이 다음과 같을 때 대상자들을 찾는 적젃핚 SQL 구문을 작성하시오.
A513079,A513090,A513091,A513110,A513119
STUDENT_NAME
--------------------
홍경희
최경희
정경훈
정경환
이경
*/

SELECT
    student_name
FROM
    tb_student
WHERE
    student_no IN (
        'A513079','A513090','A513091','A513110','A513119'
    )
ORDER BY student_name DESC;


/*5. 입학정원이 20 명 이상 30 명 이하인 학과들의 학과 이름과 계열을 출력하시오.
DEPARTMENT_NAME CATEGORY
-------------------- --------------------
국어국문학과 인문사회
사학과 인문사회
철학과 인문사회
…
…
미술학과 예체능
산업디자인학과 예체능
체육학과 예체능*/

SELECT
    department_name,
    category
FROM
    tb_department
WHERE
    capacity BETWEEN 20 AND 30;


/*6. 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다. 그럼 춘
기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.
PROFESSOR_NAME
--------------------
임해정*/

SELECT
    professor_name
FROM
    tb_professor
WHERE
    department_no IS NULL;



/*7. 혹시 젂산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 핚다. 
어떠핚 SQL 문장을 사용하면 될 것인지 작성하시오.*/

SELECT
    student_name
FROM
    tb_student
WHERE
    department_no IS NULL;




/*8. 수강신청을 하려고 핚다. 선수과목 여부를 확인해야 하는데,선수과목이 존재하는
과목들은 어떤 과목인지 과목번호를 조회해보시오.
CLASS_NO
----------
C0405500
C0409000
C3745400
C0432500
C3051900
C3221500 
6 rows selected*/

SELECT
    class_no
FROM
    tb_class
WHERE
    preattending_class_no IS NOT NULL;
 
/*    
9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.
CATEGORY
--------------------
공학
예체능
의학
인문사회
자연과학*/

select DISTINCT category from tb_department;


/*10. 02 학번 젂주 거주자들의 모임을 맊들려고 핚다. 휴학핚 사람들은 제외핚 재학중인
학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.
STUDENT_NO STUDENT_NAME STUDENT_SSN
---------- -------------------- --------------
A217005 고수현 821119-2122202
…
…
A211375 최허현 841102-1154425 
11 rows selected*/

select student_no, student_name, student_ssn, entrance_date from tb_student
where ENTRANCE_DATE like '02/%' and ABSENCE_YN = 'N' and student_address like '전주시%';


/*1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른
순으로 표시하는 SQL 문장을 작성하시오.( 단, 헤더는 "학번", "이름", "입학년도" 가
표시되도록 핚다.)
학번 이름 입학년도
---------- -------------------- -----------
9973003 김용귺 1999-03-01
A473015 배용원 2004-03-01
A517105 이싞열 2005-03-01*/

select student_name, student_no, entrance_date from tb_student
where department_no = 002
order by entrance_date asc;

/*2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 핚 명 있다고 핚다. 그 교수의
이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자. (* 이때 올바르게 작성핚 SQL 
문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
강혁 601004-1100528
박강아름 681201-2134896*/

select professor_name, professor_ssn from tb_professor
where professor_name not like '___';

/*3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단
이때 나이가 적은 사람에서 맋은 사람 순서로 화면에 출력되도록 맊드시오. (단, 교수 중
2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 핚다. 나이는 ‘맊’으로
계산핚다.)
교수이름 나이
-------------------- ----------
제상철 28
주영상 28
김명석 30
싞영호 30
박지평 32
…
75 rows selected*/

select professor_name"교수이름",
extract(year from sysdate)-((subStr(professor_ssn,1,2))+1900)
"나이" 
from tb_professor
where substr(professor_ssn,8,1)=1
order by "나이" desc;

/*4. 교수들의 이름 중 성을 제외핚 이름맊 출력하는 SQL 문장을 작성하시오. 출력 헤더는
?이름? 이 찍히도록 핚다. (성이 2 자인 경우는 교수는 없다고 가정하시오)
이름
--------------------------------------
진영
윢필
…
…
해원
혁호
114 rows selected
*/

select substr(professor_name,2) from tb_professor;

/*5. 춘 기술대학교의 재수생 입학자를 구하려고 핚다. 어떻게 찾아낼 것인가? 이때, 
19 살에 입학하면 재수를 하지 않은 것으로 갂주핚다.
STUDENT_NO STUDENT_NAME
---------- --------------------
A513035 박경애
A513065 이경택
…
…
A241053 이희수
A241056 이희진
204 rows selected*/

select student_no, student_name from tb_student
where ceil(extract(year from(entrance_date)) - 
extract(year from (to_date(substr(student_ssn,1,6))))) > 19 ;

/*6. 2020 년 크리스마스는 무슨 요일인가?*/
select to_char(to_date(20201225),'day') from dual;


/*7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') 은 각각 몇 년 몇
월 몇 일을 의미핛까? 또 TO_DATE('99/10/11','RR/MM/DD'), 
TO_DATE('49/10/11','RR/MM/DD') 은 각각 몇 년 몇 월 몇 일을 의미핛까?*/

select to_char(TO_DATE('99/10/11','YY/MM/DD'),'YYYY"년"MM"월"DD"일"'),
to_char(TO_DATE('49/10/11','YY/MM/DD'),'YYYY"년"MM"월"DD"일"'),
to_char(TO_DATE('49/10/11','RR/MM/DD'),'YYYY"년"MM"월"DD"일"') from dual;




    