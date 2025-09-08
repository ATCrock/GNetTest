package com.example.gravenettest.service.InterfaceExample;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gravenettest.entity.Userdata;
import com.example.gravenettest.mapper.UserdataMapper;
import com.example.gravenettest.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class UserServiceImpl implements UserService {

    //@Resource // 自动把mapper接口注入userdataMapper
    private final UserdataMapper userdataMapper;

    @Override
    public Integer login(Integer id, String username, String name, String password, Integer userType) {
        /*
        name:用户名
        password:密码
         */
        // 条件构造器：
        LambdaQueryWrapper<Userdata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Userdata::getUsername, username);
        Userdata userdata = userdataMapper.selectOne(queryWrapper);
        if(userdata == null){
            userdata = Userdata.builder().id(id).username(username).password(password).name(name).userType(userType).build();
            userdataMapper.insert(userdata);
            System.out.println(0);
        }
        else {
            if (!userdata.getPassword().equals(password)) {
                return -1;
            }
        }
        System.out.println(1);
        return userdata.getId();
    }
    @Override
    public Integer login(String username, String password) {
        /*
        name:用户名
        password:密码
         */
        // 条件构造器：
        LambdaQueryWrapper<Userdata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Userdata::getUsername, username);
        Userdata userdata = userdataMapper.selectOne(queryWrapper);
        if(userdata == null){
            userdata = Userdata.builder().username(username).password(password).build();
            userdataMapper.insert(userdata);
        }
        else {
            if (!userdata.getPassword().equals(password)) {
                return -1;
            }
        }
        return userdata.getId();
    }

    public Integer register(String username, String password) {
        /*
        name:用户名
        password:密码
         */
        // 条件构造器：
        LambdaQueryWrapper<Userdata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Userdata::getUsername, username);
        Userdata userdata = userdataMapper.selectOne(queryWrapper);
        if(userdata == null){
            userdata = Userdata.builder().username(username).password(password).build();
            userdataMapper.insert(userdata);
        }
        else {
            if (!userdata.getPassword().equals(password)) {
                return -1;
            }
        }
        return userdata.getId();
    }

    public Integer register(Integer id, String username, String name, String password, Integer userType) {
        /*
        name:用户名
        password:密码
         */
        // 条件构造器：
        LambdaQueryWrapper<Userdata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Userdata::getUsername, username);
        Userdata userdata = userdataMapper.selectOne(queryWrapper);
        if(userdata == null){
            userdata = Userdata.builder().username(username).password(password).userType(userType).name(name).id(id).build();
            userdataMapper.insert(userdata);
            return 1;
        }
        else { return -1;}
    }

    public String getUserNameById(Integer id) {
        QueryWrapper<Userdata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).select("name");
        Userdata userdata = userdataMapper.selectOne(queryWrapper);
        return userdata != null ? userdata.getName() : null;
    }
}
