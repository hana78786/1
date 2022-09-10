const images = [
    "flower.jpg",
    "mountains.jpg",
    "window.jpg"
]

const chosenImage = images[Math.floor(Math.random() * images.length)]


const bgImage=document.createElement("img"); //img태그를 추가한다

bgImage.src=`img/${chosenImage}`; //랜덤으로 images배열에 있는 img의 이름을 가지고와 img src태그에 넣는다.

console.log(bgImage); //<img src = "img/flower.jpg">


document.body.appendChild(bgImage);