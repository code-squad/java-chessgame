package piece;

import chess.Board.Color;
import chess.Location;
import chess.MoveChecker;
import chess.Movement;
import exception.InvalidColorException;

public class Knight implements Piece {
	private Color color;
	private MoveChecker moveChecker = new MoveChecker();

	public Knight(Color color) {
		this.color = color;
		moveChecker.addRule(new Movement("NNE"));
		moveChecker.addRule(new Movement("NNW"));
		moveChecker.addRule(new Movement("SSE"));
		moveChecker.addRule(new Movement("SSW"));
		moveChecker.addRule(new Movement("NEE"));
		moveChecker.addRule(new Movement("NWW"));
		moveChecker.addRule(new Movement("SEE"));
		moveChecker.addRule(new Movement("SWW"));
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'n';
		if (Color.BLACK.equals(color))
			return 'N';
		throw new InvalidColorException("잘못된 Knight의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return moveChecker.isMovable(currentLocation, moveLocation);
	}
}