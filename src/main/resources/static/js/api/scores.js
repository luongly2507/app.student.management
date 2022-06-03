var page = 0;
var size = 5;
var totalSize;

// COUNT
function count() {
    $.ajax({
        url: url + '/api/v1/scores/count',
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
            $('#score-content').html('');
            for (let i = 0; i < data.length; i++) {
                $('#score-content').append(
                    `
                        <tr>
                            <td>${i + 1}</td>
                            <td>${data[i].scoreType}</td>
                            <td>${data[i].coeff}</td>
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
        findAll(url + '/api/v1/scores?page=' + page + '&size=' + size );
    }

})
$('#pre-page').on('click', function () {
    if (!$('#pre-page').hasClass('disabled')) {
        page--;
        changePaginationButtonState();
        findAll(url + '/api/v1/scores?page=' + page + '&size=' + size );
    }

})

// ADD 
$('#add-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/scores',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#add-name').val(),
            coeff: $('#add-coeff').val()
        }),
        statusCode: {
            201: function () {
                $('#add-modal').modal('hide');
                count();
                findAll(url + '/api/v1/scores?page=' + page + '&size=' + size );
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
        url: url + '/api/v1/scores/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#update-name').val(data.scoreType);
            $('#update-coeff').val(data.coeff);
            $('#update-score').val(id);
        }
    })
}
$('#update-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/scores/' + $('#update-score').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#update-name').val(),
            coeff: $('#update-coeff').val()
        }),
        statusCode: {
            204: function () {
                $('#update-modal').modal('hide');
                count();
                findAll(url + '/api/v1/scores?page=' + page + '&size=' + size );
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
        url: url + '/api/v1/scores/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#delete-score').val(id);
            $('#delete-message').text("Bạn chắc chắn xóa điểm này không ?");
        }
    })
}
$('#delete-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/scores/' + $('#delete-score').val(),
        method: 'DELETE',
        contentType: 'application/json',
        statusCode: {
            204: function () {
                $('#delete-modal').modal('hide');
                count();
                findAll(url + '/api/v1/scores?page=' + page + '&size=' + size);
                $('#notification-message').text("Xóa thành công!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// APP
count();

findAll(url + '/api/v1/scores?page=' + page + '&size=' + size);

