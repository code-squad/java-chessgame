package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class King extends Piece {

	private King(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece create(Type type, Color color, Position position) {
		return new King(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		if (this.getPosition().getXPosition() - position.getXPosition() > 2
				| position.getXPosition() - this.getPosition().getXPosition() < -1) {
			throw new FreezeException();
		}
		if (this.getPosition().getYPosition() - position.getYPosition() > 2
				| position.getYPosition() - this.getPosition().getYPosition() < -1) {
			throw new FreezeException();
		}
		return new King(this.getType(), this.getColor(), position);
	}
}
