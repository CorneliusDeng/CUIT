package it.mall.build.common;

public class MallException extends RuntimeException {

    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    // 丢出一个异常
    public static void fail(String message) {
        throw new MallException(message);
    }

}
