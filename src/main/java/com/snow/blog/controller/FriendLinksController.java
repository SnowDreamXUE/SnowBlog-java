package com.snow.blog.controller;

import com.snow.blog.service.FriendLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/friend-links")
public class FriendLinksController {

    @Resource
    private FriendLinksService friendLinksService;
}
