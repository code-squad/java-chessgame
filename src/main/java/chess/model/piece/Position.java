package chess.model.piece;

public class Position {
	private int x;
	private int y;
	public Position(char x, int y) {
		this.x = x - 'a';
		this.y = y - 1;
	}
}
