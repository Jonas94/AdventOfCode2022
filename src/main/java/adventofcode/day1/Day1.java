package adventofcode.day1;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day1 {
    public int solveDay1(String inputFile) {
        Map<Integer, List<Integer>> caloriesMap = readStringsToNumbers(inputFile);

        return sumEveryBackpack(caloriesMap).stream().mapToInt(v -> v).max().orElseThrow();
    }

    public int solveDay1Part2(String inputFile) {
        Map<Integer, List<Integer>> caloriesMap = readStringsToNumbers(inputFile);
        List<Integer> summedCalories = sumEveryBackpack(caloriesMap);
        Collections.sort(summedCalories);
        Collections.reverse(summedCalories);

        int sumOfTop3HighestCalories = 0;
        for (int i = 0; i < 3; i++) {
            sumOfTop3HighestCalories += summedCalories.get(i);
        }

        return sumOfTop3HighestCalories;
    }

    private List<Integer> sumEveryBackpack(Map<Integer, List<Integer>> calorieMap) {
        List<Integer> calorieList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : calorieMap.entrySet()) {
            int elfCalorieSum = 0;
            for (Integer calorie : entry.getValue()) {
                elfCalorieSum += calorie;
            }
            calorieList.add(elfCalorieSum);
        }

        return calorieList;
    }

    private Map<Integer, List<Integer>> readStringsToNumbers(String inputFile) {
        List<String> numberStrings = FileHandler.readFileIntoList(inputFile);
        numberStrings.add(""); //Empty string to add the last elf

        Map<Integer, List<Integer>> caloriesMap = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();

        int elfNumber = 0;
        for (String number : numberStrings) {
            if (number != null && !number.isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    System.out.println("Something went wrong parsing number");
                }
            } else {
                caloriesMap.put(elfNumber, List.copyOf(numbers));
                numbers.clear();
                elfNumber++;
            }
        }
        return caloriesMap;
    }
}
