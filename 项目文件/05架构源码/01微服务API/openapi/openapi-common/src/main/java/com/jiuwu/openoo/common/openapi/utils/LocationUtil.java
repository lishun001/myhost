package com.jiuwu.openoo.common.openapi.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.xml.resolver.apps.resolver;

public class LocationUtil {

	 /** 地球半径 */  
    private static final double EARTH_RADIUS = 6371000;  
    /** 范围距离 */  
    private double distance;  
    /** 左上角 */  
    public Location left_top = null;  
    /** 右上角 */  
    public Location right_top = null;  
    /** 左下角 */  
    public Location left_bottom = null;  
    /** 右下角 */  
    public Location right_bottom = null;  
    
    private static double EARTH_RADIUS2 = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
    public  LocationUtil(double distance) {  
        this.distance = distance;  
    }  
    
	public void getRectangle4Point(double lat, double lng) {  
		  
        double dlng = 2 * Math.asin(Math.sin(distance / (2 * EARTH_RADIUS))  
                / Math.cos(lat));  
        dlng = Math.toDegrees(dlng);  // # 弧度转换成角度  
  
       
        double dlat = distance / EARTH_RADIUS;  
        dlat = Math.toDegrees(dlat); // # 弧度转换成角度  
  
        //已用户传过来的经纬度为中心，取得这个正方形的4个角的坐标       
        left_top = new Location(lat + dlat, lng - dlng);  
        right_top = new Location(lat + dlat, lng + dlng);  
        left_bottom = new Location(lat - dlat, lng - dlng);  
        right_bottom = new Location(lat - dlat, lng + dlng);  
        
    }  
	
	public Location[] getCoordinate4(double lng,double lat,double distance){
		
		LocationUtil llu = new LocationUtil(distance);  
	        llu.getRectangle4Point(lat, lng);  
	        Location[] locations = new Location[4];  
	        locations[0] = llu.left_top;  
	        locations[1] = llu.right_top;  
	        locations[2] = llu.left_bottom;  
	        locations[3] = llu.right_bottom;
	        
			return locations; 
	}
	public static void main(String[] args) {
		
		LocationUtil util = new LocationUtil(500);
		util.getRectangle4Point(30.493335, 114.429582);
	}
	
	/**
	 * FunName:GetDistance Description: 传入2者的经纬度，计算2者的距离
	 * 
	 * @param 4个double数据
	 * @return double
	 * @Author:fengchao
	 * @Create Date: 2014-8-26
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		//计算双方距离的算法
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS2;
		s = Math.round(s * 1000);
		return s;
	}
	/**
	 * FunName:changeUnit
	 * Description: 传入2者的经纬度，计算2者的距离
	 * @param 距离米
	 * @return String
	 * @Author:fengchao
	 * @Create Date: 2015-04.24
	 */
	public static String changeUnits(Double dis){
		
		String s = null;
		if(dis!=null && dis.intValue()>1){
			if(dis.intValue()>100){
				s = String.format("%.1f", dis/1000.0);
			}else{
				s = String.format("%.2f", dis/1000.0);
			}
		    
		    if(Double.parseDouble(s)>1){
		    	if(Double.parseDouble(s)>10){
		    	s = s.substring(0,s.indexOf("."));
		    	}else{
		    	  if(s.contains(".")){
		    		  if(s.substring(s.indexOf(".")+1,s.length()).equals("0")){
		    			  s = s.substring(0,s.indexOf("."));
		    		  }
		    	  }
		    	}
		     }
		}
		
		return s!=null?s+"km":null;
		
		
	}
	public static String ConvertUnit(int distance){
		
		String s = "";
		int len = String.valueOf(distance).length();
		String st = String.valueOf(distance)+"m";
		if(len>3){
			s = String.format("%.1f", distance/1000.0);
			if(s.substring(s.indexOf(".")+1,s.length()).equals("0")){
				  st = s.substring(0,s.indexOf("."))+"km";
			}else{
				st = s+"km";
			}
		}else if((distance <= 50) && distance != 0){ 
			st = "50m以内";
		}else if(distance == 0){
			st = "0m";
		}  
		return st;
		
	}
	
	public static String ConvertDISTime(Date updateTime){
		long min1=new Date().getTime();
		long min2=updateTime.getTime();
		long d=(min1-min2)/(1000*60);
		if (d>=0&&d<60) {
			return (int)d+"分钟前";
		}else if (d>=60&&d<1440) {
			return (int)d/60+"小时前";
		}else if (d>=1440&&d<43200) {
			return (int)d/1440+"天前";
		}else if (d>=43200&&d<518400) {
			return (int)d/43200+"个月前";
		}else if (d>=518400) {
			return (int)d/518400+"年前";
		}else {
			return "";
		}
	}
}
