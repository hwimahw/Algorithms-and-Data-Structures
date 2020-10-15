package ru.nsd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    SinglyLinkedList<String> singlyLinkedList;

    @Before
    public void setUp(){
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void insert(){
        singlyLinkedList.insert("First");
        singlyLinkedList.insert("Second");
        assertEquals(2, singlyLinkedList.getSize());
    }

    @Test
    public void search(){
        singlyLinkedList.insert("First");
        singlyLinkedList.insert("Second");
        singlyLinkedList.insert("Third");
        singlyLinkedList.insert("Fourth");
        String actual = singlyLinkedList.search("Third");
        assertEquals("Third", actual);
        assertEquals(4, singlyLinkedList.getSize());
    }

    @Test
    public void get(){
        singlyLinkedList.insert("First");
        singlyLinkedList.insert("Second");
        singlyLinkedList.insert("Third");
        singlyLinkedList.insert("Fourth");
        String actual = singlyLinkedList.get(3);
        assertEquals("First", actual);
    }

    @Test
    public void delete(){
        singlyLinkedList.insert("First");
        singlyLinkedList.insert("Second");
        singlyLinkedList.insert("Third");
        singlyLinkedList.insert("Fourth");
        assertTrue(singlyLinkedList.delete("Third"));
        assertEquals(3, singlyLinkedList.getSize());
    }


}
