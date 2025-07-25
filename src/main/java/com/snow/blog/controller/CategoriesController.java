package com.snow.blog.controller;

import com.snow.blog.dto.CategoriesDetailDTO;
import com.snow.blog.entity.Categories;
import com.snow.blog.service.CategoriesService;
import com.snow.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    /**
     * 获取所有分类列表
     * @return 分类列表
     */
    @GetMapping("/list")
    public Result<List<Categories>> getCategoriesList() {
        List<Categories> CategoriesList = categoriesService.getCategoriesList();
        return Result.success(CategoriesList);
    }

    /**
     * 获取分类详情，包含该分类下的文章ID、标题和时间
     * @param id 分类ID
     * @return 分类详情
     */
    @GetMapping("/{id}")
    public Result<CategoriesDetailDTO> getCategoryDetail(@PathVariable("id") Integer id) {
        CategoriesDetailDTO categoryDetail = categoriesService.getCategoryDetail(id);
        if (categoryDetail == null) {
            return Result.error("分类不存在");
        }
        return Result.success(categoryDetail);
    }
}
