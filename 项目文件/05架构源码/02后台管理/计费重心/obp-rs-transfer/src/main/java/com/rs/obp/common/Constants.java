/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.common;


/**
 *
 * @author wangxinming
 */
public class Constants {

    
    /*心跳超时时间*/
    public final static int HEARTBEAT_VALUE = 300;
    /*
     * Para Type
     */
    public final static byte TYPE_BYTE = 0;
    public final static byte TYPE_WORD = 1;
    public final static byte TYPE_INT = 2;
    public final static byte TYPE_FLOAT = 3;
    public final static byte TYPE_STRING = 4;
    public final static byte TYPE_WIDESTR = 5;
    public final static byte TYPE_OBJECT = 6;
    public final static byte TYPE_DOUBLE = 7;
    public final static byte TYPE_BINARY = 8;
    /*
     * Para Length
     */
    public final static int TYPE_BYTE_LENGTH = 1;
    public final static int TYPE_WORD_LENGTH = 2;
    public final static int TYPE_INT_LENGTH = 4;
    public final static int TYPE_FLOAT_LENGTH = 4;
    public final static int TYPE_DOUBLE_LENGTH = 8;
    public final static int TYPE_BINARY_LENGTH = 8;
    /* 字符串结束符*/
    public final static byte[] TYPE_STRING_END = new byte[]{0};
    public final static byte[] TYPE_WIDESTR_END = new byte[]{0, 0};
}
