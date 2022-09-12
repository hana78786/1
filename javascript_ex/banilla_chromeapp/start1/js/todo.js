const toDoForm = document.getElementById("todo-form");
const toDoList = document.getElementById("todo-list");
const todoInput = toDoForm.querySelector("input");


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
    paintToDo(newTodo)

}

toDoForm.addEventListener("submit",handlToDoSubmit);