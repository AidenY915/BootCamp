document.addEventListener("DOMContentLoaded", () => {
  const button = document.querySelector("button");
  let cnt = 1;
  button.addEventListener("click", () => {
    const messageDiv = document.querySelector("#messageDiv");
    const message = "알림 내용";
    const newMessage = document.createElement("p");
    newMessage.innerText = message + `(${cnt++})`;
    messageDiv.insertBefore(newMessage, messageDiv.childNodes[0]);
    setTimeout(() => {
      messageDiv.removeChild(newMessage);
    }, 3000);
  });
});
