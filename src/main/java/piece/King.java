package piece;

import chess.Location;
import exception.InvalidColorException;

public class King implements Piece {
	private String color;

	public King(String color) {
		this.color = color;
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
		return true;
	}
}