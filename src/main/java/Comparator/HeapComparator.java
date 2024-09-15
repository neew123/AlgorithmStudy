package Comparator;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 比较器与其他数据结构相结合,比如大根堆
 */
public class HeapComparator {

    public static class BigComp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new BigComp());
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
