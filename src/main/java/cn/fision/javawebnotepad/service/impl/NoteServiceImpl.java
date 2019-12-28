package cn.fision.javawebnotepad.service.impl;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.Note;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.mapper.NoteMapper;
import cn.fision.javawebnotepad.mapper.UserMapper;
import cn.fision.javawebnotepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 00:10
 **/
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Note> findAll() {
        return noteMapper.findAll();
    }

    @Override
    public Note findById(int id) {
        return noteMapper.findById(id);
    }

    @Override
    public Note findBy(int userId,String title,String createTime){
        return  noteMapper.findBy(userId,title,createTime);
    }

    @Override
    public List<Note> findByUserId(int userId) {
        return noteMapper.findByUserId(userId);
    }

    @Override
    public JsonResult insertOne(int userId, @NotBlank Note note) {
        User user = userMapper.findById(userId);//再次校验用户
        String msg = "";
        if (user!=null) {
            if(StringUtils.isEmpty(note.getTitle().trim()))
               return JsonResult.build(-1,"标题不能为空");
            //Integer id = noteMapper.insertOne(userId,note.getTitle(),note.getContent(),note.getCreateTime(),note.getUpdateTime());
            Integer rs = noteMapper.insertOneByExample(note);//note携带了id
            if (rs!=null&&rs == 1){
                return JsonResult.ok(note);
            }
            msg = "保存失败！";
        }else{
            msg= "用户不存在";
        }
        return JsonResult.build(-1,msg);
    }

    @Override
    public JsonResult updateById(int id, @NotBlank String title, String content, Date updateTime) {
        Note note = noteMapper.findById(id);
        if (note==null||note.getId()<=0){
            return JsonResult.build(404,"您的内容已不存在");
        }
            Integer update = noteMapper.updateById(id, title, content, updateTime != null ? updateTime : new Date());
            if (update==1){
                return JsonResult.ok();
            }
        return JsonResult.build(-1,"更新失败",update);
    }

    @Override
    public JsonResult deleteById(int id) {
        Integer delete = noteMapper.deleteById(id);
        if (delete==1)
            return JsonResult.ok();
        return JsonResult.build(-1,"删除失败");
    }
}
