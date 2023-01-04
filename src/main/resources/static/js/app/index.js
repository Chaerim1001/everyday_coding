const main = {
    init: function () {
        const _this = this;
        $('#btn-register').on('click', () => {
            _this.register();
        });
    },
    register: function () {
        const data = {
            email: $('#email').val(),
            nickname: $('#nickname').val(),
            password: $('#password').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/members',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(() => {
            window.location.href = '/';
        }).fail((error) => {
            alert(JSON.stringify(error));
        })
    }
}

main.init();