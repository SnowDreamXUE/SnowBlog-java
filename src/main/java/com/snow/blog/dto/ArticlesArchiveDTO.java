package com.snow.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 文章归档DTO - 按年份分组的文章归档信息
 */
@Data
public class ArticlesArchiveDTO {

    // 按年份分组的文章列表
    private Map<Integer, List<ArchiveArticleInfo>> articlesByYear;

    /**
     * 归档文章信息内部类
     */
    @Data
    public static class ArchiveArticleInfo {
        private Integer id;
        private String title;
        private LocalDateTime createdAt;
    }
}
