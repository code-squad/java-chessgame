package chess.model.piece;

public class Blank extends Piece {

	private Blank(Position pos) {
		super(pos, Color.NONE, '.', Direction.blankDirections());
	}
	
	public static Blank create(Position pos) {
		return new Blank(pos);
	}

	@Override
	public boolean isBlack() {
		return false;
	}
	
	@Override
	public boolean isWhite() {
		return false;
	}
}
