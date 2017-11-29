package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;

public class Pawn extends Piece {

	private Pawn(Type type, Color color, Position position) {
		super(type, color, position);
	}

	public static Piece createWhitePawn(Position position) {
		return new Pawn(Type.PAWN, Color.WHITE, position);
	}

	public static Piece createBlackPawn(Position position) {
		return new Pawn(Type.PAWN, Color.BLACK, position);
	}

	@Override
	public Piece move(Position position) {
		int x = this.getXPosition() - position.getXPosition();
		int y = this.getYPosition() - position.getYPosition();
		if (this.getColor() == Color.WHITE) {
			if (x == 0 && y == 1) {
				new Pawn(Type.PAWN, this.getColor(), position);
			}
		} else {
			if (x == 0 && y == -1) {
				new Pawn(Type.PAWN, this.getColor(), position);
			}
		}
		throw new FreezeException("폰은 해당위치로 이동할 수 없습니다.");
	}

}
