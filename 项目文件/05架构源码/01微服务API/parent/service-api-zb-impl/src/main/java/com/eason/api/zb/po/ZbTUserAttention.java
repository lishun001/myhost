package com.eason.api.zb.po;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_user_attention database table.
 */
@Entity
@Table(name = "qvod_zb_t_user_attention")
@NamedQuery(name = "ZbTUserAttention.findAll", query = "SELECT z FROM ZbTUserAttention z")
public class ZbTUserAttention implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attention_time")
    private Timestamp attentionTime;

    private Integer channel;

    @Column(name = "a_id")
    private Integer aId;


    @Column(name = "f_id")
    private Integer fId;

    public ZbTUserAttention() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getAttentionTime() {
        return this.attentionTime;
    }

    public void setAttentionTime(Timestamp attentionTime) {
        this.attentionTime = attentionTime;
    }

    public Integer getChannel() {
        return this.channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }
}