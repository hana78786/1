const toDoForm = document.getElementById("todo-form");
const toDoList = document.getElementById("todo-list");
const todoInput = toDoForm.querySelector("input");

function paintToDo(newTodo){
    const li = document.createElement('li'); //li태그 생성
    const span = document.createElement('span'); //span태그 생성
    li.appendChild(span); //<li><span></spam></li>
    span.innerText=newTodo;
    toDoList.appendChild(li);
    console.log(newTodo)
}


function handlToDoSubmit(event){
    event.preventDefault();
    console.log("?")
    const newTodo=todoInput.value;
    todoInput.value="";
    paintToDo(newTodo)

}

toDoForm.addEventListener("submit",handlToDoSubmit);