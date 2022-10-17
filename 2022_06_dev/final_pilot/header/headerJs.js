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

var user = document.querySelector('#user-icon');
var mypage= document.querySelector('#mypage-tooltip-area')
mypage.style.display='none'

user.onclick=function(){
    if(mypage.style.display=='none'){
    mypage.style.display='block';
    }else{
        mypage.style.display='none'; 
    }

}