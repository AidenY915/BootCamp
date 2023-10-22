document.addEventListener("DOMContentLoaded", () => {
  document
    .querySelector('input[type="email"]')
    .addEventListener("keyup", (event) => {
      const email = event.currentTarget.value;
      const messageP = document.querySelector("p");
      const pattern = /^[a-z0-9]+@[a-z]+(\.[a-z]{2,}){1,2}$/;
      const regex = new RegExp(pattern);
      if (regex.test(email)) {
        console.log(regex.test(email));
        messageP.innerText = "올바른 이메일: " + email;
        messageP.style.color = "green";
      } else {
        messageP.innerText = "잘못된 이메일: " + email;
        messageP.style.color = "red";
      }
    });
});
