package org.example.stackAndQueues;

public class MyStack {

    private int[] data;
    private int top;
    private int capacity;

    public MyStack(int size) {
        this.capacity = size;
        data = new int[capacity];
        top = -1;
    }

    private void push(int val) throws Exception{
        if (isFull()) throw new Exception("StackOverflow");
        data[++top] = val;
    }

    private int pop() throws Exception{
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

    private boolean isEmpty(){
        return top == -1;
    }

    private boolean isFull(){
        return top == capacity-1;
    }

}
