package com.snow.blog.dto;

import com.snow.blog.entity.Categories;
import com.snow.blog.entity.Tags;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticlesDTO {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String coverImage;
    private Integer viewCount;
    private Integer wordCount;
    private String readingTime;
    private Integer isTop;
    private String status;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 关联的分类列表
    private List<Categories> categories;

    // 关联的标签列表
    private List<Tags> tags;
}
