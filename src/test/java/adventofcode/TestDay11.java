package adventofcode;

import adventofcode.day11.Day11;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay11 {

    @Test
    void part1() {
        Day11 day = new Day11();
        assertEquals(10605, day.part1("testinput11.txt"));
        assertEquals(51075, day.part1("input11.txt"));
    }

    @Test
    void part2() {
        Day11 day = new Day11();
        assertEquals(0, day.part2("testinput11.txt"));
       // assertEquals(0, day.part2("input11.txt"));
    }
}