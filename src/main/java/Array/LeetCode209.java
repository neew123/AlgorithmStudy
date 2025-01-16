package Array;

/**
 * 长度最小的子数组
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int subLen = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for(int j = 0;j<nums.length;j++){
            sum+=nums[j];
            while (sum>=target){
                subLen = Math.min(subLen,j-i+1);
                sum -= nums[i++];
            }
        }
        return subLen==Integer.MAX_VALUE?0:subLen;
    }

    public static void main(String[] args) {
        LeetCode209 leetCode209 = new LeetCode209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(leetCode209.minSubArrayLen(7,nums));

        int[] nums2 = {1,1,1,1,1,1,1,1};
        System.out.println(leetCode209.minSubArrayLen(11,nums2));
    }
}
