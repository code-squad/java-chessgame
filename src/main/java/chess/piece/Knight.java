package chess.piece;

import chess.board.Position;

public class Knight extends Piece {

	private Knight(Type type, Color color, Position position) {
		super(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		return new Knight(this.getType(), this.getColor(), position);
	}

	public static Piece createBlackKnight(int no) {
		if (no == 0) {
			return new Knight(Type.KNIGHT, Color.BLACK, Position.setup(6, 7));
		}
		return new Knight(Type.KNIGHT, Color.BLACK, Position.setup(1, 7));
	}

	public static Piece createWhiteKnight(int no) {
		if (no == 0) {
			return new Knight(Type.KNIGHT, Color.WHITE, Position.setup(1, 0));
		}
		return new Knight(Type.KNIGHT, Color.WHITE, Position.setup(6, 0));
	}

}
