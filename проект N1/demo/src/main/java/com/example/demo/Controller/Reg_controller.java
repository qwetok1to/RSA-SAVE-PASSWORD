package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DTO_USER;
import com.example.demo.Servise.Reg_servise;
import com.example.demo.Servise.Servise;
import com.example.demo.Servise.Servise_DB;

import java.security.KeyPair;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
public class Reg_controller {
    @Autowired
    Servise s;
    @Autowired
    Reg_servise reg_servise;
    @Autowired
    Servise_DB servise_DB;

    @GetMapping("/getID")
    public ResponseEntity<String> getMethodName() {
     
                    
        return new ResponseEntity<>(reg_servise.generate_ID(),HttpStatus.OK);
  
    }
   @PostMapping("/reg_user")
    public ResponseEntity<String> postMethodName(@RequestBody DTO_USER dto) {
    return new ResponseEntity<>(servise_DB.getId(dto.userId),HttpStatus.OK);
}

    
}

