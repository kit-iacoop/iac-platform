//검색조건 input에 이벤트 넣기
const SerachFilterState = {
  projectType: "t1", //기본적으로 장기 프로젝트가 선택되어있다고 가정
  major: [],
};
requestProjectList = function () {
  console.log(SerachFilterState);
  console.log(JSON.stringify(SerachFilterState));
  $.ajax({
    contentType: "application/json",
    url: "/collabo/collabo-list",
    type: "POST",
    data: JSON.stringify(SerachFilterState),
    success: function (data) {
      console.log(data);
      alert("성공");
    },
    error: function (errorThrown) {
      alert(errorThrown.statusText);
    },
  });
};
modifyFilter = function () {
  var eleType = $(this).attr("type");
  var value = $(this).attr("data-type");
  if (eleType === "radio") {
    SerachFilterState.projectType = value;
  }
  if (eleType === "checkbox") {
    var index = SerachFilterState.major.indexOf(value);
    //이미 있다면 이것은 uncheck하겠다는 의미
    if (index !== -1) {
      SerachFilterState.major.splice(index, 1);
    } else {
      //없다면 이것은 새로 check되었다는 의미
      SerachFilterState.major.push(value);
      SerachFilterState.major.sort();
    }
  }
  requestProjectList();
};

$(function () {
  $(".sidebar-body input").on({
    change: modifyFilter,
  });
});
