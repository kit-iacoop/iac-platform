changeCompanyInfo = function () {
    $('.modal-content').load('/about/companies/list/' + $(this).find('input').val());
}

$(function () {
    $(".modalToggle").on({
        click: changeCompanyInfo
    });
});
