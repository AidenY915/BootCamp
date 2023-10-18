const submitForm = document.querySelector("#submitForm");

function addToDo(toDo) {
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
  removeButton.addEventListener("click", () => {
    toDoList.removeChild(li);
  });

  li.appendChild(checkbox);
  li.appendChild(toDoSpan);
  li.appendChild(removeButton);
  toDoList.appendChild(li);
}

submitForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const textInput = document.querySelector("#submitForm>input");
  addToDo(textInput.value);
  textInput.value = "";
});
