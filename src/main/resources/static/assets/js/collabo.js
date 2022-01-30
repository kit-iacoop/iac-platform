//검색조건 input에 이벤트 넣기
// const SearchFilterState = {
//   projectType: "t1", //기본적으로 장기 프로젝트가 선택되어있다고 가정
//   major: [],
// };

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
  searchFilterState.projectType = $("input[name='projectType']:checked").val();
  searchFilterState.fields = [];
  $.each($("input[name='fieldCategory']:checked"), function () {
    searchFilterState.fields.push($(this).val());
  });
  return searchFilterState;

  // var eleType = target.attr("type");
  // var value = target.attr("data-type");
  // if (eleType === "radio") {
  //   SerachFilterState.projectType = value;
  // }
  // if (eleType === "checkbox") {
  //   var index = SerachFilterState.major.indexOf(value);
  //   //이미 있다면 이것은 uncheck하겠다는 의미
  //   if (index !== -1) {
  //     SerachFilterState.major.splice(index, 1);
  //   } else {
  //     //없다면 이것은 새로 check되었다는 의미
  //     SerachFilterState.major.push(value);
  //     SerachFilterState.major.sort();
  //   }
  // }
};

requestProjectList = function () {
  const searchFilterState = getValues();

  // console.log(searchFilterState);
  console.log(JSON.stringify(searchFilterState));

  $.ajax({
    // contentType: "application/json",
    method: "GET",
    url: "/requests/list/filter",
    data: searchFilterState,
    success: function (fragment) {
      $('.project-list-container').replaceWith(fragment);
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

  $(".sidebar-body input").on({
    change: requestProjectList,
  });
});