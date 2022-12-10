package adventofcode;

import adventofcode.day7.Day7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay7 {

    @Test
    void part1() {
        Day7 day = new Day7();
        long result = day.part1("testinput7.txt");
        assertEquals(95437, result);
        assertEquals(1307902, day.part1("input7.txt"));
    }

    @Test
    void part2() {
        Day7 day = new Day7();
        long result = day.part2("testinput7.txt");
        assertEquals(24933642, result);
        assertEquals(7068748, day.part2("input7.txt"));
    }
}