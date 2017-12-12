  //中奖信息滚动显示
  var ulObj = $('#winning').find('ul');
  var ulHei = ulObj.find('li').height()*100;
  var scrollTop = 0;
  ulObj.append(ulObj.html());
  setTimeout(function(){
    if(scrollTop >= ulHei){
      scrollTop = scrollTop - ulHei;
    }else{
      scrollTop++;
    }
    ulObj.scrollTop(scrollTop);
    setTimeout(arguments.callee,90);
  });