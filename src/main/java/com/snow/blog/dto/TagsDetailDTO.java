package com.snow.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 标签详情DTO - 包含按年份分组的文章信息
 */
@Data
public class TagsDetailDTO {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;

    // 按年份分组的文章列表
    private Map<Integer, List<ArticleDetailInfo>> articlesByYear;

    /**
     * 文章详细信息内部类
     */
    @Data
    public static class ArticleDetailInfo {
        private Integer id;
        private String title;
        private LocalDateTime createdAt;  // 改为创建时间
    }
}
