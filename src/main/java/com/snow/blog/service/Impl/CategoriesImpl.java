package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.dto.CategoriesDetailDTO;
import com.snow.blog.entity.Categories;
import com.snow.blog.mappers.CategoriesMapper;
import com.snow.blog.service.CategoriesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoriesImpl extends ServiceImpl<CategoriesMapper, Categories>  implements CategoriesService {

    @Resource
    private CategoriesMapper categoriesMapper;

    @Override
    public List<Categories> getCategoriesList() {

        return categoriesMapper.selectCategoriesWithArticleCount();
    }

    @Override
    public CategoriesDetailDTO getCategoryDetail(Integer categoryId) {
        // 获取分类信息
        Categories category = this.getById(categoryId);
        if (category == null) {
            return null;
        }

        // 创建返回对象并设置基本信息
        CategoriesDetailDTO dto = new CategoriesDetailDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setCreatedAt(category.getCreatedAt());

        // 直接查询分类下的文章详情（使用新的mapper方法）
        List<CategoriesDetailDTO.ArticleDetailInfo> articleDetails = this.baseMapper.selectArticleDetailsByCategoryId(categoryId);

        // 按创建年份分组文章
        Map<Integer, List<CategoriesDetailDTO.ArticleDetailInfo>> articlesByYear = articleDetails.stream()
                .filter(article -> article.getCreatedAt() != null)
                .collect(Collectors.groupingBy(article -> article.getCreatedAt().getYear()));

        dto.setArticlesByYear(articlesByYear);

        return dto;
    }
}
