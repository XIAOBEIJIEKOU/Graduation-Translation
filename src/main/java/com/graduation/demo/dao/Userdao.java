package com.graduation.demo.dao;

import com.graduation.demo.model.User;

public interface Userdao {

    User login(User user);

    int register(User user);
}
