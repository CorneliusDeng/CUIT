package com.jay.date.match.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Jay
 */
public class MatchTimeoutEvent extends ApplicationEvent {
    private final Integer userId;

    public MatchTimeoutEvent(Integer userId) {
        super(userId);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
