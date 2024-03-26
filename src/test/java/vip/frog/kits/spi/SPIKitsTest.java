package vip.frog.kits.spi;

import org.junit.Test;
import vip.frog.kits.spi.data.Demo1;
import vip.frog.kits.spi.data.Demo2;

import java.util.List;


/**
 * {@link SPIKits}
 */
public class SPIKitsTest {


    @Test
    public void getAll() {
        {
            final List<Demo1.MyInterface> all = SPIKits.getAll(Demo1.MyInterface.class);
            System.out.println(all);
        }

        {
            final List<Demo2.MyInterface> all = SPIKits.getAll(Demo2.MyInterface.class);
            System.out.println(all);
        }

    }


    @Test
    public void get() {
        {
            final Demo1.MyInterface spi = SPIKits.get(Demo1.MyInterface.class);
            System.out.println(spi);
        }

        {
            final Demo2.MyInterface spi = SPIKits.get(Demo2.MyInterface.class);
            System.out.println(spi);
        }

    }
}
