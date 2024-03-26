package vip.frog.kits.spi;

@SuppressWarnings("JavaDoc")
public final class SPIKitSettings {

    public static final int DEFAULT_ORDER_VALUE = Integer.MIN_VALUE + 1;

    // default implements
    private static SPIKit spiKit = new DefaultSPIKit();

    @SuppressWarnings("unused")
    public static void setDefaultOrderValue(SPIKit spiKit) {
        SPIKitSettings.spiKit = spiKit;
    }

    static SPIKit getSpiKit() {
        return spiKit;
    }


    private SPIKitSettings() {
    }

}



