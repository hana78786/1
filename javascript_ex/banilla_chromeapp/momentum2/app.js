const age = "열여덟";
console.log(isNaN(age));

if(isNaN(age)){
    console.log("숫자가 아닙니다");
}else{
    console.log(age);
}

const age1 = prompt("나이 입력");
console.log(typeof age1, typeof parseInt(age1));

if(isNaN(age1)){
    console.log("숫자가 아닙니다");
}else if(age1<18){
    console.log("18세 미만입니다.");
}else if(age1>=18&&age1<=50){
    console.log("50세 미만입니다");
}else if(age1>50||age1==88){
    console.log("출입금지");
}else{
    console.log("환영합니다");
}


if(age1===100){
    console.log("숫자100");
}else if(age1==100){
    console.log("문자100");
}else{
    console.log("조건 외 입력")
}

if(age!==100){
    console.log("입력값은 숫자로 입력되지 않았습니다.")
}

if(age!=100){
    console.log("100이 아닙니다.")
}
