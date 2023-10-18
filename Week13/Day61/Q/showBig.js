const smallImgs = document.querySelectorAll(".small");
const bigImg = document.querySelector("#cup");

for (const img of smallImgs) {
  img.addEventListener("click", (event) => {
    bigImg.src = event.target.src;
  });
}
