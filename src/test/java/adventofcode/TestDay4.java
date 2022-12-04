package adventofcode;

import adventofcode.day4.Day4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay4 {

    @Test
    void part1() {
        Day4 day = new Day4();
        long result = day.part1("testinput4.txt");
        assertEquals(2, result);
        result = day.part1("input4.txt");
        assertEquals(464, result);
    }

    @Test
    void part2() {
        Day4 day = new Day4();
        long result = day.part2("testinput4.txt");
        assertEquals(4, result);
        result = day.part2("input4.txt");
        assertEquals(770, result);
    }
}