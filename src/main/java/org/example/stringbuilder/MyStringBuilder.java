package org.example.stringbuilder;

public class MyStringBuilder {
    private char[] array;
    private int size;

    public MyStringBuilder() {
        this.array = new char[16];
        this.size = 0;
    }

    public MyStringBuilder append(String str) {
        ensureCapacity(size + str.length());
        for (int i = 0; i < str.length(); i++) {
            array[size++] = str.charAt(i);
        }
        return this;
    }

    public String toString(){
        return new String(array,0,size);
    }

    public MyStringBuilder reverse(String str){
        for (int i = 0; i < size / 2; i++) {
            char temp = array[i];
            array[i] = array[size-1-i];
            array[size-i-1] = temp;
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            char[] newArr = new char[newCapacity];
            System.arraycopy(array, 0, newArr, 0, size);
            array = newArr;
        }
    }
}
