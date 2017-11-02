package chess.model.piece.move;

import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Position;

public class BlankMoveStractegy implements MoveStrategy {

	@Override
	public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
		throw new InvalidPositionException("빈칸은 이동 할 수 없습니다.");
	}
}
