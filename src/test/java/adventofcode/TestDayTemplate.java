package adventofcode;

import adventofcode.dayTemplate.DayTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDayTemplate {

    @Test
    void part1() {
        DayTemplate day = new DayTemplate();
        assertEquals(0, day.part1("testinputTemplate.txt"));
        assertEquals(0, day.part1("inputTemplate.txt"));
    }

    @Test
    void part2() {
        DayTemplate day = new DayTemplate();
        assertEquals(0, day.part2("testinputTemplate.txt"));
        assertEquals(0, day.part2("inputTemplate.txt"));
    }
}