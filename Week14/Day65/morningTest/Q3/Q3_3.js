document.addEventListener("DOMContentLoaded", () => {
  let intervalId;
  let sec = 0;
  document
    .querySelector('input[name = "timerCheck"]')
    .addEventListener("change", (event) => {
      const timer = document.querySelector("#timer");
      if (event.target.checked) {
        intervalId = setInterval(() => {
          sec++;
          timer.innerText = sec + "초";
        }, 1000);
      } else {
        clearInterval(intervalId);
      }
    });
});
