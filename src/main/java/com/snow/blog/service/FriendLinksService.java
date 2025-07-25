package com.snow.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.blog.entity.FriendLinks;

import java.util.List;

public interface FriendLinksService extends IService<FriendLinks> {
    /**
     * 获取友链列表（状态为active的）
     * @return 友链列表
     */
    List<FriendLinks> getFriendLinksList();
}
