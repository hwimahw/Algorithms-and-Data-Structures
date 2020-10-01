package ru.nsd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    DynamicArray<String> dynamicArray;

    @Before
    public void setUp(){
        dynamicArray = new DynamicArray<>();
    }

    @Test
    public void addIf(){
        dynamicArray.add("FirstObject");
        dynamicArray.add("SecondObject");

        assertEquals(2, dynamicArray.size());
    }
    @Test
    public void addElse(){
        dynamicArray.add("FirstObject");
        dynamicArray.add("SecondObject");
        dynamicArray.add("ThirdObject");
        dynamicArray.add("FourthObject");
        dynamicArray.add("FifthObject");
        dynamicArray.add("SixthObject");

        assertEquals(6, dynamicArray.size());
        assertEquals(10, dynamicArray.getCapacity());

    }

    @Test
    public void get(){
        dynamicArray.add("FirstObject");
        dynamicArray.add("SecondObject");
        dynamicArray.add("ThirdObject");
        dynamicArray.add("FourthObject");
        dynamicArray.add("FifthObject");
        dynamicArray.add("SixthObject");

        assertEquals("FirstObject",dynamicArray.get(0));
        assertEquals("SixthObject",dynamicArray.get(5));
    }
}
