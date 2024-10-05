package sort.recurison;


/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * 求一个数组的小和。例子：[1,3,4,2,5] 1左边比1小的数，没有；3左边比3小的数，1；4左边比4小的数，1、3；2左边比2小的数，1；5左边比5小的数，1、3、4、2，所以小和为1+1+3+1+1+3+4+2=16。
 *
 * 解题思路：计算小和时可以这样想，对于1，右边有多少个数比1大，计算结果时就需要加上多少个1。这样，就可以联想到排序，左边右边 ---- 归并排序思想
 */
public class MergeSort_SmallSum {

    public static int smallSum(int arr[]){
        if(arr == null || arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }


    private static int process(int[] arr, int l, int r) {
        if(l == r){
            return 0;
        }

        int mid = l+((r-l)>>1);
        return process(arr,l,mid)+process(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];

        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while (p1<=mid && p2<=r){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];//注意这里与归并排序的区别，相等时优先复制右侧
            res += arr[p1]<arr[p2]?(arr[p1]*(r-p2+1)):0;
        }
        while (p1<=mid){
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
