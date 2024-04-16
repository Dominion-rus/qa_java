package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalTest {
    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Корм");
        when(felineMock.eatMeat()).thenReturn(food);
        List<String> result = cat.getFood();
        assertEquals(food, result);
    }


    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> meat = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(meat);
        assertEquals(meat, felineMock.eatMeat());
    }

    @Test
    public void testFelineGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testCatGetSound() {
        Cat cat = new Cat(new Feline());
        Assert.assertEquals("Мяу", cat.getSound());
    }
}
