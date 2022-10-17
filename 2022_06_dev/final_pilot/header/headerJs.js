var menu = document.querySelector('#togglemenu');
var check = false;
menu.onclick=function(){
    if(!check){
    document.querySelector('#menu-bar').style.display='block'
    check=true;
    }else{
    document.querySelector('#menu-bar').style.display='none'
    check=false;
    }
}