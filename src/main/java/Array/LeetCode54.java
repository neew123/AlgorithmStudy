package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class LeetCode54 {

    //关键点控制循环不变量：左闭右开
    public List<Integer> spiralOrderWithCarl(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int numEle = matrix.length * matrix[0].length;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0,right = n-1;
        int top = 0,bottom = m-1;
        while (numEle>0){
            //从左到右
            for(int i = left;i<=right;i++){
                ans.add(matrix[top][i]);
                numEle--;
            }
            top++;
            //从上到下
            for(int i = top;i<=bottom;i++){
                ans.add(matrix[i][right]);
                numEle--;
            }
            right--;
            //从右到左
            for(int i = right;i>=left;i--){
                ans.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            //从下到上
            for(int i = bottom;i>=top;i--){
                ans.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return ans;
    }


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
        List<Integer> integers1 = leetCode54.spiralOrderWithCarl(matrix);
        System.out.println(integers);
        System.out.println(integers1);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers2 = leetCode54.spiralOrder(matrix2);
        System.out.println(integers2);
    }
}
