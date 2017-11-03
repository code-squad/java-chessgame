package chess.model.piece.move;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class NormalMoveStrategy implements MoveStrategy {

	@Override
	public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
		if (target.isValidMove(source, directions)) {
			return new ArrayList<Position>();
		}
		throw new InvalidPositionException("이동 할 수 없는 위치 입니다.");
	}

}
