<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
  <meta content="yes" name="apple-mobile-web-app-capable">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta content="telephone=no" name="format-detection">
  <title>Ta帮天使大赛</title>
  <link rel="stylesheet" type="text/css" href="ta/css/common.css">
  <link rel="stylesheet" type="text/css" href="ta/css/cj.css">
  
  <link href="${base}/css/app/alter/mdialog.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="${base}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/js/app/alter/mdialog.js"></script>
<script type="text/javascript" src="${base}/js/app/alter/zepto.min.js"></script>
  <script type="text/javascript" src="${base}/js/tools.js"></script>
</head>
<body>
		<!--  产品名称 -->
		<input type="hidden" id="mktId"  value='${mktId!""}'></input>
		<input type="hidden" id="userId" value='${userId!""}'></input>
		
   <!-- <a   type="hidden" class="down" href="https://itunes.apple.com/cn/app/ta-bang/id1050846773"><img src="ta/image/mkt/down.jpg" alt="" width="100%;"></a>-->
    
  <div id="zpbg">
    <img src="ta/image/mkt/main-bg.png" class="img-responsive">
    <div class="coin1"><img src="ta/image/mkt/coin1.png" class="img-responsive"></div>
    <div class="coin2"><img src="ta/image/mkt/coin2.png" class="img-responsive"></div>
  </div>
  <div id="desc">
    <a href="javascript:void(0)" onclick="torecord();" >敬请期待</a>
    <p>允许参赛人数为 <span id="bdsum">${mktVo.userLimit!""}</span> 人,报名人数 <span id="cjnum">${mktVo.userApplyNum!""}</span> 人</p>
    <p>（参与报名的Ta友会有神秘礼品(⊙o⊙)哦）</p>
  </div>
  <div id="winning">
    <div class="bx"></div>
    <div class="hjlist">
      <ul>
    	 <#list applyUsers as user>
	 		   <li>恭喜 <span>${user.nickName}</span> 报名成功！</li>
		 </#list>
      </ul>
    </div>
  </div>
  <div id="rule">
    <div id="rule-header"></div>
    <ul>
      <li><span>1.活动日期：</span><br>${mktVo.startDt!""} — ${mktVo.endDt!""}<li>
	  <li><span>2.活动奖励：</span><br>根据活动规则评选出的每个赛区的获奖用户，并以现金的形式进行奖励。每个赛区产生猎人天使奖1名，一等奖1名，二等奖1名，三等奖7名；赏金天使奖1名，一等奖1名，二等奖1名，三等奖7名。<li>
	  <li><span>3.活动说明：</span><br>《Ta帮》天使大赛是由奥绅文化传媒有限公司主办的线下有奖竞赛活动，旨在丰富大学生的课余生活。比赛活动以高校为单位，分赛区进行，按照活动规则评选出每个赛区的“《Ta帮》天使”，并给与现金奖励。<li>
	  <li><span>4.活动内容：</span><br>下载并使用《Ta帮》APP。用户作为赏金角色发布任务，并且指定猎人角色完成任务，完成后视为1个有效的赏金任务。用户作为猎人角色，揭榜并且执行赏金角色的任务，完成后经赏金角色查收任务视为1个有效猎人的任务。在截止时间之前，完成有效任务最多的猎人用户与赏金用户都将获得现金奖励。<li>
	  <li><span>5.活动规则：</span><br>每个《Ta帮》会员都拥有唯一的用户ID，当用户作为赏金角色发布任务，并且指定猎人角色完成任务之后，系统会记录任务中双方用户的ID，并且同时为赏金用户和猎人用户积累1个有效任务。重复完成同一赏金ID的任务时，仅视为1个有效的猎人任务；重复指定同一猎人ID完成的任务，仅视为1个有效的赏金任务。<li>
    </ul>
  </div>

  <script type="text/javascript">
  		$(function(){
  			if($("#userId").val()==""){
  			
  				$(".down").show();
  			}
  		});
  	
        var browser = {
            versions: function () {
                var u = navigator.userAgent, app = navigator.appVersion;
                return {         //移动终端浏览器版本信息
                    trident: u.indexOf('Trident') > -1, //IE内核
                    presto: u.indexOf('Presto') > -1, //opera内核
                    webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                    mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
                    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                    android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
                    iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
                    iPad: u.indexOf('iPad') > -1, //是否iPad
                    webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
                };
            }(),
            language: (navigator.browserLanguage || navigator.language).toLowerCase()
        }

		
		
        function torecord() {
           	var mktId = $("#mktId").val();
			var userId = $("#userId").val(); 
			
			if(userId==null || userId==''){
			 	new TipBox({type:'tip',str:'请先登录！',clickDomCancel:true,setTime:10000500,hasBtn:true});
			}else{
				new TipBox({type:'tip',str:'敬请期待！',clickDomCancel:true,setTime:10000500,hasBtn:true});
			}
        }
    </script>

</body>
</html>