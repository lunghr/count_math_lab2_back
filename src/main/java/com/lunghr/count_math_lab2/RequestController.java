package com.lunghr.count_math_lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @PostMapping("/data")
    public void receiveData(@RequestBody String str){
        System.out.println("Data:" + str);
    }

    @GetMapping("/req")
    public String simpleGetReq(){
        return "req was cathced";
    }
}
