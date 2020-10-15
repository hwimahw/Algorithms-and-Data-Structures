package ru.nsd;

public class QueueOnArray<T> {
    private T[] objects;
    private int head;
    private int tail;


    public QueueOnArray(int n){
        objects = (T[]) new Object[n];
        head = -1;
        tail = -1;
    }

    public boolean enqueue(T object){
        if(head == tail + 1 || ((head == 0) && (tail == objects.length - 1))){
            throw new RuntimeException(); // ошибка переполнения
        }
        if(tail == objects.length - 1) {
            tail = 0;
        }else{
            tail++;
        }
        objects[tail] = object;
        if(head == -1){
            head = 0;
        }
        return true;
    }

    public T dequeue(){
        if(head == tail + 1 || head == -1){
            throw new RuntimeException(); // ошибка пустоты
        }
        T object = objects[head];
        if(head == objects.length - 1){
            head = 0;
        }else{
            head = head + 1;
        }
        return object;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public T[] getObjects() {
        return objects;
    }

    public void setObjects(T[] objects) {
        this.objects = objects;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
