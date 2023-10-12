let answer;

const submitButton = document.querySelector("#submitButton");
const input = document.querySelector("#input");

let guideMessageDiv;
let prevInputDiv;
let baseLimitDiv;
let baseSpan;
let limitSpan;

let submit;
let base = 1;
let limit = 100;

const showGuideMessage = function (o) {
  if (guideMessageDiv == undefined) {
    const messageDiv = document.createElement("div");
    document.querySelector("#content").appendChild(messageDiv);
    prevInputDiv = document.createElement("div");
    messageDiv.appendChild(prevInputDiv);
    guideMessageDiv = document.createElement("div");
    messageDiv.appendChild(guideMessageDiv);
    baseLimitDiv = document.createElement("div");
    messageDiv.appendChild(baseLimitDiv);
    baseSpan = document.createElement("span");
    limitSpan = document.createElement("span");
    baseLimitDiv.appendChild(baseSpan);
    baseLimitDiv.appendChild(limitSpan);
    baseSpan.innerText = "BASE: " + base;
    limitSpan.innerText = "\tLIMIT: " + limit;
  }
  prevInputDiv.innerHTML += submit + "&nbsp";
  switch (o) {
    case -1:
      guideMessageDiv.innerText = "up";
      baseSpan.innerText = "BASE: " + base;
      break;
    case 1:
      guideMessageDiv.innerText = "down";
      limitSpan.innerText = "\tLIMIT: " + limit;
      break;
    case 0:
      guideMessageDiv.innerText = "correct";
      break;
  }
};

submitButton.addEventListener("click", () => {
  submit = Number(input.value);
  if (submit < base || submit > limit) {
    alert("범위 밖의 입력");
    return;
  }
  if (submit == answer) {
    showGuideMessage(0);
    return;
  }
  if (submit < answer) {
    base = submit;
    showGuideMessage(-1);
  } else if (submit > answer) {
    limit = submit;
    showGuideMessage(1);
  }
});

const initGame = function () {
  answer = Math.floor(Math.random() * 100) + 1;
  base = 1;
  limit = 100;
};

initGame();
