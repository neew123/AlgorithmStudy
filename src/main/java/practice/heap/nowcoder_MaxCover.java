package practice.heap;

import java.io.*;
import java.util.Arrays;

/**
 * 线段重合：
 * 每个线段都有start和end两个数据项，表示这条线段在X轴上从start位置开始到end位置结束
 * 给定一批线段，求所有重合区域最多重合来几个线段，首尾相接的线段不算重合
 * 例如：线段[1,2]和线段[2,3]不重合、线段[1,3]和线段[2,3]重合
 */
public class nowcoder_MaxCover {
    public static int MAXN = 10001;
    public static int[][] line = new int[MAXN][2];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int)in.nval;
                in.nextToken();
                line[i][1] = (int)in.nval;
            }
            out.print(compute());
        }
        out.flush();
        out.close();
        br.close();
    }
    //堆的大小
    public static int size;
    //小根堆，堆顶在0位置
    public static int[] heap = new int[MAXN];
    public static int compute(){
        //清空堆
        size  = 0;
        //比较器的用法（所有线段根据开始位置排序，不管结束位置）
        Arrays.sort(line,0,n,(a,b)->a[0]-b[0]);
        int ans = 0;
        for(int i = 0;i<n;i++){
            while(size>0 && heap[0]<=line[i][0]){
                pop();
            }
            add(line[i][1]);
            ans = Math.max(ans,size);
        }
        return ans;
    }

    public static void add(int x){
        heap[size] = x;
        int i = size++;
        while (heap[i]<heap[(i-1)/2]) {
            swap(i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void pop(){
        swap(0,--size);
        int i = 0,l = 1;
        while(l<size){
            int best = l+1<size&&heap[l+1]<heap[l]?l+1:l;
            best = heap[best]<heap[i]?best:i;
            if(best == i){
                break;
            }
            swap(best,i);
            i = best;
            l = i*2+1;
        }
    }

    public static void swap(int i,int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
