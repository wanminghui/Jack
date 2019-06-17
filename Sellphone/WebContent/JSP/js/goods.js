/*function ShowGoodsByPage(ppage){
	$.ajax({
		url:"goods",
		type:"post",
		data:{//oper,区分开始查询或者其他的操作 
			oper:"showgoods",
			page:ppage,
			
		},
		dataType:"json",
		success:function(data){
			alert(data);
		}	
	});
	
}*/
/*ShowGoodsByPage(1);*/

function showcart(){
	$.ajax({
		url:"Cart",
		type:"post",
		data:{
			oper:"show"						
			},
		
		dataType:"json",
		success:function(data){
			//alert(data);
			 var content="";
			 var totalprice=0;
      
          for (var i=0;i<data.length;i++){
			 content+="<div class='content2 center' id='showbuycar'>"+
			"<div class='sub_content fl '>"+
				"<input type='checkbox' value='quanxuan' class='quanxuan' />"+
			"</div>"+
			"<div class='sub_content fl' id='showimg'><img src='"+data[i].picture+"' style='width:80px;height:80px'></div>"+
			"<div class='sub_content fl ft20' id='showname'>"+data[i].goodname+"</div>"+
			"<div class='sub_content fl ' id='showprice'>"+data[i].price+"</div>"+
			"<div class='sub_content fl'>"+
				"<input class='shuliang' type='number' value='1' step='1' min='1'>"+
			"</div>"+
			"<div class='sub_content fl'></div>"+
			"<div class='sub_content fl'><a href=''>×</a></div>"+
			"<div class='clear'></div>"+
		"</div>"
			totalprice+=data[i].price*data[i].number;
			}
//          content+=
//        "<div class='jiesuan fr'>"
//			+"<div class='jiesuanjiage fl' id='showprice1'></span></div>"
//			+"<div class='jsanniu fr'><input class='jsan' type='submit' name='jiesuan'  value='结账'/></div>"
//			+"<div class='clear'></div>"+
//		"</div>"
//         
         $("#showbuycar").html(content);
        $("#showprice1").html(totalprice);	
        
		}
	});
}
showcart();






