package chess.model.piece;

import chess.model.piece.move.NormalMoveStractegy;

public class Knight extends Piece{

	private Knight(Position pos, Color color) {
		super(pos, color,'n', 2.5, Direction.knightDirections(), new NormalMoveStractegy());
	}
	
	public static Knight createBlack(Position pos) {
		return new Knight(pos, Color.BLACK);
	}
	
	public static Knight createWhite(Position pos) {
		return new Knight(pos, Color.WHITE);
	}
}
