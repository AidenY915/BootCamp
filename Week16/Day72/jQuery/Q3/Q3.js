$(() => {
  $(".removeBtn").on("click", () => {
    $("ol>:last-child").remove();
  });
});
