package chess.piece;

import chess.board.Position;

public class Rook extends Piece {

	private Rook(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, int no) {
		if (color == Color.WHITE) {
			if (no == 0) {
				return new Rook(type, color, Position.setup(0, 0));
			}
			return new Rook(type, color, Position.setup(7, 0));
		}
		if (no == 1) {
			return new Rook(type, color, Position.setup(7, 7));
		}
		return new Rook(type, color, Position.setup(0, 7));
	}

	@Override
	public Piece move(Position position) {
		return null;
	}

}
