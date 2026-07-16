package com.example.demo.Rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User_password;

public interface User_Password_rep extends JpaRepository<User_password,Long>{
    List<User_password> findByUserId(String userId);
    User_password findByUserIdAndNamePassword(String userId, String namePassword);
    
}
