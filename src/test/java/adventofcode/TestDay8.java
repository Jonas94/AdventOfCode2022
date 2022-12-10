package adventofcode;

import adventofcode.day8.Day8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay8 {

    @Test
    void part1() {
        Day8 day = new Day8();
        assertEquals(21, day.part1("testinput8.txt"));
        assertEquals(1782, day.part1("input8.txt"));
    }

    @Test
    void part2() {
        Day8 day = new Day8();
        assertEquals(8, day.part2("testinput8.txt"));
        assertEquals(474606, day.part2("input8.txt"));
    }
}