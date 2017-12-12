<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>奥绅科技开放平台 - API在线测试工具</title>
<link rel="shortcut icon" href="${base}/img/SBY_15-15.ico"/>

<script>
	function getCurrentTime(){
	
		var currentDate = new Date();
		var formatDate = currentDate.getFullYear();
		formatDate += '-' + ((currentDate.getMonth()+1)>9?(currentDate.getMonth()+1):'0' + (currentDate.getMonth()+1));
		formatDate += '-' + (currentDate.getDate()>9?currentDate.getDate():'0' + currentDate.getDate());
		formatDate += ' ' + (currentDate.getHours()>9?currentDate.getHours():'0' + currentDate.getHours());
		formatDate += ':' + (currentDate.getMinutes()>9?currentDate.getMinutes():'0' + currentDate.getMinutes());
		formatDate += ':' + (currentDate.getSeconds()>9?currentDate.getSeconds():'0' + currentDate.getSeconds());
		document.getElementById('timestamp').value=formatDate;
	}
	
</script>
</head>

<body onload="getCurrentTime();">

	<form method="post" action="testByPost.action" name="testform" enctype="multipart/form-data">

		<strong>测试环境：</strong>
    	<input style="width:500px" type='text' name="routerUrl" value="${routerUrl!"http://openapi.1mall.com:8090/app/api/rest/router"}" />
			
	<table style="width:1100px;" border=0>
	
	<tr>
	<td>
		<table style="width:600px" border=0>
			<tr><td colspan=2><strong>系统级参数：</strong></td></tr>
			<tr>
				<td>appKey:</td>
				<td><input type='text' name="appKey" value="${appKey!''}" style="width:300px"/>(可选)</td>
			</tr>
			<tr>
				<td>sessionKey:</td>
				<td><input type='text' name="sessionKey" value="${sessionKey!''}" style="width:300px" />(可选)</td>
			</tr>
			<tr>
				<td>调用的接口名称:</td>
				<td><input type='text' name="method" value="${method!''}" style="width:300px"/></td>
			</tr>
			<tr>
				<td>接口版本号:</td>
				<td><input type='text' name="ver" value="1.0" style="width:300px"/></td>
			</tr>
			<tr>
				<td>返回数据格式 xml/json:</td>
				<td><input type='text' name="format" value="${format!'xml'}" style="width:300px"/></td>
			</tr>
			<tr>
				<td>时间戳:</td>
				<td><input id="timestamp" type='text' value="${timestamp!''}" name="timestamp" style="width:300px"/>
					<input type='button'  value="当前时间" style="width:80px" onClick="getCurrentTime();"/>
				</td>
			</tr>
			<tr>
				<td>密钥:</td>
				<td><input type='text' name="secret" value="${secret!'1234567890'}" style="width:300px"/></td>
			</tr>
			<tr>
				<td>是否调用sdk测试:</td>
				<td>
					<select type="select" name="enableSdk" id="enableSdk" style="width:80px">
    					<option value="1">是</option>
    					<#if enableSdk?exists && enableSdk=="0" >
    						<option value="0" selected = "selected">否 </option>
    					<#else>
    						<option value="0">否</option>
    					</#if>
    				
   					</select> 
   				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
	<td>
	
		<strong>应用级参数：</strong><br/>
		<textarea rows=10 cols=50 name="appParams"><#if appParams?exists >${appParams}</#if></textarea>
		<br/><strong>请选择附件：</strong><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
		<input type='file' name="upload" size="50"/><br/>
	
	
	</td>
	</tr>
	<tr>
		<td align="center" colspan=2><input type="submit" value="提交" style="width:200px;height:50px"/></td>
	</tr>
	</table>
		<br/>
		
		返回结果：<br/>
		<textarea rows=20 cols=150 name="responseData"><#if responseData?exists >${responseData}</#if></textarea>
		
	</form>
</body>


</html>