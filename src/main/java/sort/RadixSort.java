package sort;


/**
 * 基数排序
 */
public class RadixSort {

    //only for non-negative value
    public static void radixSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    //求最大的值有几个十进制位
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    //arr[begin..end]排序
    public static void radixSort(int[] arr,int L,int R,int digit){
        final int radix = 10;
        int i = 0, j = 0;
        //有多少个数准备多少个辅助空间
        int[] bucket = new int[L-R+1];
        for(int d = 1;d<=digit;d++){ //有多少位就进出几次
            //count[0] 当前位d是0的数字有多少个
            //count[1] 当前位d是0和1的数字有多少个
            //count[i] 当前位d是0~i的数字有多少个
            int[] count = new int[radix];//10个空间
            for(i = L;i<=R;i++){
                j = getDigit(arr[i],d);
                count[j]++;
            }
            //count数组处理成前缀和
            for(i=1;i<radix;i++){
                count[i] = count[i]+count[i-1];
            }
            //入桶：数组从右往左遍历
            for(i = R;i>=L;i--){
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];//放进哪个桶里
                count[j]--;//表示当前位小于等于j的数
            }
            //出桶
            for(i = L,j = 0;i<=R;i++,j++){
                arr[i] = bucket[j];
            }

        }
    }

    public static int getDigit(int x,int d){
        return ((x / ((int)Math.pow(10,d-1))) % 10);
    }
}
