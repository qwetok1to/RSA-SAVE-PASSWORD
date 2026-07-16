package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Id_entity {
       @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "id_user")
    public String userId;
   
    
}
