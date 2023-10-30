$(() => {
  const correct = Math.floor(Math.random() * 4);

  console.log(correct);
  $("img").one("click", function () {
    $("img").off("click mouseover mouseout");
    const message =
      $("img").index($(this)) == correct
        ? `Your Code:CODE${Math.floor(Math.random() * 100)}`
        : "Sorry, no discount this time";
    console.log($(this).eq());
    $(".container").append(`<div>${message}</div>`);
    $("img").css("borderColor", "red");
    $("img").eq(correct).css("borderColor", "green");
  });
  $("img").on("mouseover", function () {
    $(this).css("borderColor", "blue");
  });
  $("img").on("mouseout", function () {
    $(this).css("borderColor", "black");
  });
});
