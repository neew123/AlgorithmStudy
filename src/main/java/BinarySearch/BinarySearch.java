package BinarySearch;

/**
 * 在一个有序数组中，查找某个数是否存在
 */
public class BinarySearch {
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid] == target){
                return  mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,4,5,9,14};
        int target = 4;
        int result = binarySearch(arr,target);
        System.out.println("result position:"+result);
    }
}
