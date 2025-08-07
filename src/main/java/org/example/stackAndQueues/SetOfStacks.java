package org.example.stackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {

    List<MyStack> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    void push(int v) throws Exception {
        MyStack last = stacks.getLast();
        if (last != null && !last.isFull()) {
            last.push(v);
        } else {
            MyStack stack = new MyStack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    int pop() throws Exception {
        MyStack last = stacks.getLast();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.isEmpty()) stacks.remove(last);
        return v;
    }

//    int popAt(int index) throws Exception {
//        if (index < 0 || index > stacks.size()){
//            throw new IndexOutOfBoundsException("OutOfBoundEx");
//        }
//
//        MyStack stack = stacks.get(index);
//        int v = stack.pop();
//        if (stack.isEmpty()) {
//            stacks.remove(stack);
//        }
//        return v;
//    }

    int popAt(int index) throws Exception {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException();
        }
        return leftShift(index, true);
    }


    private int leftShift(int index, boolean removeTop) throws Exception {
        MyStack stack = stacks.get(index);

        int removedItem = removeTop ? stack.pop() : stack.removeBottom();

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (index + 1 < stacks.size()) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }

        return removedItem;
    }


}
