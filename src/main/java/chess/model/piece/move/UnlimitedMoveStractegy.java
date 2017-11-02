package chess.model.piece.move;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class UnlimitedMoveStractegy implements MoveStrategy {

	@Override
	public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
		List<Position> positions = new ArrayList<Position>();
		Direction direction = Direction.direciton(target.xGap(source.getX()), target.yGap(source.getY()));
		if(!directions.contains(direction)) {
			throw new InvalidPositionException("이동 할 수 없는 방향 입니다.");
		}
		Position ahead = source.ahead(direction);
		for(int i =0; i < 7; i++) {
			positions.add(ahead);
			ahead = ahead.ahead(direction);
			if(ahead.equals(target)) {
				return positions;
			}
		}
		throw new InvalidPositionException("이동 할 수 없는 방향 입니다.");
	}

}
