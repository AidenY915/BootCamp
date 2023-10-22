const orderOnclick = (event) => {
  const orderListDiv = document.createElement("div");
  orderListDiv.innerText = event.target.parentElement.childNodes[3].innerText;
  orderListDiv.style.color = "blue";
  event.target.parentElement.appendChild(orderListDiv);
  event.target.removeEventListener("click", orderOnclick);
};
document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("button").addEventListener("click", orderOnclick);
});
