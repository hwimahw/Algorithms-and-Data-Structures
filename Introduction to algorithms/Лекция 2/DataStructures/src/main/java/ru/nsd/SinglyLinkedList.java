package ru.nsd;

import java.util.LinkedList;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;


    public SinglyLinkedList(){
        head = null;
        size = 0;
    }

    public T search(T object){
        Node<T> element = head;
        if(size > 0) {
            while (element != null && !element.data.equals(object)) {
                element = element.next;
            }
        }else{
            return null; //throw new RuntimeException(); вместо null лучше бросать эксепшны!
        }
        return element.data;
    }

    public int insert(T object){
        Node<T> node = new Node<>(object);
        if(head == null){
            head = node;
            head.next = null;
        }else{
            node.next = head;
            head = node;
        }
        return ++size;
    }


    public boolean delete(T object) {
        Node element = head;
        if(element != null) {
            while(element != null){
                if(element.data.equals(object)) {
                    if(element == head){
                        head = null;
                    }
                    size--;
                    return true;
                }
                element = element.next;
            }
        }
        return false;
    }

    public T get(int i){
        if(i >= 0 && i < this.size) {
            int number = 0;
            Node<T> node = this.head;
            while (number != i && node != null) {
                node = node.next;
                number++;
            }
            return node.data;
        }
        return null;    //throw new RuntimeException(); вместо null лучше бросать эксепшны!
    }



    public static void main(String[] args) {

    }

    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

//    private static class Node<E> {
//        E item;
//        SinglyLinkedList.Node<E> next;
//        SinglyLinkedList.Node<E> prev;
//
//        Node(SinglyLinkedList.Node<E> var1, E var2, SinglyLinkedList.Node<E> var3) {
//            this.item = var2;
//            this.next = var3;
//            this.prev = var1;
//        }
//    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T var2) {
            this.data = var2;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

    }


}
