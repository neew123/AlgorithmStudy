package greedy;

/**
 * 最大子数组和
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int proDiff = 0;
        for(int i = 1;i<prices.length;i++){
            proDiff = prices[i] - prices[i-1];
            if(proDiff>0){
                result += proDiff;
            }
        }
        return result;
    }
}
