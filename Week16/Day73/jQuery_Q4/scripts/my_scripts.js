$(() => {
  let menu;
  $("#vegOn").on("click", () => {
    $(".fish").parent().parent().hide();
    const $menus = $(".hamburger, .meat").parent().parent();
    $("<img src = 'images/leaf.png'>").prependTo($menus);

    $(".hamburger").replaceWith('<li class="Portobello">Portobello</li>');
    $(".meat").replaceWith('<li class="veg">Tofu</li>');
  });
  $("#restoreMe").on("click", () => {
    location.reload();
  });
});
