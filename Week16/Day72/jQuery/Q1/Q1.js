$(function () {
  $("#moveUpBtn, #moveDownBtn, #addColorBtn, #appearToggleBtn").on(
    "click",
    (event) => {
      const $p = $("p");
      $p.css({ position: "absolute" });
      switch ($(event.target).attr("id")) {
        case "moveUpBtn":
          $p.animate({ top: "50px" }, 1000, "linear", () => {});
          break;
        case "moveDownBtn":
          $p.animate({ top: "500px" }, 1000, "linear");
          break;
        case "addColorBtn":
          $p.css({ color: "purple" });
          break;
        case "appearToggleBtn":
          $p.toggle();
          break;
      }
    }
  );
});
