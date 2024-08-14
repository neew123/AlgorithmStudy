package Stack;

import java.util.Stack;

/**
 * leetcode 151
 */
class MinStack2 {
    public final int MAXN = 8001;
    public int[] data;
    public int[] min;
    int size;

    public MinStack2() {
        data = new int[MAXN];
        min = new int[MAXN];
        size = 0;
    }

    public void push(int val) {
        data[size] = val;
        if(size == 0||val<min[size-1]){
            min[size]  =val;
        }else{
            min[size] = min[size-1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size-1];
    }

    public int getMin() {
        return  min[size-1];
    }
}

/**
 * Your Stack.MinStack object will be instantiated and called as such:
 * Stack.MinStack obj = new Stack.MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */