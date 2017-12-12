//公共js方法(经常用到的方法)

//点击查询按钮时获取id为panelId表单中的所有参数值
function getFormParams(panelId){
	var params = {};
	$("#"+panelId).find("input").each(function(){
		params[this.name] = this.value;
	});
	
	$("#"+panelId).find("select").each(function(){
		params[this.name] = this.value;
	});
	
	$("#"+panelId).find("textarea").each(function(){
		params[this.name] = this.value;
	});	
	return params;
}

//如果显示结果为空，则在panelId处显示没有找到的提示信息
function showErrorBaseInfo(panelId,data){
	if(data.rows==null || data.rows.length==0){
		var errorInfoHtml = "<table width='100%' border=0>";
		errorInfoHtml+="<tr><td><span class='red14'>&nbsp;&nbsp;&nbsp;&nbsp;没有找到符合条件的记录信息！ </span></td></tr>";
		errorInfoHtml+="</table>";
		$("#"+panelId).html(errorInfoHtml);
	}
}

//获取当前视口的中间y坐标高度   pxx偏移量为窗口宽度一半
function getViewCenterYPosition(pxx) {
	var sTop = 0;
	var ppx = 160;
	// 页面在iframe内面打开
	if (typeof (pxx) != "undefined" && !isNaN(pxx)) {
		ppx = pxx;
	}
	if (window.self != window.top) {
		var top = ($(window).height() - ppx - 100) / 2;
		var scrollTop = window.document.documentElement.scrollTop;
		sTop = scrollTop + top;
	} else {// 页面在iframe外面打开
		var top = ($(window).height() - ppx) / 2;
		var mainScrollTop = $(document).scrollTop();
		sTop = mainScrollTop + top;
	}
	// 设置遮罩的高度 高于easyui表格350px
	if ($('.datagrid-view').css('height')) {
		var tableHeight = parseFloat($('.datagrid-view').css('height').split(
				'px')[0]);
		$('.window-mask').css('height', tableHeight + 350);
	}
	return parseInt(sTop);
}