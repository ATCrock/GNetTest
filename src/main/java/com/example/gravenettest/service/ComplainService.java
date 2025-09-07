package com.example.gravenettest.service;

import com.example.gravenettest.dto.ComplainRequest;
import com.example.gravenettest.dto.ReportList;
import com.example.gravenettest.entity.Complaindata;
import jakarta.validation.Valid;

import java.util.List;

public interface ComplainService {
    public Integer complainPost(Integer userId, Integer postId, String reason);
    public List<Complaindata> lookUpComplainPost(Integer userId);
    //public void likePost(Integer postId){}
    public List<Complaindata> getAllComplainPost(Integer userId);
    public ReportList[] complaindata2ReportList(Integer userId);
    public Integer checkComplainPost(Integer userId, Integer reportId, Integer approval);

}
