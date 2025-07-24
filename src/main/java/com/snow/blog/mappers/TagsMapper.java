package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.dto.TagsDetailDTO;
import com.snow.blog.entity.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagsMapper extends BaseMapper<Tags> {

    /**
     * 查询所有标签基本信息
     * @return 标签列表
     */
    @Select("SELECT t.id, t.name, t.created_at FROM tags t ORDER BY t.created_at DESC")
    List<Tags> selectAllTags();

    /**
     * 根据标签ID查询关联的文章详细信息（包含创建时间）
     * @param tagId 标签ID
     * @return 文章详细信息列表
     */
    @Select("SELECT a.id, a.title, a.created_at FROM articles a " +
            "INNER JOIN article_tags at ON a.id = at.article_id " +
            "WHERE at.tag_id = #{tagId} " +
            "AND a.status = 'published' " +
            "ORDER BY a.created_at DESC")
    List<TagsDetailDTO.ArticleDetailInfo> selectArticleDetailsByTagId(Integer tagId);
}
