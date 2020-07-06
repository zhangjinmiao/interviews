package com.jimzhang.sort;

/**
 * 排序算法
 */
public class SortDemo {

    /**
     * 冒泡排序：稳定
     * 算法：前后两两交换，大者靠后，重复n趟（不一定），直到有序
     * 时间复杂度：O(n)~O(n^2)
     * 空间复杂度：O(1)
     *
     * @param arr
     */
    public static void BubbleSort(int[] arr) {
        for (int i=0; i< arr.length-1; i++) { // 表示趟数，一共 arr.length-1 次
            // 是否交换
            boolean flag = false;
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {
                    // 临时变量
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 选择排序：不稳定
     * 算法：在未排序序列中找出最小的数，放到排序序列起始位置；再从剩余未排序序列找出最小的数，放到已排序序列的末尾，直到所有元素排序完毕。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i=0; i< arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 当前数与后面找出来的最小数互换
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = arr[i];
            }
        }
    }


    /**
     * 插入排序：稳定
     * 算法：
     * 时间复杂度：O(n)~O(n^2)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i=0; i<length-1; i++) {
            for (int j=i+1; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
    }

    /**
     * 快速排序：不稳定
     * 算法：分区交换思想
     * 时间复杂度：O(nlogn) ~ O(n^2)
     * 空间复杂度：O(nlogn)
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;

        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];

        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr,leftIndex, left-1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr,right+1,rightIndex);
    }
}
