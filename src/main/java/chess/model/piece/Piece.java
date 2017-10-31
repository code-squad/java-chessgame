package chess.model.piece;

import java.util.List;

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

	public Piece(Position pos, Color color, char represent, List<Direction> directions) {
		this.position = pos;
		this.color = color;
		this.represent = represent;
		this.score = 0;
		this.directions = directions;
	}

	public Piece(Position pos, Color color, char represent, double score, List<Direction> directions) {
		this.position = pos;
		this.color = color;
		this.represent = represent;
		this.score = score;
		this.directions = directions;
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

	public void move(Position target) {
		if(!canMove(target)) {
			throw new InvalidPositionException("이동 할 수 없는 위치 입니다.");
		}
		this.position = target;
	}

	private boolean canMove(Position targetPos) {
		int xDegree = targetPos.getX() - position.getX();
		int yDegree = targetPos.getY() - position.getY();
		for (Direction direction : directions) {
			if (direction.getxDegree() == xDegree && direction.getyDegree() == yDegree) {
				return true;
			}
		}
		return false;
	}

	public Color getColor() {
		return color;
	}

	public boolean sameColor(Color color) {
		return this.color.equals(color);
	}
	
}
