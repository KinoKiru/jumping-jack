package nl.kinokiru.java;

public class Position {
    private final int x, y, index;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public Position(int index) {
        this.index = index;
        this.x = index % Board.SIZE;
        this.y = (int) Math.floor(index / Board.SIZE);
    }

    @Override
    public boolean equals(Object position) {
        return position instanceof Position && ((Position) position).index == this.index;
    }

    @Override
    public String toString() {
        return "(" + x + "-" + y + ")";
    }

}
