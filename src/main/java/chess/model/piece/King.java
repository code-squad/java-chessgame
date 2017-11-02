package chess.model.piece;

import chess.model.piece.move.NormalMoveStrategy;

public class King extends Piece{

	private King(Position pos, Color color) {
		super(pos, color,'k', Direction.royaltyDirections(), new NormalMoveStrategy());
	}
	
	public static King createBlack(Position pos) {
		return new King(pos, Color.BLACK);
	}
	
	public static King createWhite(Position pos) {
		return new King(pos, Color.WHITE);
	}

}
