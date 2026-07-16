package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User_password {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "id_user",columnDefinition = "TEXT")
    public String userId;
    @Column(name = "name_password", columnDefinition = "TEXT")
    public String namePassword;
     @Column(name = "password", columnDefinition = "TEXT")
    public String password;
    
}
