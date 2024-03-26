package vip.frog.kits.spi;

import org.junit.Assert;
import org.junit.Test;
import vip.frog.kits.spi.data.Demo1;
import vip.frog.kits.spi.data.Demo2;
import vip.frog.kits.spi.data.NoneClass;


/**
 * {@link Util}
 */
public class UtilTest {

    @Test
    public void getOrderValue() {

        {
            final int orderValue = Util.getOrderValue(Demo1.MyImpl.class);
            Assert.assertEquals(SPIKitSettings.DEFAULT_ORDER_VALUE, orderValue);
        }

        {
            final int orderValue = Util.getOrderValue(Demo2.MyImpl1.class);
            Assert.assertEquals(1, orderValue);
        }

        {
            final int orderValue = Util.getOrderValue(Demo2.MyImpl2.class);
            Assert.assertEquals(2, orderValue);
        }


        {
            final int orderValue = Util.getOrderValue(NoneClass.class);
            Assert.assertEquals(SPIKitSettings.DEFAULT_ORDER_VALUE, orderValue);
        }

    }

}
