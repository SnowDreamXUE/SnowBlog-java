package com.snow.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.blog.dto.CategoriesDetailDTO;
import com.snow.blog.entity.Categories;

import java.util.List;

public interface CategoriesService extends IService<Categories> {
    /**
     * 获取所有分类及其包含的文章ID和标题
     * @return 分类列表，包含文章信息
     */
    List<Categories> getCategoriesList();

    /**
     * 根据分类ID获取分类详情，包含文章ID、标题和时间
     * @param categoryId 分类ID
     * @return 分类详情，包含文章信息
     */
    CategoriesDetailDTO getCategoryDetail(Integer categoryId);
}
