const toDoForm = document.getElementById("todo-form");
const toDoList = document.getElementById("todo-list");
const todoInput = toDoForm.querySelector("input");

const TODOS_KEY = "todos"

const toDos = [];



function saveToDos(){
    localStorage.setItem("toDos", JSON.stringify(toDos)) //로컬스토리지에 해당 배열을 저장 JSON형식의 배열로 저장
}


function paintToDo(newTodo){
    const li = document.createElement('li'); //li태그 생성
    const span = document.createElement('span'); //span태그 생성
    span.innerText=newTodo;
    const button = document.createElement('button');
    button.className='delete';
    button.innerText='❌';
   
    button.addEventListener("click", deleteToDo) //클릭이벤트 생성
        
    li.appendChild(span); //<li><span></spam></li>
    li.appendChild(button);
    toDoList.appendChild(li);

 
}


function deleteToDo(even){
    const li = event.target.parentElement//클릭한 현재 이벤트의 타겟의 부모태그속성
    li.remove();
}


function handlToDoSubmit(event){
    event.preventDefault();
        const newTodo=todoInput.value;
    todoInput.value="";
    toDos.push(newTodo); //리스트를 해당 배열의 ㅓ장
    paintToDo(newTodo);
    saveToDos();


}




toDoForm.addEventListener("submit",handlToDoSubmit);

const savedTodos= localStorage.getItem(TODOS_KEY); //현재는 null
if(saveToDos){ //만약 saveToDos가 존재한다면

    const parsedToDos = JSON.parse(saveToDos) //문자열이 아니라 제대로 배열로 인식한다, 이렇게 인식하면 같은 값을 넣어줘도 제대로 더해진다.
    //parsedToDos.forEach((item) => console.log("thisis the turn of", item)); //parsedToDos length만큼 ()안의 값을 반복한다.
    //변수를 가져와서 => 뒤에 값을 실행한다. 가져온 변수를 이곳에서 사용할수 있다.

    parsedToDos.forEach(paintToDo) //paserdTodo만큼 반복한다 paintTodo를

}