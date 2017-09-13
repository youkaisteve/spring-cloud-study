package com.sm.yk.cloud.study.repository;

import com.sm.yk.cloud.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by youkai on 2017/9/8.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
