package com.eason.api.base.vo.response;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseVo implements Serializable {
    private int status; //0
    private String message;
    private Object data = new HashMap();

    public ResponseVo() {

    }

    public ResponseVo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
