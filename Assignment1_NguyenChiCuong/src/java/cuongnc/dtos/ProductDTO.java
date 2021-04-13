/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.dtos;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class ProductDTO {
    String proID, proName;
    float proPrice;
    int proQuantity;
    boolean proStatus;
    String proImage, proDescription;
    Date proCreateDate;
    String cateID;

    public ProductDTO() {
    }

    public ProductDTO(String proID, String proName, float proPrice, int proQuantity, boolean proStatus, String proImage, String proDescription, Date proCreateDate, String cateID) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proStatus = proStatus;
        this.proImage = proImage;
        this.proDescription = proDescription;
        this.proCreateDate = proCreateDate;
        this.cateID = cateID;
    }

    public ProductDTO(String proID, String proName, float proPrice, int proQuantity, boolean proStatus, String proImage, String proDescription, String cateID) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proStatus = proStatus;
        this.proImage = proImage;
        this.proDescription = proDescription;
        this.cateID = cateID;
    }

    
    
    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public boolean isProStatus() {
        return proStatus;
    }

    public void setProStatus(boolean proStatus) {
        this.proStatus = proStatus;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public Date getProCreateDate() {
        return proCreateDate;
    }

    public void setProCreateDate(Date proCreateDate) {
        this.proCreateDate = proCreateDate;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }
    
    
}
