/*
Implement a queue with 2 stacks. Your queue should have an enqueue and a dequeue method and it should be FIFO

Optimize for the time cost of m calls on your queue. These can be any mix of enqueue and dequeue calls.

Assume you already have a stack implementation and it gives O(1)O(1) time push and pop.

Time - O(m) runtime for m calls.
O(1) for each push / pop operation

*/


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueTwoStacks {

    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.isEmpty()) {

            // move items from inStack to outStack, reversing order
            while (!inStack.isEmpty()) {
                int newestInStackItem = inStack.pop();
                outStack.push(newestInStackItem);
            }

            // if outStack is still empty, raise an error
            if (outStack.isEmpty()) {
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            }
        }
        return outStack.pop();
    }
}
