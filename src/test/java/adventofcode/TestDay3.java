package adventofcode;

import adventofcode.day3.Day3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay3 {

    @Test
    void part1() {
        Day3 day = new Day3();
        long result = day.part1("testinput3.txt");
        assertEquals(157, result);
        result = day.part1("input3.txt");
        assertEquals(7878, result);
    }

    @Test
    void part2() {
        Day3 day = new Day3();
        long result = day.part2("testinput3.txt");
        assertEquals(70, result);
        result = day.part2("input3.txt");
        assertEquals(2760, result);
    }
}