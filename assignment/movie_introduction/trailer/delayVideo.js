document.addEventListener("DOMContentLoaded", () => {
  const video = document.querySelector("video");
  video.style.display = "none";
  video.style.width = "100%";
  video.style.height = "100%";
  video.style.margin = "auto";
  setTimeout(() => {
    video.style.display = "block";
  }, 1000);
});
