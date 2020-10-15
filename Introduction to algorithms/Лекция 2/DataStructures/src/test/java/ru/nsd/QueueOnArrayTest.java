package ru.nsd;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueOnArrayTest {

    QueueOnArray<String> queueOnArray;

    @Before
    public void setUp(){
        queueOnArray = new QueueOnArray<>(3);
    }

    @Test
    public void enqueueIf(){
        queueOnArray.enqueue("First");
        queueOnArray.enqueue("Second");
        queueOnArray.enqueue("Third");
        queueOnArray.setHead(1);
        queueOnArray.enqueue("Fourth");
        assertEquals(0, queueOnArray.getTail());
    }

    @Test
    public void enqueueElse(){
        queueOnArray.enqueue("First");
        queueOnArray.enqueue("Second");
        assertEquals(0, queueOnArray.getHead());
        assertEquals(1, queueOnArray.getTail());
    }

    @Test
    public void dequeueIf(){
        queueOnArray.enqueue("First");
        queueOnArray.enqueue("Second");
        queueOnArray.enqueue("Third");
        queueOnArray.setHead(2);
        queueOnArray.setTail(0);
        String actual = queueOnArray.dequeue();
        assertEquals(0, queueOnArray.getHead());
        assertEquals("Third", actual);
    }

    @Test
    public void dequeueElse(){
        queueOnArray.enqueue("First");
        queueOnArray.enqueue("Second");
        queueOnArray.enqueue("Third");
        String actual = queueOnArray.dequeue();
        assertEquals(1, queueOnArray.getHead());
        assertEquals("First", actual);
    }

}
