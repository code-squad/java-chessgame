package chess.model.piece.move;

import java.util.List;

import chess.model.piece.Direction;
import chess.model.piece.Position;

public interface MoveStrategy {
	public List<Position> pathWay(Position source, Position target, List<Direction> directions);
}
