package com.jay.date.service.impl;

import com.jay.date.mapper.TagMapper;
import com.jay.date.model.entity.TagDO;
import com.jay.date.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Jay
 */
@Service
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;
    private final RedisTemplate<String, String> redisTemplate;

    private static final int DEFAULT_RANDOM_LIMIT = 30;
    private static final int TAG_CONTENT_MAX_LENGTH = 6;
    @Autowired
    public TagServiceImpl(TagMapper tagMapper, RedisTemplate<String, String> redisTemplate) {
        this.tagMapper = tagMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<TagDO> getRandomTags(Integer limit) {
        if(limit == null || limit <= 0 || limit > DEFAULT_RANDOM_LIMIT){
            limit = DEFAULT_RANDOM_LIMIT;
        }
        return tagMapper.randomTags(limit);
    }

    @Override
    public Integer saveNewTag(String content) {
        if(content == null || content.length() == 0 || content.length() > TAG_CONTENT_MAX_LENGTH){
            throw new IllegalArgumentException("添加新标签参数错误");
        }
        return tagMapper.saveTag(content);
    }

    @Override
    public List<String> getUserTags(Integer userId) {
        if(userId == null || userId < 0){
            throw new IllegalArgumentException("获取标签参数错误");
        }
        return tagMapper.getUserTags(userId);
    }

    @Override
    public List<Integer> getUserTagIds(Integer userId) {
        List<Integer> result;
        result = tagMapper.getUserTagIds(userId);
        return result;
    }
}
