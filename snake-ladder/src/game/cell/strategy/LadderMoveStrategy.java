package game.cell.strategy;

import game.Cell;

public class LadderMoveStrategy implements MoveStrategy {
    private static MoveStrategy ladderMoveStrategy;

    private LadderMoveStrategy() {

    }

    public static MoveStrategy getInstance() {
        if (ladderMoveStrategy == null)
            ladderMoveStrategy = new LadderMoveStrategy();
        return ladderMoveStrategy;
    }

    @Override
    public int move(Cell cell) {
        return cell.value + cell.moveSteps;
    }

    @Override
    public void draw() {
        System.out.print("Ladder ");
    }

}
