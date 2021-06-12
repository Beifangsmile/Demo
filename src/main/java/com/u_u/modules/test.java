package com.u_u.modules;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class test {

    @GetMapping("/t")
    public Map<String,Object> test(HttpServletRequest servletRequest){
        Map<String,Object> map = new HashMap<>();
        map.put("test1","aaa");
        System.out.println("testaaaaaaaaaaaa");
        return map;
    }
}
