package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.entity.ArticleTags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleTagsMapper extends BaseMapper<ArticleTags> {
}
