/**
 * name
 * @param {type} param 
 */
 function changeOption() {
 	var methodId = document.getElementById("apiMethod").value;
 	var postUrl = document.getElementById("postUrl").value;
	$.ajax({
	   type: "POST",
	   dataType:'text',
	   url: "http://"+postUrl+":8080/forward/apitool/queryMethodInfoById.action",
	   data: "methodId="+methodId,
	   success: function(msg){
	   	$("#responseData").val("");
	   	$("#paramId").val(msg);
	   	var result=msg.split(",");
	   	var appParams;
	   	for(var i=0;i<result.length-1;i++){
	   		if(result[i].length > 4 && result[i].substring(result[i].length - "File".length) == "File" ){
				appParams = appParams + "<tr><td>"+result[i]+"</td><td><input type='file' name='upload' size='50'/></td></tr>";
	   		} else {
				appParams = appParams + "<tr><td>"+result[i]+"</td><td><input type='text'/></td></tr>";
	   		}
		}
	   	$('#appParams').html(appParams);
	   }
	});
 }

 /**
 * name
 * @param {type} param 
 */
 function toSubmit(){
 	var methodId = document.getElementById("apiMethod").value;
 	var methodName=$("#apiMethod").find("option:selected").text(); 
 	var postUrl = document.getElementById("postUrl").value;
	if(methodName == "jiuwu.user.login" || methodName == "jiuwu.user.register" || methodName == "jiuwu.user.setpw.update" || methodName == "jiuwu.user.updatepw.update"){
		postUrl = "https://" + postUrl + ":443";
		alert("SSL访问违反了同源策略，无法访问");
		return ;
	} else {
		postUrl = "http://" + postUrl + ":8080";
	}
	var paramIds = document.getElementById("paramId").value;
   	var result=paramIds.split(",");
   	var param = "method:" + methodName + "," + "ver:1.0," + "sign:0,ignoreSign:1,";
   	for(var i=0;i<result.length-1;i++){
	  param = param + ":" + document.getElementById(result[i]) + ",";
	}
	alert(param);
	$.ajax({
	   type: "POST",
	   dataType:'text',
	   url: postUrl+"/forward/api/rest/router",
	   data: param,
	   success: function(msg){
	   	$("#responseData").val(msg);
	   }
	});
 }
 
 
 function toSubmit2() {
	if(!checkMustEnter()){
		return;
	}
		toSubmitRequest.action="handleSubmitRequest.action";
		toSubmitRequest.submit();		
 }