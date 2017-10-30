package chess.model.piece;

public class Rook extends Piece {

	private Rook(Position pos, Color color) {
		super(pos, color, 'r', 5, Direction.rookDirections());
	}

	public static Rook createBlack(Position pos) {
		return new Rook(pos, Color.BLACK);
	}
	
	public static Rook createWhite(Position pos) {
		return new Rook(pos, Color.WHITE);
	}
}
