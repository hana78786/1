// const loginForm = document.querySelector("#login-form");
// const loginInput=loginForm.querySelector("input");
// const loginButton = loginForm.querySelector("button");

const loginInput=document.querySelector("#login-form input");
const loginButton = document.querySelector("#login-form button");

function nLoginbtnClikc(){
   const username= loginInput.value;
//    if(username==""){
//     alert("plase write your name")
//    }else if(username.length>15){
//     alert("Your name is long")
//    }


}

loginButton.addEventListener("click",nLoginbtnClikc)