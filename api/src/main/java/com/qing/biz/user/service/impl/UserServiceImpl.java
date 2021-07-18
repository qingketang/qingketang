package com.qing.biz.user.service.impl;

import com.qing.biz.user.dao.UserRepository;
import com.qing.biz.user.entity.User;
import com.qing.biz.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
