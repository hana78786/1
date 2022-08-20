document.title="안녕!"
const title=document.querySelector(".hello h1")
console.log(title);

const title1=document.querySelectorAll(".hello h1")
console.log(title1);



function clickevent(){
title1[1].style.color="blue"
}

title1[1].addEventListener("click",clickevent);

console.dir(title);

function moseEnt(){
    title.innerHTML="mouse is here"
}
function moseLeave(){
    title.innerHTML="mouse is out"
}

title.addEventListener("mouseenter",moseEnt)
title.addEventListener("mouseleave",moseLeave)

window.addEventListener("resize",handlewindowResize)

function handlewindowResize(){
    document.body.style.backgroundColor="tomato";
}

window.addEventListener("copy",handleWindow)
function handleWindow(){

    alert("copy!")
}

window.addEventListener("offline",handlwindowoffline)
window.addEventListener("online",handlwindowonline)
function handlwindowoffline(){
    alert("no Wifi")
}

function handlwindowonline(){
    alert("ok")
}