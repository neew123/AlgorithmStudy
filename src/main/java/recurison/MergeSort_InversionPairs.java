package recurison;


/**
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有的逆序对数量。
 */
public class MergeSort_InversionPairs {

    public static int inversionPairs(int arr[]){
        if(arr == null || arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int l, int r) {
        if(l == r){
            return 0;
        }
        int mid = l+((r-l)>>2);
        return process(arr,l,mid)+process(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] <=arr[p2] ? arr[p1++] : arr[p2++];
            res += arr[p1] > arr[p2] ? (mid-p1+1) : 0;
        }

        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for(int k = 0;k<help.length;k++){
            arr[l+k] = help[k];
        }
        return res;
    }
}
