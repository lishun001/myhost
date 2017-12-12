package com.eason.api.zb.vo.gift;

import java.io.Serializable;

public class SendBombScreenRequestVo  implements Serializable {

    private String msgText;         //飞屏内容

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Override
    public String toString() {
        return "SendBombScreenRequestVo{" +
                "msgText='" + msgText + '\'' +
                '}';
    }
}
