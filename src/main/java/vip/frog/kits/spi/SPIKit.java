package vip.frog.kits.spi;


import java.util.List;

/**
 * SPI 工具类
 */
@SuppressWarnings({"JavaDoc", "unused"})
public interface SPIKit {

    /**
     * 获取所有 实现服务,没有返回空List
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T get(Class<T> clazz);


    /**
     * 获取所有 实现服务,没有返回空List
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> getAll(Class<T> clazz);

    /**
     * 获取所有实现中排序最高的, 没有返回 null
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getHighestOrder(Class<T> clazz);


}
