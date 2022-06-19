let servicepath = "http://182.92.116.152:8000";
/**
 * 获取所有教师信息，通过ajax向后端发送请求，然后后端返回json
 */
function listAll(){
    axios.get(servicepath+ "/teachers")
    .then(function(response){
        vm.teachers = response.data;
    })
    .catch(function(error){
        console.log(error);
    });
}

/**
 * 获取所有的部门
 */
function getDepartments(){
    axios.get(servicepath + "/departments")
    .then(function(response){
        teacherVM.departments = response.data;
    })
    .catch(function(error){
        console.log(error);
    });
}

/**
 * 添加教师的ajax操作，以json形式向后端发送teacher
 */
function addTeacher(){
    axios.post(servicepath + "/teacher", teacherVM.teacher)
    .then(function(response){
        response.data==200?alert("添加成功"):alert("添加失败");
        window.location="teacher.html";
    })
    .catch(function(error){
        alert("添加出错");
        window.location="teacher.html";
    });
}

/**
 * 删除教师，向后端发送教师id作为参数
 * @param {*} t_id 
 */
function deleteTeacher(t_id){
    axios.delete(servicepath + "/teacher", {
        params:{
            't_id': t_id
        }
    })
    .then(function(response){
        response.data==200 ? alert("删除成功") : alert("删除失败");
        window.location="teacher.html";
    })
    .catch(function(error){
        alert("删除出错");
        window.location="teacher.html";
    });
}

/**
 * 更新修改框的信息，通过id获得单个的教师json，然后填入输入框
 * @param {*} t_id 
 */
function updateModal(t_id){
    axios.get(servicepath + "/teacher", {
        params:{
            't_id': t_id
        }
    })
    .then(function(response){
        console.log(response.data);
        updateVM.teacher = response.data;
    })
    .catch(function(error){
        alert("error");
    });
}

/**
 * 更新教师信息，向后端发送教师json来更新一个已有教师
 */
function updateTeacher(){
    axios.put(servicepath + "/teacher", updateVM.teacher)
    .then(function(response){
        response.data==200?alert("修改成功") : alert("修改失败");
        window.location="teacher.html";
    })
    .catch(function(error){
        alert("error");
    });
}