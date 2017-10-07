package leecode;

import java.util.Stack;

/***
 * https://leetcode.com/problems/min-stack/description/
 * 
 * @author weiwei
 *
 */
public class MinStack {

    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }

        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // --> Returns -3.
        minStack.pop();
        minStack.top(); // --> Returns 0.
        minStack.getMin(); // --> Returns -2.
    }
}
