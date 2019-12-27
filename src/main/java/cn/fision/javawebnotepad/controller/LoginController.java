package cn.fision.javawebnotepad.controller;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-27 23:20
 **/
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public JsonResult login(@NotBlank String username, @NotBlank String password){
        User user = userService.findByUserName(username);
        if (user==null)
            return JsonResult.build(-1,"用户名或密码错误");
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (pwd.equals(user.getPassword()))
            return JsonResult.ok(user);
        else
            return JsonResult.build(-1,"用户名或密码错误");
    }
}
