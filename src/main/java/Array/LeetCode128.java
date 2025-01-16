package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num:nums){
            num_set.add(num);
        }
        //
        int longestStreak = 0;
        for(int num:num_set){
            //如果存在num-1，则num肯定不是开头，跳过
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                //对每个开头的数循环，直到这个序列不再连续
                while (num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
