var loginUrl='';
















function loginPost(userName,password) {
	$.ajax({
		url: loginUrl,
		type: "POST",
		data: {
			userName: userName,
			password: password
		},
		dataType: 'json',
		success: function(response) {
			if(response.code == '200') {
				 location.href = 'index.html'; 
			} else {
				
			}
		},
		error: function() {
			alert("加载失败,请重尝试");
		}
	});
}