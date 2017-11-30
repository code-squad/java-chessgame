package chess.piece;

import chess.board.Position;

public class Queen extends Piece {

	private Queen(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Color color, Position position) {
		return new Queen(Type.QUEEN, color, position);
	}

	public static Piece createWhiteQueen() {
		return new Queen(Type.QUEEN, Color.WHITE, Position.create("d1"));
	}

	@Override
	public Piece move(Position position) {
		return new Queen(this.getType(), this.getColor(), position);
	}
}
