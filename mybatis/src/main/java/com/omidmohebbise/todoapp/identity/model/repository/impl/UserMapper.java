package com.omidmohebbise.todoapp.identity.model.repository.impl;

import com.omidmohebbise.todoapp.identity.model.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Optional;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findUserByUsername(String username);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(long id);

    @Insert("insert into users " +
            "(active, first_name, last_name, last_refresh, password, remember_me, username)" +
            "values (#{active},#{firstName},#{lastName},#{lastRefresh},#{password},#{rememberMe},#{username});")
    void insert(User user);

    @Update("update users set  remember_me= #{rememberMe} , token = #{token}, last_refresh = #{lastRefresh} where id = #{id}")
    void update(User user);
}
