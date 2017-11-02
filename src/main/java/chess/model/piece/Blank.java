package chess.model.piece;

import chess.model.piece.move.BlankMoveStractegy;

public class Blank extends Piece {

	private Blank(Position pos) {
		super(pos, Color.NONE, '.', Direction.blankDirections(), new BlankMoveStractegy());
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
