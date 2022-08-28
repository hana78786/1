// const loginInput=loginForm.querySelector("input");
// const loginButton = loginForm.querySelector("button");

const loginInput=document.querySelector("#login-form input");
const loginForm = document.querySelector("#login-form");
const link = document.querySelector('a');
const greetning = document.querySelector('#greeting')
const HIDDEN_CLASSNAME="hidden" //문자열을 담은 상수는 대문자로 표기한다


function onLoginSubmit(event){
    event.preventDefault();
    const username = loginInput.value;
    loginForm.classList.add(HIDDEN_CLASSNAME);
    // greetning.innerText="Hello "+username;
    greetning.innerText=`Hello ${username}`;
    greetning.classList.remove(HIDDEN_CLASSNAME);

}

loginForm.addEventListener("submit",onLoginSubmit)