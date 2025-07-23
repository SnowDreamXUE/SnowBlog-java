package com.snow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("articles") // 指定表名，如果表名与类名不同，请修改为实际的表名
public class Articles {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title") // 如果数据库字段名不是title，请修改为实际的字段名
    private String title;

    @TableField("summary") // 如果数据库字段名不是summary，请修改为实际的字段名
    private String summary;

    @TableField("content") // 如果数据库字段名不是content，请修改为实际的字段名
    private String content;

    @TableField("cover_image") // 假设数据库字段名是cover_image
    private String coverImage;

    @TableField("view_count")
    private Integer viewCount;

    @TableField("word_count")
    private Integer wordCount;

    @TableField("reading_time")
    private String readingTime;

    @TableField("is_top")
    private  Integer isTop;

    @TableField("status")
    private String status;

    @TableField("published_at")
    private LocalDateTime publishedAt;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("updated_at")
    private  LocalDateTime updatedAt;
}
