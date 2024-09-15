package sort.recurison;


import java.io.*;

/**
 * 随机快速排序
 * 在当前范围上选择一个数字x，并对当前范围进行划分 <x,=x,>x
 * 对于<x范围重复这个过程，对>x范围重复这个过程
 *
 *  时间复杂度：
 *  坏的情况，x不靠近中点，时间复杂度O(n^2),空间复杂度O(n)
 *  好的情况，x靠近中点，时间复杂度O(n*logn),空间复杂度O(n)
 *
 *  关联：无序数组中寻找第K大的数
 */
public class QuickSort {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            for(int i = 0;i<n;i++){
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            quickSort(0,n-1);
            out.print(arr[0]);
            for(int i = 1;i<n;i++){
                out.print(" "+arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void quickSort(int l,int r){
        if(l >= r){
            return;
        }

        //只有这一下随机才能在概率上把快速排序的时间复杂度收敛到O(n*logn)
        int x = arr[l+(int)(Math.random()*(r-l+1))];
        partition(l,r,x);
        //为了防止底层递归覆盖全局变量，使用临时变量记录first，last
        int left = first;
        int right = last;
        quickSort(l,left-1);
        quickSort(right+1,r);
    }

    // 划分数组，<x放左边，==x放中间，>x放右边;全局变量first，last更新程==x的左右边界
    public static int first,last;
    public static  void partition(int l,int r,int x){
        first = l;
        last = r;
        int i = l;
        while(i<=last){
            if(arr[i] == x){
                i++;
            }else if(arr[i]<x){
                swap(first++,i++);
            }else {
                swap(i,last--);
            }
        }
    }

    public static void swap(int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //无序数组中寻找第K大的数，时间复杂度O(n),空间复杂度O(1)
    public static int findKthLargest(int k){
        return randomsizedSelect(arr.length-k);
    }

    //对arr数组进行排序，返回在i位置的数字
    public static int randomsizedSelect(int i){
        int ans = 0;
        for(int l = 0,r = arr.length-1;l<=r;){
            //随机选择一个数
            partition(l,r,arr[l+(int)(Math.random()*(r-l+1))]);
            //       i
            // first   last
            if(i<first){
                r = first -1;
            }else if(i>last){
                l = last+1;
            }else{
               ans = arr[i];
               break;
            }
        }
        return ans;
    }

}
