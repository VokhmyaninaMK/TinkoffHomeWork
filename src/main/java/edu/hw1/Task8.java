package edu.hw1;

import java.awt.Point;
import java.util.ArrayList;

public class Task8 {
    private Task8() {
    }

    private final static int SIZE_OF_BOARD = 8;

    public static boolean knightBoardCapture(int[][] chessBoard) {
        if (chessBoard.length != SIZE_OF_BOARD || chessBoard[0].length != SIZE_OF_BOARD) {
            return false;
        }
        ArrayList<Point> knightPositionArray = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_BOARD; i++) {
            for (int j = 0; j < SIZE_OF_BOARD; j++) {
                if (chessBoard[i][j] == 1) {
                    knightPositionArray.add(new Point(i, j));
                    for (int indexOfKnightPosition = 0; indexOfKnightPosition < knightPositionArray.size() - 1;
                         indexOfKnightPosition++) {
                        if (Math.abs(knightPositionArray.get(indexOfKnightPosition).x - i) == 1
                            && Math.abs(knightPositionArray.get(indexOfKnightPosition).y - j) == 2
                            || Math.abs(knightPositionArray.get(indexOfKnightPosition).x - i) == 2
                            && Math.abs(knightPositionArray.get(indexOfKnightPosition).y - j) == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
