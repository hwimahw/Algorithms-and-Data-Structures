package ru.nsd;


public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;
    private int capacity;

    public DynamicArray(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public int add(T object){
        if(size < capacity){
            array[size] = object;
            size++;
        }else{
            this.array = resize();
            array[size] = object;
            size++;
        }
        return size;
    }

    private Object[] resize() {
        int newSize = size * 2;
        capacity = newSize;
        Object[] copyArray = new Object[newSize];
        for (int i = 0; i < this.size; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    public T get(int i){
        if(i < size){
            return (T)array[i];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("AAA");
        dynamicArray.add("BBB");
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.get(1));
    }

    public int getCapacity() {
        return capacity;
    }

    public Object[] getArray() {
        return array;
    }
}