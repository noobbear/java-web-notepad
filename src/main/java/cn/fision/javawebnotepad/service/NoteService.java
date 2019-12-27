package cn.fision.javawebnotepad.service;

import cn.fision.javawebnotepad.bean.JsonResult;
import cn.fision.javawebnotepad.bean.Note;
import cn.fision.javawebnotepad.bean.User;

import java.util.Date;
import java.util.List;

/**
 * ClassName: NoteService <br/>
 * Description: <br/>
 *
 * @author Fision<br />
 * @version 1.0
 * @Date: 2019/12/28- 0:08<br/>
 */
public interface NoteService {
    List<Note> findAll();

    Note findById(int id);

    Note findBy(int userId,String title,String createTime);

    List<Note> findByUserId(int userId);

    JsonResult insertOne(int userId, Note note);

    JsonResult updateById(int id,String title,String content,Date updateTime);

    JsonResult deleteById(int  id);
}
