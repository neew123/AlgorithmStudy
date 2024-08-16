package hashMapAndHashSet;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetAndTreeMap {
    public static void main(String[] args) {
        //底层红黑树
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"这是1");
        treeMap.put(2,"这是2");
        treeMap.put(3,"这是3");
        treeMap.put(9,"这是9");
        treeMap.put(6,"这是6");

        System.out.println(treeMap.firstKey());//最小key
        System.out.println(treeMap.lastKey());//最大key
        //TreeMap中所有key<=5且最近的key
        System.out.println(treeMap.floorKey(5));
        //TreeMap中所有key>=5且最近的key
        System.out.println(treeMap.ceilingKey(5));

        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);
        System.out.println("有序表大小："+set.size());//大小为2
        while (!set.isEmpty()){
            System.out.println(set.pollFirst());
            System.out.println(set.pollLast());
        }

        System.out.println("-------堆:默认小根堆，如果需要大根堆，定制比较器------------");
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        System.out.println("堆大小："+heap.size());
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
