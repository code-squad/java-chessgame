package chess.piece;

import java.util.ArrayList;
import java.util.List;

import chess.board.Position;

public abstract class Piece implements Moveable {

	public enum Color {
		WHITE, BLACK, NO_COLOR;
	}

	public enum Type {
		PAWN("P", 1.0), ROOK("R", 5.0), KNIGHT("N", 2.5), BISHOP("B", 3.0), QUEEN("Q", 9.0), KING("K", 0.0), BLANK(".",
				0.0);

		private String expression;
		private Double score;

		private Type(String representation) {
			this.expression = representation;
		}

		private Type(String representation, Double score) {
			this.expression = representation;
			this.score = score;
		}

		public String getBlankExpression() {
			return expression;
		}

		public Double getScore() {
			return score;
		}

		public String getExpression(Color color) {
			if (color == Color.WHITE) {
				return expression.toLowerCase();
			}
			return expression;
		}
	}

	public enum Score {
		PAWN(1.0), ROOK(5.0), KINIGHT(2.5), BISHOP(3.0), QUEEN(9.0), KING(0.0);

		private Double score;

		private Score(Double score) {
			this.score = score;
		}

		public Double getScore() {
			return score;
		}
	}

	private Color color;
	private Type type;
	private String expression;
	private Double score;
	private Position position;
	private List<Position> positions;

	public Piece(Type type, Color color, Position position) {
		this.type = type;
		this.color = color;
		this.expression = type.getExpression(color);
		this.score = type.getScore();
		this.position = position;
		this.positions = new ArrayList<>();
	}

	public Piece(Type type, Color color) {
		this.type = type;
		this.color = color;
		this.expression = type.getExpression(color);
		this.score = type.getScore();
	}

	public static Piece createWhiteRook(int no) {
		return Rook.create(Type.ROOK, Color.WHITE, no);
	}

	public static Piece createWhiteBishop(int no) {
		return Bishop.create(Type.BISHOP, Color.WHITE, no);
	}

	public static Piece createWhiteKnight(int no) {
		return Knight.create(Type.KNIGHT, Color.WHITE, no);
	}

	public static Piece createWhiteQueen() {
		return Queen.create(Type.QUEEN, Color.WHITE, Position.setup(3, 0));
	}

	public static Piece createWhiteKing() {
		return King.create(Type.KING, Color.WHITE, Position.setup(4, 0));
	}

	public static Piece createWhitePawn(int xPosition) {
		return Pawn.create(Type.PAWN, Color.WHITE, Position.setup(xPosition, 1));
	}

	public static Piece createBlackRook(int no) {
		return Rook.create(Type.ROOK, Color.BLACK, no);
	}

	public static Piece createBlackKnight(int no) {
		return Knight.create(Type.KNIGHT, Color.BLACK, no);
	}

	public static Piece createBlackBishop(int no) {
		return Bishop.create(Type.BISHOP, Color.BLACK, no);
	}

	public static Piece createBlackQueen() {
		return Queen.create(Type.QUEEN, Color.BLACK, Position.setup(3, 7));
	}

	public static Piece createBlackKing() {
		return King.create(Type.KING, Color.BLACK, Position.setup(4, 7));
	}

	public static Piece createBlackPawn(int xPosition) {
		return Pawn.create(Type.PAWN, Color.BLACK, Position.setup(xPosition, 6));
	}

	public static Piece createBlank() {
		return Blank.create(Type.BLANK, Color.NO_COLOR);
	}

	@Override
	public String toString() {
		return expression;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	public Double getScore() {
		return score;
	}

	public int getXPosition() {
		return position.getXPosition();
	}

	public int getYPosition() {
		return position.getYPosition();
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (expression == null) {
			return other.expression == null;
		} else if (!expression.equals(other.expression))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public boolean isMove(Position targetPosition) {
		return positions.contains(targetPosition);
	}
}
