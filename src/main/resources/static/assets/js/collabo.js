movePage = function (page) {
  $("input[name='page']").val(page);
  requestProjectList();
}

getDepth = function (elem) {
  return elem.attr('class').slice(-1) * 1;
}

cascadingCheck = function () {
  let prop = $(this).is(':checked');
  let curDepth = getDepth($(this).parent());
  let temp = $(this).parent().next();
  while (curDepth < getDepth(temp)) {
    temp.children('input').prop("checked", prop);
    temp.children('input').prop("disabled", prop);
    temp = temp.next();
  }
}

getValues = function () {
  let searchFilterState = {};

  searchFilterState.page = $("input[name='page']").val();
  searchFilterState.term = $("input[name='term']:checked").val();
  searchFilterState.type = $("input[name='type']:checked").val();

  searchFilterState.options = [];
  $.each($("input[name='options']:checked"), function () {
    searchFilterState.options.push($(this).val());
  });
  
  searchFilterState.fields = [];
  $.each($("input[name='fieldCategory']:checked"), function () {
    searchFilterState.fields.push($(this).val());
  });

  return searchFilterState;
};

requestProjectList = function () {
  $.ajax({
    method: "GET",
    url: "/requests/list/query",
    data: getValues(),
    success: function (fragment) {
      $('.project-list-container').html(fragment);
      $("html, body").animate({ scrollTop: 0 }, "fast");
    },
    error: function (errorThrown) {
      alert(errorThrown.statusText);
    },
  });
};

$(function () {
  $(".sidebar-body input[type='checkbox']").on({
    change: cascadingCheck,
  });

  $("#filterBtn").on({
    click: requestProjectList,
  });

  movePage(1);
});