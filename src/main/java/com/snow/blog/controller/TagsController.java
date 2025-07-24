package com.snow.blog.controller;

import com.snow.blog.dto.TagsDetailDTO;
import com.snow.blog.entity.Tags;
import com.snow.blog.service.TagsService;
import com.snow.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    /**
     * 获取标签列表（直接返回Tags实体）
     * @return 标签基本信息列表
     */
    @GetMapping("/list")
    public Result<List<Tags>> getTagsList() {
        List<Tags> tags = tagsService.getTagsList();
        return Result.success(tags);
    }

    /**
     * 根据ID获取标签详情（包含按年份分组的文章信息，文章时间为创建时间）
     * @param id 标签ID
     * @return 标签详情
     */
    @GetMapping("/{id}")
    public Result<TagsDetailDTO> getTagDetail(@PathVariable Integer id) {
        TagsDetailDTO tagDetail = tagsService.getTagDetail(id);
        if (tagDetail == null) {
            return Result.failed("标签不存在");
        }
        return Result.success(tagDetail);
    }
}
