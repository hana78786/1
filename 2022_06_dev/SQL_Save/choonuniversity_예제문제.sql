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


/*8. 춘 기술대학교의 2000 년도 이후 입학자들은 학번이 A 로 시작하게 되어있다. 2000 년도
이젂 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오.
STUDENT_NO STUDENT_NAME
---------- --------------------
9919024 김계영
9831163 이권민
…
…
9811251 김충원
9911206 임충헌
52 rows selected
*/

select student_no, student_name from tb_student
where student_no not like'A%';

/*9. 학번이 A517178 인 핚아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단,
이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 핚
자리까지맊 표시핚다.
평점
----------
 3.6
1 개의 행이 선택되었습니다.
*/

select round(avg(point),1)"평점" from tb_grade
group by student_no
having student_no='A517178';


/*10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 맊들어 결과값이
출력되도록 하시오.
학과번호 학생수(명)
---------- ----------
001 14
002 3
…
…
061 7
062 8 
62 rows selected
*/

select department_no"학과번호", count(*)"학생수(명)" from tb_student
group by department_no
order by 1;

/*11. 지도 교수를 배정받지 못핚 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을
작성하시오.
COUNT(*)
----------
 */
 
 select count(*) from tb_student
 group by COACH_PROFESSOR_NO
 having COACH_PROFESSOR_NO is null;
 
 
 /*12. 학번이 A112113 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 
이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여
소수점 이하 핚 자리까지맊 표시핚다.
년도 년도 별 평점
-------- ------------
2001 2.8
2002 2.3
2003 4
2004 3.5
*/

select substr(TERM_NO,1,4) "년도",round(avg(point),1) from tb_grade
where student_no = 'A112113'
group by substr(TERM_NO,1,4)
order by 1;

/*13. 학과 별 휴학생 수를 파악하고자 핚다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을
작성하시오.
학과코드명 휴학생 수
------------- ------------------------------
001 2
002 0
003 1
061 2
062 2
62 rows selected
*/

select DEPARTMENT_NO"학과코드",
count(case when absence_yn='Y' then 1 end)
"휴학생수" from tb_student
group by DEPARTMENT_NO
order by 1;

/*14. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 핚다. 어떤 SQL 
문장을 사용하면 가능하겠는가?
동일이름 동명인 수
-------------------- ----------
김경민 2
김명철 2
…
…
조기현 2
최효정 2
20 rows selected*/

select student_name,count(student_name) from tb_student
group by student_name
having count(student_name)>1
order by 1;


/*15. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총
평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1 자리까지맊 반올림하여
표시핚다.)
년도 학기 평점
-------- ---- ------------
2001 01 2.5
2001 02 3
2001 2.8
2002 01 2
2002 02 2.5
2002 2.3
2003 01 3.5
2003 02 4.5
2003 03 4
2003 4
2004 01 4
2004 02 3
2004 3.5
3.2*/

select nvl(substr(term_no,1,4),'합계')"년도", nvl(substr(term_no,5,2),' ')"학기", round(avg(point),1)"평점" from tb_grade
where student_no = 'A112113'
group by rollup(substr(term_no,1,4),substr(term_no,5,2))
order by 1;

 
 /*1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고,
정렬은 이름으로 오름차순 표시하도록 핚다.
학생 이름 주소지
-------------------- ----------------------------------------------------------
감현제 서울강서등촌동691-3부영@102-505
강동연 경기도 의정부시 민락동 694 산들마을 대림아파트 404-1404
…
황형철 전남 숚천시 생목동 현대ⓐ 106/407 T.061-772-2101
황효종 인천시서구 석남동 564-4번지
588 rows selected
*/

select student_name"학생", student_address"주소" from tb_student
order by 1 asc;

/*2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.
STUDENT_NAME STUDENT_SSN
-------------------- --------------
릴희권 871222-1124648
황효종 871125-1129980
전효선 871030-2176192
김진호 871013-1140536
…
…
91 rows selected*/

select student_name, student_ssn from tb_student
where ABSENCE_YN = 'Y'
order by 2 desc;


/*3. 주소지가 강원도나 경기도인 학생들 중 1900 년대 학번을 가진 학생들의 이름과 학번, 
주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번",
"거주지 주소" 가 출력되도록 핚다.
학생이름 학번 거주지 주소
-------------------- ---------- -------------------------------------------------------------
김계영 9919024 경기도 용인시 수지구 풍덕천2동 싞정마을 임광 305-1703호
박규상 9931111 경기도 성남시 분당구 탑마을 526 경남아파트 710-1302
송귺우 9931165 경기도 부천시 원미구 중2동 386-1186 복사골아파트 1701-405
송정삼 9995148 경기도 남양주시 도농동 부영그린타운 306-2304
이기범 9931248 경기도 굮포시 산본동 핚양목련아파트1224-2002
이춘평 9811176 경기도 고양시 일산구 일산동1107후곡마을1209-705
전기성 9931277 경기도 용인시 수지구 풍덕천동 239-3 중앙빌딩 3층
정기웅 9931285 경기도 성남시 분당구 야탑동 기산아파트 307-801호
조기환 9931312 경기도 시흥시 매화동 194-1 동진아파트 1-305
9 rows selected*/

select student_name"학생이름", student_no"학번", student_address"거주지 주소" from tb_student
where (STUDENT_ADDRESS like '%경기도%' or STUDENT_ADDRESS like '%강원도%') and substr(student_no,1,2) between '90' and '99'
order by 1 asc;

/*. 현재 법학과 교수 중 가장 나이가 맋은 사람부터 이름을 확인핛 수 있는 SQL 문장을
작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아
내도록 하자)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
홍남수 540304-1112251
김선희 551030-2159000
임진숙 640125-1143548
이미경 741016-2103506*/

select professor_name , professor_ssn from TB_PROFESSOR
join tb_department
using (department_no)
where department_name = '법학과'
order by 2;

/*5. 2004 년 2 학기에 'C3118100' 과목을 수강핚 학생들의 학점을 조회하려고 핚다. 학점이
높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을
작성해보시오.
STUDENT_NO POINT
---------- -----
A352017 4.00
A115270 3.50
A215247 3.00
A417074 3.00
A131046 2.50
A219089 2.50
A331076 2.00 
7 rows selected*/
select student_no, point from tb_grade
where class_no = 'C3118100' and term_no = '200402'
order by point desc, student_no asc;

/*6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 
문을 작성하시오.
STUDENT_NO STUDENT_NAME DEPARTMENT_NAME
---------- -------------------- --------------------
A213046 서가람 중어중문학과
A445008 남가영 경제학과
…
…
A241056 이희진 서반아어학과
A241004 김희훈 생태시스템공학과
588 rows selecte*/

select student_no, student_name, department_name from tb_student
join tb_department
using (department_no)
order by 2;

/*7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
고전시가롞특강 국어국문학과
국어어휘롞특강 국어국문학과
국어음성학연구 국어국문학과
…
…
논문지도1 체육학과
논문지도2 체육학과
882 rows selecte*/

select class_name, department_name from tb_class
join TB_DEPARTMENT
using (DEPARTMENT_NO);


/*8. 과목별 교수 이름을 찾으려고 핚다. 과목 이름과 교수 이름을 출력하는 SQL 문을
작성하시오.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
고전시가롞특강 김선정
국어어휘롞특강 김선정
국어음성학연구 김선정
…
…
논문지도1 백은정
776 rows selected
*/

select class_name, professor_name from TB_PROFESSOR
join TB_CLASS
using (department_no);

/*9. 8 번의 결과 중 ‘인문사회’ 계열에 속핚 과목의 교수 이름을 찾으려고 핚다. 이에
해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
고전시가롞특강 김선정
국어어휘롞특강 김선정
…
…
논문지도2 강혁
197 rows selected*/
select class_name, professor_name,category from TB_PROFESSOR
join TB_CLASS
using (department_no)
join tb_department
using(department_no)
where category= '인문사회';



/*10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름", 
"젂체 평점"을 출력하는 SQL 문장을 작성하시오. (단, 평점은 소수점 1 자리까지맊
반올림하여 표시핚다.)
학번 학생 이름 전체 평점
---------- -------------------- ----------
9931310 조기현 4.1
A354020 양재영 3.5
A411116 박현화 3.6
A415245 조지선 3.2
A431021 구병훈 3.9
A431358 조상진 3.7
A557031 이정범 3.3
A612052 싞광현 4.1
8 rows selected
*/

select student_no, student_name, round(avg(point),1) from tb_grade
join tb_student
using (student_no)
where department_no = 059
group by student_no, student_name
order by 1;



/*11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 젂달하기
위핚 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용핛 SQL 문을
작성하시오. 단, 출력헤더는 ?학과이름?, ?학생이름?, ?지도교수이름?으로
출력되도록 핚다.
학과이름 학생이름 지도교수이름
-------------------- -------------------- --------------------
경제학과 손건영 박태환*/

select department_name, student_name, professor_name from TB_DEPARTMENT
join tb_professor
using (department_no)
join tb_student
on COACH_PROFESSOR_NO = PROFESSOR_NO
where student_no = 'A313047';


/*12. 2007 년도에 '인갂관계롞' 과목을 수강핚 학생을 찾아 학생이름과 수강학기름 표시하는
SQL 문장을 작성하시오.
STUDENT_NAME TERM_NAME
-------------------- --------------------
김혜원 200701
오진형 200701
이정호 200703
*/

select student_name, term_no, class_name, tb_class.CLASS_NO from tb_grade
join tb_student
using(student_no)
join tb_class
using (department_no)
where term_no like '2007__' and class_name = '인간관계론';

/*13. 예체능 계열 과목 중 과목 담당교수를 핚 명도 배정받지 못핚 과목을 찾아 그 과목
이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
드로잉 미술학과
미술시장,경영롞 미술학과
…
…
운동처방연구 체육학과
해부학실험 체육학과
44 rows selected*/

select class_name, department_name from TB_PROFESSOR
right join tb_class
using (department_no)
right outer join TB_department
using(department_no)
where category = '예체능' and professor_no is null;


/*14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 핚다. 학생이름과
지도교수 이름을 찾고 맊일 지도 교수가 없는 학생일 경우 "지도교수 미지정? 으로
표시하도록 하는 SQL 문을 작성하시오. 단, 출력헤더는 ? 학생이름? , ? 지도교수? 로
표시하며 고학번 학생이 먼저 표시되도록 핚다.
학생이름 지도교수
-------------------- --------------------
주하나 허문표
이희진 남명길
… …
최철현 백양임
14 rows selected*/


select student_name"학생이름", nvl(professor_name,'지도교수 미지정')"지도교수" from tb_student a
left outer join TB_PROFESSOR
on COACH_PROFESSOR_NO = TB_PROFESSOR.PROFESSOR_NO
where a.DEPARTMENT_NO =(select department_no from TB_DEPARTMENT where department_name = '서반아어학과')
order by student_no desc;


