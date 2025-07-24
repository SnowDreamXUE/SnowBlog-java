package com.snow.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.blog.dto.TagsDetailDTO;
import com.snow.blog.entity.Tags;

import java.util.List;

public interface TagsService extends IService<Tags> {

    /**
     * 获取标签列表（直接返回Tags实体）
     * @return 标签基本信息列表
     */
    List<Tags> getTagsList();

    /**
     * 根据ID获取标签详情（包含按年份分组的文章信息）
     * @param id 标签ID
     * @return 标签详情
     */
    TagsDetailDTO getTagDetail(Integer id);
}
