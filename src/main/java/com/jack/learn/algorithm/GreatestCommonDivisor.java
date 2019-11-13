package com.jack.learn.algorithm;

/**
 * <p>
 * 求最大公约数
 * </p>
 *
 * @author liweijian.
 * @date 2019/11/10.
 */
public class GreatestCommonDivisor {

    /**
     * 辗转相除法，a与b的最大公约数等于b与(a和b的取模）的最大公约数相等，进行递归取值。
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }

        return getGreatestCommonDivisor(big % small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 5));
        System.out.println(getGreatestCommonDivisor(100, 80));
        System.out.println(getGreatestCommonDivisor(27, 14));
    }
}
