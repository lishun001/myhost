//接口级别
var authLevel = undefined;

$(document).ready(function(){
	
	//API类别及接口下拉框初始化
	methodTypeInit();
});

/**
 * 接口类别、接口名称下拉框初始化
 */
function methodTypeInit(){
	$.ajax({  
		url : 'queryMethodCategorys.action',  
		type : 'POST',  
		dataType : 'json',  
		success : function(data) {
			var pageCateId = $('#pageCateId').val();
			var methodType = $('#methodType').val();
			//循环判断类别名称是否存在，如果存在选中，否则用默认
			if(pageCateId !=null && pageCateId!=""){
			
				
				  $.each(data,function(index,rowData){
					  	
						var value = rowData.id;
						
						if(pageCateId == value){
							$('#methodType').val(value);
							return false;
						}
						
					});
				  var methodType = $('#methodType').val();
				  if(methodType==""){
					  data.unshift({'id':'','cateCnName':'--请选择API类别--','selected':'true'});
				  }
				  
				  
			}else{
				//在顶部添加"--请选择API类别--"
				data.unshift({'id':'','cateCnName':'--请选择API类别--','selected':'true'});
			}
				
			$("#methodType").combobox({
				data:data,
				valueField : 'id',
				textField : 'cateCnName',
				panelHeight:'150',
				editable:false,
				onChange:function(newValue) {
					
					  $.each(data,function(index,rowData){
						  	
							var value = rowData.id;
							
							if(value == newValue){
								$('#isCompatible').val(rowData.isCompatible);
								return false;
							}
							
						});
					
					//选择某个类目后初始化对应类目下接口下拉列表
					if(newValue != '') {
						$('#pageMethodId').val('');
						methodInit('queryMethods.action?methodType='+newValue);
					}
				}
			}); 
		},
		error : function() {  
			$.messager.alert('操作提示','加载接口类别失败!','error');
		}  
	});
	
	//第一次初始化api接口为空的选择下拉列表
	methodFirstInit();
}

/**
 * 第一次初始化api接口为空的选择下拉列表
 */
function methodFirstInit() {
	
	var pageCateId = $('#pageCateId').val();
	
	if(pageCateId != null && pageCateId !=""){
		methodInit('queryMethods.action?methodType='+pageCateId);
	}else{
		$("#method").combobox({
			valueField : 'method',
			textField : 'method',
			editable:false,
			panelHeight:'25',
			data:[{   
			    "method":'',   
			    "method":'--请选择API接口--',
			    selected:true
			}]
		});
		
	}
	

}
/**
 * 选择接口类目后初始化方法下拉列表
 */
function methodInit(remoteUrl){
	$.ajax({  
		url : remoteUrl,  
		type : 'POST',  
		dataType : 'json',
		success : function(data) {
			//下拉列表的高度
			var panelHeight = 'auto';
			//列表内容较多时设置最大高度,最多显示7个
			if(data.length >= 6) {
				panelHeight = '172';
			}
			
			//隐藏appKey和sessionKey
			//$('#tmpAppkey').val('');
			$('#appKey').hide();
			$('#tmpSessionKey').val('');
			$('#sessionKey').hide();
			
			var pageMethod = $('#pageMethodId').val();
			var pageCateId = $('#methodType').val();
			if(pageCateId!="" && pageMethod != null && pageMethod!=""){
				
				  $.each(data,function(index,rowData){
					  	
						var value = rowData.method;
						
						if(pageMethod == value){
							$('#method').val(value);
							
							onSelectRecord(rowData);
							appendSystemParam(rowData.id);
							return false;
						}
						
					});
				  var method = $('#method').val();
				  if(method==""){
						data.unshift({'method':'','method':'--请选择API接口--','selected':'true'});
				  }
				  
			}else{
				
				//在顶部添加"--请选择API接口--"
				data.unshift({'method':'','method':'--请选择API接口--','selected':'true'});
			}

			$("#method").combobox({
				data:data,
				valueField : 'method',
				textField : 'method',
				editable:false,
				panelHeight:panelHeight,
				onSelect: function(record) {
					onSelectRecord(record);
				},
				onChange:function(newValue, oldValue) {

					var data = $("#method").combobox('getData');
					for(var i = 0;i<data.length;i++) {
						if(newValue == '--请选择API接口--') {//没有选择接口就清空应用级参数
							$('#appParams').html('');
							break;
						}
						if(data[i].method == newValue) {
							appendSystemParam(data[i].id);
							break;
						}
					}

				}
			});
		},
		error : function() {  
			$.messager.alert('操作提示','加载API接口失败!','error');
		}  
	});
	
}


function onSelectRecord(record){
	authLevel = record.authLevel;
	//有选择某一个接口,且接口级别>0
	if(record.id != undefined && authLevel > 0) {
		//显示appKey
		$('#appKey').show();
		//级别为2或3则显示sessionKey
		if(record.authLevel > 1) {
			$('#sessionKey').show();
		} else {//级别为1
			$('#tmpSessionKey').val('');
			$('#sessionKey').hide();
		}
	} else {//没有选择接口或级别为0
		//$('#tmpAppkey').val('');
		$('#appKey').hide();
		$('#tmpSessionKey').val('');
		$('#sessionKey').hide();
	}
}

/**
 * 动态添加应用级参数输入框
 */
function appendSystemParam(tmpMethodId) {
	$.ajax({  
		url : 'queryMethodInParams.action?methodId='+tmpMethodId,
		type : 'POST',  
		dataType : 'json',  
		success : function(data) {
			//应用级参数名称数组
			var paramsNames = new Array();
			//应用级"参数类型"
			var paramsTypes = new Array();
			
			var appParams = '';
			//方法名称包括upload,即为上传图片接口
			if($("#method").combobox('getValue').indexOf('upload') != -1) {
				appParams += '<tr><td width="26%">图片:</td><td width="29%"> <input type="file" id="imageId" name="logoFile" size="20"/></td><td></td></tr>';
			}
			//动态添加参数名称、输入框、是否必须
			for(var i=0;i<data.length;i++) {
				
				//参数名称
				var paramName = data[i].paramName;
				paramsNames[i] = paramName;
				var paramType = data[i].paramType;
				if(paramType == 'Long' || paramType == 'Double' || paramType == 'Integer' || paramType == 'Boolean' || paramType == 'byte[]') {
					paramsTypes[i] = paramType;
				} else {
					paramsTypes[i] = "String";
				}
				
				appParams += '<tr><td width="26%">'+paramName+':</td>';
				if(paramType != 'byte[]'){
					appParams += '<td width="49%"><input class="width98 combo" name="'+paramName+'" maxlength="5000" /></td>';
				} else {
					appParams += '<td width="29%"> <input type="file" id="'+paramName+'" name="'+paramName+'" size="20"/></td>';
				}
				if(data[i].isNecessary == 1) {//必须
					appParams += '<td><em>*</em></td></tr>';
				} else {
					appParams += '<td></td></tr>';
				}
				
			}
			$('#appParams').html(appParams);
			$('#paramsNames').val(paramsNames);
			$('#paramsTypes').val(paramsTypes);
		},
		error : function() {  
			$.messager.alert('操作提示','加载应用级参数失败!','error');
		}  
	});
}

function toSubmit() {
	if(!checkMustEnter()){
		return;
	}
		toSubmitRequest.action="handleSubmitRequest.action";
		toSubmitRequest.submit();		
}

function checkMustEnter() {
	
	//没有选择API类别
	if($("#methodType").combobox('getValue') == '') {
		$.messager.alert('提示','请选择API类别!','error');
		return false;
	}
	
	//没有选择API接口
	if($("#method").combobox('getValue') == '--请选择API接口--') {
		$.messager.alert('提示','请选择API接口!','error');
		return false;
	}
	
	//接口级别大于0则校验appKey是否输入
	if(authLevel != undefined && authLevel > 0) {
		if($.trim($("#tmpAppkey").val()) == '') {
			$.messager.alert('提示','请输入appKey!','error');
			return false;
		}
	}
	
	//加密密钥没有输入
	if($.trim($("#appSecret").val()) == '') {
		$.messager.alert('提示','请输入appSecret!','error');
		return false;
	}
	
	return true;
}