/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wangxinming
 */
public class MdCardCache {

    private static Map<String, String> useIngCards = new ConcurrentHashMap<String, String>();

    public static void putCards(String key, String value) {
        useIngCards.put(key, value);
    }

    public static String getUseingCard(String key) {
        return useIngCards.get(key);
    }

    public static void delCards(String key) {
        useIngCards.remove(key);
    }
}
