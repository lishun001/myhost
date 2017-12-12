package com.jiuwu.openoo.common.openapi.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DateUtils {
	public static final String YMD = "yyyyMMdd";
	public static final String YMD_SLASH = "yyyy/MM/dd";
	public static final String YMD_DASH = "yyyy-MM-dd";
	public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String YMD_SLASH_WITH_TIME = "yyyy/MM/dd HH:mm:ss";
	public static final String YMD_DASH_WITH_TIME2 = "yyyy-MM-dd HH:mm";
	public static final String YMD_SLASH_WITH_TIME2 = "yyyy/MM/dd HH:mm";
	public static final String YDM_SLASH = "yyyy/dd/MM";
	public static final String YDM_DASH = "yyyy-dd-MM";
	public static final String HM = "HHmm";
	public static final String HM_COLON = "HH:mm";
	public static final long DAY = 24 * 60 * 60 * 1000L;
	public static final long HOUR = 60 * 60 * 1000L;
	public static final long MIN = 60 * 1000L;

	private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

	private static final Log log = LogFactory.getLog(DateUtils.class);

	private DateUtils() {
	}

	public static DateFormat getFormat(String pattern) {
		DateFormat format = DFS.get(pattern);
		if (format == null) {
			format = new SimpleDateFormat(pattern);
			DFS.put(pattern, format);
		}
		return format;
	}

	public static Date parse(String source, String pattern) {
		if (source == null) {
			return null;
		}
		Date date;
		try {
			date = getFormat(pattern).parse(source);
		} catch (ParseException e) {
			if (log.isDebugEnabled()) {
				log.debug(source + " doesn't match " + pattern);
			}
			return null;
		}
		return date;
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return getFormat(pattern).format(date);
	}
	
	public static Timestamp IllegerNow(String pattern){
		String str = format(new Date(), pattern);
		return new Timestamp(parse(str, pattern).getTime());
	}
	/**
	 * @param year
	 *            年
	 * @param month
	 *            月(1-12)
	 * @param day
	 *            日(1-31)
	 * @return 输入的年、月、日是否是有效日期
	 */
	public static boolean isValid(int year, int month, int day) {
		if (month > 0 && month < 13 && day > 0 && day < 32) {
			// month of calendar is 0-based
			int mon = month - 1;
			Calendar calendar = new GregorianCalendar(year, mon, day);
			if (calendar.get(Calendar.YEAR) == year
					&& calendar.get(Calendar.MONTH) == mon
					&& calendar.get(Calendar.DAY_OF_MONTH) == day) {
				return true;
			}
		}
		return false;
	}

	private static Calendar convert(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 返回指定年数位移后的日期
	 */
	public static Date yearOffset(Date date, int offset) {
		return offsetDate(date, Calendar.YEAR, offset);
	}

	/**
	 * 返回指定月数位移后的日期
	 */
	public static Date monthOffset(Date date, int offset) {
		return offsetDate(date, Calendar.MONTH, offset);
	}

	/**
	 * 返回指定天数位移后的日期
	 */
	public static Date dayOffset(Date date, int offset) {
		return offsetDate(date, Calendar.DATE, offset);
	}

	/**
	 * 返回指定小时位移后的日期
	 */
	public static Date hourOffset(Date date, int offset) {
		return offsetDate(date, Calendar.HOUR, offset);
	}
	
	/**
	 * 返回指定分钟位移后的日期
	 */
	public static Date minOffset(Date date, int offset) {
		return offsetDate(date, Calendar.MINUTE, offset);
	}

	/**
	 * 返回指定日期相应位移后的日期
	 * 
	 * @param date
	 *            参考日期
	 * @param field
	 *            位移单位，见 {@link Calendar}
	 * @param offset
	 *            位移数量，正数表示之后的时间，负数表示之前的时间
	 * @return 位移后的日期
	 */
	public static Date offsetDate(Date date, int field, int offset) {
		Calendar calendar = convert(date);
		calendar.add(field, offset);
		return calendar.getTime();
	}

	/**
	 * 返回当月第一天的日期
	 */
	public static Date firstDay(Date date) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 返回当月最后一天的日期
	 */
	public static Date lastDay(Date date) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * 返回两个日期间的差异天数
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
	 */
	public static int dayDiff(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		return (int) (diff / DAY);
	}

	/**
	 * 返回两个日期间的差异小时
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
	 */
	public static int hourDiff(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		return (int) (diff / HOUR);
	}

	/**
	 * 返回两个日期间的差异分钟
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
	 */
	public static int minDiff(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		return (int) (diff / MIN);
	}

	/** 把整数秒数转换成时分秒格式显示 */
	public static String secToTime(int time) {
		String timeStr = null;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0)
			return "00:00:00";
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second);
			} else {
				hour = minute / 60;
				if (hour > 99)
					return "99:59:59";
				minute = minute % 60;
				second = time - hour * 3600 - minute * 60;
				timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":"
						+ unitFormat(second);
			}
		}
		return timeStr;
	}

	public static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}
	
	/**
	 * 返回两个日期间的差异天数
	 * 
	 * @param date1
	 *            参照日期
	 * @param date2
	 *            比较日期
	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
	 */
	public static boolean isSameDate(Date date1, Date date2) {
	       Calendar cal1 = Calendar.getInstance();
	       cal1.setTime(date1);
	       Calendar cal2 = Calendar.getInstance();
	       cal2.setTime(date2);
	       boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
	               .get(Calendar.YEAR);
	       boolean isSameMonth = isSameYear
	               && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
	       boolean isSameDate = isSameMonth
	               && cal1.get(Calendar.DAY_OF_MONTH) == cal2
	                       .get(Calendar.DAY_OF_MONTH);
	       return isSameDate;
	   }
	
	public static String expectTime(String timeStr){
		if(timeStr!=null&&timeStr.length()>0){
			Date time = DateUtils.parse(timeStr, DateUtils.YMD_DASH_WITH_TIME);
			String dd = " 23:59:59";
			if(time.getHours()<14){
				timeStr = DateUtils.format(time, DateUtils.YMD_SLASH)+dd;
			}else{
				Date newtt = DateUtils.dayOffset(time, 1);
				timeStr = DateUtils.format(newtt, DateUtils.YMD_SLASH)+dd;
			}
			return timeStr;
		}else{
			return "";
		}
	}
	
	
	
	public static void main(String[] args) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = DateUtils.dayOffset(new Date(), 7);
//		System.out.println(sdf.format(date));
//		System.out.println(format(date,YMD_DASH_WITH_TIME2 ));
		
//		boolean x = DateUtils.isSameDate( new Timestamp(116, 0, 13, 8, 0, 0, 0),new Date());
//		System.out.println(new Timestamp(116, 0,14, 15, 0, 0, 0));
//		System.out.println(x);
//		System.out.println(DateUtils.parse("2000-2-14", DateUtils.YMD_DASH));
//		System.out.println(DateUtils.format(DateUtils.parse("2000-2-14", DateUtils.YMD_DASH), DateUtils.YMD_DASH));
		String timeStr = "2016-01-18 14:54:16";
		
		System.out.println(formatDate(timeStr));
	
		
	}
	
	/**
	 * 新增，格式化时间字符串。精确到分钟
	 */
	public static String formatString(String time){
		if(time!=null&&time.length()>0){
			int index = time.lastIndexOf(":");
			String time1 = time.substring(0,index);
			String formatTime = time1.replace("-", "/");
			return formatTime;
		}else{
			return "";
		}
	}
	
	/**
	 * 新增，格式化时间字符串。精确到秒
	 */
	public static String formatSeconds(String time){
		if(time!=null&&time.length()>0){
			int index = time.indexOf(".");
			String time1 = time;
			if(index!=-1){
				time1 = time.substring(0,index);
			}
			String formatTime = time1.replace("-", "/");
			return formatTime;
		}else{
			return "";
		}
	}
	
	/**
	 * 新增，格式化时间字符串。精确到天
	 */
	public static String formatDate(String time){
		if(time!=null&&time.length()>0){
			String time1 = time.split(" ")[0];
			String formatTime = time1.replace("-", "/");
			return formatTime;
		}else{
			return "";
		}
	}
	
}