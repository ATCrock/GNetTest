package com.example.gravenettest.service;

import com.example.gravenettest.entity.Postdata;

import java.util.List;

public interface PostServcie {
    public Integer publishPost(Integer userId, String title, String content);
    public Integer publishPost(Integer userId, String content);
    public List<Postdata> getAllPost();
    public Integer deletePost(Integer userId, Integer postId);
    public void complainPost(Integer userId, Integer postId, String reason);
    public Integer rewritePost(Integer user_id, Integer posrtId, String rewriteContext);
    // public void getPostLike(Integer postId(){}
    public void lookUpComplainPost(Integer userId);
    //public void likePost(Integer postId){}
    public void getAllComplainPost(Integer postId);
    public void checkComplainPost(Integer userId, Integer reportId);
    public Integer getNextAvailablePostId();
}
