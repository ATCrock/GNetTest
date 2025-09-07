package com.example.gravenettest.service.InterfaceExample;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gravenettest.dto.ComplainRequest;
import com.example.gravenettest.dto.ReportList;
import com.example.gravenettest.entity.Checkdata;
import com.example.gravenettest.entity.Complaindata;
import com.example.gravenettest.entity.Postdata;
import com.example.gravenettest.entity.Userdata;
import com.example.gravenettest.mapper.ComplaindataMapper;
import com.example.gravenettest.mapper.PostdataMapper;
import com.example.gravenettest.mapper.UserdataMapper;
import com.example.gravenettest.service.ComplainService;
import com.example.gravenettest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ComplainServiceImpl implements ComplainService {
    private final ComplaindataMapper complaindataMapper;
    private final PostdataMapper postdataMapper;
    private final UserdataMapper userdataMapper;
    private final UserService userService;
    //private final UserService userService;

    public Integer complainPost(Integer userId, Integer postId, String reason){
        Postdata postdata = postdataMapper.selectById(postId);
        if (postdata == null){
            return -1;
        }else if (Objects.equals(postdata.getUserId(), userId)){
            Complaindata complainPostdata = new Complaindata();
            complainPostdata.setPostId(postdata.getPostId());
            complainPostdata.setUserId(postdata.getUserId());
            complainPostdata.setReason(reason);
            complaindataMapper.insert(complainPostdata);
            return 1;
        }
        else {
            return -1;
        }
    }

    public List<Complaindata> lookUpComplainPost(Integer userId){
        QueryWrapper<Complaindata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId); // 假设数据库字段名为user_id
        return complaindataMapper.selectList(queryWrapper);
    }


    //public void likePost(Integer postId){}
    public List<Complaindata> getAllComplainPost(Integer userId) {
        QueryWrapper<Complaindata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return complaindataMapper.selectList(queryWrapper);
    }

    public ReportList[] complaindata2ReportList(Integer userId){
        QueryWrapper<Complaindata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        QueryWrapper<Userdata> queryWrapperUser = new QueryWrapper<>();
        queryWrapperUser.eq("id", userId);
        List<Complaindata> complaindataList = complaindataMapper.selectList(queryWrapper);
        List<Userdata> userdataList = userdataMapper.selectList(queryWrapperUser);
        if  (userdataList.isEmpty()){
            return null;
        }
        String username = null;
        for (Userdata userdata : userdataList){
            username = userdata.getUsername();
        }
        int reportListLength = complaindataList.size();
        ReportList[] reportLists = new ReportList[reportListLength];
        int count = 0;
        for (Complaindata complaindata : complaindataList){
            Integer postId = complaindata.getPostId();
            String reason  = complaindata.getReason();
            Integer status = complaindata.getStatus();
            Integer reportId = complaindata.getReportId();
            ReportList staticReportList = new ReportList(userId, postId, reason, status, username, reportId);
            reportLists[count] = staticReportList;
            count++;
        }
        //String username = userService.getUserNameById(userId);
        //List<Userdata> complaindataList =
        //List<Complaindata> complaindataList = complaindataMapper.selectList(userId)
        return reportLists;
        //reportList.
    }
    public Integer checkComplainPost(Integer userId, Integer reportId, Integer approval){
        QueryWrapper<Complaindata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("report_id", reportId);
        if (approval == 1){
            complaindataMapper.delete(queryWrapper);
            return 1;
        }
        else if (approval == 2){
            return 2;
        }
        else
            return -1;
        //pass
    }
}
