package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracing(res,path,nums,0);

        return res;
    }
    void backTracing(List<List<Integer>> res,List<Integer> path,int[] nums,int startIndex){
        res.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for(int i = startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backTracing(res,path,nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
