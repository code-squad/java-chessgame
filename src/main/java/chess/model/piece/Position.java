package chess.model.piece;

public class Position {
	private int x;
	private int y;

	public Position(String position) {
		this.x = position.charAt(0) - 'a' + 1;
		this.y = Character.getNumericValue(position.charAt(1));
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXIndex() {
		return x - 1;
	}

	public int getYIndex() {
		return y - 1;
	}
}
