 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<script type="text/javascript" src="JS/jquery.1.9.1.js"></script>
<!-- 相对路径 -->
<meta charset="UTF-8">
<title>Connection Future</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <link rel="stylesheet" media="screen" href="JSP/css/style.css">
  <link rel="stylesheet" type="text/css" href="JSP/css/reset.css"/>

</head>


<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				请登录连接未来官网！
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="JSP/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="" value="" id="account" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="JSP/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name=""value="" id="pass"  placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="cheickpic">
				<img src="pic" onclick="getpicture()" id="pic">
			</div>
			<div class="input">
				<input type="text"  id="checkpic">
			</div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp
			<span id="mes" ></span></br>
			
			<div class="login-button" onclick="login()" >
				登陆
			</div>
			<div class="register-button" onclick="register()" >
				   点击注册
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>


<!-- <script src="js/particles.min.js"></script> -->
<!-- <script src="js/app.js"></script> -->
<script type="text/javascript">
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	
	 
</script>

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
    		      if(data=="验证码有误，请重新输入验证码！"||data=="密码错误！登陆失败！"){
    		    	 /*  window.location.reload(); */
    		    	 //刷新页面
    		    	 getpicture();
    		    	 
    		      }
    		      if(data=="账号不存在！请重新输入并注册"){
    		    	  window.location.reload();
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
    		      if(data=="注册成功,请登陆！"){
    		    	 /*  window.location.href="JSP/mainPage.jsp"; */
    		    	 window.location.reload();
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
 
 
 
 
 
 
 
 
 
 
 
 

 
 
 