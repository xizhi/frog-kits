package vip.frog.kits.spi.data;

import vip.frog.kits.spi.SPIKit;

import java.util.List;

public class SPIKitImpl implements SPIKit {

    @Override
    public String toString() {
        return "custom implements";
    }

    @Override
    public <T> T get(Class<T> clazz) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getHighestOrder(Class<T> clazz) {
        return null;
    }
}
