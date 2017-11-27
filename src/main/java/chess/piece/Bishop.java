package chess.piece;

import chess.board.Position;

public class Bishop extends Piece {

	private Bishop(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, int no) {
		if (color == Color.WHITE) {
			if (no == 0) {
				return new Bishop(type, color, Position.setup(2, 0));
			}
			return new Bishop(type, color, Position.setup(5, 0));
		}
		if (no == 1) {
			return new Bishop(type, color, Position.setup(5, 7));
		}
		return new Bishop(type, color, Position.setup(2, 7));
	}

	@Override
	public Piece move(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

}
