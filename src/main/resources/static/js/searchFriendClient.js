function doSendRequestAddFriend(accountIdRequest) {
    var token = $("meta[name='_csrf']").attr("content");

    var dataRequest = {
        "accountIdRequest": accountIdRequest
    };

    $.ajax({
        headers: {
            'X-CSRF-TOKEN' : token
        },
        type: "POST",
        url: "/friend/request-add-friend",
        async: true,
        data : JSON.stringify(dataRequest),
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

function doRemoveRequestAddFriend(accountIdRequest) {
    var token = $("meta[name='_csrf']").attr("content");

    var dataRequest = {
        "accountIdRequest": accountIdRequest
    };

    $.ajax({
        headers: {
            'X-CSRF-TOKEN' : token
        },
        type: "POST",
        url: "/friend/remove-request-add-friend",
        async: true,
        data : JSON.stringify(dataRequest),
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

function doUnfriend(accountIdRequest) {

}