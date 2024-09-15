package sort.recurison;

public class QuickSort_Partition {

    public static void main(String[] args) {

    }

    public void partition(int[] arr,int left,int right,int num){
        int first = left;
        int last = right;
        int i = left;
        while (i<=last){
            if(arr[i] == num){
                i++;
            }else if(arr[i]<num){
                swap(arr,first++,i++);
            }else{
                swap(arr,last--,i);
            }
        }
    }

    private void swap(int[] arr, int i, int i1) {
    }
}
