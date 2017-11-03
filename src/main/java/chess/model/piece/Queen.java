package chess.model.piece;

import chess.model.piece.move.UnlimitedMoveStrategy;

public class Queen extends Piece {

	private Queen(Position pos, Color color) {
		super(pos, color, 'q', 9, Direction.royaltyDirections(), new UnlimitedMoveStrategy());
	}

	public static Queen createBlack(Position pos) {
		return new Queen(pos, Color.BLACK);
	}
	
	public static Queen createWhite(Position pos) {
		return new Queen(pos, Color.WHITE);
	}
}
