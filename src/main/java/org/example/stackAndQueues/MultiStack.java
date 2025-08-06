package org.example.stackAndQueues;

public class MultiStack {

    private final int numberOfStacks = 3;
    private int capacity;
    private int[] values;
    private int[] tops;

    public MultiStack(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity * numberOfStacks];
        this.tops = new int[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            tops[i] = -1;
        }
    }

    public void push(int stackNum, int item) throws Exception{
        if (isFull(stackNum)) throw new Exception("StackOverFlow");

        tops[stackNum]++;
        values[indexOfTop(stackNum)] = item;
    }

    public int pop(int stackNum) throws Exception{
        if (isEmpty(stackNum)) throw new Exception("StackUnderflow");
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        tops[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        int topInd = indexOfTop(stackNum);
        return values[topInd];
    }

    private boolean isEmpty(int stackNum) {
        return tops[stackNum] == -1;
    }

    public boolean isFull(int stackNum) {
        return tops[stackNum] + 1 >= capacity;
    }

    private int indexOfTop(int stackNum) {
        return stackNum * capacity * tops[stackNum];
    }
}
