package vip.frog.kits.random;

import java.util.Random;

public interface NumberRandomKit {

    /**
     * 生成介于 0.0 和 1.0之间的下一个伪随机双精度值
     * <p>
     * [0, 1)
     */
    default double random() {
        Random random = new Random();
        return random.nextDouble();
    }

    default double random(double multiple) {
        Random random = new Random();
        return random.nextDouble() * multiple;
    }


    default double random(double multiple, double offset) {
        Random random = new Random();
        return random.nextDouble() * multiple + offset;
    }

    default double[] randomArray(int length) {
        double[] r = new double[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            r[i] = random.nextDouble();
        }
        return r;
    }

}


