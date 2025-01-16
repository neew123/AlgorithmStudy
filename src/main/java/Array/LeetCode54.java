package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class LeetCode54 {

    //关键点控制循环不变量：左闭右开
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0,right = n-1;
        int top = 0,bottom = m-1;
        while (left<=right && top<=bottom) {
            //从左到右
            for (int column = left; column <= right ; column++) {
                ans.add(matrix[top][column]);
            }
            //从上到下
            for (int row = top+1; row <= bottom ; row++) {
                ans.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                //从右到左
                for (int column = right - 1; column > left; column--) {
                    ans.add(matrix[bottom][column]);

                }
                //从下到上
                for (int row = bottom; row > top; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
            //
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = {{3},{2}};
        LeetCode54 leetCode54 = new LeetCode54();
        List<Integer> integers = leetCode54.spiralOrder(matrix);
        System.out.println(integers);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers2 = leetCode54.spiralOrder(matrix2);
        System.out.println(integers2);
    }
}
