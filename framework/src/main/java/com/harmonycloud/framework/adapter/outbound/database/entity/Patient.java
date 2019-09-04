package com.harmonycloud.framework.adapter.outbound.database.entity;

import com.harmonycloud.common.database.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 病人
 *
 * @author gjq
 * @since 2019-09-04
 */
@ApiModel(value="Patient对象", description="病人")
public class Patient extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "病人用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "病人类型")
    @TableField("TYPE")
    private Double type;

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
        "username=" + username +
        ", type=" + type +
        "}";
    }

    public static class Fields extends BaseEntity.Fields{
        public static final String username = "USERNAME";
        public static final String type = "TYPE";
    }
}
