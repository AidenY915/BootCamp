const selectOnhange = (event) => {
  const select = event.target;
  const options = Array.from(select.selectedOptions).map((e) => e.innerText);
  document.querySelector("p").innerText = options;
};

document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("select").addEventListener("change", selectOnhange);
});
