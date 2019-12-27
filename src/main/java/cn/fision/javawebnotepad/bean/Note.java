package cn.fision.javawebnotepad.bean;

import lombok.Data;

import java.util.Date;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-27 23:58
 **/
@Data
public class Note {
    private int id;
    private int userId;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
}
