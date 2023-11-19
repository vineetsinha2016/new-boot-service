package com.vin.learn.entities.mysql;

//import javax.persistence.*;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="frequency")
public class Frequency {
    @Id
    @Column(name = "frq_ident")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer frequencyId;

    @Column(name = "frq_nme")
    private String frequencyName;

    @Column(name = "frq_dsc")
    private String frequencyDescription;

    @Column(name = "frq_cde")
    private String frequencyCode;

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

    //bi-directional many-to-one association to Items
    @OneToMany(mappedBy = "frequency", cascade = CascadeType.ALL)
    private List<Items> items = new ArrayList<>();

    public Integer getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }

    public String getFrequencyDescription() {
        return frequencyDescription;
    }

    public void setFrequencyDescription(String frequencyDescription) {
        this.frequencyDescription = frequencyDescription;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
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

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "frequencyId=" + frequencyId +
                ", frequencyName='" + frequencyName + '\'' +
                ", frequencyDescription='" + frequencyDescription + '\'' +
                ", frequencyCode='" + frequencyCode + '\'' +
                ", sourceApplication='" + sourceApplication + '\'' +
                ", addByUser='" + addByUser + '\'' +
                ", recordAddTime=" + recordAddTime +
                ", updatedByUser='" + updatedByUser + '\'' +
                ", recordUpdatedTime=" + recordUpdatedTime +
                ", items=" + items +
                '}';
    }
}
