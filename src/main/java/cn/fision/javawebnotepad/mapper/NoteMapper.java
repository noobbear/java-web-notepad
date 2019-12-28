package cn.fision.javawebnotepad.mapper;

import cn.fision.javawebnotepad.bean.Note;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NoteMapper <br/>
 * Description: <br/>
 *
 * @author Fision<br />
 * @version 1.0
 * @Date: 2019/12/28- 0:00<br/>
 */
@Mapper
@Repository
public interface NoteMapper {
    @Select("select * from note order by id desc")
    List<Note> findAll();

    @Select("select * from note where id = #{id}")
    Note findById(int id);

    @Select("select * from note where userId = #{userId} order by id desc")
    List<Note> findByUserId(int userId);

    @Select("select * from note where userId = #{userId} and title = #{title} and createTime = #{createTime}")
    Note findBy(int userId, String title, String createTime);

    @Insert("insert into note(userId,title,content,createTime,updateTime) values(#{userId},#{title},#{content},#{createTime},#{updateTime})")
    Integer insertOne(int userId, String title, String content,Date createTime, Date updateTime);


    @Insert("insert into note(userId,title,content,createTime,updateTime) values(#{userId},#{title},#{content},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")/*增加这个注解插入记录后会返回自增长的id*/
    Integer insertOneByExample(Note note);

    @Update("update  note set content = #{content}, title = #{title},updateTime =#{updateTime} where id = #{id}")
    Integer updateById(int id,String title,String content,Date updateTime);

    @Delete("delete from note where id = #{id}")
    Integer deleteById(int  id);
}
