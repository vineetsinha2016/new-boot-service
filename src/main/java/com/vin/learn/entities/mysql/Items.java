package com.vin.learn.entities.mysql;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="items")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "itemId")
public class Items implements Serializable {
    @Id
    @Column(name = "itm_ident")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer itemId;

    @Column(name = "itm_nme")
    private String itemName;

    @Column(name = "itm_dsc")
    private String itemDescription;

    @Column(name = "itm_uid")
    private String itemUid;

    @Column(name = "cmplt_flg")
    private String completionFlag;

    @Column(name = "rec_src_cde")
    private String sourceApplication;

    @Column(name = "add_by_user")
    private String addByUser;

    @Column(name = "rec_add_dttm")
    private Timestamp recordAddTime;

    @Column(name = "upd_by_user")
    private String updatedByUser;

    @Column(name = "rec_upd_dttm")
    private Timestamp recordUpdatedTime;

    //bi-directional many-to-one association to category
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ctg_ident")
    Category category;

    //bi-directional many-to-one association to frequency
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="frq_ident")
    Frequency frequency;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Users users;
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemUid() {
        return itemUid;
    }

    public void setItemUid(String itemUid) {
        this.itemUid = itemUid;
    }

    public String getCompletionFlag() {
        return completionFlag;
    }

    public void setCompletionFlag(String completionFlag) {
        this.completionFlag = completionFlag;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }

    public String getAddByUser() {
        return addByUser;
    }

    public void setAddByUser(String addByUser) {
        this.addByUser = addByUser;
    }

    public Timestamp getRecordAddTime() {
        return recordAddTime;
    }

    public void setRecordAddTime(Timestamp recordAddTime) {
        this.recordAddTime = recordAddTime;
    }

    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    public Timestamp getRecordUpdatedTime() {
        return recordUpdatedTime;
    }

    public void setRecordUpdatedTime(Timestamp recordUpdatedTime) {
        this.recordUpdatedTime = recordUpdatedTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemUid='" + itemUid + '\'' +
                ", completionFlag='" + completionFlag + '\'' +
                ", sourceApplication='" + sourceApplication + '\'' +
                ", addByUser='" + addByUser + '\'' +
                ", recordAddTime=" + recordAddTime +
                ", updatedByUser='" + updatedByUser + '\'' +
                ", recordUpdatedTime=" + recordUpdatedTime +
                ", category=" + category +
                ", frequency=" + frequency +
                ", user=" + users +
                '}';
    }
}
