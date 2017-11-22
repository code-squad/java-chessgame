package piece;

import chess.Location;
import exception.InvalidColorException;

public class Bishop implements Piece {
	private String color;

	public Bishop(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'b';
		if ("black".equals(color))
			return 'B';
		throw new InvalidColorException("잘못된 Bishop의 색상입니다.");
	}

	@Override
	public boolean isMoveable(Location currentLocation, Location moveLocation) {
		return true;
	}
}