package com.example.gravenettest.controller;

import com.example.gravenettest.dto.DeleteRequest;
import com.example.gravenettest.dto.PostRequest;
import com.example.gravenettest.entity.Postdata;
import com.example.gravenettest.result.AjaxResult;
import com.example.gravenettest.service.PostServcie;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Slf4j
public class PostController {
    @Resource
    private PostServcie postServcie;

    @PostMapping("/post")
    public AjaxResult<PostRequest> publishPost(@Valid @RequestBody PostRequest postRequest){
        Integer postT = postServcie.publishPost((postRequest.getUserId()), postRequest.getContent());
        if (postT != -1) {
            return AjaxResult.successPost();
        }
        else{
            return AjaxResult.fail();
        }
    }

    @PostMapping("/post2")
    public AjaxResult<PostRequest> publishPost2(@Valid @RequestBody PostRequest postRequest){
        postServcie.publishPost((postRequest.getUserId()), postRequest.getTitle(), postRequest.getContent());
        return AjaxResult.successPost();
    }

    @GetMapping("/getpost")
    public AjaxResult<List<Postdata>> getAllPost(){
        List<Postdata> postdata = postServcie.getAllPost();
        if (postdata != null) {
            return AjaxResult.success(postdata);
        }else {
            return AjaxResult.fail();
        }
    }

    @DeleteMapping("/delete")
    public AjaxResult<DeleteRequest> deletePost(@Valid @RequestBody DeleteRequest deleteRequest){
        Integer postdata = postServcie.deletePost(deleteRequest.getUserId(), deleteRequest.getPostId());
        if (postdata == -1){
            return AjaxResult.fail();
        }else {
            return AjaxResult.successDelete();
        }
    }

    @DeleteMapping("/delete2")
    public AjaxResult<DeleteRequest>  deletePost2(@Valid @RequestBody DeleteRequest deleteRequest){
        Integer postdata = postServcie.deletePost(deleteRequest.getUserId(), deleteRequest.getPostId());
        if (postdata == -1){
            return AjaxResult.fail(new DeleteRequest(deleteRequest.getUserId(), deleteRequest.getPostId()));}
        else{
            return AjaxResult.successDelete(new DeleteRequest(deleteRequest.getUserId(), deleteRequest.getPostId()));
        }
    }

    @PutMapping("/post")
    public AjaxResult<PostRequest> rewirtePost(@Valid @RequestBody PostRequest postRequest){
        Integer postdata = postServcie.rewritePost(postRequest.getUserId(), postRequest.getPostId(), postRequest.getContent());
        if (postdata == -1){
            return AjaxResult.fail();
        }else {
            return AjaxResult.successPost();
        }
    }
}
