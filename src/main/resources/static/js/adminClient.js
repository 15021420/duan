function doLockOrUnlock(username, isActive) {
    var token = $("meta[name='_csrf']").attr("content");

    var statusChange = !(isActive === 'true');

    var data = {
      "username" : username,
      "status" : statusChange
    };

    console.log(data);

    $.ajax({
        headers: {
            'X-CSRF-TOKEN' : token
        },
        type: "POST",
        url: "/admin/lock-or-unlock-acc",
        async: true,
        data : JSON.stringify(data),
        contentType: "application/json",
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