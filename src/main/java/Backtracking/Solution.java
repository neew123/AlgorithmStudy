package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracing(res, output, 0, candidates, target, 0,used);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        return res;
    }

    public void backTracing(List<List<Integer>> res, List<Integer> output, int sum,
                            int[] candidates, int targert, int index,boolean[] used) {
        if (sum == targert) {
            res.add(new ArrayList<>(output));
            return;
        }
        //
        for (int i = index; i < candidates.length && sum+candidates[i]<=targert; i++) {
            if(i>0&&candidates[i] == candidates[i-1]&&used[i-1]==false){
                continue;
            }
            sum += candidates[i];
            output.add(candidates[i]);
            used[i] = true;
            backTracing(res, output, sum, candidates, targert, i + 1,used);
            sum -= candidates[i];
            output.remove(output.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
