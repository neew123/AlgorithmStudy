package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */



public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]>o2[0]){
//                    return 1;
//                }else if(o1[0]<o2[0]){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });
       // Arrays.sort(points,(o1, o2)->o1[0]-o2[0]);
        int ans = 1;
        for(int i = 1;i<points.length;i++){
            if(points[i][0]>points[i-1][1]){
                ans++;
            }else{
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode452 leetCode452 = new LeetCode452();
       int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        //int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(leetCode452.findMinArrowShots(points));
    }
}
