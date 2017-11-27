package chess.piece;

import chess.board.Position;

public class Knight extends Piece {

	private Knight(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, int no) {
		if (color == Color.WHITE) {
			if (no == 0) {
				return new Knight(type, color, Position.setup(1, 0));
			}
			return new Knight(type, color, Position.setup(6, 0));
		}
		if (no == 1) {
			return new Knight(type, color, Position.setup(6, 7));
		}
		return new Knight(type, color, Position.setup(1, 7));
	}

	@Override
	public Piece move(Position position) {
		return new Knight(this.getType(), this.getColor(), position);
	}

}
