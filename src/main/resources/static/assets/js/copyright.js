changeCopyrightInfo = function () {
    $('.modal-content').load('/copyrights/list/' + $(this).find('input').val());
}

$(function () {
    $(".modalToggle").on({
        click: changeCopyrightInfo
    });
});
