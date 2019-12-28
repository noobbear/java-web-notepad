package cn.fision.javawebnotepad;

import cn.fision.javawebnotepad.bean.Note;
import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.mapper.NoteMapper;
import cn.fision.javawebnotepad.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class JavaWebNotepadApplicationTests {

    @Autowired
    UserMapper mapper;

    @Autowired
    NoteMapper noteMapper;

    @Test
    void contextLoads() {
        int i =mapper.insertOne("demo2", DigestUtils.md5DigestAsHex("123456".getBytes()),"demoQAQ");
        System.out.println(i);
        List<User> all = mapper.findAll();
        System.out.println(all.toString());
    }

    @Test
    void find(){
        System.out.println(mapper.findByUserName("demo"));
    }

    @Test
    void insert(){
        Note note = new Note();
        note.setUserId(1);
        note.setTitle("测试22");
        note.setContent("测试2222，66内容\r\nQAQ");
        note.setCreateTime(new Date());
        note.setUpdateTime(new Date());
        int rs = noteMapper.insertOne(note.getUserId(),note.getTitle(),note.getContent(),note.getCreateTime(),note.getUpdateTime());
        System.out.println(rs);
    }
    @Test
    void insert2(){
        Note note = new Note();
        note.setUserId(1);
        note.setTitle("测试3");
        note.setContent("测试333，66内容\r\nQAQ");
        note.setCreateTime(new Date());
        note.setUpdateTime(new Date());
        System.out.println(noteMapper.insertOneByExample(note));
        System.out.println(note);
    }
    @Test
    void findNote(){
        System.out.println(noteMapper.findById(1));
    }

    @Test
    void updateNote(){
        Integer integer = noteMapper.updateById(1, "111修改", "测试1111，6226内容\r\nQAQ", new Date());
        System.out.println(integer);
        System.out.println(noteMapper.findById(1));
    }

    @Test
    void get(){
        //2019-12-27 16:54:21
            System.out.println(noteMapper.findBy(1, "测试22", "2019-12-27 16:54:21"));
    }

    @Test
    void addUser(){
        //mapper.insertOne("用户名", DigestUtils.md5DigestAsHex("密码".getBytes()),"昵称");
        int i =mapper.insertOne("demo2", DigestUtils.md5DigestAsHex("123456".getBytes()),"demoQAQ");
        System.out.println(i);//i==1证明成功
    }
}
