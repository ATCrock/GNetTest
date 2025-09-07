package com.example.gravenettest.controller;

import com.example.gravenettest.dto.CheckRequest;
import com.example.gravenettest.dto.ComplainRequest;
import com.example.gravenettest.dto.PostRequest;
import com.example.gravenettest.dto.ReportList;
import com.example.gravenettest.entity.Checkdata;
import com.example.gravenettest.entity.Complaindata;
import com.example.gravenettest.entity.Postdata;
import com.example.gravenettest.result.AjaxResult;
import com.example.gravenettest.service.ComplainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ComplainController {
    @Resource
    private ComplainService complainServcie;


    @PostMapping("/student/report-post")
    public AjaxResult<ComplainRequest> publishPost(@Valid @RequestBody ComplainRequest complainRequest){
        Integer complainCompare = complainServcie.complainPost((complainRequest.getUserId()), complainRequest.getPostId(), complainRequest.getReason());
        if (complainCompare == 1){
        return AjaxResult.successPost();}
        else{
            return AjaxResult.fail();
        }
    }

    @GetMapping("/student/report-post")
    public AjaxResult<List<Complaindata>> getComplain(@Valid @RequestBody ComplainRequest complainRequest){
        List<Complaindata> complaindata = complainServcie.lookUpComplainPost((complainRequest.getUserId()));
        if (complaindata != null){
            return AjaxResult.success(complaindata);}
        else{
            return AjaxResult.fail();
        }
    }

    @GetMapping("/admin/report")
    public AjaxResult<ReportList[]> getAllPost(@Valid @RequestBody ComplainRequest complainRequest){
        ReportList[] reportListData = complainServcie.complaindata2ReportList((complainRequest.getUserId()));
        if (reportListData != null) {
            return AjaxResult.success(reportListData);
        }else {
            return AjaxResult.fail();
        }
    }

    @PostMapping("/admin/report")
    public AjaxResult<Checkdata> checkComplainPost(@Valid @RequestBody CheckRequest checkRequest){
        Integer result = complainServcie.checkComplainPost(checkRequest.getUserId(), checkRequest.getReportId(), checkRequest.getApproval());
        if (result == 1){
            return AjaxResult.successDelete();
        }
        else if (result == 2){
            return AjaxResult.successConserve();
        }
        else{
            return  AjaxResult.fail();
        }
    }


}
