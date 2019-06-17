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
<script type="text/javascript" src="JSP/js/goods.js"></script>

</head>
<body>


<!-- start banner_x -->
		<div class="banner_x center">
			<!-- <a href="./index.html" target="_blank"><div class="logo fl"></div></a> -->
			
			<div class="wdgwc fl ml40">我的购物车</div>
		
			<div class="dlzc fr">
				<ul>
					<li><a href="JSP/LG.jsp" target="_blank" id="account">${sessionScope.account}</a></li>
					<li>|</li>
				
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" />全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>				
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<div class="content2 center" id="showbuycar">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl" id="showimg"><img src="JSP/img/gwc_xiaomi6.jpg" style="width:77px height:77px"></div>
					<div class="sub_content fl ft20" id="showname">小米6</div>
					<div class="sub_content fl " id="showprice">2499元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="1" step="1" min="1" >
					</div>
					<div class="sub_content fl"></div>
					<div class="sub_content fl"><a href="">×</a></div>
					<div class="clear"></div>
				</div>
			
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="JSP/liebiao.jsp">继续购物</a></li>
						<li>|</li>
						<li>已选择<span>1</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl" id="showprice1"></span></div>
					<div class="jsanniu fr"><input class="jsan" type="button" name="jiesuan"  value="结账" onclick="givemoney()" /></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
	

<script type="text/javascript">



function givemoney(){
	$.ajax({
	url:"checkout",
	type:"post",
	data:{
		oper:"paymoney"
	
	},
	dataType:"json",
	success:function(data){
		alert(data);
	}
	});
	
}
</script>







</body>
</html>