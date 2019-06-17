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
			<div class="top center">
				<div class="left fl">
					<ul>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="./login.html" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="JSP/mainPage.jsp" target="_blank" >返回首页</a></li>
							<li>|</li>
							
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">国产手机</div>
			<div class="main center" id="pname">
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="JSP/xiangqing.jsp" target="_blank" id="img1"><img src="JSP/img/liebiao_xiaomi6.jpg" alt=""></a></div>
					<div class="pinpai" id="name1"><a href="./xiangqing.html" target="_blank">小米6</a></div>
					<div class="youhui">高性价比的手机</div>
					<div class="jiage" id="price1">2499.00元</div>
				</div>
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="JSP/xiangqing.jsp" id="img2"><img src="JSP/img/huaweimate30.jpg" alt=""></a></div>
					<div class="pinpai" id="name2"><a href="">华为p20</a></div>
					<div class="youhui">华为旗舰系列，拍照性能更强</div>
					<div class="jiage" id="price2">2999.00元</div>
				</div>
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="JSP/xiangqing.jsp" id="img3"><img src="JSP/img/meizu16.jpeg" alt=""></a></div>
					<div class="pinpai" id="name3"><a href="">魅族16</a></div>
					<div class="youhui">性能最出色颜值最高的手！</div>
					<div class="jiage" id="price3">2799.00元</div>
				</div>
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="JSP/xiangqing.jsp" id="img4"><img src="JSP/img/liebiao_xiaomimix.jpg" alt=""></a></div>
					<div class="pinpai" id="name4"><a href="">vivox23</a></div>
					<div class="youhui">前后两千万照亮你的美</div>
					<div class="jiage" id="price4">3499.00元</div>
				</div>


				<div class="clear"></div>
			</div>
			<!-- <div class="main center mb20">
				
				<div class="clear"></div>
			</div> 以下为翻页的界面 -->
			
			
			</div>
		</div>
		<div class="page">
			<div class="lastpage"style=" width:98px;height:28px; color:blue" id="lastp" ><input type="button" onclick="lastpage()" value="上一页"></div>
			<div class="midpage" style=" width:98px;height:28px;" id="pnum">2</div>
			<div class="nextpage" style=" width:98px;height:28px; color:blue" id="nextp" "><input type="button" onclick="nextpage()" value="下一页"></div>
		</div>
		<script type="text/javascript">
		function lastpage(){
			
		}
		
		function nextpage(){
			$.ajax({
				url:"goods",
				type:"post",
				data:{
					oper:"add",
				    page:$("#pnum").html() //传页码
				},
				dataType:"json",
				success:function(data){
					 
					var content="";
						for (var i=0;i<data.length;i++){					
						var po=data[i]; 						
						 content+="<div class=\"mingxing fl mb20\" style=\"border:2px solid #fff;width:230px;cursor:pointer;\" onmouseout=\"this.style.border='2px solid #fff'\" onmousemove=\"this.style.border='2px solid red'\">"+
							"<div class=\"sub_mingxing\"><a href=\"/Sellphone/JSP/xiangqing.jsp?goodid="+po.goodID+"\" target=\"_blank\" id=\"img1\"><img src=\""+po.picture+"\" alt=\"\"></a></div>"+
							"<div class=\"pinpai\" ><a href=\"/Sellphone/JSP/xiangqing.jsp?goodid="+po.goodID+"\" target=\"_blank\">"+po.goodname+"</a></div>"+
							"<div class=\"youhui\">"+po.describute+"</div>"+
							"<div class=\"jiage\">"+po.price+"</div>"+
						"</div>"  
						
					}
						$("#pname").html(content);
						
				 	   }
				
				
				
				
			});
			 
			
		}
		
		
		</script>
		
</body>
</html>