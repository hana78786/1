const apiKey = "055d381dd7dfea669cb7c3d20e3948b3"


function onGeoOk(position){
    
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metri`;
    fetch(url).then(response => response.json().then(data =>{
        console.log(data.weather[0].main)
    } ));
}

function onGeoError(){
    alert("can't find you. No weather for you")
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError) //현재 와이파이 gps 등의 정보를 넘겨줌 ()안에 성공, 실패 함수를 넣어주어 실행한다.
