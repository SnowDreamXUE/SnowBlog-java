package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.dto.ArticlesDTO;
import com.snow.blog.dto.ArticlesListDTO;
import com.snow.blog.entity.Articles;
import com.snow.blog.entity.Categories;
import com.snow.blog.entity.Tags;
import com.snow.blog.mappers.ArticlesMapper;
import com.snow.blog.service.ArticlesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticlesImpl implements ArticlesService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public List<ArticlesListDTO> findAll() {
        List<Articles> articles = articlesMapper.selectAllArticles();
        return articles.stream().map(this::convertToListDTO).collect(Collectors.toList());
    }

    @Override
    public IPage<ArticlesListDTO> getArticlesList(Page<ArticlesListDTO> page, String title, String status) {
        // 创建Articles的分页对象
        Page<Articles> articlesPage = new Page<>(page.getCurrent(), page.getSize());

        // 执行分页查询
        IPage<Articles> articlesResult = articlesMapper.selectArticlesPage(articlesPage, title, status);

        // 转换为ListDTO
        List<ArticlesListDTO> dtoList = articlesResult.getRecords().stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());

        // 创建DTO分页结果
        Page<ArticlesListDTO> dtoPage = new Page<>(page.getCurrent(), page.getSize());
        dtoPage.setRecords(dtoList);
        dtoPage.setTotal(articlesResult.getTotal());
        dtoPage.setPages(articlesResult.getPages());

        return dtoPage;
    }

    @Override
    public ArticlesDTO getArticleDetail(Integer id) {
        Articles article = articlesMapper.selectById(id);
        if (article == null) {
            return null;
        }
        return convertToDTO(article);
    }

    /**
     * 将Articles实体转换为ArticlesDTO（包含完整内容）
     */
    private ArticlesDTO convertToDTO(Articles article) {
        ArticlesDTO dto = new ArticlesDTO();

        // 复制基本属性
        BeanUtils.copyProperties(article, dto);

        // 查询并设置关联的分类
        List<Categories> categories = articlesMapper.selectCategoriesByArticleId(article.getId());
        dto.setCategories(categories);

        // 查询并设置关联的标签
        List<Tags> tags = articlesMapper.selectTagsByArticleId(article.getId());
        dto.setTags(tags);

        return dto;
    }

    /**
     * 将Articles实体转换为ArticlesListDTO（不包含文章内容）
     */
    private ArticlesListDTO convertToListDTO(Articles article) {
        ArticlesListDTO dto = new ArticlesListDTO();

        // 复制基本属性（不包含content）
        BeanUtils.copyProperties(article, dto);

        // 查询并设置关联的分类
        List<Categories> categories = articlesMapper.selectCategoriesByArticleId(article.getId());
        dto.setCategories(categories);

        // 查询并设置关联的标签
        List<Tags> tags = articlesMapper.selectTagsByArticleId(article.getId());
        dto.setTags(tags);

        return dto;
    }
}
