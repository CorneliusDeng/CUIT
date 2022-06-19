package com.jay.date.match.event;

import com.jay.date.mapper.MatchingMapper;
import com.jay.date.match.MessageSender;
import com.jay.date.match.pool.MatchPoolUserInfo;
import com.jay.date.model.dto.MatchedUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 匹配成功事件监听器
 * @author Jay
 */
@Component
public class MatchSuccessEventListener implements ApplicationListener<MatchSuccessEvent> {

    private final MatchingMapper matchingMapper;
    private final MessageSender messageSender;
    private final Logger logger;
    @Autowired
    public MatchSuccessEventListener(MatchingMapper matchingMapper, MessageSender messageSender) {
        this.matchingMapper = matchingMapper;
        this.messageSender = messageSender;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onApplicationEvent(MatchSuccessEvent matchSuccessEvent) {
        MatchPoolUserInfo currentUser = matchSuccessEvent.getUser1();
        MatchPoolUserInfo first = matchSuccessEvent.getUser2();

        MatchedUserDTO currentUserDTO = matchingMapper.getMatchedUserInfo(currentUser.getUserId());
        MatchedUserDTO firstUserDTO = matchingMapper.getMatchedUserInfo(first.getUserId());
        logger.info(currentUserDTO.toString());
        // 发送匹配成功反馈
        messageSender.sendResponse(first.getUserId(), 2, "匹配成功", currentUserDTO);
        messageSender.sendResponse(currentUser.getUserId(), 2, "匹配成功", firstUserDTO);
        logger.info("已发送匹配成功反馈，userId={},{}", first.getUserId(), currentUser.getUserId());
    }
}
