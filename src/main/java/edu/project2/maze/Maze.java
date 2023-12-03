package edu.project2.maze;

public class Maze {
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.mazeMatrix = new int[width][height];
    }

    private final int height;
    private final int width;

    public int height() {
        return this.height;
    }

    public int width() {
        return this.width;
    }

    public int[][] mazeMatrix;
}
