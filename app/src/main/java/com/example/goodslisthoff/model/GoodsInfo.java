package com.example.goodslisthoff.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoodsInfo {
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("plashka")
    @Expose
    private Object plashka;
    @SerializedName("couches")
    @Expose
    private List<Items> couches = null;
    @SerializedName("relatedCategories")
    @Expose
    private List<RelatedCategory> relatedCategories = null;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getPlashka() {
        return plashka;
    }

    public void setPlashka(Object plashka) {
        this.plashka = plashka;
    }

    public List<Items> getCouches() {
        return couches;
    }

    public void setCouches(List<Items> couches) {
        this.couches = couches;
    }

    public List<RelatedCategory> getRelatedCategories() {
        return relatedCategories;
    }

    public void setRelatedCategories(List<RelatedCategory> relatedCategories) {
        this.relatedCategories = relatedCategories;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
