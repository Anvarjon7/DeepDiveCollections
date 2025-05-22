package org.example.arraylist;

import java.util.ArrayList;

public class MyArrayList<T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[10];
        this.size = 0;
    }


    public void add(T value){
        ensureCapacity();
        array[size++] = value;
    }

    public T get(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }

        array[size - 1] = null;
        size--;
    }

    public int size(){
        return size;
    }
    private void checkIndex(int index){
        if(index < 0 && index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(){
        if (size == array.length){
            Object[] newArr = new Object[array.length * 2];
            System.arraycopy(array,0,newArr,0,array.length);
            array = newArr;
        }
    }
}
