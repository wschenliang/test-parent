package com.snail.test.service;

import com.snail.test.pojo.User;

import java.util.List;

public interface IUserService {
    User getUserByName(String name);

    List<User> getAllUsers();

    void saveTestToMongo();

    void saveTestToEs();

}
