package com.snow.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.dto.ArticlesDTO;
import com.snow.blog.dto.ArticlesListDTO;
import com.snow.blog.dto.ArticlesArchiveDTO;

import java.util.List;

public interface ArticlesService {

    List<ArticlesListDTO> findAll();

    /**
     * 分页查询文章列表（不包含文章内容）
     * @param page 分页对象
     * @param title 标题（可选，用于搜索）
     * @param status 状态（可选）
     * @return 分页结果
     */
    IPage<ArticlesListDTO> getArticlesList(Page<ArticlesListDTO> page, String title, String status);

    /**
     * 根据ID获取文章详情（包含完整内容）
     * @param id 文章ID
     * @return 文章详情
     */
    ArticlesDTO getArticleDetail(Integer id);

    /**
     * 获取文章归档信息（按年份分组）
     * @return 文章归档信息
     */
    ArticlesArchiveDTO getArticlesArchive();
}
