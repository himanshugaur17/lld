package game.cell.strategy;

import game.Cell;

public interface MoveStrategy {
    int move(Cell cell);

    void draw();
}
