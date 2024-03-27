package vip.frog.kits.random;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("JavaDoc")
public interface IntegerRandomKit {

    /**
     * 生成一个 最小为 0, 最大为 99 的随机数 [0, 99]
     *
     * @return
     */
    default int random() {
        return random(99);
    }

    /**
     * 生成一个 最小为 0, 最大为 max 的随机数
     *
     * @param max 随机数的最大值
     * @return
     */
    default int random(int max) {
        return random(0, max);
    }

    /**
     * 生成一个 最小为 min, 最大为 max 的随机数
     *
     * @param min 随机数的最小值
     * @param max 随机数的最大值
     * @return
     */
    default int random(int min, int max) {
        if (min == max) {
            return min;
        }
        int realMax = max;
        int realMin = min;
        if (min > max) {
            // 防止输入错误
            realMax = min;
            realMin = max;
        }

        Random random = new Random();
        return getRandomResult(random, realMin, realMax);

    }

    /**
     * 生成一组随机数
     *
     * @param length 随机数的数量
     * @param max    随机中的最大值
     * @return
     */
    default int[] randomArray(int length, int max) {
        return randomArray(length, 0, max);
    }

    /**
     * 生成一组随机数
     *
     * @param length 随机数的数量
     * @param max    随机中的最大值
     * @param min    随机中的最小值
     * @return
     */
    default int[] randomArray(int length, int min, int max) {
        int[] r = new int[length];

        if (min == max) {
            Arrays.fill(r, min);
            return r;
        }
        int realMax = max;
        int realMin = min;
        if (min > max) {
            // 防止输入错误
            realMax = min;
            realMin = max;
        }
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            r[i] = getRandomResult(random, realMin, realMax);
        }
        return r;
    }

    static int getRandomResult(Random random, int min, int max) {
        if (max <= min) {
            throw new UnsupportedOperationException();
        }
        int range = max - min + 1;
        int r = random.nextInt(range);
        r += min;
        return r;
    }
}




