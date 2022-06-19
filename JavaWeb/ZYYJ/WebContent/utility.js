var xmlhttp;

function loadExternalPage(url){
	xmlhttp = null;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		xmlhttp = new ActiveXObject();
	}
	
	if(xmlhttp != null){
		xmlhttp.onreadystatechange = state_change;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
	}
}

function state_change(){
	if(xmlhttp.readyState == 4){
		if(xmlhttp.status == 200){
			document.getElementById('main').innerHTML = xmlhttp.responseText;
		}
		else{
			alert("加载错误: " + xmlhttp.statusText);
		}
	}
}

// 用搜索结果更改页面
function search_state_change(externalPage){
	if(xmlhttp.readyState == 4){
		if(xmlhttp.status == 200){
			document.getElementById('add-button').innerHTML = "<a href='#' onclick=\"loadExternalPage('" + externalPage + "')\">显示全部</a>";
			document.getElementById('table-tbody').innerHTML = xmlhttp.responseText;
		}
		else{
			alert("搜索出错: " + xmlhttp.statusText);
		}
	}
}

// 获取搜索结果
function search(url, externalPage){
	var input = document.getElementById("search-input").value;
	var option = document.getElementById("search-option").value;
	if(input != ""){
		if(xmlhttp!=null){
			var post_data = "input=" + input + "&option=" + option;
			
			xmlhttp.onreadystatechange = function(){search_state_change(externalPage);}
			xmlhttp.open('post', url, true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			xmlhttp.send(post_data);
		}
	}
	else{
		alert("请输入搜索内容");
	}
}
//修改科目信息
function updateCourseInfo(course_id){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/CourseGetAction",
		data:{"course_id" : course_id},
		success: function(data)
		{
			$("#course_id").val(data.course_id);
			$("#user_id").val(data.user_id);
			$("#name").val(data.name);
			$("#introduction").val(data.introduction);
			$("#photo").val(data.photo);
			$("#practice_count").val(data.practice_count);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改章节信息
function updateChapterInfo(chapter_id){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/chapterGetAction",
		data:{"chapter_id" : chapter_id},
		success: function(data)
		{
			$("#chapter_id").val(data.chapter_id);
			$("#course_id").val(data.course_id);
			$("#name").val(data.name);
			$("#photo").val(data.photo);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改知识点信息
function updateKnowledgeInfo(know_id){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/knowledgeGetAction",
		data:{"know_id" : know_id},
		success: function(data)
		{
			$("#know_id").val(data.know_id);
			$("#course_id").val(data.course_id);
			$("#name").val(data.name);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改题目信息
function updateQuestionInfo(question_id){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/questionGetAction",
		data:{"question_id" : question_id},
		success: function(data)
		{
			$("#question_id").val(data.question_id);
			$("#course_id").val(data.course_id);
			$("#programme_id").val(data.programme_id);
			$("#exam_id").val(data.exam_id);
			$("#question_type").val(data.question_type);
			$("#level").val(data.level);
			$("#question").val(data.question);
			$("#answer1").val(data.answer1);
			$("#answer2").val(data.answer2);
			$("#answer3").val(data.answer3);
			$("#answer4").val(data.answer4);
			$("#rightanswer").val(data.rightanswer);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改学院信息
function updateCollegeInfo(collegeID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/CollegeGetAction",
		data:{"collegid" : collegeID},
		success: function(data)
		{
			$("#college_id").val(data.id);
			$("#name").val(data.name);
			$("#comment").val(data.detail);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改部门信息
function updateDepartmentInfo(departmentID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/DepartmentGetAction",
		data:{"departmentid" : departmentID},
		success: function(data)
		{
			$("#department_id").val(data.departmentid);
			$("#college_id").val(data.collegeid);
			$("#name").val(data.name);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改专业信息
function updateMajorInfo(majorID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/MajorGetAction",
		data:{"majorid" : majorID},
		success: function(data)
		{
			$("#major_id").val(data.majorid);
			$("#college_id").val(data.collegeid);
			$("#name").val(data.name);
			$("#comment").val(data.detail);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改年级信息
function updateGradeInfo(gradeID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/GradeGetAction",
		data:{"gradeID" : gradeID},
		success: function(data)
		{
			$("#grade_id").val(data.gradeid);
			$("#major_id").val(data.majorid);
			$("#name").val(data.name);
			$("#comment").val(data.detail);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改班级信息
function updateClassInfo(classID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/ClassGetAction",
		data:{"classID" : classID},
		success: function(data)
		{
			$("#class_id").val(data.classid);
			$("#grade_id").val(data.gradeid);
			$("#name").val(data.name);
			$("#comment").val(data.detail);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

//修改学生信息
function updateStudentInfo(studentID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/StudentGetAction",
		data:{"studentID" : studentID},
		success: function(data)
		{
			$("#studentid").val(data.studentid);
			$("#classid").val(data.classid);
			$("#name").val(data.name);
			$("#gender").val(data.gender);
			$("#email").val(data.email);
			$("#phone").val(data.phone);
			$("#account").val(data.account);
			$("#password").val(data.password);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

function updateModalPracticeProgramme(programmeID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getPracticeProgramme",
		data:{"programme_id" : programmeID},
		success: function(data){
			$("#programme_id").val(data.programme_id);
			$("#name").val(data.name);
			$("#course").val(data.course);
			$("#score").val(data.score);
			$("#note").val(data.note);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

function updateModalCheckpoint(checkpointID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getCheckpointJSON",
		data:{"checkpoint_id" : checkpointID},
		success: function(data){
			$("#checkpoint_id").val(data.checkpoint_id);
			$("#name").val(data.name);
			$("#creator").val(data.creator);
			$("#programme").val(data.programme);
			$("#limit_time").val(data.limit_time);
			$("#question_num").val(data.question_num);
			$("#total_score").val(data.total_score);
			$("#pass_score").val(data.pass_score);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}

function updateModalExamProgramme(examID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getExamProgramme",
		data:{"exam_id" : examID},
		success: function(data){
			$("#exam_id").val(data.exam_id);
			$("#name").val(data.name);
			$("#total_question").val(data.total_question);
			$("#total_score").val(data.total_score);
			$("#pass_score").val(data.pass_score);
			$("#question_num").val(data.question_num);
			$("#limit_time").val(data.limit_time);
			$("#start_time").val(data.start_time);
			$("#course").val(data.course);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}

function updateModalExchangeRule(ruleID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getExchangeRuleJSON",
		data:{"rule_id" : ruleID},
		success: function(data){
			$("#rule_id").val(data.rule_id);
			$("#name").val(data.name);
			$("#score").val(data.score);
			$("#integral").val(data.integral);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}