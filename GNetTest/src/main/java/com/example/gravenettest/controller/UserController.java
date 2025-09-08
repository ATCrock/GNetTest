package com.example.gravenettest.controller;

import com.example.gravenettest.dto.LoginRequest;
import com.example.gravenettest.dto.LoginResponse;
import com.example.gravenettest.dto.RegisterRequest;
import com.example.gravenettest.dto.RegisterRequestLite;
import com.example.gravenettest.entity.Postdata;
import com.example.gravenettest.result.AjaxResult;
import com.example.gravenettest.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/reg")
    public AjaxResult<RegisterRequest> register(@Valid @RequestBody RegisterRequest registerRequest) {
        //Integer user_id = userService.login(registerRequest.getUsername(), registerRequest.getPassword());
        Integer user_id = userService.register(registerRequest.getId(), registerRequest.getUsername(), registerRequest.getName(), registerRequest.getPassword(), registerRequest.getUser_type());
        //报错原因是数据没有全部初始化
        //System.out.println(1);
        //### Cause: java.sql.SQLException: Field 'name' doesn't have a default value
        if  (user_id != -1) {
            return AjaxResult.success();
        }
        else{
            return AjaxResult.fail();
        }
    }

    @PostMapping("/login")
    public AjaxResult<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Integer user_id = userService.login(loginRequest.getId(), loginRequest.getUsername(), loginRequest.getName(), loginRequest.getPassword(), loginRequest.getUser_type());
        //Integer user_type = userService.login(loginRequest.getId(), loginRequest.getUsername(), loginRequest.getName(), loginRequest.getPassword(), loginRequest.getUser_type());
        //报错原因是数据没有全部初始化
        //System.out.println(1);
        //### Cause: java.sql.SQLException: Field 'name' doesn't have a default value
        if (user_id != -1) {
            return AjaxResult.success(new LoginResponse(user_id, loginRequest.getUser_type()));
        }
        else{
            return AjaxResult.fail();
        }
        // return AjaxResult.success(new LoginResponse(user_id, user_type));
    }
}
