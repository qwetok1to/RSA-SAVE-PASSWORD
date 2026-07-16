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
 
    public Controller(Servise s) {
        try{
        k=s.generateKeyPair();
        }catch(Exception e){

        }
    }
      
 

   
    @PostMapping("/add_password")
     public ResponseEntity<String> login( @RequestBody DTO dto){
        String pass="";
       
        try{

   
          pass =s.encrypt(dto.password, k.getPublic());
          System.out.println("Encrypted password: " + pass);
          db.savePassword(pass, dto.userId, dto.name_password);
          
          
          return ResponseEntity.ok(pass);
        }catch(Exception e){
            System.out.print("error" + e );    
            
        }
         return  ResponseEntity.badRequest().body("error: ");
     }
     @PostMapping("/get_password")
     public ResponseEntity< List<DTO_Response>>postMethodName(@RequestBody DTO dto  ) {
      
     try {
        List<DTO_Response> passwords = db.getAllPasswordsByUser(dto.userId, k.getPrivate());
        return ResponseEntity.ok(passwords);
    } catch (Exception e) {
        System.out.print("error" + e);
        return ResponseEntity.badRequest().body(null);
    }
        
         
         
     
    }
    
     


}   