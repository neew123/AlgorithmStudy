package recurison.sort;

import java.io.*;

/**
 * 1.左部分排好序、右部分排好序，利用merge过程让左右整体有序
 * 2.merge过程：谁小拷贝谁，直到左右两部分所有的数字耗尽
 * 3.递归实现和非递归实现
 * 4.时间复杂度O(n*logn)
 * 5.需要辅助数组，额外空间复杂度O(n)
 * 6.归并排序比O(n^2)快的原因：比较行为没有浪费
 * 7.利用归并排序的便利性可以解决很多问题
 */

public class MergeSort {

    public static int MAXIN = 501;
    public static int[] arr = new int[MAXIN];
    public static int[] help = new int[MAXIN];

    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer streamTokenizer = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (streamTokenizer.nextToken()!=StreamTokenizer.TT_EOF){
            int n = (int)streamTokenizer.nval;
            for(int i = 0;i<n;i++){
                streamTokenizer.nextToken();
                arr[i] = (int)streamTokenizer.nval;
            }
            mergeSort1(0,n-1);
            mergeSort2();

        }
        out.flush();
        out.close();
    }

    //归并排序递归版
    //假设l...r一共是n个数，T(n)=2*T(n/2)+O(n)
    //a = 2,b=2,c=1,根据master公式，时间复杂度O(nlogn),空间复杂度O(n)
    public static void mergeSort1(int l ,int r){
        if(l == r){
            return;
        }
        int m = (l+r)/2;
        mergeSort1(l,m);
        mergeSort1(m+1,r);
        merge(l,m,r);
    }
     public static void merge(int l,int m,int r){
        int i = l;
        int a = l;
        int b = m+1;
        while(a<=m && b<=r){
            help[i++] = arr[a]<=arr[b]?arr[a++]:arr[b++];
        }
        while(a<=m){
            help[i++] = arr[a++];
        }
        while (b<=r){
            help[i++] = arr[b++];
        }
        for(i = l;i<=r;i++){
            arr[i] = help[i];
        }
    }

    //归并排序非递归版，时间复杂度O(n*logn),空间复杂度O(n)
    public static void mergeSort2(){
        //循环次数为logn
        for(int l,m,r,step=1;step<n;step<<=1){
            //内部分组merge，时间复杂度O(n)
            l = 0;
            while(l<n){
                m = l+step-1;
                if(m+1>=n){
                    //已经没有右侧
                    break;
                }
                //求右侧的右边界:l+2*step-1
                r = Math.min(l+(step<<1)-1,n-1);
               //l..m m+1..r
                //          l..m m+1..r
                merge(l,m,r);
                l=r+1;
            }
        }
    }

}
