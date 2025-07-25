package com.snow.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 分类详情DTO - 包含按年份分组的文章信息
 */
@Data
public class CategoriesDetailDTO {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;

    // 按年份分组的文章列表，键为年份（如2023），值为该年份的文章列表
    private Map<Integer, List<ArticleDetailInfo>> articlesByYear;

    @Data
    public static class ArticleDetailInfo {
        private Integer id;
        private String title;
        private LocalDateTime createdAt;
    }
}
