package com.example.demo.Rep;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Entity.Id_entity;

public interface User_rep  extends JpaRepository<Id_entity,Long>{
     Id_entity findByUserId(String userId);

    
} 