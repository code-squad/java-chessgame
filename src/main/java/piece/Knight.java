package piece;

import chess.Location;
import exception.InvalidColorException;

public class Knight implements Piece {
	private String color;

	public Knight(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'n';
		if ("black".equals(color))
			return 'N';
		throw new InvalidColorException("잘못된 Knight의 색상입니다.");
	}

	@Override
	public boolean isMoveable(Location currentLocation, Location moveLocation) {
		return true;
	}
}