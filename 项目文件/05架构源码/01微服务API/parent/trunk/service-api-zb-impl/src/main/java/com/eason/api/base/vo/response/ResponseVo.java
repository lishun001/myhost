package com.eason.api.base.vo.response;

import java.io.Serializable;

public class ResponseVo implements Serializable {
    private int status; //0
    private String massgae;
    private Object data;

    public ResponseVo() {

    }

    public ResponseVo(int status, String massgae) {
        this.status = status;
        this.massgae = massgae;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassgae() {
        return massgae;
    }

    public void setMassgae(String massgae) {
        this.massgae = massgae;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
