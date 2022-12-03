package adventofcode.day3;

import adventofcode.utils.FileHandler;

import java.util.*;
import java.util.stream.Collectors;

public class Day3 {
    private static final int LOWERCASE_REDUCE_AMOUNT = 96;
    private static final int UPPERCASE_REDUCE_AMOUNT = 38;

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Character> duplicatedItems = new ArrayList<>();
        for (String line : lines) {

            int midChar = line.length() / 2;
            String firstCompartmentString = line.substring(0, midChar);
            String secondCompartmentString = line.substring(midChar);

            Set<Character> firstCompartment = firstCompartmentString.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> secondCompartment = secondCompartmentString.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            char duplicate = firstCompartment.stream().filter(secondCompartment::contains).findFirst().orElseThrow();

            duplicatedItems.add(duplicate);
        }

        int totalPriority = 0;
        for (Character item : duplicatedItems) {
            int itemNumber = item;
            if (itemNumber >= 96) {
                itemNumber -= LOWERCASE_REDUCE_AMOUNT;
            } else {
                itemNumber -= UPPERCASE_REDUCE_AMOUNT;
            }
            totalPriority += itemNumber;
        }

        return totalPriority;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);


        int totalPriority = 0;
        for (int i = 0; i < lines.size(); i += 3) {

            Set<Character> firstRucksack = lines.get(i).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> secondRucksack = lines.get(i + 1).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> thirdRucksack = lines.get(i + 2).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            int itemNumber = findCommonChar(List.of(firstRucksack, secondRucksack, thirdRucksack));
            if (itemNumber >= 96) {
                itemNumber -= LOWERCASE_REDUCE_AMOUNT;
            } else {
                itemNumber -= UPPERCASE_REDUCE_AMOUNT;
            }
            totalPriority += itemNumber;
        }


        return totalPriority;
    }

    private char findCommonChar(List<Set<Character>> rucksacks) {

        Map<Character, Integer> items = new HashMap<>();

        for (Set<Character> rucksack : rucksacks) {
            rucksack.forEach(i -> items.merge(i, 1, Integer::sum));
        }

        return items.entrySet().stream().filter(entry -> entry.getValue() > 2).findFirst().map(Map.Entry::getKey).orElseThrow();

    }

}
