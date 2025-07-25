package com.snow.blog.controller;

import com.snow.blog.entity.FriendLinks;
import com.snow.blog.service.FriendLinksService;
import com.snow.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/friend-links")
public class FriendLinksController {

    @Resource
    private FriendLinksService friendLinksService;

    /**
     * 获取友链列表
     * @return 友链列表
     */
    @GetMapping("/list")
    public Result<List<FriendLinks>> getFriendLinksList() {
        List<FriendLinks> friendLinks = friendLinksService.getFriendLinksList();
        return Result.success(friendLinks);
    }
}
