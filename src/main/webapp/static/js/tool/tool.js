const Tool={};
	
//判断是否为空
Tool.isNull=function(data){
	return (data == "" || data == undefined || data == null); 
};
Tool.postError=function(){
	alert('请求失败！');
}
//返回事件
Tool.back=function(){
	if (/(iPhone|iPad|iPod)/i.test(navigator.userAgent)) {
		window.location.href = window.document.referrer;
	} else { 
		window.history.go("-1"); 
	}
};

//jsonget请求 可以解决跨域的问题
Tool.jsonpGet=function(pathUrl, data, success, error) {
	$.ajax({
		type:"get",
		url:pathUrl,
		async:true,
		data:data,
		dataType:"jsonp",
		jsonp:'jsonpCallback',
		success: success||function(){},
		error: error||function(){}
	});
};

Tool.post=function(pathUrl, data, success, error){
	$.ajax({
		url: pathUrl,
		type: "POST",
		data:data,
		dataType: 'json',
		success:success||function(){},
		error: error||function(){alert('请求失败');}
	});
}


