package cn.fision.javawebnotepad.service;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.User;

import java.util.List;

/**
 * ClassName: UserService <br/>
 * Description: <br/>
 *
 * @author Fision<br />
 * @version 1.0
 * @Date: 2019/12/27- 20:53<br/>
 */
public interface UserService {
    JsonResult insert(User user);
    User findByUserName(String userName);
    User updateUserNickName(int id,String nickname);
    List<User> findAll();
}
