package chess.model.piece;

import java.util.List;

import chess.model.piece.move.MoveStrategy;

public abstract class Piece {
	public enum Color {
		BLACK, WHITE, NONE;
		String s;
	}

	protected Position position;
	protected Color color;
	protected char represent;
	protected double score;
	protected List<Direction> directions;
	protected MoveStrategy move;

	public Piece(Position pos, Color color, char represent, List<Direction> directions, MoveStrategy move) {
		this.position = pos;
		this.color = color;
		this.represent = represent;
		this.score = 0;
		this.directions = directions;
		this.move = move;
	}

	public Piece(Position position, Color color, char represent, double score, List<Direction> directions,
			MoveStrategy move) {
		this.position = position;
		this.color = color;
		this.represent = represent;
		this.score = score;
		this.directions = directions;
		this.move = move;
	}

	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}

	public boolean isWhite() {
		return color.equals(Color.WHITE);
	}

	public double getScore(Color color) {
		if (this.color == color) {
			return score;
		}
		return 0;
	}

	public Position getPosition() {
		return position;
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

	public char getRepresent() {
		if (isWhite()) {
			return (char) (represent - 32);
		}
		return represent;
	}

	public int getXIndex() {
		return position.getXIndex();
	}

	public int getYIndex() {
		return position.getYIndex();
	}

	public void move(Position target) {
		this.position = target;
	}

	public Color getColor() {
		return color;
	}

	public boolean sameColor(Color color) {
		return this.color.equals(color);
	}

	public boolean isBlank() {
		return this instanceof Blank;
	}

	public List<Position> pathWay(Position targetPosition) {
		return move.pathWay(position, targetPosition, directions);
	}

	@Override
	public String toString() {
		return "Piece [position=" + position + ", color=" + color + ", represent=" + represent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + represent;
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
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (represent != other.represent)
			return false;
		return true;
	}

}
