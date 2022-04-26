$(function () {
    $('#submitButton').click(function (e) {

        //Prevent default submission of form
        // Don't call action from controller
        e.preventDefault();

        //Remove previous errors
        $('input').next('span').remove();

        $.post({
            url: '/SpringMVCHospital/operator/savePatient',
            data: $('#registrationForm').serialize(),
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            success: function (res) {
                if (res.validated) {
                    //take your successful action here; you may want to redirect to another page
                    alert("Registration Successful");
                } else {
                    //Dynamic html element for error message
                    $.each(res.errorMessages, function (key, value) {
                        $('input[name=' + key + ']').after('<span class="error">' + value + '</span>');
                    });
                }
            },
            error: function (){
                alert("Si è verificato un errore");
            }
        })
    });

});