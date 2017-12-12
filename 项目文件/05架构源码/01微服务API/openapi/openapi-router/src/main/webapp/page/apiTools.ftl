<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>卓尔冷链开放平台 - API在线测试工具</title>
    <link rel="shortcut icon" href="${base}/img/SBY_15-15.ico"/>
    <link href="${base}/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${base}/css/ftlcommon.css" rel="stylesheet" type="text/css" />
    <link href="${base}/css/easyui/icon.css" rel="stylesheet" type="text/css" >
    <link href="${base}/css/easyui/easyui.css" rel="stylesheet" type="text/css" >
    <script type="text/javascript" src="${base}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${base}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${base}/js/common.js"></script>
    <script type="text/javascript" src="${base}/js/apiTools.js"></script>
    <script> var basePath = '${base}'; </script>
    
    
    <style type="text/css">
    	.width98{
    		width:98%;
    	}
    	.comboboxWidth{
    		width:16%;
    	}
    	.combo{
    		height: 20px;
			line-height: 20px;
    	}
    	.bordercolor{
    		background-color: #FFFFFF;
    		border-color: #95B8E7;
    	}
	</style>
	
</head>
<body>
	<iframe height="100px" width="100%" frameborder="0" scrolling="no" ></iframe><br/>
	
	<div class="easyui-layout">
		<table style="width:990px;" border=0 align="center">
			<tr>
				<td valign="top" width="50%" class="left">
				<form id='toSubmitRequest' method='post' enctype="multipart/form-data"  target="formSumit">
					<table cellspacing="4" width="100%">
						<tr>
							<td width="26%">请求地址</td>
							<td><input class="width98 combo" id="postUrl" name="postUrl" value = "http://127.0.0.1:8082/forward/api/rest/router" maxlength="5000" /></td>
							<td width="25%"><em>*</em></td>
							<input type="hidden" id="pageCateId" name="pageCateId" value = "${(pageCateId)!''}" />
							<input type="hidden" id="isCompatible" name="isCompatible" value = "${(isCompatible)!''}" />
						</tr>
						<tr>
							<td width="26%">API类别</td>
							<td width="49%"><input class="comboboxWidth" id="methodType" name="methodType" value = "${(methodType)!''}"/></td>
							<td width="25%"><em>*</em></td>
							<input type="hidden" id="pageCateId" name="pageCateId" value = "${(pageCateId)!''}" />
							<input type="hidden" id="isCompatible" name="isCompatible" value = "${(isCompatible)!''}" />
						</tr>
						<tr>
							<td>API接口:</td>
							<td><input class="comboboxWidth" id="method" name="systemParam.method" value = "${(systemParam.method)!''}" /></td>
							<td><em>*</em><input type="hidden" id="methodId" name="methodId" value = "${(methodId)!''}" /></td>
							<input type="hidden" id="pageMethodId" name="pageMethod"  value = "${(pageMethod)!''}"/>
							<#--<#if apiMethodInfoList?exists && apiMethodInfoList?size gt 0>
								<td><select name="systemParam.method" onchange="changeOption()">
									<option value="0">-------</option>
									<#list apiMethodInfoList as item>
							        	<option value="${(item.method)!''}">${(item.method)!''}</option>
							      	</#list>
						      	</select></td>
							</#if>-->
						</tr>
						<tr>
							<td>版本号:</td>
							<td>
								<input type="radio" checked="yes" value="1.0.0" name="systemParam.ver">1.0.0
							</td>
							<td></td>
						</tr>
						<tr>
							<td>返回格式:</td>
							<td>
								<input type="radio" checked="yes" value="xml" name="systemParam.format">xml　
								<input type="radio" value="json" name="systemParam.format">json
							</td>
							<td></td>
						</tr>
						<tr>
							<td>数据环境:</td>
							<td>正式环境</td>
							<td></td>
						</tr>
						<tr id="appKey">
							<td>appKey:</td>
							<td><input class="width98 combo" id="tmpAppkey" name="systemParam.appKey" value = "${(systemParam.appKey)!'appKey00001'}" maxlength="5000" /></td>
							<td><em>*</em></td>
						</tr>
						<tr id="sessionKey" style="display:none">
							<td>sessionKey:</td>
							<td><input class="width98 combo" id="tmpSessionKey" name="systemParam.sessionKey" value = "${(systemParam.sessionKey)!''}" maxlength="5000" /></td>
							<td></td>
						</tr>
						<tr>
							<td>appSecret:</td>
							<td><input class="width98 combo" id="appSecret" name="systemParam.appSecret" value = "${(systemParam.appSecret)!'asdfghjkqwertyu'}" maxlength="5000" /></td>
							<td><em>*</em></td>
						</tr>
						<tr>
							<td colspan="3"><strong>接口应用级参数</strong></td>
						</tr>
					</table>
					<table cellspacing="4" width="100%" id="appParams"/>
					<table cellspacing="4" width="100%">
						<tr>
							<td></td>
							<td align="center"><a href="javascript:toSubmit()" class="easyui-linkbutton" id="btnToSubmit">提交测试</a></td>
							<td></td>
						</tr>
					</table>
					<input type="hidden" id="paramsNames" name="paramsNames" value = "${(paramsNames)!''}" />
					<input type="hidden" id="paramsTypes" name="paramsTypes" value = "${(paramsTypes)!''}" />
				</form>	
				</td>
				<td valign="top" class="right">
				<iframe  name="formSumit"  width="500px" height="560px" frameborder="no" src="apiToolsResult.action" scrolling="no" >
				</iframe>
				
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>