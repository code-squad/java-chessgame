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
		this.position.calculatePosition(this.positions);
	}

	public Piece(Type type, Color color) {
		this.type = type;
		this.color = color;
		this.expression = type.getExpression(color);
		this.score = type.getScore();
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
		if (type != other.type)
			return false;
		return true;
	}

	public boolean isMove(Position targetPosition) {
		return positions.contains(targetPosition);
	}

	public void calculatePosition() {
		positions.add(position);
	}
}
