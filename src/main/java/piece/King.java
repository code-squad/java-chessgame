package piece;

import static org.junit.Assert.assertEquals;

import chess.Location;
import chess.MoveChecker;
import chess.Movement;
import exception.InvalidColorException;

public class King implements Piece {
	private String color;
	private MoveChecker moveChecker = new MoveChecker();

	public King(String color) {
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
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'k';
		if ("black".equals(color))
			return 'K';
		throw new InvalidColorException("잘못된 Kinght의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return moveChecker.isMovable(currentLocation, moveLocation);
	}
}