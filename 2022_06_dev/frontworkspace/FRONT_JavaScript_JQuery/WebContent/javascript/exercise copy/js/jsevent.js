function changeBg(param){
    document.body.style.background=param;

}



window.onload=function(){
    var range1 = document.querySelector("[type='range']");
    console.log(range1)
    range1.onclick = function(){
       var h1Tag= document.querySelector('h1');
       console.log(h1Tag)
       h1Tag.style.fontSize=range1.value+"px";
       console.log(h1Tag)
    }    

}