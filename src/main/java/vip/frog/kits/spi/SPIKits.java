package vip.frog.kits.spi;


import java.util.List;

/**
 * SPI 工具类
 */
@SuppressWarnings({"JavaDoc", "unused"})
public final class SPIKits {


    private static final SPIKit kit = SPIKitSettings.getSpiKit();

    /**
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(Class<T> clazz) {
        return kit.get(clazz);
    }


    /**
     * 获取所有 实现服务,没有返回空List
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getAll(Class<T> clazz) {
        return kit.getAll(clazz);
    }

    /**
     * 获取所有实现中排序最高的, 没有返回 null
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getHighestOrder(Class<T> clazz) {
        return kit.getHighestOrder(clazz);
    }


    //
    //
    //
    private SPIKits() {
    }
}


