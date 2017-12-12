<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
    <link href="${base}/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${base}/css/ftlcommon.css" rel="stylesheet" type="text/css" />
    <link href="${base}/css/easyui/icon.css" rel="stylesheet" type="text/css" >
    <link href="${base}/css/easyui/easyui.css" rel="stylesheet" type="text/css" >
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

		<strong>提交参数:</strong><br/>
		<textarea class="width98 bordercolor" rows="5" cols="55" id="postParams" name="postParams" readonly="true"><#if postParams?exists >${postParams}</#if></textarea><br/><br/>
		<strong>返回结果:</strong><br/>
		<textarea class="width98 bordercolor" rows="10" cols="55" id="appResult" name="appResult" readonly="true"><#if appResult?exists >${appResult}</#if></textarea><br/><br/>
	
</body>
</html>

