<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<script type="text/javascript" src="JS/jquery.1.9.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="height:20px">
请输入修改账户账号：<input type="text" id="uacc" >
</div>
<div style="height:20px" >
请输入你的账户密码： <input type="password" id="upas">
</div>
<div style="height:20px" >
请输入你的修改后的密码：<input type="password" id="npas" >
</div>
<div>
<input type="button" id="tijiao" value="提交" onclick="updatepass()">

</div>

<script type="text/javascript">
function updatepass(){
	$.ajax({
		url:"up",
		type:"post",
		data:{
			
			uacc:$("#uacc").val(),
			upas:$("#upas").val(),
			npas:$("#npas").val()		
		},
		success:function(data){
			alert(data);
			if(data=="密码修改成功!请重新登陆！"){			
				 window.location.href="JSP/LG.jsp";
			}
			else{
				window.location.reload();
			}
			
			
		}
		
		
		
	});
	
	
	
	
}


</script>




</body>
</html>