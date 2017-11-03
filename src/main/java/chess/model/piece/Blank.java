package chess.model.piece;

import java.util.List;

import chess.model.piece.move.MoveStrategy;


public class Blank extends Piece {

	private Blank(Position pos) {
		super(pos, Color.NONE, '.', Direction.blankDirections(), new MoveStrategy() {
			public List<Position> pathWay(Position source, Position target, List<Direction> directions) {
			throw new InvalidPositionException("빈칸은 이동 할 수 없습니다.");
		}
			});
	}
	
	public static Blank create(Position pos) {
		return new Blank(pos);
	}

	@Override
	public boolean isBlack() {
		return false;
	}
	
	@Override
	public boolean isWhite() {
		return false;
	}
}
