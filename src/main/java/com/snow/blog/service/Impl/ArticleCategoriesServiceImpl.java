package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.ArticleCategories;
import com.snow.blog.mappers.ArticleCategoriesMapper;
import com.snow.blog.service.ArticleCategoriesService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoriesServiceImpl extends ServiceImpl<ArticleCategoriesMapper, ArticleCategories> implements ArticleCategoriesService {
}
