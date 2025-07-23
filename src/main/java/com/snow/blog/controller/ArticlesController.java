package com.snow.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.entity.Articles;
import com.snow.blog.service.ArticlesService;
import com.snow.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Resource
    private ArticlesService articlesService;

    @GetMapping("/listAll")
    public Result<?> listAll() {
        return Result.success(articlesService.findAll());
    }

    /**
     * 分页查询文章列表
     * @param currentPage 当前页码
     * @param pageSize 每页大小
     * @param title 标题关键词（可选）
     * @param status 状态（可选）
     * @return 分页结果
     */
    @GetMapping("/page")
    public Result<IPage<Articles>> page(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String status) {

        // 创建分页对象
        Page<Articles> page = new Page<>(currentPage, pageSize);

        // 调用服务层方法执行分页查询
        IPage<Articles> pageData = articlesService.findByPage(page, title, status);

        // 返回结果
        return Result.success(pageData);
    }
}
