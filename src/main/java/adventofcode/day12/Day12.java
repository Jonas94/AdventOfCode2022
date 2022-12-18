package adventofcode.day12;

import adventofcode.utils.FileHandler;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Day12 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = new char[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < lines.get(0).length(); j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        java.util.Queue<Node> queue = new LinkedList<>();

        Node startingNode = new Node(findStartingPosition(grid), 0);

        queue.add(startingNode);
        Set<Point> visited = new HashSet<>();
        int currentDistance = 0;

        visited.add(startingNode.point());
        boolean foundE = false;
        while (!queue.isEmpty()) {
            if (foundE) {
                System.out.println("E found");
                break;
            }
            Node current = queue.poll();
            currentDistance = current.distance();

            for (Point neighbour : findNeighbours(current.point(), grid)) {
                char currentChar = grid[current.point().x][current.point().y];
                char neighbourChar = grid[neighbour.x][neighbour.y];
                if (neighbourChar == 'E' && isTraversable(currentChar, neighbourChar)) {
                    currentDistance++;
                    foundE = true;
                    break;
                }
                if (!visited.contains(neighbour) && isTraversable(currentChar, neighbourChar)) {
                    Node newNode = new Node(neighbour, currentDistance + 1);
                    queue.add(newNode);
                    visited.add(newNode.point());
                }
            }
            visited.add(new Point(current.point().x, current.point().y));

        }

        return currentDistance;
    }

    private record Node(Point point, int distance) {
    }

    private List<Point> findNeighbours(Point point, char[][] grid) {

        List<Point> neighbours = new ArrayList<>();

        if (isValidPoint(getRightNeighbour(point), grid)) {
            neighbours.add(getRightNeighbour(point));
        }

        if (isValidPoint(getLeftNeighbour(point), grid)) {
            neighbours.add(getLeftNeighbour(point));
        }

        if (isValidPoint(getBelowNeighbour(point), grid)) {
            neighbours.add(getBelowNeighbour(point));
        }

        if (isValidPoint(getAboveNeighbour(point), grid)) {
            neighbours.add(getAboveNeighbour(point));
        }


        return neighbours;
    }

    private Point findStartingPosition(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }


    private Point getAboveNeighbour(Point currentPosition) {
        return new Point(currentPosition.x - 1, currentPosition.y);
    }

    private Point getBelowNeighbour(Point currentPosition) {
        return new Point(currentPosition.x + 1, currentPosition.y);
    }

    private Point getLeftNeighbour(Point currentPosition) {
        return new Point(currentPosition.x, currentPosition.y - 1);
    }

    private Point getRightNeighbour(Point currentPosition) {
        return new Point(currentPosition.x, currentPosition.y + 1);
    }

    private boolean isValidPoint(Point point, char[][] grid) {
        return point.x < grid.length && point.x >= 0 && point.y < grid[0].length && point.y >= 0;
    }

    private boolean isTraversable(char current, char neighbour) {

        if (neighbour == 'S') {
            return true;
        }
        if (neighbour == 'E') {
            return current == 'y' || current == 'z';
        }

        return neighbour - current <= 1 || current == 'S';
    }

    private List<Point> possibleStartingNodes(char[][] grid) {

        List<Point> startingNodes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'a') {
                    startingNodes.add(new Point(i, j));
                }
            }
        }
        return startingNodes;

    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = new char[lines.size()][lines.get(0).length()];

        Map<Integer, Point> numberOfStepsFromStartingPoints = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < lines.get(0).length(); j++) {
                grid[i][j] = line.charAt(j);
            }
        }


        for (Point point : possibleStartingNodes(grid)) {

            java.util.Queue<Node> queue = new LinkedList<>();

            Node startingNode = new Node(point, 0);

            queue.add(startingNode);
            Set<Point> visited = new HashSet<>();
            int currentDistance = 0;

            visited.add(startingNode.point());
            boolean foundE = false;
            while (!queue.isEmpty()) {
                if (foundE) {
                    numberOfStepsFromStartingPoints.put(currentDistance, point);

                    break;
                }
                Node current = queue.poll();
                currentDistance = current.distance();

                for (Point neighbour : findNeighbours(current.point(), grid)) {
                    char currentChar = grid[current.point().x][current.point().y];
                    char neighbourChar = grid[neighbour.x][neighbour.y];
                    if (neighbourChar == 'E' && isTraversable(currentChar, neighbourChar)) {
                        currentDistance++;
                        foundE = true;
                    }
                    if (!visited.contains(neighbour) && isTraversable(currentChar, neighbourChar)) {
                        Node newNode = new Node(neighbour, currentDistance + 1);
                        queue.add(newNode);
                        visited.add(newNode.point());
                    }
                }
                visited.add(new Point(current.point().x, current.point().y));

            }

        }

        return numberOfStepsFromStartingPoints.keySet().stream().sorted().limit(1).collect(Collectors.toList()).get(0);
    }


}
