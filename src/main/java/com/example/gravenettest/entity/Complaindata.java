package com.example.gravenettest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@TableName(value ="complaindata")
@Data
public class Complaindata {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer reportId;

    /**
     * 
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 
     */
    @JsonProperty("post_id")
    private Integer postId;

    /**
     * 
     */
    private String reason;

    /**
     * 
     */
    private Integer status = 0;
}