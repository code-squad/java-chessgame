package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class Rook extends Piece {

	private Rook(Type type, Color color, Position position) {
		super(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		if ((this.getXPosition() != position.getXPosition() && this.getYPosition() == position.getYPosition())
				|| (this.getXPosition() == position.getXPosition() && this.getYPosition() != position.getYPosition())) {
			return new Rook(this.getType(), this.getColor(), position);
		}
		throw new FreezeException("해당 위치로 움직일수 없습니다.");
	}

	public static Piece createBlackRook(int no) {
		if (no == 0) {
			return new Rook(Type.ROOK, Color.BLACK, Position.setup(0, 7));
		}
		return new Rook(Type.ROOK, Color.BLACK, Position.setup(7, 7));
	}

	public static Piece createWhiteRook(int no) {
		if (no == 0) {
			return new Rook(Type.ROOK, Color.WHITE, Position.setup(0, 0));
		}
		return new Rook(Type.ROOK, Color.WHITE, Position.setup(7, 0));
	}
}
