const quotes= [
    {
        quoto:"헬로자바" ,
        autohor:"자바"
    },
    {
        quoto:"츄르죠" ,
        autohor:"야옹"
    }, 
    {
        quoto:"낮잠자고 싶다" ,
        autohor:"냥냥펀치"
    }, 
    {
        quoto:"자바스크립트는 어렵다" ,
        autohor:"제이쿼리"
    }, 
    {
        quoto:"제이쿼리는 한물갔다" ,
        autohor:"자바스크립트"
    }, 
    {
        quoto:"파이썬은 겉멋만들었다" ,
        autohor:"자바"
    },
     {
        quoto:"자바는 촌스럽다" ,
        autohor:"파이썬"
    },
     {
        quoto:"CSS가 필요해" ,
        autohor:"html"
    },
     {
        quoto:"그리드는 공부했니?" ,
        autohor:"css"
    }
];

const quote = document.querySelector('#quote span:first-child');
const autor = document.querySelector('#quote span:last-child');

console.log(quotes[Math.floor(Math.random() * 10)]) 
Math.random() // 0에서 1사이의 실수를 출력한다 ex) 0.111245, 0.89865
Math.round()//소숫점을 버림해주는 함수
Math.ceil()//소숫점을 정수로 올림해주는 함수
Math.floor()//소숫점을 정수로 버림해주는 함수


const quoteAndAutor =quotes[Math.floor(Math.random() * quotes.length)];

quote.innerText = quoteAndAutor.quoto;
autor.innerText = quoteAndAutor.autohor;