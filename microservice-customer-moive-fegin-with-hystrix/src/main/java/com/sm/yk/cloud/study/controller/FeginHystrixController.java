package com.sm.yk.cloud.study.controller;

import com.sm.yk.cloud.study.entity.User;
import com.sm.yk.cloud.study.fegin.UserFeginHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youkai on 2017/9/13.
 */
@RestController
public class FeginHystrixController {
    @Autowired
    private UserFeginHystrixClient userFeignHystrixClient;

    @GetMapping("/fegin/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignHystrixClient.findByIdFeign(id);
    }
}
