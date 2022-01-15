package com.omidmohebbise.todoapp.task.model.repository.impl;

import com.omidmohebbise.todoapp.task.model.Task;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


import java.util.List;


@Mapper
public interface TaskMapper {


    @Insert( value = "insert into todo_app.tasks (do_date, done, title, user_id) values (#{doDate} , #{done}, #{title}, #{userId});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long insert(Task task);

    @Select("SELECT * FROM todo_app.tasks WHERE id = #{id} and user_id = #{userId}")
    Task findByIdAndUserId(long id, long userId);

    @Update("update todo_app.tasks set  title= #{title} , done = #{done} , do_date= #{doDate} where id = #{id}")
    void update(Task task);

    @Delete("delete from todo_app.tasks where id = #{id}")
    void delete(Task task);

    @Select("select * from todo_app.tasks t  where user_id = #{userId} order by id limit #{size} offset #{page} * #{size}")
    @Results(id = "id", value = {
            @Result(property = "title", column = "title", id = true, jdbcType = JdbcType.VARCHAR),
            @Result(property = "userId", column = "user_id", id = true, jdbcType = JdbcType.INTEGER),
            @Result(property = "doDate", column = "do_date", id = true, jdbcType = JdbcType.DATETIMEOFFSET),
            @Result(property = "done", column = "done", id = true, jdbcType = JdbcType.BOOLEAN)
    }
    )
    List<Task> findAll(int page, int size, long userId);
}
