import java.util.ArrayList;
import java.util.List;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 
 Time - O(1)
 Space - O(n) extra space

 */

public class MinStack {

    private List<Integer> stack = new ArrayList<>();
    private List<Integer> min = new ArrayList<Integer>();

    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() || x <= min.get(min.size() - 1)) {
            min.add(x);
        }
    }

    public void pop() {
        int removed = stack.remove(stack.size() - 1);
        if (removed == min.get(min.size() - 1)) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}

/*

Max Stack 

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> maxesStack = new ArrayDeque<>();

    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxesStack, it's
    // the new max! So we'll add it to maxesStack.
    public void push(int item) {
        stack.push(item);
        if (maxesStack.isEmpty() || item >= maxesStack.peek()) {
            maxesStack.push(item);
        }
    }

    // Remove and return the top item from our stack. If it equals
    // the top item in maxesStack, they must have been pushed in together.
    // So we'll pop it out of maxesStack too.
    public int pop() {
        int item = stack.pop();
        if (item == maxesStack.peek()) {
            maxesStack.pop();
        }
        return item;
    }

    // The last item in maxesStack is the max item in our stack.
    public int getMax() {
        return maxesStack.peek();
    }
}

/*
Time - O(1) 
Space  - O(1)
https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
*/

