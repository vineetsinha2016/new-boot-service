package com.vin.learn.entities.mysql;

//import javax.persistence.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @Column(name = "ctg_ident")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "ctg_nme")
    private String categoryName;

    @Column(name = "ctg_dsc")
    private String categoryDescription;

    @Column(name = "ctg_cde")
    private String categoryCode;

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
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Items> items  = new ArrayList<>();

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", sourceApplication='" + sourceApplication + '\'' +
                ", addByUser='" + addByUser + '\'' +
                ", recordAddTime=" + recordAddTime +
                ", updatedByUser='" + updatedByUser + '\'' +
                ", recordUpdatedTime=" + recordUpdatedTime +
                ", items=" + items +
                '}';
    }
}
