package greedy;

import java.util.*;

/**
 * 56. 合并区间
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        //按区间左边从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]<=ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] interval : leetCode56.merge(intervals)){
            for (int i : interval) {
                System.out.print(i+" ");
            }
        }
    }
}
