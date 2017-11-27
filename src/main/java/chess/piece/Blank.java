package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class Blank extends Piece {

	private Blank(Type type, Color color) {
		super(type, color);
	}

	public static Piece create(Type type, Color color) {
		return new Blank(type, color);
	}

	@Override
	public Piece move(Position position) {
		throw new FreezeException("Blank는 움직일수 없습니다.");
	}

}
