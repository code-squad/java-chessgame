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
		if (this.getXPosition() - position.getXPosition() > 2 | position.getXPosition() - this.getXPosition() < -1) {
			throw new FreezeException();
		}
		if (this.getYPosition() - position.getYPosition() > 2 | position.getYPosition() - this.getYPosition() < -1) {
			throw new FreezeException();
		}
		return new King(this.getType(), this.getColor(), position);
	}

	public static Piece createBlackKing(Position setup) {
		// TODO Auto-generated method stub
		return null;
	}
}
