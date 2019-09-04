package com.harmonycloud.framework.adapter.outbound.database.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 病人
 *
 * @author GJQ
 * @since 2019-09-04
 */
@ApiModel(value="Patient对象", description="病人")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID")
    private Long id;

    @ApiModelProperty(value = "删除标记")
    @TableField("IS_DELETED")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("GMT_CREATE")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATOR")
    private String creator;

    @ApiModelProperty(value = "更新时间")
    @TableField("GMT_MODIFIED")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "更新者")
    @TableField("MODIFIER")
    private String modifier;

    @ApiModelProperty(value = "病人用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "病人类型")
    @TableField("TYPE")
    private Double type;

    public Long getId() {
        return id;
    }

    public Patient setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Patient setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public Patient setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Patient setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public Patient setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public String getModifier() {
        return modifier;
    }

    public Patient setModifier(String modifier) {
        this.modifier = modifier;
        return this;
    }
    public String getUsername() {
        return username;
    }

    public Patient setUsername(String username) {
        this.username = username;
        return this;
    }
    public Double getType() {
        return type;
    }

    public Patient setType(Double type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", gmtCreate=" + gmtCreate +
                ", creator=" + creator +
                ", gmtModified=" + gmtModified +
                ", modifier=" + modifier +
                ", username=" + username +
        ", type=" + type +
        "}";
    }

    public static class Fields {
        public static final String id = "ID";
        public static final String isDeleted = "IS_DELETED";
        public static final String gmtCreate = "GMT_CREATE";
        public static final String creator = "CREATOR";
        public static final String gmtModified = "GMT_MODIFIED";
        public static final String modifier = "MODIFIER";
        public static final String username = "USERNAME";
        public static final String type = "TYPE";
    }
}
