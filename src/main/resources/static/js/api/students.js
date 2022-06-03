var page = 0;
var size = 5;
var totalSize;
var classesSize;
var semestersSize;
// SEMESTER 
function count(){
    $.ajax({
        url: url + '/api/v1/students/count?semesterId='+$('#semester-list').val()+'&classId='+$('#class-list').val(),
        method: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (data) {
           totalSize= data;
        }
    })
}
function initSemesters() {
    $.ajax({
        url: url + '/api/v1/semesters/count',
        method: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (data) {
            semestersSize = data;
            $.ajax({
                url: url + '/api/v1/semesters?page=0&size=' + semestersSize + '&sort=yearStart&sort=name',
                method: 'GET',
                async: true,
                contentType: 'application/json',
                success: function (data) {
                    $('#semester-list').html('');
                    for (let i = 0; i < data.length; i++) {
                        $('#semester-list').append(
                            `
                                <option value="${data[i].id}">${data[i].name} năm học ${data[i].yearStart} - ${data[i].yearEnd} </option>
                            `
                        );
                        $('#add-semester').append(
                            `
                                <option value="${data[i].id}">${data[i].name} năm học ${data[i].yearStart} - ${data[i].yearEnd} </option>
                            `
                        );
                    }
                    initClass()
                }
            })
        }
    })
    
    
}
// CLASSES
function initClass(){
    $.ajax({
        url: url + '/api/v1/classes/count',
        method: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (data) {
            classesSize = data;
            $.ajax({
                url: url + '/api/v1/classes?page=0&size=' + classesSize + '&sort=grade',
                method: 'GET',
                async: true,
                contentType: 'application/json',
                success: function (data) {
                    $('#class-list').html('');
                    for (let i = 0; i < data.length; i++) {
                        $('#class-list').append(
                            `
                                <option value="${data[i].id}">Lớp  ${data[i].grade.name}${data[i].name} </option>
                            `
                        );
                        $('#add-class').append(
                            `
                                <option value="${data[i].id}">Lớp  ${data[i].grade.name}${data[i].name} </option>
                            `
                        );
                    }
                    findAll();
                }
            })
        }
    
    })
   
  
}

function findAll(){
    $.ajax({
        url: url + '/api/v1/students?semesterId='+$('#semester-list').val()+'&classId='+$('#class-list').val()+'&page=' + page + '&size=' + size + '&sort=name',
        method: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (data) {
            $('#student-content').html('');
            for (let i = 0; i < data.length; i++) {
                $('#student-content').append(
                    `
                        <tr>
                            <td>${i + 1}</td>
                            <td>  ${data[i].name}</td>
                            <td>  ${data[i].email}</td>
                            <td>  ${data[i].gender}</td>
                            <td>  ${data[i].birthday}</td>
                            <td>  ${data[i].address}</td>
                            <td>
                                <button class="btn btn-primary" data-toggle="modal" data-target="#update-modal" onclick="updateModalContent(${data[i].id})">Cập nhật</button>
                                <button class="btn btn-info" data-toggle="modal" data-target="#score-modal" onclick="scoreModalContent(${data[i].id})">Bảng điểm</button>
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
$('#add-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/students',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#add-name').val(),
            email: $('#add-email').val(),
            birthday: $('#add-birthday').val(),
            classId: $('#add-class').val(),
            semesterId: $('#add-semester').val(),
            gender: $('#add-gender').val(),
            address: $('#add-address').val()
        }),
        statusCode: {
            201: function () {
                $('#add-modal').modal('hide');
                count();
                findAll();
                $('#notification-message').text("Thêm thành công!");
                $('#notification-modal').modal('show');
            },
            400: function () {
                $('#add-message-error').text("Học sinh với email này đã tồn tại !");
            }
        }


    })
})
// UPDATE
function updateModalContent(id) {
    $.ajax({
        url: url + '/api/v1/semesters?page=0&size=' + semestersSize + '&sort=yearStart&sort=name',
        method: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (data) {
            $('#update-semester').html('');
            for (let i = 0; i < data.length; i++) {
                $('#update-semester').append(
                    `
                        <option value="${data[i].id}">${data[i].name} năm học ${data[i].yearStart} - ${data[i].yearEnd} </option>
                    `
                );
            }
            $.ajax({
                url: url + '/api/v1/classes?page=0&size=' + semestersSize + '&sort=grade&sort=name',
                method: 'GET',
                async: true,
                contentType: 'application/json',
                success: function (data) {
                    $('#update-class').html('');
                    for (let i = 0; i < data.length; i++) {
                        $('#update-class').append(
                            `
                                <option value="${data[i].id}">Lớp ${data[i].grade.name}${data[i].name} </option>
                            `
                        );
                    }
                    $.ajax({
                        url: url + '/api/v1/students/' + id,
                        method: 'GET',
                        contentType: 'application/json',
                        success: function (data) {
                            $('#update-name').val(data.name);
                            $("#update-semester").val($('#semester-list').val()).change();
                            $("#update-class").val($('#class-list').val()).change();
                            $("#update-email").val(data.email);
                            $("#update-gender").val(data.gender).change();
                            $("#update-birthday").val(data.birthday);
                            $("#update-address").val(data.address);
                            $('#update-student').val(id);
                        }
                    })
                }
            })
        }
    })
   
    
}
$('#update-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/students/' + $('#update-student').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            name: $('#update-name').val(),
            semesterId: $("#update-semester").val(),
            classId: $("#update-class").val(),
            email: $("#update-email").val(),
            gender: $("#update-gender").val(),
            birthday: $("#update-birthday").val(),
            address: $("#update-address").val(),
            currentSemesterId: $("#semester-list").val(),
            currentClassId: $("#class-list").val()
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
                $('#notification-message').text("Có lỗi xảy ra trong quá trình cập nhật!");
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
            $('#delete-student').val(id);
            $('#delete-message').text("Bạn chắc chắn xóa học sinh này không ?");
        }
    })
}
$('#delete-modal-form').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: url + '/api/v1/students/' + $('#delete-student').val(),
        method: 'DELETE',
        contentType: 'application/json',
        statusCode: {
            204: function () {
                $('#delete-modal').modal('hide');
                count();
                findAll();
                $('#notification-message').text("Xóa thành công!");
                $('#notification-modal').modal('show');
            }
        }


    })
})

$('#semester-list').on('change', function(){
    findAll();
})
$('#class-list').on('change', function(){
    findAll();
})
initSemesters()
