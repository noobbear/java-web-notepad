package cn.fision.javawebnotepad.controller;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 01:40
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/update")
    public JsonResult updateNickName(int id,@NotBlank String nickname){
        User user = userService.updateUserNickName(id, nickname);
        return JsonResult.ok(user);
    }
}
