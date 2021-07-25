package com.qing.api;

import com.qing.biz.user.entity.User;
import com.qing.biz.user.service.UserService;
import com.qing.core.base.BaseController;
import com.qing.core.exception.ServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
