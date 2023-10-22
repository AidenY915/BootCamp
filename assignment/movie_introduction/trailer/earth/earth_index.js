document.addEventListener("DOMContentLoaded", () => {
  const earthButton = document.querySelector("button#earth");
  earthButton.addEventListener("click", (event) => {
    const video = document.querySelector("video");
    video.style.display = "block";
    video.style.float = "left";
    video.style.margin = "auto";
  });
});
