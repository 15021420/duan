function doAddFriend(accountIdFrom) {
    var token = $("meta[name='_csrf']").attr("content");

    var dataAddFriend = {
        "accountIdFrom": accountIdFrom
    };

    $.ajax({
        headers: {
            'X-CSRF-TOKEN' : token
        },
        type: "POST",
        url: "/friend/add-friend",
        async: true,
        data : JSON.stringify(dataAddFriend),
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
    })
}