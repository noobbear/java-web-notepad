package cn.fision.javawebnotepad.controller;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.Note;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 01:42
 **/
@RestController
public class NoteRestController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/note/all")
    public List<Note> findAll(){
        return noteService.findAll();
    }

    @GetMapping("/note/all/{userId}")
    public List<Note> findAll(@PathVariable("userId") int userId){
       return noteService.findByUserId(userId);
    }

    @PostMapping("/note/insert")
    public JsonResult insert(Note note, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        if (user==null||user.getId()<=0){
            return JsonResult.build(-1,"未登录或登录超时！");
        }else{
            if (note.getCreateTime()==null)
                note.setCreateTime(new Date());
            note.setUpdateTime(new Date());
            note.setUserId(user.getId());
            JsonResult jsonResult = noteService.insertOne(user.getId(), note);
            return jsonResult;
        }
    }
    @PostMapping("/note/update")
    public JsonResult update(Note note, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        if (user==null||user.getId()<=0 || user.getId()!=note.getUserId()){//不能修改别人的
            return JsonResult.build(-1,"未登录或登录超时！");
        }else{
            JsonResult jsonResult = noteService.updateById(note.getId(),note.getTitle(),note.getContent(),new Date());
            return jsonResult;
        }
    }
}
