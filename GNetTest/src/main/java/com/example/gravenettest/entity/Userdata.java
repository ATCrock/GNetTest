package com.example.gravenettest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "userdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Userdata {

    @TableId(type = IdType.AUTO)
    private Integer id;


    private String username;


    private String name;


    private String password;

    private Integer userType;
}