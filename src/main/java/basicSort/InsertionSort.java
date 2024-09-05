package basicSort;

/**
 * 插入排序时间复杂度：O(n^2),额外空间复杂度：O(1)
 * 算法流程按照最差情况来估计时间复杂度
 */

public class InsertionSort {
    public static  void insertionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        //0~i做到有序，此时0～i-1有序
        for(int i = 1;i<arr.length;i++){
            for(int j = i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
