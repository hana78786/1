const clock = document.querySelector('h2#clock');

function sayHello(){
    console.log("hello");

}

const date = new Date() //오늘날짜

date.getDate //오늘의 날짜만 출력 (00일)

date.getDay // 요일을 숫자로 출력 0일. 1월 2화...

 date.getFullYear// 0000년 년도출력

 date.getHours //00시 몇시인지 출력 24시 기준

 date.getMinutes // 몇분인지 출력

 date.getSeconds //몇초인지 출력;

 function getClock(){

    const date = new Date() //함수안에서 newDate를 선언해줘야 시계가 계속 업데이트 된다
    const hour=String(date.getHours()).padStart(2,"0"); //00시 몇시인지 출력 24시 기준

    const minute = String(date.getMinutes()).padStart(2,"0"); // 몇분인지 출력
   
    const second = String(date.getSeconds()).padStart(2,"0"); //몇초인지 출력;
    clock.innerText=`${hour}:${minute}:${second}`;

 }

 getClock()
 setInterval(getClock,1000);


 "1".padStart(2,"0") //""로 표기한 문자열을 2자리로 표기한다 앞에는 1자리일때 0을 넣는다

 "hello".padStart(20,"x") //'xxxxxxxxxxxxxxxhello' 이렇게 출력됨