package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.ArticleTags;
import com.snow.blog.mappers.ArticleTagsMapper;
import com.snow.blog.service.ArticleTagsService;
import org.springframework.stereotype.Service;

@Service
public class ArticleTagsImpl extends ServiceImpl<ArticleTagsMapper, ArticleTags> implements ArticleTagsService {
}
