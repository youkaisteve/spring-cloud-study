package com.sm.yk.cloud.study.fegin;

import com.sm.yk.cloud.study.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youkai on 2017/9/13.
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeginHystrixClient.HystrixClientFallback.class)
public interface UserFeginHystrixClient {
    @RequestMapping("/{id}")
    User findByIdFeign(@RequestParam("id") Long id);

    @Component
    static class HystrixClientFallback implements UserFeginHystrixClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        @Override
        public User findByIdFeign(Long id) {
            HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default fegin username");
            user.setAge(0);
            return user;
        }
    }
}
