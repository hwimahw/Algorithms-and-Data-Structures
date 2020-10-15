package ru.nsd;

import java.util.EmptyStackException;

 class QueueTwoStacks<T> {
     private Stack<T> in;
     private Stack<T> out;
     private int size;

     public QueueTwoStacks(){
         in = new Stack<>(10);
         out = new Stack<>(10);
         size = 0;
     }

    public void pushBack(T object){
         in.push(object);
         size++;
    }

     public int getSize() {
         return size;
     }

     public T popFront(){
         T obj = null;
             if (out.stackEmpty()) {
                 while (!in.stackEmpty()) {
                     T object = in.pop();
                     out.push(object);
                 }
                 obj = out.pop();
             } else {
                 obj = out.pop();
             }
         return obj;
    }


    private static class Stack<T> {
        private T[] objects;
        private int top;

        public Stack(int n){
            top = -1;
            objects = (T[])new Object[n];
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
            objects[++top] = object;
           // top = top + 1;
            return true;
        }

        public T pop(){
            if(top < 0){
                throw new EmptyStackException();
            }
            top = top - 1;
            return objects[top + 1];
        }

    }

     public static void main(String[] args) {
         QueueTwoStacks<String> queue = new QueueTwoStacks<>();
         queue.pushBack("AAAA");
         queue.pushBack("BBBB");
         queue.pushBack("CCCC");
         queue.pushBack("DDDD");
         queue.pushBack("EEEE");
         System.out.println(queue.popFront());

     }
}
