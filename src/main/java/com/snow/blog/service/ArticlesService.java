package com.snow.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.entity.Articles;

import java.util.List;

public interface ArticlesService {

    List<Articles> findAll();

    /**
     * 分页查询文章列表
     * @param page 分页对象
     * @param title 标题（可选，用于搜索）
     * @param status 状态（可选）
     * @return 分页结果
     */
    IPage<Articles> findByPage(Page<Articles> page, String title, String status);
}
