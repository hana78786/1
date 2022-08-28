// const loginInput=loginForm.querySelector("input");
// const loginButton = loginForm.querySelector("button");

const loginInput=document.querySelector("#login-form input");
const loginForm = document.querySelector("#login-form");
const link = document.querySelector('a');
const greetning = document.querySelector('#greeting')
const HIDDEN_CLASSNAME="hidden" //문자열을 담은 상수는 대문자로 표기한다
const USERNAME_KEY="username;"
const saveUserName = localStorage.getItem(USERNAME_KEY)


function onLoginSubmit(event){
    event.preventDefault();
    loginForm.classList.add(HIDDEN_CLASSNAME);
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY,username);
    paintGreeting(username)

}

function paintGreeting(username){
    greetning.innerText=`Hello ${username}`;
    greetning.classList.remove(HIDDEN_CLASSNAME);

}


if(saveUserName==null){
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("submit",onLoginSubmit)
    
}else{
   paintGreeting(saveUserName)

}