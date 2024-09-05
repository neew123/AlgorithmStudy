package BinarySearch;

/**
 * 数组arr无序且相邻数一定不相等，局部最小定义为：如果 arr[i-1] > arr[i]  && arr[i] < arr[i+1]，则称arr[i]为局部最小。
 * 时间复杂度优于O(n)
 */
public class LocalMinFinder {
    public static int findLocalMin(int[] arr){
        if(arr == null || arr.length<3){
            throw new IllegalArgumentException("at least 3 elements");
        }
        int start = 0;
        int end = arr.length - 1;

        if(arr[start]<arr[start+1]){
            return start;
        }
        if(arr[end]<arr[end]-1){
            return end;
        }
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<arr[mid-1]&&arr[mid]<arr[mid+1]){
                return mid;
            }

            if(mid>0 && arr[mid-1]<arr[mid]){
                end = mid-1;
            }else {
                start = mid +1;
            }
        }
        //如果没有，则返回-1；
        return -1;
    }

    public static void main(String[] args) {
        int[] arr  = {5,2,3,4,1,6,7,8};
        int index = findLocalMin(arr);
        System.out.println("局部最小值的位置是："+index);
    }
}
