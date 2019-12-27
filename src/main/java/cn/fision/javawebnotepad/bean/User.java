package cn.fision.javawebnotepad.bean;

import lombok.Data;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-27 17:21
 **/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
}
