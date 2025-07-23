package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snow.blog.entity.Articles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 文章Mapper接口
 */
@Mapper
public interface ArticlesMapper extends BaseMapper<Articles> {

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
            "ORDER BY created_at DESC" +
            "</script>")
    IPage<Articles> selectPageWithConditions(Page<Articles> page,
                                           @Param("title") String title,
                                           @Param("status") String status);

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
}
