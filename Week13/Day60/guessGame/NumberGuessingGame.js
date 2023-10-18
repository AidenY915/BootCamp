let answer;

const submitButton = document.querySelector("#submitButton");
const input = document.querySelector("#input");

let messageDiv = document.createElement("div");
let guideMessageDiv;
let prevInputDiv;
let baseLimitDiv = document.querySelector("#baseLimitDiv");
let baseSpan = document.querySelector("#baseSpan");
let limitSpan = document.querySelector("#limitSpan");

let submit;
let base = 1;
let limit = 100;

const showGuideMessage = function (o) {
  if (guideMessageDiv == undefined || guideMessageDiv == null) {
    guideMessageDiv = document.createElement("div");
    baseLimitDiv.parentElement.insertBefore(guideMessageDiv, baseLimitDiv);
    prevInputDiv = document.createElement("div");
    guideMessageDiv.parentElement.insertBefore(prevInputDiv, guideMessageDiv);
    guideMessageDiv.style.color = "white";
    guideMessageDiv.style.padding = "5px";
  }
  prevInputDiv.innerHTML += submit + "&nbsp";
  switch (o) {
    case -1:
      guideMessageDiv.innerText = "up";
      baseSpan.innerText = "BASE: " + base;
      guideMessageDiv.style.backgroundColor = "red";
      break;
    case 1:
      guideMessageDiv.innerText = "down";
      limitSpan.innerText = "\tLIMIT: " + limit;
      guideMessageDiv.style.backgroundColor = "red";
      break;
    case 0:
      guideMessageDiv.innerText = "correct";
      guideMessageDiv.style.backgroundColor = "green";
      break;
  }
};
let eventListenerAdded = false;
const initGame = function () {
  answer = Math.floor(Math.random() * 100) + 1;
  base = 1;
  limit = 100;
  baseSpan.innerText = "BASE: " + base;
  limitSpan.innerText = "\tLIMIT: " + limit;
  if (guideMessageDiv != undefined && guideMessageDiv != null) {
    guideMessageDiv.parentElement.removeChild(guideMessageDiv);
    guideMessageDiv = null;
    prevInputDiv.parentElement.removeChild(prevInputDiv);
    prevInputDiv = null;
  }
  if (eventListenerAdded) {
    submitButton.removeEventListener("click", submitInput);
    eventListenerAdded = false;
  }
  submitButton.addEventListener("click", submitInput);
  eventListenerAdded = true;
};

const submitInput = () => {
  submit = Number(input.value);
  if (submit < base || submit > limit) {
    alert("The input is out of range");
    return;
  }
  if (submit == answer) {
    showGuideMessage(0);
    submitButton.removeEventListener("click", submitInput);
    return;
  }
  if (submit < answer) {
    base = submit + 1;
    showGuideMessage(-1);
  } else if (submit > answer) {
    limit = submit - 1;
    showGuideMessage(1);
  }
  input.value = "";
};

document.getElementById("input").addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    submitButton.click();
  }
});

document.querySelector("body").addEventListener("keydown", (event) => {
  if (event.key === "r") {
    initGame();
  }
});

document.querySelector("#restartButton").addEventListener("click", initGame);

initGame();
