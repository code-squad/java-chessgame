package chess.model.piece;

import chess.model.piece.move.NormalMoveStrategy;

public class Knight extends Piece{

	private Knight(Position pos, Color color) {
		super(pos, color,'n', 2.5, Direction.knightDirections(), new NormalMoveStrategy());
	}
	
	public static Knight createBlack(Position pos) {
		return new Knight(pos, Color.BLACK);
	}
	
	public static Knight createWhite(Position pos) {
		return new Knight(pos, Color.WHITE);
	}
}
