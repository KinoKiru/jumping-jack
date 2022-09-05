package nl.kinokiru.java;

import java.util.ArrayList;

public class Board {
    final static int GOAL = 0;
    final static int SIZE = 7;
    private int[] board = { 3, 6, 4, 3, 2, 4, 3,
            2, 1, 2, 3, 2, 5, 2,
            2, 3, 4, 3, 4, 2, 3,
            2, 4, 4, 3, 4, 2, 2,
            4, 5, 1, 3, 2, 5, 4,
            4, 3, 2, 2, 4, 5, 6,
            2, 5, 2, 5, 6, 1, GOAL };

    public boolean isGoal(Position player) {
        return board[player.getIndex()] == GOAL;
    }

    public ArrayList<Position> getNeighbours(Position player) {
        int x = player.getX();
        int y = player.getY();
        int jumpLength = board[player.getIndex()];
        ArrayList<Position> neighbours = new ArrayList<>();

        if (x + jumpLength < SIZE)
            neighbours.add(new Position(jumpLength + player.getIndex()));
        if (x - jumpLength >= 0)
            neighbours.add(new Position(player.getIndex() - jumpLength));
        if (y + jumpLength < SIZE)
            neighbours.add(new Position(player.getIndex() + jumpLength * SIZE));
        if (y - jumpLength >= 0)
            neighbours.add(new Position(player.getIndex() - jumpLength * SIZE));
        return neighbours;
    }
}
