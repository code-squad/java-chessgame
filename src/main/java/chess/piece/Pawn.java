package chess.piece;

import chess.board.Position;

public class Pawn extends Piece {

	private Pawn(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, Position position) {
		return new Pawn(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

}
