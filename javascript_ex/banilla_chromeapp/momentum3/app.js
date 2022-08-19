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