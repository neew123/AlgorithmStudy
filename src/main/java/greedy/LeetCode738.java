package greedy;

/**
 * 738. 单调递增的数字
 */
public class LeetCode738 {
    public int monotoneIncreasingDigits(int n) {
       String strN = String.valueOf(n);
       char[] nArray = strN.toCharArray();
       int flag = strN.length();
       for(int i = strN.length()-1;i>0;i--){
           if(nArray[i-1]>nArray[i]){
               nArray[i-1]--;
               flag = i;
           }
       }
       for(int i = flag;i<strN.length();i++){
           nArray[i] = '9';
       }
        return Integer.valueOf(String.valueOf(nArray));
    }

    public static void main(String[] args) {
        LeetCode738 leetCode738 = new LeetCode738();
        System.out.println(leetCode738.monotoneIncreasingDigits(100));
    }


}
