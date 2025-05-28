package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    fizzBuzz fizzbuzz = new fizzBuzz();

    @Test
    void testDivisibleBy3() {
        assertEquals("Fizz", fizzbuzz.fizzBuzz(3));
    }

    @Test
    void testDivisibleBy5() {
        assertEquals("Buzz", fizzbuzz.fizzBuzz(5));
    }

    @Test
    void testDivisibleBy3And5() {
        assertEquals("FizzBuzz", fizzbuzz.fizzBuzz(15));
    }

    @Test
    void testNotDivisibleBy3Or5() {
        assertEquals("2", fizzbuzz.fizzBuzz(2));
    }
}