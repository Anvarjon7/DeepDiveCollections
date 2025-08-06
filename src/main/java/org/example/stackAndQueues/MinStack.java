package org.example.stackAndQueues;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int item) throws Exception{
        mainStack.push(item);
        if (minStack.isEmpty() || item <= minStack.peek()){
            minStack.push(item);
        }
    }

    public int pop(){
        int removed = mainStack.pop();
        if (removed == minStack.peek()){
            mainStack.pop();
        }
        return removed;
    }

    public int min(){
        return minStack.peek();
    }

    private boolean isEmpty(){
        return mainStack.isEmpty();
    }
}
