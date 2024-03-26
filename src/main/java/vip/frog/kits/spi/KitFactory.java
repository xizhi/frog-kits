package vip.frog.kits.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 工具类创建工厂
 * </p>
 *
 * <p>
 * 工具类spi实现
 *
 * </p>
 */
@SuppressWarnings({"unchecked", "unused", "JavaDoc"})
public class KitFactory {

    private static final Logger log = LoggerFactory.getLogger(KitFactory.class);

    /**
     * 创建 工具类 示例
     *
     * @param clazz
     * @param defaultObject
     * @param <T>
     * @return
     */
    public static <T> T createKit(Class<T> clazz, T defaultObject) {
        T r = null;
        try {
            r = SPIKits.get(clazz);
        } catch (Exception e) {
            log.error("", e);
        }
        if (r != null) {
            return r;
        }
        return defaultObject;
    }
}
