package chess.model.piece.move;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class NormalMoveStractegy implements MoveStrategy {

	@Override
	public boolean isValid(int xDegree, int yDegree, List<Direction> directions) {
		for (Direction direction : directions) {
			if (direction.getxDegree() == xDegree && direction.getyDegree() == yDegree) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
		if (isValid(target.getXIndex() - source.getXIndex(), target.getYIndex() - source.getYIndex(), directions)) {
			return new ArrayList<Position>();
		}
		throw new InvalidPositionException("이동 할 수 없는 위치 입니다.");
	}

}
