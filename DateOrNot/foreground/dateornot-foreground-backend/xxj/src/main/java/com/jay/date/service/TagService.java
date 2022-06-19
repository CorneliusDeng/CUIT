package com.jay.date.service;

import com.jay.date.model.entity.TagDO;

import java.util.List;

/**
 * @author Jay
 */
public interface TagService {
    /**
     * 随机获取一定数量的标签
     * @param limit 数量
     * @return 随机标签
     */
    List<TagDO> getRandomTags(Integer limit);

    /**
     * 添加用户自定义标签
     * @param content 标签内容
     * @return 添加状态
     */
    Integer saveNewTag(String content);

    /**
     * 获取用户所有标签
     * @param userId 用户id
     * @return 用户标签集合
     */
    List<String> getUserTags(Integer userId);

    /**
     * 获取用户所有标签的id
     * @param userId 用户id
     * @return 用户标签
     */
    List<Integer> getUserTagIds(Integer userId);
}
