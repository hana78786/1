const apiKey = "055d381dd7dfea669cb7c3d20e3948b3"


function onGeoOk(position){
    
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    console.log("you live in",lat, lon )
}

function onGeoError(){
    alert("can't find you. No weather for you")
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError) //현재 와이파이 gps 등의 정보를 넘겨줌 ()안에 성공, 실패 함수를 넣어주어 실행한다.
