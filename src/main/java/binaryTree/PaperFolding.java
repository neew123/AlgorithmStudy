package binaryTree;

public class PaperFolding {

    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }

    //i:表示当前层、N：最深层、down：方向 true：凹  false：凸
    public static void printProcess(int i , int N, boolean down){
        if(i>N){
            return;
        }
        printProcess(i+1,N,true);
        System.out.println(down?"凹":"凸");
        printProcess(i+1,N,false);
    }
}
