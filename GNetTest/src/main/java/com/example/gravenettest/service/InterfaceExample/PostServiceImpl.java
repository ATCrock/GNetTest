package com.example.gravenettest.service.InterfaceExample;

import com.example.gravenettest.entity.Postdata;
import com.example.gravenettest.mapper.PostdataMapper;
import com.example.gravenettest.mapper.UserdataMapper;
import com.example.gravenettest.service.PostServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostServcie {
    private final PostdataMapper postdataMapper;
    private final JdbcTemplate jdbcTemplate;


    public Integer publishPost(Integer userId, String title, String context){
        Postdata post = Postdata.builder()
                .userId(userId)
                .title(title)
                .context(context)
                .build();
        postdataMapper.insert(post);
        return 1;
    }
    public Integer getNextAvailablePostId() {
        //查询当前最大ID
        Integer maxId = jdbcTemplate.queryForObject("SELECT MAX(post_id) FROM postdata", Integer.class);
        return (maxId != null) ? maxId + 1 : 1;
    }

    public Integer publishPost(Integer userId, String context){
        Postdata post = Postdata.builder()
                .userId(userId)
                .title("unknown")
                .context(context)
                .build();
        postdataMapper.insert(post);
        return 1;
    }

    public List<Postdata> getAllPost(){
        return postdataMapper.selectList(null);
    }
    public Integer deletePost(Integer userId, Integer postId){
       Postdata post = postdataMapper.selectById(postId);
       if (post == null){
           return -1;
        }else {
           postdataMapper.deleteById(postId);
           return 1;
       }
    }
    public void complainPost(Integer userId, Integer postId, String reason){
        //在complainService里面
    }
    public Integer rewritePost(Integer user_id, Integer post_id, String rewriteContext){
        Postdata post = postdataMapper.selectById(post_id);
        if (post == null){
            return -1;
        }else {
            Postdata post2 = new Postdata();
            post2.setUserId(user_id);
            post2.setPostId(post_id);
            post2.setContext(rewriteContext);
            postdataMapper.insertOrUpdate(post2);
            return 1;
        }
    }
    // public void getPostLike(Integer postId(){}
    public void lookUpComplainPost(Integer userId){

    }
    //public void likePost(Integer postId){}
    public void getAllComplainPost(Integer postId){
    }
    public void checkComplainPost(Integer userId, Integer reportId){
        //pass
    }

}
