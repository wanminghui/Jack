<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--这里加入相对路径的声明  -->
<base href="<%=request.getContextPath()%>/"> 
<link rel="stylesheet" type="text/css" href="JSP/css/style1.css">
</head>
 <body>
 <header>
	<li><a >当前在线人数：<%= application.getAttribute("count") %></a></li>
    <li><a href="JSP/updataPassword.jsp" style="color:red" >修改密码点击此处 </a></li>
			<div class="top center">
				<div class="left fl">
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="">购物车</a></div>
					
					<div class="fr">
				<li><a href="JSP/LG.jsp" target="_blank" >${sessionScope.account}</a></li>							
				
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	
<!-- start banner_x -->
		<div class="banner_x center">
			<div class="logo fl"> </div>
			<div class="ad_top fl"><img src="JSP/img/chouyan.jpg" width=180px height=98px></div>
			<div class="nav fl">
				<ul>
					<li><a href="JSP/liebiao.jsp" target="_blank">连接未来官网</a></li>
					<li><a href="">奢侈手机</a></li>
					<li><a href="">高端手机</a></li>
					<li><a href="JSP/liebiao.jsp">国产手机</a></li>
					<li><a href="">拍照手机</a></li>
					<li><a href="">网络人气手机</a></li>
					<li><a href="">拍照性价比手机</a></li>
					<li><a href="">功能手机</a></li>
					<li><a href="">手机配件</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索" />
					</div>
					<div class="clear"></div>
				</form>
				
			</div>
		</div>
<!-- end banner_x -->
<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">手机类型</div>
			<div class="main center">
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="JSP/img/weitu.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">奢侈手机</a></div>
					<div class="youhui">立即下单送超值礼品</div>
					<div class="jiage">10000元以上</div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="JSP/img/iphonex.jpg" alt="" width=60px height=60px></a></div>
					<div class="pinpai"><a href="">高端手机</a></div>
					<div class="youhui">旗舰机型商务高端</div>
					<div class="jiage">4000到9000不等</div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="JSP/liebiao.jsp"><img src="JSP/img/huaweimate30.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">国产手机</a></div>
					<div class="youhui">纯国产手机！体现爱国情怀</div>
					<div class="jiage">1000到3000+</div>
				</div>
				<div class="mingxing fl"> 	
					<div class="sub_mingxing"><a href=""><img src="JSP/img/xiaolingtong.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">功能手机</a></div>
					<div class="youhui">仅仅提供接打电话发信息</div>
					<div class="jiage">800以下</div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="JSP/img/aliware.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">外星人笔记本</a></div>
					<div class="youhui">超级游戏本</div>
					<div class="jiage">10000+</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="peijian w">
			<div class="biaoti center">手机配件</div>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href=""><img src="JSP/img/peijian1.jpg"></a>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian2.jpg"></a></div>
						<div class="miaoshu"><a href="">小米6 硅胶保护套</a></div>
						<div class="jiage">49元</div>
						<div class="pingjia">372人评价</div>
						<div class="piao">
							<a href="">
								<span>选择它让你的手机无可挑剔</span>
								<span>来自20亿人的评价</span>
							</a>
		
						</div>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian3.jpg"></a></div>
						<div class="miaoshu"><a href="">魅族酷炫充电宝</a></div>
						<div class="jiage">199</div>
						<div class="pingjia">1000+人评价</div>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian4.jpg"></a></div>
						<div class="miaoshu"><a href="">苹果X手机壳</a></div>
						<div class="jiage">88</div>
						<div class="pingjia">2万人的选择</div>
						<div class="piao">
							<a href="">
								<span>选择它没有错！</span>
						
							</a>
						</div>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian5.jpg"></a></div>
						<div class="miaoshu"><a href="">三星JBL耳机</a></div>
						<div class="jiage">89元</div>
						<div class="pingjia">372人评价</div>
						<div class="piao">
							<a href="">
								<span>你的选择很棒！买下它</span>							
							</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="content">
					<div class="remen fl"><a href=""><img src="JSP/img/peijian6.png"></a>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian7.jpg"></a></div>
						<div class="miaoshu"><a href="">魅族16手机壳</a></div>
						<div class="jiage">99元</div>
						<div class="pingjia">955人评价</div>
						<div class="piao">
							<a href="">
								<span>买下它十分适合你！</span>
							</a>
						</div>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian8.jpg"></a></div>
						<div class="miaoshu"><a href="">手机挂件</a></div>
						<div class="jiage">19.9元</div>
						<div class="pingjia">372人评价</div>
					</div>
					<div class="remen fl">
						
						<div class="tu"><a href=""><img src="JSP/img/peijian9.jpg"></a></div>
						<div class="miaoshu"><a href="">华为mate20保护壳</a></div>
						<div class="jiage">99RMB</div>
						<div class="pingjia">1000+人评价</div>
					</div>
					<div class="remenlast fr">
						<div class="hongmi"><a href=""><img src="JSP/img/hongmin4.png" alt=""></a></div>
						<div class="liulangengduo"><a href=""><img src="JSP/img/liulangengduo.png" alt=""></a></div>					
					</div>
					<div class="clear"></div>
				</div>				
			</div>
		</div>

	</body>
</html>    	
	 
         





