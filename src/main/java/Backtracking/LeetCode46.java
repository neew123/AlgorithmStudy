package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean [] used = new boolean[nums.length];
        backTracing(res,path,nums,used);
        return res;
    }

    void backTracing(List<List<Integer>> res,List<Integer> path,int[] nums,boolean [] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(res,path,nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        int[] nums = {1,2,3};
        List<List<Integer>> res = leetCode46.permute(nums);
        for(List<Integer> list : res){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
