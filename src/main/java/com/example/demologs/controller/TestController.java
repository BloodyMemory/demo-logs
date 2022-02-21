package com.example.demologs.controller;

import com.example.demologs.except.NormalException;
import com.example.demologs.except.SystemException;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test1/{id}")
    public String test1(@PathVariable(value = "id", required = false) String id) {
        if ("100".equals(id)) {
            MDC.put("bizType","AAABiz");
            throw new NormalException("An Normal Exception");
        } else if ("0".equals(id)) {
            MDC.put("bizType","CCCBiz");
            throw new SystemException("An System Exception");
        }
        return "test1";
    }
}
