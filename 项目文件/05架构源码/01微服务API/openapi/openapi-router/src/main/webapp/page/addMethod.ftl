<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>奥绅科技开放平台 - 注册接口方法</title>
    <link rel="stylesheet" href="${base}/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="${base}/css/bootstrap-theme.min.css"> 
    <script type="text/javascript" src="${base}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>    
    <script type="text/javascript">
       function checkForm(){
          if($("#interfaceName").val()==''){
                 alert("接口名称不能为空");
                 return false;
          }
          if($("#serviceName").val()==''){
                 alert("service类名不能为空");
                 return false;
          }
          if($("#methodName").val()==''){
                 alert("方法名不能为空");
                 return false;
          }
          if($("#methodRemark").val()==''){
                 alert("方法备注不能为空");
                 return false;
          }
          if($("#methodType").val()==''){
                 alert("接口类型不能为空");
                 return false;
          }
          return true;
       }
    </script>
    <style> 
            .bs-docs-home 
            { 
            background-color: #F1E1C6; 
           
            } 
    </style> 
</head> 

<body class="bs-docs-home"> 
    <div class="container theme-showcase"> 
        <h1 style=" line-height:2em;"> </h1><br /> 
       
        <div class="row"> 
            <div class="col-sm-3"></div> 
        <div class="col-sm-6"> 
            <div class="panel panel-primary"> 
                <div class="panel-heading"> 
                    <h3 class="panel-title"><strong>注册api接口方法</strong></h3> 
                </div> 
                <div class="panel-body"> 
                <#if msg?? && msg!=''>
                   <div class="alert alert-danger alert-dismissable"> 
                       <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                       <strong>注意!</strong>${msg!""}</div> </#if>
                       <form role="form" name="form1" action="registerMethod.action" method="method" onsubmit="return checkForm()"> 
                           <div class="form-group"> 
                               <label for="IDCard"><small>请输入接口名称，如：jiuwu.linggong.address.delete</small></label> 
                               <input type="text" class="form-control" id="interfaceName" name="interfaceName" placeholder="" >  
                               
                           </div> 
                           <div class="form-group"> 
                               <label for="Subject"><small>请输入service类名,如：UserInfoServiceImpl</small></label> 
                               <input type="text" class="form-control" id="serviceName" name="serviceName" placeholder="">  
                           </div> 
                           <div class="form-group"> 
                               <label for="Subject"><small>请输入方法名,如：getUserInfo</small></label> 
                               <input type="text" class="form-control" id="methodName" name="methodName" placeholder="">  
                           </div>
                           <div class="form-group"> 
                               <label for="Subject"><small>请输入方法备注,如：获取用户详细信息</small></label> 
                               <input type="text" class="form-control" id="methodRemark" name="methodRemark" placeholder="">  
                           </div>
                           <label for="Subject"><small>请输入接口级别: 默认为2</small></label> 
                           <select class="form-control" name="methodLevel">
								  <option>1</option>
								  <option selected="selected">2</option>
                           </select>
                            <div class="form-group"> 
                               <label for="Subject"><small>请输入接口类型,输入数字（是零工圈订单的类型还是大博好友或是其他）</small></label> 
                               <input type="text" class="form-control" id="methodType" name="methodType" placeholder="">  
                           </div>
                           <button type="subbimt" class="btn btn-success btn-primary">注册Api接口</button>
                       </form> 
            
                      
                   </div> 
               </div> 
           </div> 
      
           <div class="col-sm-3"></div> 
        </div> 
    </div>  
  
</head>
<body>
	
</body>
</html>