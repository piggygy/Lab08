package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCities() {
        list = MockCityList();
        City city = new City("TTT", "AAA");
        City city2 = new City("TT", "AA");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(city2));
    }

    @Test
    void testDeleteCities() {
        list = MockCityList();
        City city = new City("TTT", "AAA");
        City city2 = new City("TT", "AA");
        list.addCity(city);
        list.delete(city);
        Assert.assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city2);});

    }

    @Test
    void testCountCities(){
        list = MockCityList();
        City city = new City("TTT", "AAA");
        Assert.assertEquals(0, list.getCount());
        list.addCity(city);
        Assert.assertEquals(1, list.getCount());
        list.delete(city);
        Assert.assertEquals(0, list.getCount());
    }



}
