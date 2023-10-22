const convertToRemoveButton = (node, listArr, index) => {
  node.addEventListener("click", (event) => {
    node.parentElement.parentElement.removeChild(node.parentElement);
    delete listArr[index];
    console.log(listArr);
  });
};

const addParticipant = (listArr) => {
  const index = listArr.length - 1;
  const participant = listArr[index];
  const tbody = document.querySelector("tbody");
  const tr = document.createElement("tr");
  const nameTd = document.createElement("td");
  const majorTd = document.createElement("td");
  nameTd.innerText = participant.name;
  majorTd.innerText = participant.major;
  tr.appendChild(nameTd);
  tr.appendChild(majorTd);
  tbody.appendChild(tr);
  convertToRemoveButton(nameTd, listArr, index);
};

document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("table");
  table.style.display = "none";
  const listArr = [];
  document.querySelector("form").addEventListener("submit", (event) => {
    event.preventDefault();
    const name = event.target.childNodes[2].value;
    const major = event.target.childNodes[6].value;
    if (listArr.length == 0) table.style.display = "block";
    listArr.push({ name: name, major: major });
    addParticipant(listArr);
  });
});
