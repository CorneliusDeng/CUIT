package com.jay.date.match.event;

import com.jay.date.match.pool.MatchPoolUserInfo;
import org.springframework.context.ApplicationEvent;

/**
 * 匹配成功事件
 * @author Jay
 */
public class MatchSuccessEvent extends ApplicationEvent {

    private final MatchPoolUserInfo user1;
    private final MatchPoolUserInfo user2;

    public MatchSuccessEvent(MatchPoolUserInfo user1, MatchPoolUserInfo user2) {
        super(user1);
        this.user1 = user1;
        this.user2 = user2;
    }

    public MatchPoolUserInfo getUser1() {
        return user1;
    }

    public MatchPoolUserInfo getUser2() {
        return user2;
    }
}
