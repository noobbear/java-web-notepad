package cn.fision.javawebnotepad;

import cn.fision.javawebnotepad.bean.User;
import cn.fision.javawebnotepad.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
class JavaWebNotepadApplicationTests {

    @Autowired
    UserMapper mapper;

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

}
