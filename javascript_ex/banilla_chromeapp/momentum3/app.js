const h1 = document.querySelector("div.hello:first-child h1")

const Cname ="clicked";
function hadnleTitleClick(){
   if(h1.classList.contains("active")){
    h1.classList.remove("active");
   }else{
   h1.classList.add("active");}
   console.log(h1.className)

}
h1.addEventListener("click",hadnleTitleClick)

