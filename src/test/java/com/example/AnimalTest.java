package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    Animal animal = new Animal();

    private final String testAnimalKind;
    private final List<String> expectedListOfFood;

    public AnimalTest (String testAnimalKind, List<String> expectedListOfFood) {
        this.testAnimalKind = testAnimalKind;
        this.expectedListOfFood = expectedListOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void testPositiveFoodValuesWithAnimal() throws Exception {
        List <String> actualListOfFeed = animal.getFood(testAnimalKind);
        assertEquals(expectedListOfFood, actualListOfFeed);

    }

    @Test
    public void testPositiveFamilyValueWithAnimal() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void testNullExceptionForEmptyStringInGetFood()  {
        assertThrows(
                Exception.class,
                () -> animal.getFood(null));
    }

    @Test
    public void testNonexistentAnimalKindExceptionMessage() {
        try {
            animal.getFood("Другое");
            fail("Expected validation exception was not thrown");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());

        }
    }
}