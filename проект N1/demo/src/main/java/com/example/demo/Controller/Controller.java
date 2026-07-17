package com.example.demo.Controller;

import java.security.KeyPair;
import java.util.List;

import com.example.demo.DTO.DTO;
import com.example.demo.DTO.DTO_Response;
import com.example.demo.DTO.DTO_USER;
import com.example.demo.Servise.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;




@RestController

public class Controller{
 
    @Autowired
    Servise_DB db;
     @Autowired
     Servise s;
    
    KeyPair k; 


       @PostMapping("/add_password")
    public ResponseEntity<String> login(@RequestBody DTO dto) {
            try {
            String pass = s.encrypt(dto.password, s.getPublicKey());
            db.savePassword(pass, dto.userId, dto.name_password);
            return ResponseEntity.ok(pass);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }

    @PostMapping("/get_password")
    public ResponseEntity<List<DTO_Response>> postMethodName(@RequestBody DTO dto) {
        if (dto == null || dto.userId == null || dto.userId.isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            List<DTO_Response> passwords = db.getAllPasswordsByUser(dto.userId, s.getPrivateKey());
            return ResponseEntity.ok(passwords);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
     


}   