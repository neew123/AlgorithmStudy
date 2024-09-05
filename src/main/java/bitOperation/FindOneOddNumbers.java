package bitOperation;

/**
 * 习题1:在一个数组中，有一种数字出现了奇数次，其他数字出现了偶数次。
 * （1）找到出现奇数次的数。（2）如果有两种数字出现了奇数次，找到这两种数字。
 * 要求时间复杂度O(n)，空间复杂度O(1)。
 */
public class FindOneOddNumbers {

    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int cur:arr){
            eor^=cur;
        }
        System.out.println(eor);
    }

    /**
     * 1.eor结果a^b
     * 2.因为a不等于b，所以至少在eor的某一位是1（比如第八位）。由此可将整个数组分为A组和B组
     * 3.eor和A组异或，假设得到结果为eor'=a，b =eor^eor' 。
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int cur:arr){
            eor ^= cur;
        }
        //此时eor = a^b
        //提取出最右边的1；；例如：eor=1010111100，eor&(~eor+1)=0000000100；
        int rightOne = eor & ( ~ eor + 1);

        int onlyOne = 0;
        for(int cur : arr){
            if((cur & rightOne) ==0){
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " "+(eor^onlyOne));
    }
}
