const h1 = document.querySelector("div.hello:first-child h1")

const Cname ="clicked";
function hadnleTitleClick(){
   if(h1.className==="active"){
    h1.className=Cname;
   }else{
   h1.className="active";}
   console.log(h1.className)

}
h1.addEventListener("click",hadnleTitleClick)

