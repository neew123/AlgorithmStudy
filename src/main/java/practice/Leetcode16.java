package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Leetcode16 {
    //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近，返回这三个数的和。
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //[-4,-1,1,2] target=1
        //1.三个数的和相等
        //2.上一个数小于target，但是下一个数大于target，比较两个sum，取较小值
        int n = nums.length;
        int best = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int left = i + 1;
            int right = n-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return target;
                }
                //根据差值的绝对值来更新答案
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best = sum;
                }
                if(sum>target && left<right){
                    right--;
                }
                if(sum<target&&left<right) {
                    left++;
                }

            }
        }
        return best;
    }

    //给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //[-2,-1,0,0,1,2] target=0
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                 continue;
            }
            int j=i+1,k=j+1,l=n-1;
            while(j<k && k<l && l<n){
                int sum = nums[i]+nums[j]+nums[k]+nums[l];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                }
                if(sum>target){
                  int sum1 = nums[i]+nums[j]+nums[k-1]+nums[l];
                  if(sum1>target && k>j) k--;
                }
                if(sum<target && l+1<n){
                    int sum1 = nums[i]+nums[j]+nums[k]+nums[l+1];
                    if(sum1<target && l<n) l++;
                }
            }
        }
        return ans;
    }
}
