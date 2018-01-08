package com.eason.api.zb.model;

import java.util.HashMap;
import java.util.Map;

public final class TreeSeeConfig {
    public static final Map<String,Integer> time=new HashMap<String,Integer>(){
        {
            put("VIP1",3*60);
            put("VIP2",8*60);
            put("VIP3",15*60);
            put("VIP4",25*60);
            put("VIP5",40*60);
            put("VIP6",60*60);
        }
    };

    public static Integer getTreeTime(short level){
        if (level<=0){
            return 0;
        }
        if (level>=6){
            level=6;
        }
        return time.get("VIP"+level);
    }
}
