package cn.fision.javawebnotepad.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-27 22:18
 **/
@Getter
@Setter
public class JsonResult implements Serializable {
    private int status=200;
    private String msg;
    private Object data;

    public JsonResult(){
        msg = "";
        data = null;
    }

    public JsonResult(int status,String msg,Object data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
    public JsonResult(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

    public static JsonResult ok(){
        return  new JsonResult();
    }
    public static JsonResult ok(Object data){
        return  new JsonResult(200,"OK",data);
    }
    public static JsonResult build(int status,String msg,Object data){
        return  new JsonResult( status, msg, data);
    }
    public static JsonResult build(int status,String msg){
        return  new JsonResult(status, msg);
    }
}
