package cn.fision.javawebnotepad.mapper;

import cn.fision.javawebnotepad.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: UserMapper <br/>
 * Description: <br/>
 *
 * @author Fision<br />
 * @version 1.0
 * @Date: 2019/12/27- 17:19<br/>
 */
@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user order by id desc")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Insert("insert into user(username,password,nickname) values(#{username},#{password},#{nickname})")
    Integer insertOne(String username,String password,String nickname);

    @Update("update  user set nickname= #{nickname} where id = #{id}")
    Integer updateNicknameById(int id,String nickname);

    @Select("select * from user where username = #{username} limit 1")
    User findByUserName(String username);
}
