package algo.study.class01;

public class Code_MergeSort {

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return ;
        }
        int mid = L + ((R-L) >> 1);
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
         int[] temp = new int[R - L + 1];
         int i = 0, p1 = L, p2 = mid + 1;
         while (p1 <= mid && p2 <= R) {
             temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
         }
         while (p1 <= mid) {
             temp[i++] = arr[p1++];
         }
         while (p2 <= R) {
             temp[i++] = arr[p2++];
         }
         for (int j = 0; j < temp.length; j++) {
             arr[L + j] = temp[j];
         }
    }

}
