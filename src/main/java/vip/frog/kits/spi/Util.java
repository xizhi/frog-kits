package vip.frog.kits.spi;

class Util {

    /**
     * 获取 权重值
     *
     * @param clazz
     * @return
     */
    static int getOrderValue(Class<?> clazz) {
        if (clazz == null) {
            return Integer.MIN_VALUE;
        }
        int r = SPIKitSettings.DEFAULT_ORDER_VALUE;
        SPIOrder annotation = clazz.getAnnotation(SPIOrder.class);
        if (annotation != null) {
            r = annotation.value();
        }
        return r;
    }
}
