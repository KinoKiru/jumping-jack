package nl.kinokiru.java;

import java.util.ArrayList;

public class App {
    private Board board = new Board();

    public static void main(String[] args) {
        ArrayList<Position> path = new App().dfs(new Position(5), new ArrayList<Position>());

        if (path.isEmpty()) {
            System.out.println("No way to get to the goal from starting point");
            return;
        }
        System.out.println(path);
    }

    /**
     * @param startPoint: index where player starts
     * @param visited:    Array list of visited tiles
     * @return: path of visited places
     */
    public ArrayList<Position> dfs(Position startPoint, ArrayList<Position> visited) {
        visited.add(startPoint);
        ArrayList<Position> resolvePath = new ArrayList<>();

        // looks if point is same as the ending of the goal
        if (board.isGoal(startPoint)) {
            // add startingPoint to the resolve path
            resolvePath.add(0, startPoint);
            // return path
            return resolvePath;
        }
        // gets the list of all nearby neighbours(tiles)
        ArrayList<Position> neighbours = board.getNeighbours(startPoint);

        for (Position neighbour : neighbours) {
            // you cant visit the same tile again
            if (!visited.contains(neighbour)) {
                // go into the dfs again with neighbour as starting point
                // and add visited for backtracking
                resolvePath = dfs(neighbour, visited);

                // if the resolve path is not empty than the goal is found
                if (!resolvePath.isEmpty()) {
                    // add the start point aka start index to the front of array list
                    resolvePath.add(0, startPoint);
                    // return the path of the tiles
                    return resolvePath;
                }
            }
        }
        // if there is no resolve of the problem return empty path
        return resolvePath;
    }
}
