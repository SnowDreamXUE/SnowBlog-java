package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoriesMapper extends BaseMapper<Categories> {
}
