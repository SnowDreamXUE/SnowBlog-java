package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.Tags;
import com.snow.blog.mappers.TagsMapper;
import com.snow.blog.service.TagsService;
import org.springframework.stereotype.Service;

@Service
public class TagsImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {
}
