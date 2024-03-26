package vip.frog.kits.spi.data;

public class Demo1 {

    public interface MyInterface {

        default String test(){
            return String.format("my name is %s", getClass().getSimpleName());
        }
    }

    public static class MyImpl implements MyInterface {

    }
}
