<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 相对路径 -->
<base href="<%=request.getContextPath()%>/">
<script type="text/javascript" src="JS/jquery.1.9.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form>
 
 账号:<input type="text" id="account" /><br/>
密码:<input type="password" id="pass" /><br/>
<img src="pic" onclick="getpicture()" id="pic"><br/>
请输入验证码:<input type="text" id="checkpic"/> <span id="mes"></span><br/>
<input type="button"  value="点击登陆" onclick="login()" id="dologin"/>
&nbsp&nbsp&nbsp<input type="button"  value="点击注册" onclick="register()" id="doregister"/>
 </form>
<script type="text/javascript" >
    //ajax是写在js中的
    function login(){
      //ajax相当于form表单，异步发请求，页面不跳转，不影响当前页面，可以显示在当前页面
    	$.ajax({
    		url:"User",//设置连接
    		//设置请求类型相当于post
    		type:"post",
    		data:{
    		  account: $("#account").val(),
    	      pass: $("#pass").val(),
    	      checkpicture:$("#checkpic").val()
    		},
    		dataType:"json",
    		//当服务器发送数据成功后并且服务器也有响应时，执行以下函数，并且再将值赋予给data，
    		success:function(data){
    			/* alert(data); */
    		      $("#mes").html(data);
    		      $("#mes").css("color","red");
    		      $("#mes").css("font-size","5");
    		      if(data=="登陆成功！"){
    		    	  window.location.href="JSP/mainPage.jsp";
    		      }
    		      if(data=="验证码有误，请重新输入验证码！"){
    		    	 /*  window.location.reload(); */
    		    	 //刷新页面
    		    	 getpicture();
    		    	 
    		      }
    		}
    	});
    }
    function register(){//注册时候的方法！
    	$.ajax({
    		
    		url:"Userreg",//设置连接
    		//设置请求类型相当于post
    		type:"post",
    		data:{
    		  account: $("#account").val(),
    	      pass: $("#pass").val(),
    	      //取得用户输入的验证码
    	      checkpicture:$("#checkpic").val()
    		},
    		dataType:"json",
    		//当服务器发送数据成功后并且服务器也有响应时，执行以下函数，并且再将值赋予给data，
    		success:function(data){
    			/* alert(data); */
    		      $("#mes").html(data);
    		      $("#mes").css("color","red");
    		      $("#mes").css("font-size","5");
    		      if(data=="登陆成功！"){
    		    	  window.location.href="JSP/mainPage.jsp";
    		      }
    		      if(data=="验证码有误，请重新输入验证码！"){
    		    	 /*  window.location.reload(); */
    		    	 //刷新页面
    		    	 getpicture();
    		    	 
    		      }
    		}
    		
    	});   	
    	
    }
    function getpicture(){
    	$("#pic").attr("src","pic?a="+Math.random());
    }
</script>




</body>
</html>