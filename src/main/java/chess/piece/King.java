package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class King extends Piece {

	private King(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Color color, Position position) {
		return new King(Type.KING, color, position);
	}

	@Override
	public Piece move(Position position) {
		int x = this.getXPosition() - position.getXPosition();
		int y = this.getYPosition() - position.getYPosition();
		if (x < -1 || x > 1) {
			throw new FreezeException("킹이 움직일수 있는 위치 아닙니다.");
		}
		if (y < -1 || y > 1) {
			throw new FreezeException("킹이 움직일수 있는 위치 아닙니다.");
		}

		return new King(this.getType(), this.getColor(), position);
	}
}
