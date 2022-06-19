let servicepath = "http://182.92.116.152:8000";
function getAll() {
    axios.get(servicepath + "/teacher_courses")
        .then(function (response) {
            vm.teacher_courses = response.data;
        })
        .catch(function (error) {
            alert("获取所有授课信息出错");
        });
}
function loadTeachers() {
    axios.get(servicepath + "/teachers")
        .then(function (response) {
            addVM.teachers = response.data;
            updateVM.teachers = response.data;
        })
        .catch(function (error) {
            alert("获取所有教师出错");
        });
}

function loadCourses(){
    axios.get(servicepath + "/courses")
    .then(function(response){
        addVM.courses = response.data;
        updateVM.courses = response.data;
    })
    .catch(function(error){
        alert("获取所有课程出错");
    });
}

function addTeacherCourse(){
    axios.post(servicepath + "/teacher_course", addVM.teacher_course)
    .then(function(response){
        response.data==200 ? alert("添加成功") : alert("添加失败");
        window.location="teacher-course.html";
    })
    .catch(function(error){
        alert("添加请求出错");
    });
}

function deleteTeacherCourse(id){
    axios.delete(servicepath + "/teacher_course", {
        params:{
            'id':id
        }
    }).then(function(response){
        response.data==200?alert("删除成功"):alert("删除失败");
        window.location="teacher-course.html";
    }).catch(function(error){
        alert("删除请求出错");
    });
}

function updateModal(id){
    axios.get(servicepath + "/teacher_course", {
        params:{
            'id':id
        }
    }).then(function(response){
        updateVM.teacher_course = response.data;
        console.log(updateVM.teacher_course);
    }).catch(function(error){
        alert("更新模态框请求出错");
    });
}

function updateTeacherCourse(){
    axios.put(servicepath + "/teacher_course", updateVM.teacher_course)
    .then(function(response){
        response.data == 200?alert("修改成功") : alert("修改失败");
        window.location="teacher-course.html";
    })
    .catch(function(error){
        alert("修改请求错误");
    });   
}