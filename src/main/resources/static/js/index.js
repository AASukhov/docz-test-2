$(function () {
    $('.delete-button').click(function () {
        let id = $(this).attr("data-student-id");
        $.ajax({
            url  : baseUrl + id,
            type : 'DELETE',
            success : function () {
                alert("Студент с id = " + id + " был удален");
                location.reload();
            },
            error : function (exception) {
                alert(exception);
            }
        })
    });

    $('.add-button').click(function () {
        $('.add-button-container').hide();
        $('.new-student-container').show();
    });

    $('.cancel-button').click(function () {
        $('.new-student-container').hide();

        $('#student-id').val('');
        $('#student-name').val('');
        $('#student-surname').val('');
        $('#date').val('');
        $('#group').val('');

        $('.add-button-container').show();
    })

    $('.create-button').click(function () {
        jQuery.ajax ({
            url: baseUrl + "new",
            type: "POST",
            data: JSON.stringify({
                id : $('#student-id').val(),
                name : $('#student-name').val(),
                surname : $('#student-surname').val(),
                date : $('#date').val(),
                group : $('#group').val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success : function () {
                $('#student-id').val('');
                $('#student-name').val('');
                $('#student-surname').val('');
                $('#date').val('');
                $('#group').val('');
                alert("Новый студент создан");
            },
            error : function (exception) {
                alert(exception);
            }
        });
    });
});
