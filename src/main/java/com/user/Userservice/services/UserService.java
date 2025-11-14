package com.user.Userservice.services;


import com.user.Userservice.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);



}
