package com.noodles.gateway.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @filename YrzMerchantLimitBean
 * @description 认证通商户约束表(YRZ_MERCHANT_CONF)
 * @author Eric
 * @date 2019/05/13 10:00
 */
@XmlAccessorType(XmlAccessType.NONE)
public class MerchantLimitBean implements Serializable {

    private static final long serialVersionUID = -1932685511023899054L;

    /**  主键ID*/
    private Integer merchantLimitId;

    /** 商户ID*/
    private String merchantId;

    /** 约束项*/
    private String limitItem;

    /** 约束值*/
    private String limitValue;

    /** 约束类别*/
    private String limitType;

    /** 所属系统*/
    private String sourceSystem;

    /** 状态(1:启用 0:停用)*/
    private String status;

    /** 创建人*/
    private String createdBy;

    /** 创建时间*/
    private Date createdDate;

    /** 修改人*/
    private String updatedBy;

    /** 修改时间*/
    private Date updatedDate;

    /**
      *  主键ID
      * @return MERCHANT_LIMIT_ID  主键ID
      */
    public Integer getMerchantLimitId() {
        return merchantLimitId;
    }

    /**
      *  主键ID
      * @param merchantLimitId  主键ID
      */
    public void setMerchantLimitId(Integer merchantLimitId) {
        this.merchantLimitId = merchantLimitId;
    }

    /**
      * 商户ID
      * @return MERCHANT_ID 商户ID
      */
    public String getMerchantId() {
        return merchantId;
    }

    /**
      * 商户ID
      * @param merchantId 商户ID
      */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
      * 约束项
      * @return LIMIT_ITEM 约束项
      */
    public String getLimitItem() {
        return limitItem;
    }

    /**
      * 约束项
      * @param limitItem 约束项
      */
    public void setLimitItem(String limitItem) {
        this.limitItem = limitItem == null ? null : limitItem.trim();
    }

    /**
      * 约束值
      * @return LIMIT_VALUE 约束值
      */
    public String getLimitValue() {
        return limitValue;
    }

    /**
      * 约束值
      * @param limitValue 约束值
      */
    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue == null ? null : limitValue.trim();
    }

    /**
      * 约束类别
      * @return LIMIT_TYPE 约束类别
      */
    public String getLimitType() {
        return limitType;
    }

    /**
      * 约束类别
      * @param limitType 约束类别
      */
    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    /**
      * 所属系统
      * @return SOURCE_SYSTEM 所属系统
      */
    public String getSourceSystem() {
        return sourceSystem;
    }

    /**
      * 所属系统
      * @param sourceSystem 所属系统
      */
    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem == null ? null : sourceSystem.trim();
    }

    /**
      * 状态(1:启用 0:停用)
      * @return STATUS 状态(1:启用 0:停用)
      */
    public String getStatus() {
        return status;
    }

    /**
      * 状态(1:启用 0:停用)
      * @param status 状态(1:启用 0:停用)
      */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
      * 创建人
      * @return CREATED_BY 创建人
      */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
      * 创建人
      * @param createdBy 创建人
      */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
      * 创建时间
      * @return CREATED_DATE 创建时间
      */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
      * 创建时间
      * @param createdDate 创建时间
      */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
      * 修改人
      * @return UPDATED_BY 修改人
      */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
      * 修改人
      * @param updatedBy 修改人
      */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
      * 修改时间
      * @return UPDATED_DATE 修改时间
      */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
      * 修改时间
      * @param updatedDate 修改时间
      */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}