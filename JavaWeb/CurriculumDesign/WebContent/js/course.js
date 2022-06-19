let servicepath = "http://182.92.116.152:8000";

function getAll(){
    axios.get(servicepath + "/courses")
    .then(function(response){
        vm.courses = response.data;
    })  
    .catch(function(error){
        alert("获取课程请求出错");
    })  
}

function updateModal(id){
    axios.get(servicepath + "/course", {
        params: {
            'id' : id
        }
    }).then(function(response){
        updateVM.course = response.data;
    }).catch(function(error){
        alert("更新modal请求出错");
    });
}

function deleteCourse(id){
    axios.delete(servicepath + "/course", {
        params: {
            'id':id
        }
    }).then(function(response){
        response.data==200?alert("删除成功"):alert("删除失败");
        window.location="course.html";
    }).catch(function(error){
        alert("删除请求出错");
    }); 
}

function addCourse(){
    axios.post(servicepath + "/course", addVM.course)
    .then(function(response){
        response.data == 200 ? alert("添加成功") : alert("添加失败");
        window.location="course.html";
    })
    .catch(function(error){
        alert("添加课程请求出错");
    });
}