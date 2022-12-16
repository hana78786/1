const apiKey = "055d381dd7dfea669cb7c3d20e3948b3"


function onGeoOk(position){
    
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
        const weatherContainer = document.querySelector('#weather span:first-child');
        const cityContainer = document.querySelector('#weather span:last-child');
        weatherContainer.innerHTML= data.weather[0].main;
       cityContainer.innerHTML=data.name;

        });
}

function onGeoError(){
    alert("can't find you. No weather for you")
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError) //현재 와이파이 gps 등의 정보를 넘겨줌 ()안에 성공, 실패 함수를 넣어주어 실행한다.


document.querySelector('#weather span:last-child').style.fontSize='2rem';