package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagsMapper extends BaseMapper<Tags> {
}
