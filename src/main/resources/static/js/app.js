var host = "localhost";
var port = 8080;
var url = "http://" + host + ":" + port;

// Set Tags
if( localStorage.getItem('activeTab') == null ){
    localStorage.setItem('activeTab',"ali-tab");
}
$('#'+localStorage.getItem('activeTab')).click();
$('#ali-tab').click(function(){
    localStorage.setItem('activeTab',"ali-tab");
})
$('#semester-tab').click(function(){
    localStorage.setItem('activeTab',"semester-tab");
})
$('#class-tab').click(function(){
    localStorage.setItem('activeTab','class-tab');
})
$('#student-tab').click(function(){
    localStorage.setItem('activeTab',"student-tab");
})
$('#username-tab').click(function(){
    localStorage.setItem('activeTab',"username-tab");
})
$('#regulations-tab').click(function(){
    localStorage.setItem('activeTab',"regulations-tab");
})
$('#course-tab').click(function(){
    localStorage.setItem('activeTab',"course-tab");
})
$('#score-board-tab').click(function(){
    localStorage.setItem('activeTab',"score-board-tab");
})
$('#grade-tab').click(function(){
    localStorage.setItem('activeTab',"grade-tab");
})
// SEMESTER
// Search 
$('#search-semesters').keyup(function(){
    $.ajax({
        url: url + '/semesters?search='+$('#search-semesters').val(),
        method: 'GET',
        success: function(data){
            $('#semesters-list').html('');
            
            for(let i = 0; i < data.length; i++){
                if($('#role').val() == '[ROLE_PRINCIPAL]'){
                    $('#semesters-list').append(` 
                    <tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].name} năm học ${new Date(data[i].dateStart).getFullYear()} - ${new Date(data[i].dateStart).getFullYear()+1}</td>
                        <td class="dropdown">
                        <a role="button"  data-bs-toggle="dropdown" aria-expanded="false"><i
                                class="fa-solid fa-ellipsis-vertical"></i></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#view-semeter-modal" onclick="viewSemester('${data[i].id}')">Xem chi tiết</a></li>
                            <li><a class="dropdown-item" href="#"  data-bs-toggle="modal" data-bs-target="#update-semeter-modal" onclick="updateSemester('${data[i].id}')">Chỉnh sửa</a></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#delete-semeter-modal" onclick="deleteSemester('${data[i].id}')">Xóa</a></li>
                        </ul>
                    </td>
                    </tr>`);
                }
                else{
                    $('#semesters-list').append(` 
                <tr>
                    <td>${data[i].id}</td>
                    <td>${data[i].name} năm học ${new Date(data[i].dateStart).getFullYear()} - ${new Date(data[i].dateStart).getFullYear()+1}</td>
                    <td class="dropdown">
                    <a role="button"  data-bs-toggle="dropdown" aria-expanded="false"><i
                            class="fa-solid fa-ellipsis-vertical"></i></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#view-semeter-modal" onclick="viewSemester('${data[i].id}')">Xem chi tiết</a></li>
                  </ul>
                </td>
                </tr>`);
                }
                
            }
        }
    })
})

// update
function updateSemester(id){
    $.ajax({
        url: url + '/semesters/'+id,
        method: 'GET',
        success: function(data){
            $('#update-semester-name').val(data.name);
            $('#update-semester-date-start').val(data.dateStart);
            $('#update-semester-date-end').val(data.dateEnd);
            $('#update-semester-button').val(data.id);
        }
    })
}
$('#update-semester-form').submit(function(e){
    e.preventDefault();
    $.ajax({
        url: url + '/semesters/'+ $('#update-semester-button').val(),
        method: 'PUT',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify({ 
            "name": $('#update-semester-name').val(),
            "dateStart": $('#update-semester-date-start').val(),
            "dateEnd": $('#update-semester-date-end').val()
        }),
        statusCode: {
            204: function() {
                location.reload();
            }
        }
    })
})
// delete
function deleteSemester(id){
    $.ajax({
        url: url + '/semesters/'+id,
        method: 'GET',
        success: function(data){
            $('#delete-semester-question').text("Bạn có chắc chắc xóa "+ data.name + " năm học " + new Date(data.dateStart).getFullYear() + " - " +(new Date(data.dateStart).getFullYear()+1)+" ?");
            $('#delete-semester-button').val(data.id);
        }
    })
}
$('#delete-semester-form').submit(function(e){
    e.preventDefault();
    $.ajax({
        url: url + '/semesters/'+ $('#delete-semester-button').val(),
        method: 'DELETE',
        statusCode: {
            204: function() {
                location.reload();
            }
        }
    })
})
function viewSemester(id){
    $.ajax({
        url: url + '/semesters/'+id,
        method: 'GET',
        success: function(data){
            $('#view-semester-title').text(data.name + " năm học " + new Date(data.dateStart).getFullYear() + " - " +(new Date(data.dateStart).getFullYear()+1));
        }
    })
}


// GRADE

// update
function updateGrade(id){
    $.ajax({
        url: url + '/grades/'+id,
        method: 'GET',
        success: function(data){
            $('#update-grade-name').val(data.name);
            $('#update-grade-button').val(data.id);
        }
    })
}
$('#update-grade-form').submit(function(e){
    e.preventDefault();
    $.ajax({
        url: url + '/grades/'+ $('#update-grade-button').val(),
        method: 'PUT',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify({ 
            "name": $('#update-grade-name').val(),
        }),
        statusCode: {
            204: function() {
                location.reload();
            }
        }
    })
})
// delete
function deleteGrade(id){
    $.ajax({
        url: url + '/grades/'+id,
        method: 'GET',
        success: function(data){
            $('#delete-grade-question').text("Bạn có chắc chắc xóa khối "+ data.name + " ?");
            $('#delete-grade-button').val(data.id);
        }
    })
}
$('#delete-grade-form').submit(function(e){
    e.preventDefault();
    $.ajax({
        url: url + '/grades/'+ $('#delete-grade-button').val(),
        method: 'DELETE',
        statusCode: {
            204: function() {
                location.reload();
            }
        }
    })
})