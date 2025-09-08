package com.example.gravenettest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName(value ="postdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postdata {
    /**
     * 
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 
     */
    private String context;

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @JsonProperty("post_id")
    private Integer postId;

    /**
     * 
     */
    private String title;
}