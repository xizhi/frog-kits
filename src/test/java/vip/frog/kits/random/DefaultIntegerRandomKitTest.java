package vip.frog.kits.random;

import org.junit.Test;

import java.util.Arrays;

public class DefaultIntegerRandomKitTest {

    DefaultIntegerRandomKit kit = new DefaultIntegerRandomKit();

    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            System.out.println(kit.random());
        }
    }

    @Test
    public void testRandomMax() {
        for (int i = 0; i < 100; i++) {
            System.out.println(kit.random(10));
        }
    }

    @Test
    public void testRandomMaxAndMin() {
        for (int i = 0; i < 100; i++) {
            System.out.println(kit.random(12, 8));
        }
    }


    @Test
    public void testRandomArray() {
        final int[] array = kit.randomArray(100, 9);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testRandomArray2() {
        {
            final int[] array = kit.randomArray(100, 10, 19);
            System.out.println(Arrays.toString(array));
        }
    }


}
