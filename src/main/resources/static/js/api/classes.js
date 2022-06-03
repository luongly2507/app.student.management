var page = 0;
var size = 5;
var totalSize;
var gradeSize;
// COUNT
function count() {
    $.ajax({
        url: url + '/api/v1/classes/count',
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            totalSize = data;
        }

    })
}
// COUNT GRADE SIZE
function count() {
    $.ajax({
        url: url + '/api/v1/grades/count',
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            gradeSize = data;
        }

    })
}

//FIND ALL GRADE
function findAllGrades(uri) {
    $.ajax({
        url: uri,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#add-grade').html('');
            for (let i = 0; i < data.length; i++) {
                $('#add-grade').append(
                    `
                        <option value="${data[i].id}">${data[i].name}</option>
                    `
                );
            }

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
            $('#class-content').html('');
            for (let i = 0; i < data.length; i++) {
                $('#class-content').append(
                    `
                        <tr>
                            <td>${i + 1}</td>
                            <td>${data[i].grade.name}  ${data[i].name}</td>
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
        findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');
    }

})
$('#pre-page').on('click', function () {
    if (!$('#pre-page').hasClass('disabled')) {
        page--;
        changePaginationButtonState();
        findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');
    }

})

// ADD 
findAllGrades(url + '/api/v1/grades?page=0&size=' + gradeSize + 'sort=name');
$('#add-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/classes',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            gradeId: $('#add-grade').val(),
            name: $('#add-name').val()
        }),
        statusCode: {
            201: function () {
                $('#add-modal').modal('hide');
                count();
                findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');
                $('#notification-message').text("Thêm thành công!");
                $('#notification-modal').modal('show');
            },
            400: function () {
                $('#add-modal').modal('hide');
                $('#notification-message').text("Lớp này đã tồn tại!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// UPDATE
function updateModalContent(id) {
    $.ajax({
        url: url + '/api/v1/grades?page=0&size=' + gradeSize + 'sort=name',
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#update-grade').html('');
            for (let i = 0; i < data.length; i++) {
                $('#update-grade').append(
                    `
                        <option value="${data[i].id}">${data[i].name}</option>
                    `
                );
            }

        }
    });
    $.ajax({
        url: url + '/api/v1/classes/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#update-name').val(data.name);
            $("#update-grade").val(data.grade.id).change();
            $('#update-class').val(id);
        }
    })
}
$('#update-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/classes/' + $('#update-class').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#update-name').val(),
            gradeId:  $("#update-grade").val()
        }),
        statusCode: {
            204: function () {
                $('#update-modal').modal('hide');
                count();
                findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');
                $('#notification-message').text("Cập nhật thành công!");
                $('#notification-modal').modal('show');
            },
            400: function () {
                $('#update-modal').modal('hide');
                $('#notification-message').text("Lớp này đã tồn tại! Vui lòng thay đổi thông tin khác!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// DELETE
function deleteModalContent(id) {
    $.ajax({
        url: url + '/api/v1/classes/' + id,
        method: 'GET',
        contentType: 'application/json',
        success: function (data) {
            $('#delete-class').val(id);
            $('#delete-message').text("Bạn chắc chắn xóa lớp này không ?");
        }
    })
}
$('#delete-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/classes/' + $('#delete-class').val(),
        method: 'DELETE',
        contentType: 'application/json',
        statusCode: {
            204: function () {
                $('#delete-modal').modal('hide');
                count();
                findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');
                $('#notification-message').text("Xóa thành công!");
                $('#notification-modal').modal('show');
            }
        }


    })
})
// APP
count();

findAll(url + '/api/v1/classes?page=' + page + '&size=' + size + '&sort=grade');

