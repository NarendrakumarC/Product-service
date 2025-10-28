package com.textile.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("times") int x){
        String str ="";
        for(int i=0;i<x;i++){
            str +="Hello "+ name+" !<br>";
        }
        return str;
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "Hi Narendra !";
    }
}
