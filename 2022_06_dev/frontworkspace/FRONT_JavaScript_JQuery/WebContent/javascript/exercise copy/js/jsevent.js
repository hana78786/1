function changeBg(param){
    document.body.style.backgroundColor=param;
    

}



window.onload=function(){

    var h1 = document.querySelector("#h1");
    var rangeH2 = document.querySelector("#txtsize")
    rangeH2.addEventListener("change",function(){

        h1.style.fontSize=rangeH2.value+"px";
    })
      

    document.querySelector('#ok').onclick=function(){
        
        var ina =  document.querySelector('#in').value;
        document.querySelector('#hh').innerHTML= ina;

    }

}