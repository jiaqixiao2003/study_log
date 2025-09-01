package algo.study.class01;

import java.util.Arrays;

public class Code3_InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > arr[j + 1])
                    Code2_BubbleSort.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int MAXSIZE = 100;
        int maxNum = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * MAXSIZE);
            int[] arr = randomArray(n, maxNum);
            Arrays.sort(arr);
            int num = (int) (Math.random() * maxNum);
        }
        System.out.println("测试结束");
    }

    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

//    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }
}
