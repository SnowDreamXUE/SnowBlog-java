package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.FriendLinks;
import com.snow.blog.mappers.FriendLinksMapper;
import com.snow.blog.service.FriendLinksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendLinksServiceImpl extends ServiceImpl<FriendLinksMapper, FriendLinks> implements FriendLinksService {

    @Resource
    private FriendLinksMapper friendLinksMapper;

    @Override
    public List<FriendLinks> getFriendLinksList() {
        // 调用 Mapper 层方法获取 ACTIVE 状态的友链列表
        return friendLinksMapper.selectActiveFriendLinks();
    }
}
