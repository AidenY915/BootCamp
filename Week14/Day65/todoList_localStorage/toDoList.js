const submitForm = document.querySelector("#submitForm");
let toDoArr;
let lastIndex = 0;

function addToDo(toDo, index) {
  if (toDo === "") return;
  const toDoList = document.querySelector("#toDoList");
  const li = document.createElement("li");
  const toDoSpan = document.createElement("span");
  toDoSpan.innerText = toDo;

  const checkbox = document.createElement("input");
  checkbox.type = "checkbox";
  checkbox.addEventListener("change", (event) => {
    if (event.target.checked) {
      toDoSpan.style.textDecoration = "line-through";
      toDoSpan.style.color = "#aaa";
    } else {
      toDoSpan.style.textDecoration = "none";
      toDoSpan.style.color = "#000";
    }
  });

  const removeButton = document.createElement("button");
  removeButton.innerText = "X";
  removeButton.type = "button";
  removeButton.addEventListener("click", (event) => {
    toDoList.removeChild(li);
    delete toDoArr[index];
    console.log(toDoArr);
    localStorage.setItem("toDoListOfLocal", JSON.stringify(toDoArr));
  });

  li.appendChild(checkbox);
  li.appendChild(toDoSpan);
  li.appendChild(removeButton);
  toDoList.appendChild(li);
}

submitForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const textInput = document.querySelector("#submitForm>input");
  const toDo = textInput.value;
  toDoArr.push(toDo);
  addToDo(toDo, ++lastIndex);
  localStorage.setItem("toDoListOfLocal", JSON.stringify(toDoArr));
  textInput.value = "";
});

document.addEventListener("DOMContentLoaded", () => {
  toDoArr = JSON.parse(localStorage.getItem("toDoListOfLocal"));
  toDoArr = toDoArr == undefined ? [] : toDoArr;
  toDoArr.forEach((e, i) => {
    if (e === undefined || e === null) return;
    addToDo(e, i);
    lastIndex = i;
  });
});
