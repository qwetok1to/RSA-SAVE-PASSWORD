package com.example.demo.Servise;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTO_Response;
import com.example.demo.Entity.Id_entity;
import com.example.demo.Rep.User_Password_rep;
import com.example.demo.Rep.User_rep;
import com.example.demo.Entity.User_password;

@Service
public class Servise_DB {

    @Autowired
    User_rep rep;
    @Autowired
    User_Password_rep passwordRep;
    @Autowired
    Servise s;

     public String saveId(String userId){
        Id_entity e = new Id_entity();
        e.userId = userId;
        rep.save(e);
        return "Id appended " + userId;
    }

    public String getId(String userId){
    Id_entity entity = rep.findByUserId(userId);
    if (entity == null) {
        System.out.println("User with ID " + userId + " not found.");
        return "not found";
    }
    return "OK";
    }
   public String savePassword(String pass, String userId, String name_password) {
    User_password entry = new User_password();
    entry.userId = userId;
    entry.namePassword = name_password;
    entry.password = pass;
    passwordRep.save(entry);
    return "saved";
}
    public List<DTO_Response> getAllPasswordsByUser(String userId, PrivateKey privateKey) throws Exception {
    List<User_password> entries = passwordRep.findByUserId(userId);

    List<DTO_Response> result = new ArrayList<>();
    for (User_password entry : entries) {
        result.add(new DTO_Response(
                entry.namePassword,
                s.decrypt(entry.password, privateKey)
        ));
    }

    return result;
}
}