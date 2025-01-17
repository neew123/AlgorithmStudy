package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 59.螺旋矩阵2
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //int numEle = n * n;
        int left = 0,right = n-1;
        int top = 0,bottom = n-1;
        int count = 1;
        while (count<=n*n){
            //从左到右
            for(int i = left;i<=right;i++){
                ans[top][i] = count++;
            }
            top++;
            //从上到下
            for(int i = top;i<=bottom;i++){
                ans[i][right] = count++;
            }
            right--;
            //从右到左
            for(int i = right;i>=left;i--){
                ans[bottom][i] = count++;
            }
            bottom--;
            //从下到上
            for(int i = bottom;i>=top;i--){
                ans[i][left] = count++;
            }
            left++;

        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] ans = leetCode59.generateMatrix(1);
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
