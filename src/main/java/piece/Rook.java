package piece;

import chess.Location;
import exception.InvalidColorException;

public class Rook implements Piece {
	private String color;

	public Rook(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'r';
		if ("black".equals(color))
			return 'R';
		throw new InvalidColorException("잘못된 Rook의 색상입니다.");
	}

	@Override
	public boolean isMoveable(Location currentLocation, Location moveLocation) {
		return true;
	}
}