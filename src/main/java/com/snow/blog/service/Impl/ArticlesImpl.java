package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.entity.Articles;
import com.snow.blog.mappers.ArticlesMapper;
import com.snow.blog.service.ArticlesService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticlesImpl implements ArticlesService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public List<Articles> findAll() {
        return articlesMapper.selectList(null);
    }

    @Override
    public IPage<Articles> findByPage(Page<Articles> page, String title, String status) {
        LambdaQueryWrapper<Articles> queryWrapper = new LambdaQueryWrapper<>();

        // 添加标题模糊查询条件（如果提供了标题参数）
        if (StringUtils.hasText(title)) {
            queryWrapper.like(Articles::getTitle, title);
        }

        // 添加状态查询条件（如果提供了状态参数）
        if (StringUtils.hasText(status)) {
            queryWrapper.eq(Articles::getStatus, status);
        }

        // 默认按创建时间倒序排序
        queryWrapper.orderByDesc(Articles::getCreatedAt);

        // 执行分页查询
        return articlesMapper.selectPage(page, queryWrapper);
    }
}
