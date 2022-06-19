var xmlhttp;

/*局部加载页面*/
function loadExternalPage(url)
{
	xmlhttp = null;
	if(window.XMLHttpRequest)
	{
		xmlhttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		xmlhttp = new ActiveXObject();
	}

	if(xmlhttp != null)
	{
		xmlhttp.onreadystatechange = state_change;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
	}
}

function state_change()
{
	if(xmlhttp.readyState == 4)
	{
		if(xmlhttp.status == 200)
		{
			document.getElementById('main').innerHTML = xmlhttp.responseText;
		}
		else
		{
			alert("加载错误: " + xmlhttp.statusText);
		}
	}
}

function checkNumber(nubmer)
{//判断字符串是否为数字
	let re = /^[0-9]+.?[0-9]*$/;
	if (re.test(nubmer))
	{
		return true;
	}
	else
	{
		return false;
	}
}

function check(thisform)
{//Apriori算法表单验证
	var min_support = thisform['min_support'].value;
	var min_confidence = thisform['min_confidence'].value;
	if (min_support == "" || min_support == 0 || !checkNumber(min_support))
	{
		alert("请输入最小支持度有效数据！");
		return false;
	}
	else if (min_confidence == "" || min_confidence >= 1 || !checkNumber(min_confidence))
	{
		alert("请输入最小置信度有效数据！");
		return false;
	}
	else return true;
}

function KmeansCheck(thisform)
{//Kmeans算法表单验证
	var c1_R = thisform['c1_R'].value;
	var c1_F = thisform['c1_F'].value;
	var c1_M = thisform['c1_M'].value;

	var c2_R = thisform['c2_R'].value;
	var c2_F = thisform['c2_F'].value;
	var c2_M = thisform['c2_M'].value;

	var c3_R = thisform['c3_R'].value;
	var c3_F = thisform['c3_F'].value;
	var c3_M = thisform['c3_M'].value;

	if (c1_R == "" || c2_R == "" || c3_R == "" || c1_R > 121 || c2_R > 121 || c3_R > 121 ||
	!checkNumber(c1_R) || !checkNumber(c2_R) || !checkNumber(c3_R))
	{
		alert("请输入最近一次消费时间间隔有效数据！");
		return false;
	}
	else if (c1_F == "" || c2_F == "" || c3_F == "" || c1_F > 31 || c2_F > 31 || c3_F > 31 ||
		!checkNumber(c1_F) || !checkNumber(c2_F) || !checkNumber(c3_F))
	{
		alert("请输入消费频率有效数据！");
		return false;
	}
	else if (c1_M == "" || c2_M == "" || c3_M == "" || c1_M > 7795 || c2_M > 7795 || c3_R > 7795 ||
		c1_M < 23 || c2_M < 23 || c3_M < 23 ||
		!checkNumber(c1_M) || !checkNumber(c2_M) || !checkNumber(c3_M))
	{
		alert("请输入消费总金额有效数据！");
		return false;
	}
	else return true;
}