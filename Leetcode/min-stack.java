import java.util.ArrayList;
import java.util.List;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

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

