package chess.model.piece;

import chess.model.piece.move.UnlimitedMoveStrategy;

public class Rook extends Piece {

	private Rook(Position pos, Color color) {
		super(pos, color, 'r', 5, Direction.rookDirections(), new UnlimitedMoveStrategy());
	}

	public static Rook createBlack(Position pos) {
		return new Rook(pos, Color.BLACK);
	}
	
	public static Rook createWhite(Position pos) {
		return new Rook(pos, Color.WHITE);
	}
}
