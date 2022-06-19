package com.jay.date.match.event;

import com.jay.date.match.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Jay
 */
@Component
public class MatchTimeoutEventListener implements ApplicationListener<MatchTimeoutEvent> {

    private final MessageSender messageSender;
    private static final int TIMEOUT_CODE = 1;
    @Autowired
    public MatchTimeoutEventListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void onApplicationEvent(MatchTimeoutEvent matchTimeoutEvent) {
        Integer userId = matchTimeoutEvent.getUserId();
        // 发送超时反馈
        messageSender.sendResponse(userId, TIMEOUT_CODE, "匹配超时", null);
    }
}
