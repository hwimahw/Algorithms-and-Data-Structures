package ru.nsd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTwoStacksTest {

    QueueTwoStacks<String> queueTwoStacks;

    @Before
    public void setUp() {
        queueTwoStacks = new QueueTwoStacks<>();
    }

    @Test
    public void pushBack() {
        queueTwoStacks.pushBack("First");
        queueTwoStacks.pushBack("Second");
        assertEquals(2, queueTwoStacks.getSize());
    }

    @Test
    public void popFront() {
        queueTwoStacks.pushBack("First");
        queueTwoStacks.pushBack("Second");
        queueTwoStacks.pushBack("Third");
        assertEquals("First", queueTwoStacks.popFront());
        assertEquals("Second", queueTwoStacks.popFront());
    }

}
