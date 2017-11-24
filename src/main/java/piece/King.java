package piece;

import chess.Board.Color;
import chess.Location;
import chess.MoveChecker;
import chess.Movement;
import exception.InvalidColorException;

public class King implements Piece {
	private Color color;
	private MoveChecker moveChecker = new MoveChecker();

	public King(Color color) {
		this.color = color;
		moveChecker.addRule(new Movement("S"));
		moveChecker.addRule(new Movement("E"));
		moveChecker.addRule(new Movement("N"));
		moveChecker.addRule(new Movement("W"));
		moveChecker.addRule(new Movement("NE"));
		moveChecker.addRule(new Movement("SW"));
		moveChecker.addRule(new Movement("NW"));
		moveChecker.addRule(new Movement("SE"));
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'k';
		if (Color.BLACK.equals(color))
			return 'K';
		throw new InvalidColorException("잘못된 Kinght의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return moveChecker.isMovable(currentLocation, moveLocation);
	}
}