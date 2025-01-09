package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracing(res,path,nums,used);
        return res;
    }

    public void backTracing(List<List<Integer>> res,List<Integer> path,int[] nums,boolean[] used)
    {
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //广度去重和深度去重
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if((!set.isEmpty()&&set.contains(nums[i])) || used[i]){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            used[i] = true;
            backTracing(res,path,nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LeetCode47 leetCode47 = new LeetCode47();
        int[] nums = {1,1,2};
        List<List<Integer>> res = leetCode47.permuteUnique(nums);
        System.out.println(res);
    }
}
