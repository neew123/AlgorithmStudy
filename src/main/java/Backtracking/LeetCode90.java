package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracing(res,path,nums,0,used);
        return res;
    }

    void backTracing(List<List<Integer>> res,List<Integer> path,int[] nums,int startIndex,boolean[] used){
        res.add(new ArrayList<>(path));
        //注意这里终止条件要加在后面，否则会漏掉元素
        if(startIndex>=nums.length){
            return;
        }
        for(int i = startIndex;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(res,path,nums,i+1,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
