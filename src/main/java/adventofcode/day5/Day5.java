package adventofcode.day5;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day5 {

    public String part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Stack<String>> stacks = new ArrayList<>();

        int numberOfStacks = (lines.get(0).length() + 1) / 4;

        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new Stack<>());
        }

        int numberLineId = findNumberLine(lines);

        for (int i = numberLineId - 1; i >= 0; i--) {
            String[] crates = lines.get(i).split("(?<=\\G.{4})");

            for (int j = 0; j < numberOfStacks; j++) {
                if (!crates[j].trim().isEmpty()) {
                    stacks.get(j).add(crates[j]);
                }
            }
        }

        for (int i = numberLineId + 2; i < lines.size(); i++) {

            String line = lines.get(i);
            line = line.replace("move ", "").replace(" from ", ",").replace(" to ", ",");

            int[] instructions = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

            for (int k = 0; k < instructions[0]; k++) {
                stacks.get(instructions[2] - 1).add(stacks.get(instructions[1] - 1).pop());
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Stack stack : stacks) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString().replace("[", "").replace("]", "").replace(" ", "");
    }

    public String part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Stack<String>> stacks = new ArrayList<>();

        int numberOfStacks = (lines.get(0).length() + 1) / 4;

        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new Stack<>());
        }

        int numberLineId = findNumberLine(lines);

        for (int i = numberLineId - 1; i >= 0; i--) {
            String[] crates = lines.get(i).split("(?<=\\G.{4})");

            for (int j = 0; j < numberOfStacks; j++) {
                if (!crates[j].trim().isEmpty()) {
                    stacks.get(j).add(crates[j]);
                }
            }
        }

        for (int i = numberLineId + 2; i < lines.size(); i++) {

            String line = lines.get(i);
            line = line.replace("move ", "").replace(" from ", ",").replace(" to ", ",");

            int[] instructions = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

            Stack<String> tempStack = new Stack<>();
            Stack<String> newStack = stacks.get(instructions[2] - 1);

            Stack<String> oldStack = stacks.get(instructions[1] - 1);

            for (int k = 0; k < instructions[0]; k++) {
                tempStack.add(oldStack.pop());
            }

            while (!tempStack.isEmpty()) {
                newStack.add(tempStack.pop());
            }
        }
        

        StringBuilder stringBuilder = new StringBuilder();
        for (Stack stack : stacks) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString().replace("[", "").replace("]", "").replace(" ", "");

    }

    private int findNumberLine(List<String> lines) {

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(" 1")) {
                return i;
            }
        }

        return 0;
    }
}
