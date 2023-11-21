package edu.project2.mazeSolvers;

import edu.project2.maze.Maze;
import edu.project2.maze.MazeCell;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BFSMazeSolver {
    private BFSMazeSolver() {

    }

    private final static int WALL = 1;
    private final static int WAY = 2;

    public static int[][] mazeSolverBFS(MazeCell begin, MazeCell end, Maze maze) {

        int[][] visited = new int[maze.width()][maze.height()];
        for (int i = 0; i < maze.width(); i++) {
            if (maze.height() >= 0) {
                System.arraycopy(maze.mazeMatrix[i], 0, visited[i], 0, maze.height());
            }
        }

        //BFS
        Map<MazeCell, MazeCell> previousCell = bfs(begin, end, visited);

        //заполнение пути
        MazeCell current = end;
        while (current != begin) {
            if(previousCell == null || !previousCell.containsKey(current))
                return null;
            visited[current.x()][current.y()] = WAY;
            current = previousCell.get(current);
        }
        visited[current.x()][current.y()] = WAY;
        return visited;
    }

    private static Map<MazeCell, MazeCell> bfs(MazeCell begin, MazeCell end, int[][] visited) {
        HashMap<MazeCell, MazeCell> previousCell = new HashMap<>();
        if(visited[begin.x()][begin.y()] == 1)
            return null;
        previousCell.put(begin, begin);
        Deque<MazeCell> deque = new ArrayDeque<>();
        deque.addLast(begin);

        while (!deque.isEmpty() && !previousCell.containsKey(end)) {
            MazeCell top = deque.getFirst();
            deque.pollFirst();

            //путь сверху
            MazeCell newCell = new MazeCell(top.x() - 1, top.y());
            if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
                previousCell.put(newCell, top);
                deque.addLast(newCell);
            }

            //путь снизу
            newCell = new MazeCell(top.x() + 1, top.y());
            if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
                previousCell.put(newCell, top);
                deque.addLast(newCell);
            }

            //путь слева
            newCell = new MazeCell(top.x(), top.y() - 1);
            if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
                previousCell.put(newCell, top);
                deque.addLast(newCell);
            }

            //путь справа
            newCell = new MazeCell(top.x(), top.y() + 1);
            if (!previousCell.containsKey(newCell) && visited[newCell.x()][newCell.y()] != WALL) {
                previousCell.put(newCell, top);
                deque.addLast(newCell);
            }
        }
        return previousCell;
    }
}
