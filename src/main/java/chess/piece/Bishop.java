package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class Bishop extends Piece {

	private Bishop(Type type, Color color, Position position) {
		super(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		if ((this.getXPosition() != position.getXPosition() && this.getYPosition() == position.getYPosition())
				|| (this.getXPosition() == position.getXPosition() && this.getYPosition() != position.getYPosition())) {
			throw new FreezeException("해당 위치로 움직일수 없습니다.");
		}
		return new Bishop(this.getType(), this.getColor(), position);
	}

	public static Piece createBlackBishop(int no) {
		if (no == 0) {
			return new Bishop(Type.BISHOP, Color.BLACK, Position.setup(5, 7));
		}
		return new Bishop(Type.BISHOP, Color.BLACK, Position.setup(2, 7));
	}

	public static Piece createWhiteBishop(int no) {
		if (no == 0) {
			return new Bishop(Type.BISHOP, Color.WHITE, Position.setup(2, 0));
		}
		return new Bishop(Type.BISHOP, Color.WHITE, Position.setup(5, 0));
	}

}
