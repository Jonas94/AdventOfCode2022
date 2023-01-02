package adventofcode.day14;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day14 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        Set<Point> stonePoints = new HashSet<>();

        for (String line : lines) {
            String[] pointsArray = line.split(" -> ");
            List<Point> points = new ArrayList<>();
            for (String pointString : pointsArray) {
                String[] point = pointString.split(",");
                points.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
            }

            for (int i = 1; i < points.size(); i++) {
                Point firstPoint = points.get(i - 1);
                Point secondPoint = points.get(i);

                if (firstPoint.x == secondPoint.x) {
                    if (firstPoint.y >= secondPoint.y) {
                        for (int y = secondPoint.y; y <= firstPoint.y; y++) {
                            stonePoints.add(new Point(firstPoint.x, y));
                        }

                    } else {
                        for (int y = firstPoint.y; y <= secondPoint.y; y++) {
                            stonePoints.add(new Point(firstPoint.x, y));
                        }
                    }
                }
                if (firstPoint.y == secondPoint.y) {
                    if (firstPoint.x >= secondPoint.x) {
                        for (int x = secondPoint.x; x <= firstPoint.x; x++) {
                            stonePoints.add(new Point(x, firstPoint.y));
                        }

                    } else {
                        for (int x = firstPoint.x; x <= secondPoint.x; x++) {
                            stonePoints.add(new Point(x, firstPoint.y));
                        }
                    }
                }
            }
        }

        Set<Point> pointsFilled = new HashSet<>(stonePoints);

        int sandStartX = 500;
        int sandStartY = 0;
        boolean sandOverflow = false;

        int leftEdge = findLeftEdge(stonePoints);
        int rightEdge = findRightEdge(stonePoints);
        int bottom = findStoneBottom(stonePoints);

        while (!sandOverflow) {
            Point currentSandPoint = new Point(sandStartX, sandStartY);
            boolean sandRest = false;
            while (!sandRest) {
                if (currentSandPoint.x < leftEdge || currentSandPoint.x > rightEdge || currentSandPoint.y > bottom) {
                    sandOverflow = true;
                    break;
                }

                if (!pointsFilled.contains(new Point(currentSandPoint.x, currentSandPoint.y + 1))) {
                    currentSandPoint.y++;
                } else if (!pointsFilled.contains(new Point(currentSandPoint.x - 1, currentSandPoint.y + 1))) {
                    currentSandPoint.x--;
                    currentSandPoint.y++;
                } else if (!pointsFilled.contains(new Point(currentSandPoint.x + 1, currentSandPoint.y + 1))) {
                    currentSandPoint.x++;
                    currentSandPoint.y++;
                } else {
                    pointsFilled.add(new Point(currentSandPoint.x, currentSandPoint.y));
                    sandRest = true;
                }
            }
        }
        return pointsFilled.size() - stonePoints.size();
    }

    private int findLeftEdge(Set<Point> stonePoints) {
        return stonePoints.stream().mapToInt(v -> v.x).min().orElseThrow();
    }

    private int findRightEdge(Set<Point> stonePoints) {
        return stonePoints.stream().mapToInt(v -> v.x).max().orElseThrow();
    }

    private int findStoneBottom(Set<Point> stonePoints) {
        return stonePoints.stream().mapToInt(v -> v.y).max().orElseThrow();
    }

    private int findFloorY(Set<Point> stonePoints) {
        return stonePoints.stream().mapToInt(v -> v.y).max().orElseThrow() + 2;
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        Set<Point> stonePoints = new HashSet<>();

        for (String line : lines) {
            String[] pointsArray = line.split(" -> ");
            List<Point> points = new ArrayList<>();
            for (String pointString : pointsArray) {
                String[] point = pointString.split(",");
                points.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
            }


            for (int i = 1; i < points.size(); i++) {
                Point firstPoint = points.get(i - 1);
                Point secondPoint = points.get(i);

                if (firstPoint.x == secondPoint.x) {
                    if (firstPoint.y >= secondPoint.y) {
                        for (int y = secondPoint.y; y <= firstPoint.y; y++) {
                            stonePoints.add(new Point(firstPoint.x, y));
                        }

                    } else {
                        for (int y = firstPoint.y; y <= secondPoint.y; y++) {
                            stonePoints.add(new Point(firstPoint.x, y));
                        }
                    }
                }
                if (firstPoint.y == secondPoint.y) {
                    if (firstPoint.x >= secondPoint.x) {
                        for (int x = secondPoint.x; x <= firstPoint.x; x++) {
                            stonePoints.add(new Point(x, firstPoint.y));
                        }

                    } else {
                        for (int x = firstPoint.x; x <= secondPoint.x; x++) {
                            stonePoints.add(new Point(x, firstPoint.y));
                        }
                    }
                }
            }
        }

        //Add "infinite" floor

        int size = 1000;
        int floorY = findFloorY(stonePoints);
        for (int i = -size; i <= size; i++) {
            stonePoints.add(new Point(i, floorY));
        }

        Set<Point> pointsFilled = new HashSet<>();
        pointsFilled.addAll(stonePoints);

        int sandStartX = 500;
        int sandStartY = 0;
        boolean sandOverflow = false;

        int leftEdge = findLeftEdge(stonePoints);
        int rightEdge = findRightEdge(stonePoints);
        int bottom = findStoneBottom(stonePoints);
        while (!sandOverflow) {
            Point currentSandPoint = new Point(sandStartX, sandStartY);
            boolean sandRest = false;
            while (!sandRest) {
                if (currentSandPoint.x < leftEdge || currentSandPoint.x > rightEdge || currentSandPoint.y > bottom) {
                    sandOverflow = true;
                    break;
                }

                if (!pointsFilled.contains(new Point(currentSandPoint.x, currentSandPoint.y + 1))) {
                    currentSandPoint.y++;
                } else if (!pointsFilled.contains(new Point(currentSandPoint.x - 1, currentSandPoint.y + 1))) {
                    currentSandPoint.x--;
                    currentSandPoint.y++;
                } else if (!pointsFilled.contains(new Point(currentSandPoint.x + 1, currentSandPoint.y + 1))) {
                    currentSandPoint.x++;
                    currentSandPoint.y++;
                } else {
                    pointsFilled.add(new Point(currentSandPoint.x, currentSandPoint.y));
                    sandRest = true;
                    if (currentSandPoint.x == 500 && currentSandPoint.y == 0) {
                        sandOverflow = true;
                        break;
                    }
                }
            }
        }
        return pointsFilled.size() - stonePoints.size();
    }

}
