package queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 641
 */
class MyCircularDeque {
    public Deque<Integer> deque = new LinkedList<>();
    public int size;
    public int limit;

    public MyCircularDeque(int k) {
        size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else {
            deque.addFirst(value);
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else {
            deque.addLast(value);
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else {
            deque.removeFirst();
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else {
            deque.removeLast();
            size--;
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }else {
            return deque.getFirst();
        }
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }else {
            return deque.getLast();
        }
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(size == limit){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 *
 * 用数组方式实现双端队列
 */
class MyCircularDeque2 {

    public  int[] deuqe;
    int r,l,size,limit;

    public MyCircularDeque2(int k) {
        deuqe = new int[k];
        l = r = size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else {
            if(isEmpty()){
                l = r = 0;
                deuqe[0] = value;
            }else {
                l = l == 0 ? (limit - 1) : (l - 1);
                deuqe[l] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else {
            if(isEmpty()){
                l = r = 0;
                deuqe[0] = value;
            }else {
                r = r == (limit - 1) ? 0 : (r + 1);
                deuqe[r] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else {
             l = l == (limit-1)?0:l+1;
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else {
            r = r==0?limit-1:r-1;
            size--;
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }else {
            return deuqe[l];
        }
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }else {
            return deuqe[r];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}