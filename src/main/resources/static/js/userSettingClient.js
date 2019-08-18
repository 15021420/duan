$("#submitButton").click(function(event) {

    // Stop default form Submit.
    event.preventDefault();

    // Call Ajax Submit.

    ajaxSubmitForm();

});

function ajaxSubmitForm() {
    /*console.log('fucking shit');*/
    var form = $('#upload-file-form')[0];

    var data = new FormData(form);

    $("#submitButton").prop("disabled", true);

    var buttonSubmit = document.getElementById('submitButton');

    buttonSubmit.setAttribute("disabled", "");

    buttonSubmit.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Đang cập nhật ảnh đại diện';

    var token = $("meta[name='_csrf']").attr("content");

    $.ajax({
        headers: {
            'X-CSRF-TOKEN' : token
        },
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/user/change-avatar",
        async: true,
        data : data,
        contentType: false,
        // prevent jQuery from automatically transforming the data into a query string
        processData: false,
        cache: false,
        timeout: 1000000,
        success: function(data, textStatus, jqXHR) {
            location.href = "/user";
        },
        error: function(jqXHR, textStatus, errorThrown) {
            location.href = "/user";
        }
    });
}

$(document).ready(function () {
    var elements = document.getElementsByClassName("column");

// Declare a loop variable
    var i;
    for (i = 0; i < elements.length; i++) {
        elements[i].style.msFlex = "25%";  // IE10
        elements[i].style.flex = "25%";
    }
});