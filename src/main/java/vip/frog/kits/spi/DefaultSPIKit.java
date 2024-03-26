package vip.frog.kits.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

class DefaultSPIKit implements SPIKit {


    private static final String PREFIX = "META-INF/services/";

    private static final Logger log = LoggerFactory.getLogger(DefaultSPIKit.class);

    /**
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> clazz) {
        try {
            return getHighestOrder(clazz);
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }


    /**
     * 获取所有 实现服务,没有返回空List
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getAll(Class<T> clazz) {
        if (clazz == null) {
            log.warn("class is null");
            return Collections.emptyList();
        }

        if (!clazz.isInterface()) {
            log.warn("class is not interface");
            return Collections.emptyList();
        }


        List<T> r = new ArrayList<>();
        try {
            ServiceLoader<T> loader = ServiceLoader.load(clazz);
            for (T spiServer : loader) {
                r.add(spiServer);
            }

            if (r.isEmpty()) {
                debugEmpty(clazz);
            }
        } catch (Exception e) {
            log.error("", e);
        }

        return r;
    }

    private void debugEmpty(Class<?> clazz) throws IOException {
        String fullName = PREFIX + clazz.getName();
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        final Enumeration<URL> systemResources = cl.getSystemResources(fullName);
        boolean find = false;
        while (systemResources.hasMoreElements()) {
            final URL url = systemResources.nextElement();
            log.warn("url:{}", url);
            find = true;
        }

        if (find) {
            log.warn("find {}, but not load server", fullName);
        } else {
            log.warn("not find {}", fullName);
        }
    }

    /**
     * 获取所有实现中排序最高的, 没有返回 null
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getHighestOrder(Class<T> clazz) {
        List<T> list = getAll(clazz);

        if (list.isEmpty()) {
            return null;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        T r = null;
        long max = Long.MIN_VALUE;
        for (T item : list) {
            int orderValue = Util.getOrderValue(item.getClass());
            if (orderValue == max) {
                log.warn("duplicate orderValue [{}] by {}", orderValue, clazz);
            }

            if (orderValue >= max) {
                max = orderValue;
                r = item;
            }
        }
        return r;
    }
}
