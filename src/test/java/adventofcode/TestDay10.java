package adventofcode;

import adventofcode.day10.Day10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay10 {

    @Test
    void part1() {
        Day10 day = new Day10();
        assertEquals(13140, day.part1("testinput10.txt"));
        assertEquals(15220, day.part1("input10.txt"));
    }

    @Test
    void part2() {
        Day10 day = new Day10();
        assertEquals(getTestOutput(), day.part2("testinput10.txt"));
        assertEquals(getExpectedOutput(), day.part2("input10.txt"));
    }



    private String getTestOutput(){
        return """
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....""";
    }
    
    
    private String getExpectedOutput(){
        return """
                ###..####.####.####.#..#.###..####..##..
                #..#.#.......#.#....#.#..#..#.#....#..#.
                #..#.###....#..###..##...###..###..#..#.
                ###..#.....#...#....#.#..#..#.#....####.
                #.#..#....#....#....#.#..#..#.#....#..#.
                #..#.#....####.####.#..#.###..#....#..#.""";
    }
}