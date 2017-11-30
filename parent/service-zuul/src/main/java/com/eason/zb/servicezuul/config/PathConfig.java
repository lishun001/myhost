package com.eason.zb.servicezuul.config;

import java.util.ArrayList;
import java.util.List;

public class PathConfig {
    public static final List<String> pathList=new ArrayList<String>(){
        {
                add("/getIndexList");
        }
    };

    public static void main(String[] args){
        System.out.println("");
    }
}
