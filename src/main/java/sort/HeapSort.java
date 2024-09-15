package sort;


/**
 * heapInser和Heapify的时间复杂度为O(logN)
 * 空间复杂度为O(1)
 */
public class HeapSort {

    //从下到上建立大根堆O(n),整体时间复杂度为O(n*logN)
    public static void heapSortDownToUp(int[] arr){
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            heapify(arr,i,n);
        }
        int size = n;
        while(size>1){
            swap(arr,0,--size);
            heapify(arr,0,size);
        }
    }


    //从上到下建立大根堆O(n*logn),整体时间复杂度O(n*logn)
    public static void heapSortTopToDown (int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){  //O(n)
            heapInsert(arr,i);   //O(logN)
        }
        int heapSize = n;
        swap(arr,0,--heapSize);
        while(heapSize > 0){   // O(N)
            heapify(arr,0,heapSize); // O(logN)
            swap(arr,0,--heapSize);
        }
    }

    //i位置的数，向上调整大根堆
    public static void heapInsert(int[] arr,int i){
        while (arr[i]>arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    //i位置的数，向下调整大根堆,时间复杂度为O(logN)
    public static void heapify(int[] arr,int i,int heapSize){
        int left = 2*i+1;
        //右孩子=左孩子+1
        while (left<heapSize){//判断该位置i是否还有孩子，如果小于size，说明还有孩子
            int largest = (left+1<heapSize)&&(arr[left+1]>arr[left])?left+1:left;
            largest = arr[largest]>arr[i]?largest:i;
            if(largest == i){
                break;
            }
            swap(arr,largest,i);
            i = largest;
            left = 2*i+1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
