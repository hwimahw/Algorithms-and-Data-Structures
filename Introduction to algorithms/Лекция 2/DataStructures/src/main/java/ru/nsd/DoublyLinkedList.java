package ru.nsd;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private int size;
    private Node<T> tail;


    public DoublyLinkedList(){
        head = null;
        size = 0;
        tail = null;
    }

    public int getSize(){
        return size;
    }


    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T var1) {
            this.data = var1;
        }
    }

    public T search(T object){
        Node<T> element = head;
        if(size > 0) {
            while (element != null && !element.data.equals(object)) {
                element = element.next;
            }
        }else{
            return null;
        }
        return element.data;
    }

    public int insert(T object){
        Node<T> node = new Node<>(object);
        if(head == null){
            head = node;
            tail = node;
            head.next = null;
            head.prev = null;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        return ++size;
    }

    public boolean delete(T object) {
        Node<T> element = head;
        while(element != null) {
            if (element.data.equals(object)) {
                if (element.prev == null) {
                    if (element.next != null) {
                        head = element.next;
                        element.next.prev = null;
                        element.next = null;
                    } else {
                        head = null;
                    }
                } else if (element.next != null) {
                    element.next.prev = element.prev;
                    element.prev.next = element.next;
                } else{
                    element.prev.next = null;
                }
                size--;
                return true;
            }
            element = element.next;
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
        return null;
    }

}
