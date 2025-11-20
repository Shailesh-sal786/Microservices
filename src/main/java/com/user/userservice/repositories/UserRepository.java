package com.user.userservice.repositories;

import com.user.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    // if you want to implement any custom method or query, you can write here

}
