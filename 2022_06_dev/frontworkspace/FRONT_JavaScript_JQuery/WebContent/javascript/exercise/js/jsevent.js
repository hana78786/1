function changeBg(param){
    console.log(param);
   
    document.body.style.background = param;
}

window.onload=function(){
var rangeTag = document.getElementById("txtsize");
var h1Tage = document.getElementById("h1");

rangeTag.onclick=function changeH1(){
    h1Tage.style.fontSize=rangeTag.value+"px";
    console.log(rangeTag.value)

}

}


window.onload=function(){
var textId=document.getElementById("in");
var textButton=document.getElementById("ok");
var areaHh=document.getElementById("hh");

textButton.onclick=function ChangeHH(){
   
    console.log(textId.value)
    areaHh.innerHTML=textId.value;
}
}