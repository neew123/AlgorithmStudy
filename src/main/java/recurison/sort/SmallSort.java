package recurison.sort;

import java.io.*;


/**
 * 题目：牛客网-计算数组的小和
 */
public class SmallSort {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer streamTokenizer = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (streamTokenizer.nextToken()!=StreamTokenizer.TT_EOF){
            int n = (int)streamTokenizer.nval;
            for(int i = 0;i<n;i++){
                streamTokenizer.nextToken();
                arr[i] = (int)streamTokenizer.nval;
            }
            out.println(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }

    public static long smallSum(int l ,int r){
        if(l == r){
            return 0;
        }
        int m = (l+r)/2;
        return smallSum(l,m)+smallSum(m+1,r)+merge(l,m,r);
    }

    /**
     * 返回跨左右产生的小和累加和，左侧有序，右侧有序，让左右两侧整体有序
     * arr[l...m]arr[m+1..r]
     * @param l
     * @param m
     * @param r
     * @return
     */
    public static long merge(int l,int m,int r){
        long ans = 0;
        //举例：4 6 7 7   5 6 6 8
        //     i         j
        for(int j = m+1,i = l,sum = 0;j<=r;j++){
            while (i<=m && arr[i]<=arr[j]){
                sum+=arr[i++];
            }
            ans+=sum;
        }

        //正常merge
        int i = l;
        int a = l;
        int b = m+1;
        while (a<=m && b<=r){
            help[i++] = arr[a]<=arr[b]?arr[a++]:arr[b++];
        }
        while (a<=m){
            help[i++] = arr[a++];
        }
        while (b<=r){
            help[i++] = arr[b++];
        }
        for(i = l;i<=r;i++){
            arr[i] = help[i];
        }

        return ans;
    }
}
