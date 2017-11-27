package chess.piece;

import chess.board.Position;

public class Queen extends Piece {

	private Queen(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, Position position) {
		return new Queen(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

}
