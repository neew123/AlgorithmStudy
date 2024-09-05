package BinarySearch;

/**
 * 在一个有序数组中，找>=某个数最左侧的位置
 */
public class BinarySearchFirstGE {

    public static int binarySearchFirstGE(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>=target){
                result = mid;
                right = mid - 1;
            }else{
                left = mid +1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,4,5,9,14};
        int target = 6;
        int result = binarySearchFirstGE(arr,target);
        System.out.println("result position:"+result);
    }
}
