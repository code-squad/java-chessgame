package chess.model.piece;

public class Knight extends Piece{

	private Knight(Position pos, Color color) {
		super(pos, color,'n', 2.5, Direction.knightDirections());
	}
	
	public static Knight createBlack(Position pos) {
		return new Knight(pos, Color.BLACK);
	}
	
	public static Knight createWhite(Position pos) {
		return new Knight(pos, Color.WHITE);
	}
}
