package edu.project2;

import edu.project2.generators.BFSMazeGenerator;
import edu.project2.maze.Maze;
import edu.project2.maze.MazeCell;
import edu.project2.mazeSolvers.BFSMazeSolver;
import edu.project2.mazeSolvers.DFSMazeSolver;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeGame {

    public MazeGame() {

    }

    private static final String WIDTH_AND_HEIGHT_OF_MAZE = "Input width and height of maze:";
    private static final String BEGIN_OF_THE_WAY_X_Y = "Input begin of the way (x, y):";
    private static final String END_OF_THE_WAY_X_Y = "Input end of the way (x, y):";
    private static final String BFS_DFS_0_1 = "Choose the type of MazeSolver: BFS/DFS(0/1):";

    private final static int WALL = 1;
    private final static int WAY = 2;

    private static final String PRINT_WALL = "███";
    private static final String PRINT_EMPTY = "   ";

    private static final String PRINT_WAY = " ◆ ";


    private static final Logger LOGGER = LogManager.getLogger(MazeGame.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    public void startMazeGenerate() {
        LOGGER.info(WIDTH_AND_HEIGHT_OF_MAZE);
        int[] mazeSize = inputMaze();

        LOGGER.info(BEGIN_OF_THE_WAY_X_Y);
        int[] begin = inputMaze();
        MazeCell beginCell = new MazeCell(begin[0], begin[1]);

        LOGGER.info(END_OF_THE_WAY_X_Y);
        int[] end = inputMaze();
        MazeCell endCell = new MazeCell(end[0], end[1]);

        Maze maze = new Maze(mazeSize[0], mazeSize[1]);
        BFSMazeGenerator.mazeGenerate(maze);

        mazePrint(maze.mazeMatrix);

        int[][] solvedMaze = mazeSolving(maze, beginCell, endCell);

        mazePrint(solvedMaze);

    }

    private static int[][] mazeSolving(Maze maze, MazeCell startCell, MazeCell finishCell) {
        LOGGER.info(BFS_DFS_0_1);
        int mazeSolverType = SCANNER.nextInt();

        int[][] solvedMaze = new int[0][0];
        switch (mazeSolverType) {
            case 0:
                solvedMaze = BFSMazeSolver.mazeSolverBFS(startCell, finishCell, maze);
                break;
            case 1:
                solvedMaze = DFSMazeSolver.mazeSolverDFS(startCell, finishCell, maze);
                break;
            default:
                break;
        }
        return solvedMaze;
    }

    private static int[] inputMaze() {
        int[] mazeStats = new int[2];

        int value1 = SCANNER.nextInt();
        int value2 = SCANNER.nextInt();

        mazeStats[0] = value1;
        mazeStats[1] = value2;

        return mazeStats;
    }

    public static ArrayList<String> mazePrint(int[][] mazeMatrix) {
        ArrayList<String> renderMazeMatrix = new ArrayList<>();
        for (int[] line : mazeMatrix) {
            String mazeLine = createMazeLine(line);
            LOGGER.info(mazeLine);
            renderMazeMatrix.add(mazeLine);
        }
        return renderMazeMatrix;
    }

    private static String createMazeLine(int[] mazeLine) {
        StringBuilder resultMazeLine = new StringBuilder();

        for (int mazeCell : mazeLine) {
            if (mazeCell == 1) {
                resultMazeLine.append(PRINT_WALL);
            } else if (mazeCell == 2) {
                resultMazeLine.append(PRINT_WAY);
            } else {
                resultMazeLine.append(PRINT_EMPTY);
            }
        }
        return resultMazeLine.toString();
    }
}
