package com.snow.blog.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.blog.entity.FriendLinks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendLinksMapper extends BaseMapper<FriendLinks> {

    /**
     * 查询所有状态为ACTIVE的友链，并按sortOrder排序
     * @return 友链列表
     */
    @Select("SELECT * FROM friend_links WHERE status = 'active' ORDER BY sort_order ASC")
    List<FriendLinks> selectActiveFriendLinks();
}
