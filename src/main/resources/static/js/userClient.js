$('document').ready(function () {
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

        buttonSubmit.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Đang đăng bài ...';

        var token = $("meta[name='_csrf']").attr("content");

        $.ajax({
            headers: {
               'X-CSRF-TOKEN' : token
            },
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/post/create",
            async: true,
            data : data,
            contentType: false,
            // prevent jQuery from automatically transforming the data into a query string
            processData: false,
            cache: false,
            timeout: 1000000,
            success: function(data, textStatus, jqXHR) {
                location.reload();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                location.reload();
            }
        });
    }
});