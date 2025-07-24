package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.dto.ArticlesArchiveDTO;
import com.snow.blog.dto.ArticlesDTO;
import com.snow.blog.entity.Articles;
import com.snow.blog.entity.Categories;
import com.snow.blog.entity.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文章Mapper接口
 */
@Mapper
public interface ArticlesMapper extends BaseMapper<Articles> {

    /**
     * 查询所有文章及其关联的分类和标签
     */
    @Select("SELECT * FROM articles ORDER BY created_at DESC")
    List<Articles> selectAllArticles();

    /**
     * 根据文章ID查询关联的分类
     */
    @Select("SELECT c.* FROM categories c " +
            "INNER JOIN article_categories ac ON c.id = ac.category_id " +
            "WHERE ac.article_id = #{articleId}")
    List<Categories> selectCategoriesByArticleId(@Param("articleId") Integer articleId);

    /**
     * 根据文章ID查询关联的标签
     */
    @Select("SELECT t.* FROM tags t " +
            "INNER JOIN article_tags at ON t.id = at.tag_id " +
            "WHERE at.article_id = #{articleId}")
    List<Tags> selectTagsByArticleId(@Param("articleId") Integer articleId);

    /**
     * 分页查询文章列表（支持标题和状态筛选）
     * @param page 分页参数
     * @param title 标题关键词
     * @param status 文章状态
     * @return 分页结果
     */
    @Select("<script>" +
            "SELECT * FROM articles " +
            "WHERE 1=1 " +
            "<if test='title != null and title != \"\"'>" +
            "AND title LIKE CONCAT('%', #{title}, '%') " +
            "</if>" +
            "<if test='status != null and status != \"\"'>" +
            "AND status = #{status} " +
            "</if>" +
            "ORDER BY is_top DESC, created_at DESC " +
            "</script>")
    IPage<Articles> selectArticlesPage(Page<Articles> page, @Param("title") String title, @Param("status") String status);

    /**
     * 分页查询已发布的文章（前台使用）
     * @param page 分页参数
     * @param title 标题关键词
     * @return 分页结果
     */
    @Select("<script>" +
            "SELECT * FROM articles " +
            "WHERE status = 'published' " +
            "<if test='title != null and title != \"\"'>" +
            "AND title LIKE CONCAT('%', #{title}, '%') " +
            "</if>" +
            "ORDER BY is_top DESC, published_at DESC" +
            "</script>")
    IPage<Articles> selectPublishedPage(Page<Articles> page, @Param("title") String title);

    /**
     * 查询所有已发布文章的归档信息（用于归档页面）
     * @return 文章归档信息列表
     */
    @Select("SELECT a.id, a.title, a.created_at FROM articles a " +
            "WHERE a.status = 'published' " +
            "ORDER BY a.created_at DESC")
    List<ArticlesArchiveDTO.ArchiveArticleInfo> selectArchiveArticles();
}
