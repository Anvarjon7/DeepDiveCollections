package org.example.stackAndQueues;

import java.util.Stack;

public class MyStack {

    private int[] data;
    private int top;
    private int capacity;

    public MyStack(int size) {
        this.capacity = size;
        data = new int[capacity];
        top = -1;
    }

    public int size(){
        return top + 1;
    }

    public void push(int val) throws Exception{
        if (isFull()) throw new Exception("StackOverflow");
        data[++top] = val;
    }

    public int pop() throws Exception{
        if (isEmpty()) throw new Exception("StackUnderflow");
        return data[--top];
    }

    private int peek() throws Exception{
        if (isEmpty()) throw new Exception("StackUnderflow");
        return data[top];
    }

    private void print(){
        System.out.print("Stack (top to bottom): ");
        for (int i = data.length - 1; i >= 0 ; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public int removeBottom(){
        int bottom = data[0];
        for (int i = 1; i <= top; i++) {
            data[i - 1] = data[i];
        }
        top--;
        return bottom;
    }

}
