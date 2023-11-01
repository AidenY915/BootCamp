$(() => {
  //$(".imgPart").attr("cnt", 1);
  $.each($(".imgPart"), (i, e) => {
    $(e).attr("cnt", Math.floor(Math.random() * 9));
  });
  $(".imgPart").on("click", (event) => {
    let cnt = $(event.currentTarget).attr("cnt");
    $(event.currentTarget)
      .children("img")
      .animate(
        {
          left: cnt * -370 + "px",
        },
        1000,
        "linear",
        () => {
          if (
            cnt ==
              Number($(event.currentTarget).siblings().eq(0).attr("cnt")) &&
            cnt ==
              Number($(event.currentTarget).siblings().eq(1).attr("cnt")) &&
            cnt == Number($(event.currentTarget).siblings().eq(2).attr("cnt"))
          )
            alert("correct");
        }
      );
    cnt++;
    cnt = cnt >= 10 ? 0 : cnt;
    $(event.currentTarget).attr("cnt", cnt);
  });
  $(".imgPart").trigger("click");
  const backgrounds = [
    "lightning-01.jpg",
    "lightning-02.jpg",
    "lightning-03.jpg",
  ];
  let backgroundIdx = 0;
  setInterval(() => {
    backgroundIdx++;
    backgroundIdx = backgroundIdx >= backgrounds.length ? 0 : backgroundIdx;
    $("#backgroundImg").attr("src", `images/${backgrounds[backgroundIdx]}`);
    $("#backgroundImg").fadeTo(1000, 1, "swing").fadeTo(1000, 0, "swing");
    $(".mainContainer").fadeTo(1000, 0.8, "swing").fadeTo(1000, 1, "swing");
    $("#titleImg").fadeTo(1000, 0.8, "swing").fadeTo(1000, 1, "swing");
  }, 5000);
});
