let intervalId;
let timeoutId;

function moveToTarget(movingTag, destinationTag) {
  const destinationRect = destinationTag.getBoundingClientRect();
  const destinationTagTop =
    destinationRect.top + destinationRect.height / 2 + window.scrollY;
  const destinationTagLeft =
    destinationRect.left + destinationRect.width / 3 + window.scrollX;

  const movingRect = movingTag.getBoundingClientRect();
  let movingTagTop = movingRect.top + window.scrollY;
  let movingTagLeft = movingRect.left + window.scrollX;

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
  }, 1000);
}

function dispalyDetail(planetLink) {
  const siblings = Array.from(planetLink.parentElement.childNodes);
  siblings[siblings.indexOf(planetLink) + 2].style.display = 'block';
}
function hideDetail(planetLink) {
  const siblings = Array.from(planetLink.parentElement.childNodes);
  siblings[siblings.indexOf(planetLink) + 2].style.display = 'none';
}

document.addEventListener('DOMContentLoaded', () => {
  Array.from(document.getElementsByClassName('planet')).forEach((element) => {
    const rocket = document.querySelector('#rocket');
    element.addEventListener('mouseover', (event) => {
      moveToTarget(rocket, event.currentTarget);
      dispalyDetail(event.currentTarget);
    });
    element.addEventListener('mouseout', (event) => {
      hideDetail(event.currentTarget);
    });
  });
});
