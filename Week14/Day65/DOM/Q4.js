document.addEventListener("DOMContentLoaded", () => {
  const imgTag = document.querySelector("img");
  const time = new Date().getHours();
  imgTag.src = "images/morning.jpg";
  if (time >= 12) imgTag.src = "images/afternoon.jpg";
});
