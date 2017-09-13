package com.sm.yk.cloud.study.controller;

import com.sm.yk.cloud.study.domain.User;
import com.sm.yk.cloud.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youkai on 2017/9/8.
 * @description 用户Controller
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        return discoveryClient.getLocalServiceInstance();
    }
}
