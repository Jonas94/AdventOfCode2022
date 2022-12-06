package adventofcode;

import adventofcode.day5.Day5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay5 {

    @Test
    void part1() {
        Day5 day = new Day5();
        String result = day.part1("testinput5.txt");
        assertEquals("CMZ", result);
        result = day.part1("input5.txt");
        assertEquals("FJSRQCFTN", result);
    }

    @Test
    void part2() {
        Day5 day = new Day5();
        String result = day.part2("testinput5.txt");
        assertEquals("MCD", result);
        assertEquals("CJVLJQPHS", day.part2("input5.txt"));
    }
}