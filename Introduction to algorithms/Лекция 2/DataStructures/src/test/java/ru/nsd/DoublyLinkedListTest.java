package ru.nsd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {
    DoublyLinkedList<String> doublyLinkedList;

    @Before
    public void setUp(){
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void search(){
        doublyLinkedList.insert("First");
        doublyLinkedList.insert("Second");
        doublyLinkedList.insert("Third");
        doublyLinkedList.insert("Fourth");
        String actual = doublyLinkedList.search("First");
        assertEquals("First", actual);
        assertEquals(4, doublyLinkedList.getSize());
    }

    @Test
    public void delete(){
        doublyLinkedList.insert("First");
        doublyLinkedList.insert("Second");
        doublyLinkedList.insert("Third");
        doublyLinkedList.insert("Fourth");
        assertTrue(doublyLinkedList.delete("First"));
        assertTrue(doublyLinkedList.delete("Third"));
        assertTrue(doublyLinkedList.delete("Fourth"));

        assertEquals(1, doublyLinkedList.getSize());
    }

    @Test
    public void get(){
        doublyLinkedList.insert("First");
        doublyLinkedList.insert("Second");
        doublyLinkedList.insert("Third");
        doublyLinkedList.insert("Fourth");
        String actual = doublyLinkedList.get(2);
        assertEquals("Second", actual);
    }
}
