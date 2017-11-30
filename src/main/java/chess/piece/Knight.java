package chess.piece;

import chess.board.Position;
import chess.exception.FreezeException;
import chess.manager.Route.KnightRoute;

public class Knight extends Piece {

	private Knight(Type type, Color color, Position position) {
		super(type, color, position);
	}

	@Override
	public Piece move(Position position) {
		KnightRoute[] kinghtRoute = KnightRoute.values();
		for (KnightRoute index : kinghtRoute) {
			if ((index.getxPosition() == this.getXPosition() - position.getXPosition())
					&& (index.getyPosition() == this.getYPosition() - position.getYPosition()))
				return new Knight(this.getType(), this.getColor(), position);
		}
		throw new FreezeException("해당위치로 움직일 수 없습니다.");
	}

	public static Piece createBlackKnight(int no) {
		if (no == 0) {
			return new Knight(Type.KNIGHT, Color.BLACK, Position.setup(1, 7));
		}
		return new Knight(Type.KNIGHT, Color.BLACK, Position.setup(6, 7));
	}

	public static Piece createWhiteKnight(int no) {
		if (no == 0) {
			return new Knight(Type.KNIGHT, Color.WHITE, Position.setup(1, 0));
		}
		return new Knight(Type.KNIGHT, Color.WHITE, Position.setup(6, 0));
	}

}
