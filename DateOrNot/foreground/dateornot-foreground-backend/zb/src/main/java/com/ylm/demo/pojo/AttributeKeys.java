package com.ylm.demo.pojo;

import io.netty.util.AttributeKey;

/**
 * AttributeKeys工具类，存储所有绑定在channel上的属性
 * channel通过AttributeKeys绑定userID，就可以通过channel取到他所属用户的id
 */
public class AttributeKeys {
    public static AttributeKey<Integer> USER_ID = AttributeKey.newInstance("userID");
}
