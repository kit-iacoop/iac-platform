$(function () {
    $('form').submit(function () {
        if (!$('#companyName').val()) {
            alert('요청 기업을 선택해야 합니다.');
            return false;
        }
    });

    $('.openclose').change(opencloseListener);
    opencloseInit();

    $('.tech-select').change(function () {
        updateSelect($(this).next(), $(this).val());
    });
    updateSelect($('#tech-depth-1'), -1);

    mustInputFuture($('#expireDate'));
});

mustInputFuture = function (dateInput) {
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1;
    let yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }

    // today = yyyy + '-' + mm + '-' + dd;
    dateInput.attr("min", `${yyyy}-${mm}-${dd}`);
}

opencloseListener = function () {
    if ($('#OPEN').is(':checked')) {
        $('.close-show').hide();
        $('.professorId').prop('disabled', true);
    } else {
        $('.close-show').show();
        $('.professorId').prop('disabled', false);
    }
}

opencloseInit = function () {
    $('#OPEN').prop("checked", true);
    $('.close-show').hide();
    $('.professorId').prop('disabled', true);
    $('#isCapstone-false').prop("checked", true);
}

updateSelect = function (selectBox, parent) {
    if (selectBox.prop("tagName") != 'SELECT') {
        return;
    }

    let rightSelect = selectBox;
    while (rightSelect.prop("tagName") == 'SELECT') {
        rightSelect.empty();
        rightSelect.append(`<option disabled selected></option>`);
        rightSelect = rightSelect.next();
    }

    $.ajax({
        method: "GET",
        url: `/fields/${parent}/children`
    })
        .done(function (json) {
            json.forEach(function (data, idx) {
                selectBox.append(`<option value="${data.fieldCategoryId}">${data.categoryName}</option>`);
            });
        });
}

let professorCnt = 1;
let techniqueCnt = 0;

addProfessorInput = function () {
    $('#addProfessorBtn').before(`
        <div>
            <input type="hidden" class="professorId" name="collaboRequestProfessorList[${professorCnt}].professorId" id="professorId${professorCnt}">
            <input type="text" id="professorName${professorCnt}" readonly>
            <button type="button" id="professorIdSearch" onclick="window.open('/accounts/search?dtypes=P&idTag=professorId${professorCnt}&nameTag=professorName${professorCnt}', '_blank', 'width=500,height=400');">검색</button>
        </div>
    `);
    professorCnt++;
}

getNotNullElem = function () {
    if ($('#tech-depth-4').val() != null)
        return $('#tech-depth-4');
    if ($('#tech-depth-3').val() != null)
        return $('#tech-depth-3');
    if ($('#tech-depth-2').val() != null)
        return $('#tech-depth-2');
    return $('#tech-depth-1');
}

addTechniqueInput = function () {
    let selectedTech = getNotNullElem();
    $('#tech-wrapper').append(`
                <div class="tag-wrapper">
                    <input type="hidden" name="collaboRequestTechniqueList[${techniqueCnt}].fieldCategoryId" id="techniqueId${techniqueCnt}"
                        value="${selectedTech.val()}">
                    <input type="text" class="tag-design" id="techniqueName${techniqueCnt}" value="${selectedTech.find('option:checked').text().trim()}" readonly>
                </div>
            `);
    techniqueCnt++;
}

