package chess.model.piece;

public class Queen extends Piece {

	private Queen(Position pos, Color color) {
		super(pos, color, 'q', 9, Direction.royaltyDirections());
	}

	public static Queen createBlack(Position pos) {
		return new Queen(pos, Color.BLACK);
	}
	
	public static Queen createWhite(Position pos) {
		return new Queen(pos, Color.WHITE);
	}
}
