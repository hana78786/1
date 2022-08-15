const tue ="tue";
const mon ="mon";
const web ="wed";
const thr = "thr";
const fri = "fri";
const sat = "sat";
const sun = "sund";

const dayOfweek = [mon,tue,web,thr,fri,sat,sun];

console.log(dayOfweek);
nonsense = [1,2 , "hello",false,null,true,undefined,"world"];

console.log(nonsense);

dayOfweek.push("sun");
console.log(dayOfweek);
const toBuy=["potato","tomato", "pizza"];
toBuy.push("kimbab");

const playername="nico";
const PlayterPoint=121212;
const playterHandsome=false;
const playerFate="little bit";

const player = {
    name:"nico", 
    points:10,
    fat:true,
    };

    console.log(player);
    console.log(player.name);

    player.fat=false;
    console.log(player);

    player.lastname="potato";

    function sayHello(nameOfPerson, age){
        console.log("hello, "+nameOfPerson+"I am "+age+"years old");
    };

    sayHello("nico",20);
    sayHello("dal",15);
    sayHello("lynn",30);

    function plus(a,b){
        console.log(a+b);
    }
    plus();
    plus(8,99);

    const player1={
        name : "nico",
        sayHello: function(otherPersonName){
            console.log("hello! "+otherPersonName + " nice to meet you");
        }
    }

    console.log(player1.name);
    player1.sayHello("lynn");


    const age = 96;
    function calulaterKrAge(ageOfForeigner){
       ageOfForeigner+2;
       return "Hello world!"
    }
    const krAge = calulaterKrAge(age);
    console.log(krAge);


    const caculater = {
       plus: function plus(a,b){
            return a+b;
        },
      minus:  function minus(a,b){
            return a-b;
        },
        gob:   function gob(a,b){
            return a*b;
        },
      nanugi:  function nanugi(a,b){
            return a/b;
        }
    }

    const resultPlus = caculater.plus(2,5);
    const resultMinus= caculater.minus(5,4);
    const resultGob= caculater.gob(12,54);
    const resultNanugi = caculater.nanugi(254,77);
    console.log(resultPlus);
    console.log(resultMinus);
    console.log(resultGob);
    console.log(resultNanugi);