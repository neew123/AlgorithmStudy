package inOutPut;

import java.io.*;

/**
 * acm风格
 * 1.规定数据量 （BufferedReader,StreamTokenizer,PrintWriter）
 * 2.按行读 （BufferedReader，PrintWriter）
 * 3.不要用Scanner,System.out,IO效率慢
 * 4.推荐用全局静态空间，不要用临时动态空间
 */
public class ReadByFile {

    public static int MAXN = 201;
    public static int MAXM  = 201;
    public static int[][] mat= new int[MAXN][MAXM];
    //需要的所有辅助空间也提前生成，静态的空间不停复用
    public static int[] arr = new int[MAXM];
    //当前测试数据行的数量是n，测试数据列的数量是m，可以把代码运行的边界规定下来
    public static int n,m;


    public static void main(String[] args) throws IOException {
        //把文件里的内容，load进来，保存在内存里，高效经济
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //一个一个读数字
        StreamTokenizer in = new StreamTokenizer(br);
        //提交答案时候用，也是一个内存托管区
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){//文件没有结束就继续
            // n,二维数组的行
            int n = (int)in.nval;
            in.nextToken();
            // m,二维数组的列
            int m = (int)in.nval;
            //装数字的矩阵，临时动态生成，不要采用这个方法，计算消耗内存时会累加计算
            //int[][] mat = new int[n][m];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            out.println("答案");
        }
        out.flush();
        out.close();
    }
}
