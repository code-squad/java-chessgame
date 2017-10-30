package chess.model.piece;

public class Bishop extends Piece {

	private Bishop(Position pos, Color color) {
		super(pos, color, 'b', 3, Direction.bishopDirections());
	}
	
	public static Bishop createBlack(Position pos) {
		return new Bishop(pos, Color.BLACK);
	}
	
	public static Bishop createWhite(Position pos) {
		return new Bishop(pos, Color.WHITE);
	}
	
}
