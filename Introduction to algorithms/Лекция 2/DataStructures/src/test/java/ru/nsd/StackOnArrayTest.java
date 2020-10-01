package ru.nsd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackOnArrayTest {
    StackOnArray<String> stackOnArray;

    @Before
    public void setUp(){
        stackOnArray = new StackOnArray<>(5);
    }

    @Test
    public void stackEmptyTrue(){
        assertTrue(stackOnArray.stackEmpty());
    }

    @Test
    public void stackEmptyFalse(){
        stackOnArray.push("FirstObject");
        assertFalse(stackOnArray.stackEmpty());
    }

    @Test
    public void push(){
        stackOnArray.push("FirstObject");
        stackOnArray.push("SecondObject");
        stackOnArray.push("ThirdObject");
        assertEquals(2, stackOnArray.getTop());
        assertEquals(3, stackOnArray.getSize());
    }

    @Test
    public void pop(){
        stackOnArray.push("FirstObject");
        stackOnArray.push("SecondObject");
        stackOnArray.push("ThirdObject");
        assertEquals("ThirdObject", stackOnArray.pop());
        assertEquals("SecondObject", stackOnArray.pop());
        assertEquals("FirstObject", stackOnArray.pop());
        assertEquals(-1, stackOnArray.getTop());
        assertEquals(0, stackOnArray.getSize());
    }




}
