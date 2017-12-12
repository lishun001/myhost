<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv=Cache-Control content=no-cache>
<link rel="stylesheet" type="text/css" href="ta/css/detail.css" />
<title>Ta帮官方活动</title>
<meta name="HandheldFriendly" content="true" />
<meta name="MobileOptimized" content="width" />
<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1,minimum-scale=1.0,maximum-scale=1.0"/>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${base}/css/app/alter/mdialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/js/app/alter/mdialog.js"></script>
<script type="text/javascript" src="${base}/js/app/alter/zepto.min.js"></script>

<script type= "text/javascript" >
	$(function(){
		var userId1 = $("#userId").val(); 
		if(userId1==null || userId1==''){
			$("#downImg").attr('style','display:block');
		}
		
		var u = navigator.userAgent, app = navigator.appVersion;
		var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
		if(isAndroid){
			$("#downImg").parent().attr("href","http://filmas.cn/hunter.apk");
		}
		
		$("#subBtn").click(function(){
			var mktId = $("#mktId").val();
			var userId = $("#userId").val(); 
			if(userId==null || userId==''){
			 	new TipBox({type:'tip',str:'请先登录！',clickDomCancel:true,setTime:10000500,hasBtn:true});  
			}else{
				$.post("mktApply.action",{
					"mktId":mktId,
					"userId":userId
				},function(data){
					//报名成功
					if(data.response.successCount){
						new TipBox({type:'success',str:data.response.result,hasBtn:true});
					}else{
						new TipBox({type:'error',str:data.response.result,hasBtn:true});  
					}
				},"json");
			}
		});
	});
	
</script>
</head>
<body>
<div style="height:10px ;border:1px;background-color: #f3f3f3">
</div>
<a  href="https://itunes.apple.com/cn/app/ta-bang/id1050846773"><img id='downImg'  src="ta/image/mkt/down.jpg" alt="" width="100%;" style="display:none;"></a>	
<div class="wrapper" id="wrapper">
	<h2 class="product-title"><li class="blackPoint">「${mktVo.mktName!""}」</li></h2>
	<div  class="product-time">活动时间：${mktVo.startDt!""} - ${mktVo.endDt!""}</div> 
	<a href="${mktVo.mktDesc!""}"><img   src="${mktVo.mktImage!""}" class="mkt-head"/></a>
</div>
<div  class="product-time">
		<!--  产品名称 -->
		<input type="hidden" id="mktId"  value='${mktId!""}'></input>
		<input type="hidden" id="userId" value='${userId!""}'></input>
</div>
<div>
	<table class="product-limit">
		<tr>
			<td  class="product-userNum">活动名额：<span style="color:red">${mktVo.userLimit!""}</span>人</td>
			<td  class="product-userNum">报名人数：<span style="color:red">${mktVo.userApplyNum!""}</span>人</td>
		</tr>
	</table>
</div>	
<div>
	<div style="height:10px ;border:1px;background-color: #f3f3f3">
</div>	
	<h2 class="product-target"><li class="blackPoint">「活动目标」</li></h2>
</div>
	<div class="product-info">
		<div style="color:#7c828b">${mktVo.mktTarget!""}</div>
	</div>
	<div class="sub-container" id="subBtn">
		<div class="btn-box">
			<a href="#" class="sub-btn" id="applyMktBtn"> <i class="icon-auction"></i>
				立即报名
			</a>
        </div>
	</div>

</body>
</html>

