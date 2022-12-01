package adventofcode;

import adventofcode.day1.Day1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay1 {

	@Test
	public void testSolveDay1Part1() {
		Day1 day1 = new Day1();
		int result = day1.solveDay1("testinput1.txt");

		assertEquals(24000, result);

		System.out.println(day1.solveDay1("input1.txt"));
	}

	@Test
	public void testSolveDay1Part2() {
		Day1 day1 = new Day1();
		int result = day1.solveDay1Part2("testinput1.txt");

		assertEquals(45000, result);

		result = day1.solveDay1Part2("input1.txt");
		System.out.println(day1.solveDay1Part2("input1.txt"));

		assertEquals(196804, result);

	}
}