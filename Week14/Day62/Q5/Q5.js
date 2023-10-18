const registerForm = document.getElementById("registerForm");

function makeLi(name) {
  const li = document.createElement("li");
  const nameSpan = document.createElement("span");
  const xSpan = document.createElement("span");
  nameSpan.innerText = name;
  xSpan.innerHTML = "&check;";
  li.appendChild(nameSpan);
  li.appendChild(xSpan);
  xSpan.addEventListener("click", () => {
    li.parentElement.removeChild(li);
  });
  return li;
}

function register(event) {
  event.preventDefault();
  const memberList = document.getElementById("memberList");
  const name = this.childNodes[1].value;
  this.childNodes[1].value = "";
  console.log(memberList.childNodes);
  memberList.insertBefore(makeLi(name), memberList.childNodes[0]);
}

registerForm.addEventListener("submit", register);
