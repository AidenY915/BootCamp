let textarea = document.querySelector("textarea");

console.log(textarea);
textarea.addEventListener("click", (event) => {
  alert(event.target.value);
});

let doubleEventButton = document.querySelector("#doubleEvent");
doubleEventButton.addEventListener("click", () => {
  alert(1);
});
doubleEventButton.addEventListener("click", () => {
  alert(2);
});

let eventButton = document.getElementsByClassName("eventButton");
for (const e of eventButton) {
  e.addEventListener("click", (event) => {
    alert(event.target.innerText);
  });
}
console.log(document.querySelector("body").innerText);
console.log(document.querySelector("body").textContent);
