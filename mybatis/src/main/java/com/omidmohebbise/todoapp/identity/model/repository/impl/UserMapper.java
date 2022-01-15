package com.omidmohebbise.todoapp.identity.model.repository.impl;

import com.omidmohebbise.todoapp.identity.model.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Optional;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM identity.users WHERE username = #{username}")
    User findUserByUsername(String username);

    @Select("SELECT * FROM identity.users WHERE id = #{id}")
    Optional<User> findById(long id);

    @Insert("insert into identity.users " +
            "( first_name, last_name, expire_date, password_, remember_me, username)" +
            "values (#{firstName},#{lastName},#{expireDate},#{password},#{rememberMe},#{username});" +
            "insert into identity.users_roles(user_id, role_id) values ((select last_value from  identity.users_id_seq), (select id from identity.roles where title = 'USER_ROLE'));")
    void insert(User user);

    @Update("update identity.users set  remember_me= #{rememberMe} , token = #{token}, expire_date = #{expireDate} where id = #{id}")
    void update(User user);
}
