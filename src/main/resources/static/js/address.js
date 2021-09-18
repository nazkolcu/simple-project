$(document).ready(function () {
    inputsDisabled(true);
});

function inputsClear() {
    document.getElementById('city').value = '';
    document.getElementById('number').value = '';
    document.getElementById('street').value = '';
    document.getElementById('zipcode').value = '';

}

function inputsDisabled(arg) {
    $("#btn").prop('disabled', arg);
    $("#city").prop('disabled', arg);
    $("#number").prop('disabled', arg);
    $("#street").prop('disabled', arg);
    $("#zipcode").prop('disabled', arg);
}

function addressSave() {

    var formAddress = {}
    var index = document.getElementById("userSelect");
    var userId = index.value;
    formAddress["id"] = userId;
    formAddress["city"] = $("#city").val();
    formAddress["zipcode"] = $("#zipcode").val();
    formAddress["street"] = $("#street").val();
    formAddress["number"] = $("#number").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/addaddress",
        data: JSON.stringify(formAddress),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            alert("Eklendi");
        },
    });
}

function userSelected() {

    var index = document.getElementById("userSelect");
    var userId = index.value;

    if (userId > 0) {
        inputsClear();
        inputsDisabled(false);

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/get/" + userId,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var userDto = JSON.stringify(data);

                localStorage.setItem("userDto", userDto);
                let text = localStorage.getItem("userDto");
                let user = JSON.parse(text);
                if (user.address != null) {

                    document.getElementById("city").value = user.address.city;
                    document.getElementById("number").value = user.address.number;
                    document.getElementById("zipcode").value = user.address.zipcode;
                    document.getElementById("street").value = user.address.street;

                }

            },

        });
    } else {
        inputsClear();
        inputsDisabled(true);

    }
}