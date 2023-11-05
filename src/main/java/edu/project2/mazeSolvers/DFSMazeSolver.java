package edu.project2.mazeSolvers;

import edu.project2.maze.Maze;
import edu.project2.maze.MazeCell;
import java.util.HashMap;
import java.util.Map;

public class DFSMazeSolver {
    private DFSMazeSolver() {

    }

    private final static int WALL = 1;
    private final static int WAY = 2;

    public static int[][] mazeSolverDFS(MazeCell begin, MazeCell end, Maze maze) {

        int[][] visited = new int[maze.width()][maze.height()];
        for (int i = 0; i < maze.width(); i++) {
            if (maze.height() >= 0) {
                System.arraycopy(maze.mazeMatrix[i], 0, visited[i], 0, maze.height());
            }
        }

        //DFS
        HashMap<MazeCell, MazeCell> previousCell = new HashMap<>();
        previousCell.put(begin, begin);
        dfs(begin, visited, previousCell);

        //заполнение пути
        MazeCell current = end;
        while (current != begin) {
            visited[current.x()][current.y()] = WAY;
            current = previousCell.get(current);
        }
        visited[current.x()][current.y()] = WAY;
        return visited;
    }

    private static void dfs(MazeCell begin, int[][] visited, Map<MazeCell, MazeCell> previousCell) {
        //путь сверху
        MazeCell newCell = new MazeCell(begin.x() - 1, begin.y());
        if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
            previousCell.put(newCell, begin);
            dfs(newCell, visited, previousCell);
        }

        //путь снизу
        newCell = new MazeCell(begin.x() + 1, begin.y());
        if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
            previousCell.put(newCell, begin);
            dfs(newCell, visited, previousCell);
        }

        //путь слева
        newCell = new MazeCell(begin.x(), begin.y() - 1);
        if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
            previousCell.put(newCell, begin);
            dfs(newCell, visited, previousCell);
        }

        //путь справа
        newCell = new MazeCell(begin.x(), begin.y() + 1);
        if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
            previousCell.put(newCell, begin);
            dfs(newCell, visited, previousCell);
        }
    }
}
