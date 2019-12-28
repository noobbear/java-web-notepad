package cn.fision.javawebnotepad.controller;

import cn.fision.javawebnotepad.bean.Note;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 14:29
 **/
@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping({"/","/index","/index.html"})
    public String index(HttpServletRequest request,Map<String,Object> map){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null&&user.getId()<=0){//已拦截未登录的请求，此处不用判断也行
            return "redirect:login";
        }
        List<Note> notes = noteService.findByUserId(user.getId());
        map.put("notes",notes);
        return "index";
    }

    @GetMapping("/note/upload")
    public String getView(){
        return "upload";
    }

    @GetMapping("/note/{id}")
    public String get(@PathVariable("id") int id, Map<String,Object> map){
        Note note = noteService.findById(id);
        map.put("note",note);
        return "update";
    }
}
