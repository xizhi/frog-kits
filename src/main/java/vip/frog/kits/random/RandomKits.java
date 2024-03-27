package vip.frog.kits.random;


import vip.frog.kits.spi.KitFactory;

/**
 *
 */
public final class RandomKits {

    // @formatter:off
    /**
     * double 类型随机数工具类
     */
    public static NumberRandomKit number = KitFactory.createKit(
            NumberRandomKit.class,
            new DefaultNumberRandomKit());

    /**
     * int 类型随机数工具类
     */
    public static IntegerRandomKit integer = KitFactory.createKit(
            IntegerRandomKit.class,
            new DefaultIntegerRandomKit());

    /**
     * String 类型随机数工具类
     */
    public static StringRandomKit string = KitFactory.createKit(
            StringRandomKit.class,
            new DefaultStringRandomKit());

    // @formatter:on


}


