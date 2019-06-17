<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="<%=request.getContextPath()%>/"> 
<link rel="stylesheet" type="text/css" href="JSP/css/style1.css">
<script type="text/javascript" src="JS/jquery.1.9.1.js"></script>
</head>
<body>
<!-- start header -->
		<header>
		<!-- 建立一个隐藏的标签来存界面上传来的值 -->
		<input type="hidden" value="${param.goodid}"  id="gid">
			<div class="top center">
				<div class="left fl"> 
					<ul>								
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr" "><a href="JSP/gouwuche.jsp">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="./login.html" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="JSP/liebiao.jsp" target="_blank" >上一页</a></li>
							<li>|</li>
						
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

	<div class="jieshao mt20 w" id="xiangqing">
		<div class="left fl" id="pict"><img src="JSP/img/liebiao_xiaomi6.jpg"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20" id="name">魅族16</div>
			<div class="jianjie mr40 ml20 mt10" id="des">陶瓷机身，高通孝晓龙855，水冷铜管散热！</div>
			<div class="jiage ml20 mt10" id="pri">2399元</div>	
			<div class="xqxq mt20 ml20">
				<div class="bot mt20 ft20 ftbc" id="pri">总计：2399元</div>
			</div>
			<div class="xiadan ml20 mt20">
					
					<input class="jrgwc" type="button" name="jrgwc" value="加入购物车！"/><a href="JSP/gouwuche.jsp" >            
				
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
	//通过goodid查找商品的详细信息
	function jieshao(){
	$.ajax({
		url:"goods",
		
		type:"post",
		
		data:{
			oper:"sigle",
			/*传出值 */
			gid:$("#gid").val()
			
		},
	dataType:"json",
	success:function(data){
		 
		var content="";
			for (var i=0;i<data.length;i++){					
			var po=data[i]; 						
			 content+="<div class='jieshao mt20 w' id='xiangqing'>"+
				"<div class='left fl' id='pict'><img src='"+po.picture+"' ></div>"+
				"<div class='right fr'>"+
					"<div class='h3 ml20 mt20' id='"+name+"'>"+po.goodname+"</div>"+
					"<div class='jianjie mr40 ml20 mt10' id='des'>"+po.describute+"</div>"+
					"<div class='jiage ml20 mt10' id='pri'>"+po.price+"</div>"+
					"<div class='xqxq mt20 ml20'>"+
						"<div class='bot mt20 ft20 ftbc'>"+'<a>售价：</a>'+po.price+'<a>元</a>'+"</div>"+
					"</div>"+
					"<div class='xiadan ml20 mt20'>"+
							
							"<input class='jrgwc' type='button' name='jrgwc' value='加入购物车！' onclick='addcart(\""+po.picture+"\",\""+po.goodname+"\","+po.price+",\""+po.describute+"\")'> "+           
						
					"</div>"+
				"</div>"+
				
			"</div>"
			
		}
			
			$("#xiangqing").html(content);  
	}
		
				
	});
	}
	//执行此函数
	jieshao();
	function addcart(picture,name,price,describute){
		//传入商品名字，等下再获取商品的id从页面获取
		alert("加入购物车成功！");
		 $.ajax({
			url:"Cart",
			type:"post",
			data:{
			oper:"update",
				picture:picture,
				price:price,
				goodname:name,
				gid:$("#gid").val(),
				number:"1"
				
			},
		 dataType:"json",
		 seccess:function(data){
			 
			 
		 }
		 });	
	}
	
	
	
	
	
	</script>

	


</body>
</html>