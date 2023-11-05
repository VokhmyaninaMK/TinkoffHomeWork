package edu.project2;

import edu.project2.maze.Maze;
import edu.project2.maze.MazeCell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MazeGameTest {
    @Test
    @DisplayName("Test mazePrint function")
    void testMazePrint() {
        Maze maze = new Maze(13, 13);

        maze.mazeMatrix = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        ArrayList<String> correctMaze = new ArrayList<>(List.of(
            "███████████████████████████████████████",
            "███   ███                     ███   ███",
            "███   █████████   █████████   ███   ███",
            "███   ███         ███   ███         ███",
            "███   ███   █████████   █████████   ███",
            "███         ███               ███   ███",
            "███████████████   ███   ███   ███   ███",
            "███   ███         ███   ███   ███   ███",
            "███   ███   █████████   █████████   ███",
            "███         ███   ███         ███   ███",
            "███   █████████   █████████   ███   ███",
            "███                     ███         ███",
            "███████████████████████████████████████"
        ));

        assertThat(MazeGame.mazePrint(maze.mazeMatrix)).isEqualTo(correctMaze);
    }

    @Test
    @DisplayName("Test mazeSolver function")
    void testMazeSolver() {
        Maze maze = new Maze(13, 13);

        maze.mazeMatrix = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        ArrayList<String> correctMaze = new ArrayList<>(List.of(
            "███████████████████████████████████████",
            "███ ◆ ███       ◆  ◆  ◆  ◆  ◆ ███   ███",
            "███ ◆ █████████ ◆ █████████ ◆ ███   ███",
            "███ ◆ ███ ◆  ◆  ◆ ███   ███ ◆  ◆  ◆ ███",
            "███ ◆ ███ ◆ █████████   █████████ ◆ ███",
            "███ ◆  ◆  ◆ ███               ███ ◆ ███",
            "███████████████   ███   ███   ███ ◆ ███",
            "███   ███         ███   ███   ███ ◆ ███",
            "███   ███   █████████   █████████ ◆ ███",
            "███         ███   ███         ███ ◆ ███",
            "███   █████████   █████████   ███ ◆ ███",
            "███                     ███       ◆ ███",
            "███████████████████████████████████████"

        ));

        MazeCell begin = new MazeCell(1, 1);
        MazeCell end = new MazeCell(11, 11);

        assertThat(MazeGame.mazePrint(maze.mazeMatrix)).isEqualTo(correctMaze);
    }
}
