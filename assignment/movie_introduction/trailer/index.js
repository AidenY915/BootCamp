let intervalId;
let timeoutId;
let enter;
function moveToTarget(movingTag, destinationTag) {
  enter = true;
  const destinationRect = destinationTag.getBoundingClientRect();
  const destinationTagTop =
    destinationRect.top + destinationRect.height / 2 + window.scrollY;
  const destinationTagLeft =
    destinationRect.left + destinationRect.width / 3 + window.scrollX;

  console.log(destinationTag);

  const movingRect = movingTag.getBoundingClientRect();
  let movingTagTop = movingRect.top + window.scrollY;
  let movingTagLeft = movingRect.left + window.scrollX;
  console.log(movingTagTop);
  console.log(destinationTagTop);

  const topV = (destinationTagTop - movingTagTop) / 100;
  const leftV = (destinationTagLeft - movingTagLeft) / 100;

  if (intervalId !== undefined) clearInterval(intervalId);
  intervalId = setInterval(() => {
    movingTagTop += topV;
    movingTagLeft += leftV;
    movingTag.style.transform = `translate(${movingTagLeft}px, ${movingTagTop}px)`;
  }, 10);
  if (timeoutId !== undefined) clearTimeout(timeoutId);
  timeoutId = setTimeout(() => {
    clearInterval(intervalId);
    if (enter) location.assign(destinationTag.href);
  }, 1000);
}

document.addEventListener("DOMContentLoaded", () => {
  Array.from(document.getElementsByClassName("planet")).forEach((element) => {
    const rocket = document.querySelector("#rocket");
    element.addEventListener("click", (event) => {
      event.preventDefault();
    });
    element.addEventListener("mouseover", (event) => {
      moveToTarget(rocket, event.currentTarget);
    });
    element.addEventListener("mouseout", (event) => {
      enter = false;
    });
  });
});
