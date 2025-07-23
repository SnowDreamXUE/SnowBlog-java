package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.FriendLinks;
import com.snow.blog.mappers.FriendLinksMapper;
import com.snow.blog.service.FriendLinksService;
import org.springframework.stereotype.Service;

@Service
public class FriendLinksImpl extends ServiceImpl<FriendLinksMapper, FriendLinks> implements FriendLinksService {
}
