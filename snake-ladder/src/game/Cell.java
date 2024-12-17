package game;

import game.cell.strategy.MoveStrategy;

public class Cell {
    public int value;
    private MoveStrategy moveStrategy = null;
    public int moveSteps = 0;
    public Player player;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int nextCell() {
        if (moveStrategy == null)
            return value - 1;
        else
            return moveStrategy.move(this) - 1;
    }

    public void draw() {
        if (player != null) {
            System.out.print(String.format(" %s - %s ", value, player.name));
        } else {
            System.out.print(String.format(" %s ", value));
            if (moveStrategy != null) {
                moveStrategy.draw();
            }
        }
    }
}
