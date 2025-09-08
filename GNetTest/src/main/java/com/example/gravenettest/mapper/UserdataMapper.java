package com.example.gravenettest.mapper;

import com.example.gravenettest.entity.Userdata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserdataMapper extends BaseMapper<Userdata> {
    @Select("SELECT name FROM userdata WHERE id = #{userId}")
    String selectUserNameById(@Param("userId") Integer userId);
}




