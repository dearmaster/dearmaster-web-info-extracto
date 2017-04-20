package com.master.wie.controller;

import com.master.wie.log.LoggerFactory;
import com.master.wie.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger();

    private UserService userService;

}