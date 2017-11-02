package chess.model.piece;

import chess.model.piece.move.UnlimitedMoveStractegy;

public class Bishop extends Piece {

	private Bishop(Position pos, Color color) {
		super(pos, color, 'b', 3, Direction.bishopDirections(), new UnlimitedMoveStractegy());
	}
	
	public static Bishop createBlack(Position pos) {
		return new Bishop(pos, Color.BLACK);
	}
	
	public static Bishop createWhite(Position pos) {
		return new Bishop(pos, Color.WHITE);
	}
	
}
