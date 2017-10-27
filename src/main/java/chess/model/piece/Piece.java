package chess.model.piece;

public abstract class Piece {
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

	public enum Color {
		BLACK, WHITE;
		String s;
	}

	public char getRepresent() {
		if (this.color.equals(Color.WHITE)) {
			return (char) (represent - 32);
		}
		return represent;
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

}
