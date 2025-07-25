package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.dto.CategoriesDetailDTO;
import com.snow.blog.entity.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoriesMapper extends BaseMapper<Categories> {
    
    /**
     * 根据分类ID查询该分类下所有文章的详细信息（ID、标题、创建时间）
     * @param categoryId 分类ID
     * @return 文章详细信息列表
     */
    @Select("SELECT a.id, a.title, a.created_at FROM articles a " +
            "INNER JOIN article_categories ac ON a.id = ac.article_id " +
            "WHERE ac.category_id = #{categoryId} " +
            "ORDER BY a.created_at DESC")
    List<CategoriesDetailDTO.ArticleDetailInfo> selectArticleDetailsByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * 查询所有分类以及每个分类下的文章数量
     * @return 包含文章数量的分类列表
     */
    @Select("SELECT c.*, COUNT(ac.article_id) AS article_count " +
            "FROM categories c " +
            "LEFT JOIN article_categories ac ON c.id = ac.category_id " +
            "GROUP BY c.id " +
            "ORDER BY c.id")
    List<Categories> selectCategoriesWithArticleCount();
}
