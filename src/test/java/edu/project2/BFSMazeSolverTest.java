package edu.project2;

import edu.project2.maze.Maze;
import edu.project2.maze.MazeCell;
import edu.project2.mazeSolvers.BFSMazeSolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BFSMazeSolverTest {

    @Test
    @DisplayName("Test mazeBFSSearch function")
    void testMazeBFSSearch() {
        Maze maze = new Maze(13, 13);

        maze.mazeMatrix = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int[][] solvedMatrix = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 2, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 2, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 2, 2, 2, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 2, 2, 2, 1, 0, 0, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1},
            {1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1},
            {1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };


        MazeCell begin = new MazeCell(1, 1);
        MazeCell end = new MazeCell(11, 11);
        assertThat(BFSMazeSolver.mazeSolverBFS(begin, end, maze)).isEqualTo(solvedMatrix);

        begin = new MazeCell(2, 2);
        end = new MazeCell(11, 11);
        assertThat(BFSMazeSolver.mazeSolverBFS(begin, end, maze)).isEqualTo(null);
    }
}
