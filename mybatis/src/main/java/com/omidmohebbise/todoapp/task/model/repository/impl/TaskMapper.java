package com.omidmohebbise.todoapp.task.model.repository.impl;

import com.omidmohebbise.todoapp.task.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TaskMapper {


    @Select("SELECT * FROM tasks WHERE id = #{id}")
    Task findById(long id);

    @Insert("insert into tasks (do_date, done, title, user_id) values (#{doDate} , #{done}, #{title}, #{userId});")
    long insert(Task task);

    @Select("SELECT * FROM tasks WHERE id = #{id} and user_id = #{userId}")
    Task findByIdAndUserId(long id, long userId);

    @Update("update tasks set  title= #{title} , done = #{done} , do_date= #{doDate} where id = #{id}")
    void update(Task task);

    @Delete("delete from tasks where id = #{id}")
    void delete(Task task);

    @Select("select * from tasks t  order by id limit #{size} offset #{page} * #{size}")
    List<Task> findAll(int page, int size);
}
