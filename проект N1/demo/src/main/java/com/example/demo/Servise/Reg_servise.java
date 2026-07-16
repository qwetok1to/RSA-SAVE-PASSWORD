package com.example.demo.Servise;

import java.net.InetAddress;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reg_servise {
    @Autowired
    Servise_DB servise_DB;
    public String generate_ID(){
    long timeComponent = System.currentTimeMillis();

    try {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String final_id=timeComponent + "-" + hostAddress + "-" + UUID.randomUUID();
        servise_DB.saveId(final_id);
        return final_id;
    }catch (Exception e) {
        
        return "error"+e;
    }
              
}
    
}
