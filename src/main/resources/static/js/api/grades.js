var page = 0;
var size = 5;
var totalSize;

// COUNT
function count() {
    $.ajax({
        url: url + '/api/v1/grades/count',
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            totalSize = data;
        }

    })
}

//FIND ALL
function findAll(uri) {
    $.ajax({
        url: uri,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#grade-content').html('');
            for (let i = 0; i < data.length; i++) {
                $('#grade-content').append(
                    `
                        <tr>
                            <td>${i + 1}</td>
                            <td>${data[i].name}</td>
                            <td>
                                <button class="btn btn-primary" data-toggle="modal" data-target="#update-modal" onclick="updateModalContent(${data[i].id})">Cập nhật</button>
                                <button class="btn btn-danger" data-toggle="modal" data-target="#delete-modal" onclick="deleteModalContent(${data[i].id})">Xóa</button>
                            </td>
                        </tr>
                    `
                );
            }

        }
    })
}

// PAGINATION
function changePaginationButtonState() {
    if (page == 0) {
        $('#pre-page').addClass('disabled');
    }
    else {
        $('#pre-page').removeClass('disabled');
    }

    if ((totalSize - page * size <= size) || (totalSize == size)) {
        $('#next-page').addClass('disabled');
    }
    else {
        $('#next-page').removeClass('disabled');
    }
}
$('#next-page').on('click', function () {
    if (!$('#next-page').hasClass('disabled')) {
        page++;
        changePaginationButtonState();
        findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + 'sort=name');
    }

})
$('#pre-page').on('click', function () {
    if (!$('#pre-page').hasClass('disabled')) {
        page--;
        changePaginationButtonState();
        findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + '&sort=name');
    }

})

// ADD 
$('#add-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/grades',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#add-name').val(),
            yearStart: $('#add-start-year').val(),
            yearEnd: $('#add-end-year').val()
        }),
        statusCode: {
            201: function () {
                $('#add-modal').modal('hide');
                count();
                findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + '&sort=name');
                $('#notification-message').text("Thêm thành công!");
                $('#notification-modal').modal('show');
            },
            400: function () {
                $('#add-modal').modal('hide');
                $('#notification-message').text("Khối này đã tồn tại!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// UPDATE
function updateModalContent(id) {
    $.ajax({
        url: url + '/api/v1/grades/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#update-name').val(data.name);
            $('#update-start-year').val(data.yearStart);
            $('#update-end-year').val(data.yearEnd);
            $('#update-grade').val(id);
        }
    })
}
$('#update-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/grades/' + $('#update-grade').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#update-name').val()
        }),
        statusCode: {
            204: function () {
                $('#update-modal').modal('hide');
                count();
                findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + '&sort=name');
                $('#notification-message').text("Cập nhật thành công!");
                $('#notification-modal').modal('show');
            },
            400: function () {
                $('#update-modal').modal('hide');
                $('#notification-message').text("Khối này đã tồn tại! Vui lòng thay đổi thông tin khác!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// DELETE
function deleteModalContent(id) {
    $.ajax({
        url: url + '/api/v1/grades/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#delete-grade').val(id);
            $('#delete-message').text("Bạn chắc chắn xóa khối này không ?");
        }
    })
}
$('#delete-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/grades/' + $('#delete-grade').val(),
        method: 'DELETE',
        contentType: 'application/json',
        statusCode: {
            204: function () {
                $('#delete-modal').modal('hide');
                count();
                findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + '&sort=name');
                $('#notification-message').text("Xóa thành công!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// APP
count();

findAll(url + '/api/v1/grades?page=' + page + '&size=' + size + '&sort=name');

