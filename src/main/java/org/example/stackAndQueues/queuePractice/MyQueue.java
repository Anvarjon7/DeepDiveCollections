package org.example.stackAndQueues.queuePractice;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest;
    Stack<T> stackOldest;

    public MyQueue() {
        this.stackNewest = new Stack<T>();
        this.stackOldest = new Stack<T>();
    }

    private int size() {
        return stackNewest.size() + stackOldest.size();
    }

    private void add(T value){
        stackNewest.add(value);
    }

    private void shiftStacks(){
        if (stackOldest.isEmpty()){
            while (!stackNewest.isEmpty()){
                stackOldest.add(stackNewest.peek());
            }
        }
    }

    private T remove(){
        return stackOldest.pop();
    }

    private T peek(){
       return stackOldest.peek();
    }
}
