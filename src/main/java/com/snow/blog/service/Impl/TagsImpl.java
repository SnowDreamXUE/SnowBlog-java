package com.snow.blog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.blog.dto.TagsDetailDTO;
import com.snow.blog.entity.Tags;
import com.snow.blog.mappers.TagsMapper;
import com.snow.blog.service.TagsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagsImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

    @Resource
    private TagsMapper tagsMapper;

    @Override
    public List<Tags> getTagsList() {
        // 直接查询所有标签实体
        return tagsMapper.selectAllTags();
    }

    @Override
    public TagsDetailDTO getTagDetail(Integer id) {
        // 根据ID查询标签基本信息
        Tags tag = tagsMapper.selectById(id);
        if (tag == null) {
            return null;
        }

        // 转换为TagsDetailDTO并查询关联的文章详情
        return convertToTagsDetailDTO(tag);
    }

    /**
     * 将Tags实体转换为TagsDetailDTO（包含按年份分组的文章）
     *
     * @param tag 标签实体
     * @return 包含按年份分组文章的标签详情DTO
     */
    private TagsDetailDTO convertToTagsDetailDTO(Tags tag) {
        TagsDetailDTO dto = new TagsDetailDTO();

        // 复制基本属性
        BeanUtils.copyProperties(tag, dto);

        // 查询关联的文章详细信息
        List<TagsDetailDTO.ArticleDetailInfo> articles = tagsMapper.selectArticleDetailsByTagId(tag.getId());

        // 按创建年份分组文章
        Map<Integer, List<TagsDetailDTO.ArticleDetailInfo>> articlesByYear = articles.stream()
                .filter(article -> article.getCreatedAt() != null)
                .collect(Collectors.groupingBy(article -> article.getCreatedAt().getYear()));

        dto.setArticlesByYear(articlesByYear);

        return dto;
    }
}
