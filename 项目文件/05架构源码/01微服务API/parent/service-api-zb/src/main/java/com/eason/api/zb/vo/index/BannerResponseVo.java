package com.eason.api.zb.vo.index;

import java.io.Serializable;

public class BannerResponseVo implements Serializable {
    private Integer id;
    private String title;
    private String thumb_img_url;
    private String type;
    private String url;

    public BannerResponseVo() {
    }

    public BannerResponseVo(Integer id, String title, String thumb_img_url, String type, String url) {
        this.id = id;
        this.title = title;
        this.thumb_img_url = thumb_img_url;
        this.type = type;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_img_url() {
        return thumb_img_url;
    }

    public void setThumb_img_url(String thumb_img_url) {
        this.thumb_img_url = thumb_img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
