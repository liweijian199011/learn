package com.jack.learn.datastructure.sort;

import java.util.Arrays;

/**
 * <p>
 *     冒泡排序
 *     算法思路：
 *     遍历数组，比较相邻元素的大小，如果左边的元素大于右边的元素，则交换位置，否则位置不换，并继续向下遍历列表。
 *     直到遍历到最后一个元素为止。
 *     后面的遍历则不用再遍历已经排好序的元素。因为时间复杂度为O(logn2)
 * </p>
 *
 * @author liweijian.
 * @date 2019/11/10.
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] list) {
        if (list == null || list.length == 0 || list.length == 1) {
            return;
        }
        // 用于隔离后边已经排好序的元素
        int lastExchangeIndex = 0;
        int sortBorder = list.length - 1;
        for (int i = 0; i < list.length - 1; i++) {
            // 当本次遍历的元素都是提好序的，后面的元素就不再需要遍历，添加该标志来说明
            boolean sort = true;
            for (int j = 0; j < list.length - i - 1; j++) {
                int temp = 0;
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    sort = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            System.out.println("sortBorder: " + sortBorder);
            if (sort) {
                System.out.println(i);
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序，是一种特别的冒泡排序，主要用在元素中多数已经排序的情况下。
     * 算法思路：
     * 排序的算法就像鸡尾酒一样，需要左右颠倒晃动一下，也就是左右两边都要排序。
     * 第一轮从左边开始遍历，第二轮从右边开始遍历，第三轮再从左边遍历，今次类推。。。
     * 最外层的遍历还是遍历的次数，里面的遍历包括两个循环，一个是从左边开始遍历，一个是从右边开始遍历。
     * 鸡尾酒的优点就是减少遍历的回合数，缺点就是代码比较复杂。
     * @param array
     */
    private static void cocktailSort(int[] array) {
        int temp = 0;
        // 只遍历二分之一长度即可
        for (int i = 0; i < array.length / 2; i++) {
            boolean sort = true;
            // 奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sort = false;
                }
            }
            if (sort) {
                break;
            }

            sort = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    sort = false;
                }
            }
            if (sort) {
                break;
            }
        }
    }
}
