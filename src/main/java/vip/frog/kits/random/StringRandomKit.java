package vip.frog.kits.random;

import java.util.Arrays;

@SuppressWarnings({"SpellCheckingInspection", "JavaDoc"})
public interface StringRandomKit {

    /**
     * 随机字符内容,去掉 ilouv等容易识别错误的字符
     */
    String randomSeedCharOnly = "ABCDEFGHJKLMNPQRSTWXYZabcdefghjkmnpqrstwxy";
    String randomSeedNumberOnly = "0123456789";

    /**
     * 生成 指定长度的 随机字符串
     *
     * @param length 指定长度
     * @return 返回指定长度的随机字符串
     */
    default String random(int length) {
        return random(length, randomSeedCharOnly);
    }

    /**
     * 生成 指定长度 指定内容 的 随机字符串
     *
     * @param length 指定长度
     * @param seed   指定内容
     * @return
     */
    default String random(int length, String seed) {
        {
            char[] charArr = null;
            if (seed == null || seed.length() == 0) {
                charArr = new char[length];
                Arrays.fill(charArr, ' ');
            } else if (seed.length() == 1) {
                charArr = new char[length];
                Arrays.fill(charArr, seed.charAt(0));
            }
            if (charArr != null) {
                return new String(charArr);
            }
        }


        int max = seed.length() - 1;
        int[] indexRandomArr = RandomKits.integer.randomArray(length, max);

        char[] byteArr = new char[length];

        for (int i = 0; i < indexRandomArr.length; i++) {
            byteArr[i] = seed.charAt(indexRandomArr[i]);
        }
        return new String(byteArr);
    }

}


