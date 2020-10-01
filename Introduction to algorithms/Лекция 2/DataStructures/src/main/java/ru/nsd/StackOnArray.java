package ru.nsd;

import java.util.EmptyStackException;

public class StackOnArray<T> {
    private T[] objects;
    private int top;
    private int size;

    public StackOnArray(int n){
        top = -1;
        objects = (T[])new Object[n];
        size = 0;
    }

    public boolean stackEmpty(){
        if(top >= 0){
            return false;
        }
        return true;
    }

    public boolean push(T object){
        if(this.top >= this.objects.length - 1){
            throw new StackOverflowError();
        }
        top++;
        size++;
        objects[top] = object;
        return true;
    }

    public int size(){
        return size;
    }

    public T pop(){
        if(top < 0){
            throw new EmptyStackException();
        }
        top--;
        size--;
        return objects[top + 1];
    }

    public T[] getObjects() {
        return objects;
    }

    public int getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }
}
