package chess.model.piece.move;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class UnlimitedMoveStractegy implements MoveStrategy {

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
		List<Position> positions = new ArrayList<Position>();
		Direction direction = Direction.direciton(target.getXIndex() - source.getXIndex(), target.getYIndex() - source.getYIndex());
		if(!directions.contains(direction)) {
			throw new InvalidPositionException("이동 할 수 없는 방향 입니다.");
		}
		Position ahead = source.move(direction);
		for(int i =0; i < 7; i++) {
			ahead = ahead.move(direction);
			if(ahead.equals(target)) {
				return positions;
			}
			positions.add(ahead);
		}
		throw new InvalidPositionException("이동 할 수 없는 방향 입니다.");
	}

}
