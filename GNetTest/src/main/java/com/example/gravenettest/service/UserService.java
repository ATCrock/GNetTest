package com.example.gravenettest.service;

public interface UserService {
    public Integer login(Integer id, String username, String name, String password, Integer userType); // register

    public Integer login(String username, String password);

    public Integer register(Integer id, String username, String name, String password, Integer userType);

    public String getUserNameById(Integer userId);
    //public Integer login(Integer id, Integer userType); // login
}
