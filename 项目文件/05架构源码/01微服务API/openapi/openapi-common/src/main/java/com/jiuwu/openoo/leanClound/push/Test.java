package com.jiuwu.openoo.leanClound.push;

public class Test{
	
//	public static void main(String[] args){   
//        //这个类主要是设置邮件   
//     MailSenderInfo mailInfo = new MailSenderInfo();    
//     mailInfo.setMailServerHost("smtp.163.com");    
//     mailInfo.setMailServerPort("25");    
//     mailInfo.setValidate(true);    
//     mailInfo.setUserName("xiao86y@163.com");    
//     mailInfo.setPassword("xiao8624");//您的邮箱密码    
//     mailInfo.setFromAddress("xiao86y@163.com");    
//     mailInfo.setToAddress(new String[]{"xiaoyong@gangbeng.com"}); 
//     mailInfo.setSubject("设置邮箱标题 如http://www.guihua.org ");    
//     mailInfo.setContent("设置邮箱内容 如http://www.guihua.org 中国桂花网 是中国最大桂花网站==");    
//        //这个类主要来发送邮件   
//     // sms = new SimpleMailSender();   
//    
//      SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式   
//         //System.out.println(222);
//   }  
	public static void main(String[] args) {
		String str = "11";
		String[] strs = str.split(",");
		for(String s:strs){
			System.out.println(s);
		}
	}
}