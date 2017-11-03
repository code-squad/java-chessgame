package chess.model.piece.move;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class UnlimitedMoveStrategy implements MoveStrategy {

	@Override
	public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
		List<Position> aheadPositions = new ArrayList<Position>();
		Direction direction = Direction.direciton(source, target);
		if (!directions.contains(direction)) {
			throw new InvalidPositionException("이동 할 수 없는 방향 입니다.");
		}
		aheadPositions =  source.aheadPositions(direction, target);
		return aheadPositions;
	}

}
