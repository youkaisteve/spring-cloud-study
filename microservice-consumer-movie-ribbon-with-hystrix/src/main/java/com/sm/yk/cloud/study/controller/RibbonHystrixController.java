package com.sm.yk.cloud.study.controller;

import com.sm.yk.cloud.study.entity.User;
import com.sm.yk.cloud.study.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youkai on 2017/9/12.
 */
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonHystrixService.findById(id);
    }
}
