document.querySelector("#view").addEventListener("click", (event) => {
  const detail = document.querySelector("#detail");
  if (detail.style.display == "none") {
    detail.style.display = "block";
    event.target.innerText = "상세 설명 닫기";
  } else {
    detail.style.display = "none";
    event.target.innerText = "상세 설명 보기";
  }
});
