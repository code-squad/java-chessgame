package chess.model.piece;

public abstract class Piece {
	protected Position pos;
	protected Color color;

	public Piece(Position pos, Color color) {
		this.pos = pos;
		this.color = color;
	}

	public String getColor() {
		return color.getColor();
	}
}

enum Color {
	BLACK("black"), WHITE("white");

	private String color;

	Color(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
