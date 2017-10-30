package chess.model.piece;

public abstract class Piece {
	public enum Color {
		BLACK, WHITE, NONE;
		String s;
	}
	
	protected Position position;
	protected Color color;
	protected char represent;

	public Piece(Position pos, Color color, char represent) {
		this.position = pos;
		this.color = color;
		this.represent = represent;
	}

	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}

	public boolean isWhite() {
		return color.equals(Color.WHITE);
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

	public void move(Position position) {
		this.position = position;
	}

}
