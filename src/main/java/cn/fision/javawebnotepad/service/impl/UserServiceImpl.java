package cn.fision.javawebnotepad.service.impl;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.mapper.UserMapper;
import cn.fision.javawebnotepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-27 20:58
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult insert(User user) {
        if(user==null|| StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword()))
            return  JsonResult.build(-1,"用户名和密码不能为空");
        User u = userMapper.findByUserName(user.getUsername());
        if (u!=null){
            return  JsonResult.build(-1,"用户名已存在");
        }
        Integer rs = userMapper.insertOne(user.getUsername(), user.getPassword(), user.getNickname());
        if(rs==1)
            return JsonResult.ok(userMapper.findByUserName(user.getUsername()));
        return JsonResult.build(-1,"未知失败");
    }

    @Override
    public User findByUserName(String userName) {
        if (userName==null||userName.isEmpty())
            return  null;
        return userMapper.findByUserName(userName);
    }

    @Override
    public User updateUserNickName(int id, String nickname) {
        if(id<=0||StringUtils.isEmpty(nickname))
            return null;
        Integer rs = userMapper.updateNicknameById(id, nickname);
        if(rs==1)
            return userMapper.findById(id);
        return null;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
