package com.jiuwu.openoo.common.openapi.utils;

public class Location {  
	
	/**纬度 */
    private double latitude;  
    /**经度 */
    private double longitude;  
  
    
    public Location(double latitude, double longitude) {  
        this.latitude = latitude;  
        this.longitude = longitude;  
    }  
  
    public double getLatitude() {  
        return latitude;  
    }  
  
    public void setLatitude(double latitude) {  
        this.latitude = latitude;  
    }  
  
    public double getLongitude() {  
        return longitude;  
    }  
  
    public void setLongitude(double longitude) {  
        this.longitude = longitude;  
    }  
  
}  
