package chess.piece;

import chess.board.Position;

public class Pawn extends Piece {

	private Pawn(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece createWhitePawn(Position position) {
		return new Pawn(Type.PAWN, Color.WHITE, position);
	}

	public static Piece createBlackPawn(Position position) {
		return new Pawn(Type.PAWN, Color.BLACK, position);
	}

	@Override
	public Piece move(Position position) {
		return null;
	}

}
