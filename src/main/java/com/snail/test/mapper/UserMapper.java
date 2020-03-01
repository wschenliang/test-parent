package com.snail.test.mapper;

import com.snail.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User getUserByName(@Param("name") String name);

    List<User> getAllUsers();
}