package Stack;

import java.util.Stack;

/**
 * leetcode 151
 */
class MinStack {
    public Stack<Integer> data;
    public Stack<Integer> min;
    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int val) {
        data.push(val);
        if(min.isEmpty()||val<min.peek()){
            min.push(val);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return  min.peek();
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