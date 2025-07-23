package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.entity.Categories;
import com.snow.blog.mappers.CategoriesMapper;
import com.snow.blog.service.CategoriesService;
import org.springframework.stereotype.Service;

@Service
public class CategoriesImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {
}
