window.onload=function(){
var down=document.querySelector('#down-icon');
var sec=document.querySelector('#secret-area');
var up=document.querySelector('#up-icon');
down.onclick=ViewRecipe;
up.onclick=removeRecipe;


function ViewRecipe(){
    sec.style.display='flex';
    down.style.display='none';
    up.style.display='';
    down.style.transition='0.5s';
    up.style.transition='0.5s';
    

}
function removeRecipe(){
    sec.style.display='none';
    down.style.display='';
    up.style.display='none';
    down.style.transition='0.5s';
    up.style.transition='0.5s';

}


window.addEventListener('scroll',function(){

    if(window.scrollY>1300){
        document.querySelector('.text').style.animation='slide-no 1s ease-out forwards';


    }
    
    if(window.scrollY>300&&window.scrollY<1200){
        document.querySelector('.text').style.animation='slide 1s ease-out forwards';


    }

    if(window.scrollY>1300){
        document.querySelector('.text1').style.animation='slide-no 1s ease-out forwards';


    }
    
    if(window.scrollY>300&&window.scrollY<1200){
        document.querySelector('.text1').style.animation='slide1 1s ease-out forwards';


    }

    if(window.scrollY>300&&window.scrollY<1200){
        document.querySelector('#pola-img').style.animation='fadein 1s ease-out forwards';


    }

    if(window.scrollY>1300){
        document.querySelector('#pola-img').style.animation='fadeout 1s ease-out forwards';


    }
});






}