function userSave() {

    var user = {}
    user["user-id"] = $("#btn-save").val();

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/delete/" + user["user-id"],
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            location.reload();
        }
    });
}
