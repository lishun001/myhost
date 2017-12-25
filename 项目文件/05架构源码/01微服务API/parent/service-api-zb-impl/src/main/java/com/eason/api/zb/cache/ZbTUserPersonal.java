package com.eason.api.zb.cache;

import com.eason.api.zb.model.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Document(collection = "zb_t_user_personal")
@CompoundIndexes({
        @CompoundIndex(name = "zb_user_id_index", def = "{'zbId': 1, 'userId': -1}")
})
public class ZbTUserPersonal implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @Id
    private int id;

    private Integer zbId;

    private Integer userId;

    private Date startTime;

    private Integer activityTime;

    private Date inviteTime;    //邀请时间

    private Date bookTime;

    public ZbTUserPersonal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public Integer getActivityTime() {
        return this.activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
}