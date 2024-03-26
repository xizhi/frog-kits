package vip.frog.kits.spi.data;

import vip.frog.kits.spi.SPIOrder;

public class Demo2 {
    public interface MyInterface {

        default String test() {
            return String.format("my name is %s", getClass().getSimpleName());
        }
    }

    @SPIOrder(1)
    public static class MyImpl1 implements MyInterface {
    }

    @SPIOrder(2)
    public static class MyImpl2 implements MyInterface {
    }

    @SPIOrder(2)
    public static class MyImpl3 implements MyInterface {
    }
}
