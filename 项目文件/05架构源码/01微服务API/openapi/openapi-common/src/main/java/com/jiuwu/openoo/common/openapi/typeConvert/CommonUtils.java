package com.jiuwu.openoo.common.openapi.typeConvert;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonUtils {

	/**
	 * 判断是否是整形
	 * 
	 * @author Sam
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	/**
	 * FunName:convertNickNameToBytes Description:将字符串转换成二进制码的字符串
	 * 
	 * @param:nickName
	 * @return String
	 * @Author:fanchangfei
	 * @Create Date: 2014-7-30
	 */
	public static String convertNickNameToBytes(String nickName) {
		if (StringUtils.isNotBlank(nickName)) {
			byte[] bs = nickName.getBytes();
			return new sun.misc.BASE64Encoder().encodeBuffer(bs);
		}
		return null;

	}

	/**
	 * FunName:convertNickNameToString Description:将二进制码的字符串还原成真实的字符串
	 * 
	 * @param:nickName
	 * @return String
	 * @Author:fanchangfei
	 * @Create Date: 2014-7-30
	 */
	public static String convertNickNameToString(String nickName) {
		if (StringUtils.isNotBlank(nickName)) {
			byte[] bt;
			try {
				bt = new sun.misc.BASE64Decoder().decodeBuffer(nickName);
				nickName = new String(bt, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return nickName;
		}
		return null;
	}

	/**
	 * 
	 * FunName:formatDate Description:格式化生日
	 * 
	 * @param:
	 * @return
	 * @Author:fanchangfei
	 * @Create Date: 2014-7-30
	 */
	public static Date convertStringToSimpleDate(String birthStr) {
		if (StringUtils.isNotEmpty(birthStr)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(birthStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {

		// String str = "赶😱😏";
		// byte[] bs = str.getBytes();
		// try {
		// System.out.println(str);
		// str = new String(bs,"UTF-16");
		// System.out.println(str);
		// str = new String(bs, "UTF-8");
		// System.out.println(str);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		System.out.println(convertNickNameToString("5Li65YGl5bq36ICM5Yqq5Yqb"));

		// System.out.println(getToken());

	}

	/**
	 * @description 根据生日获取年龄
	 * @param birthDay
	 * @return int 年龄
	 * @author xiaoyong
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("生日不能大于当前时间！");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}

		return age;
	}

	/**
	 * @FuncName getToken
	 * @description 生成token
	 * @param len
	 *            长度
	 * @param md5
	 *            是否用md5加密
	 * @return int 年龄
	 * @author xiaoyong
	 * @throws Exception
	 */
	public static String getToken() throws Exception {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(UUID.randomUUID().toString().replaceAll("-", "")
					.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}

				buf.append(Integer.toHexString(i));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf.toString();

	}

	public static String changeStringToUTF8(String s) {

		String word = "";
		try {
			if (s != null) {
				word = new String(s.getBytes("iso8859-1"), "utf-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;

	}

	public static String getUUId() {
		String s = UUID.randomUUID().toString().toUpperCase();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}
}
