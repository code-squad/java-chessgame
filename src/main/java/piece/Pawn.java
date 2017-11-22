package piece;

import chess.Location;
import exception.InvalidColorException;

public class Pawn implements Piece {
	private String color;

	public Pawn(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'p';
		if ("black".equals(color))
			return 'P';
		throw new InvalidColorException("잘못된 Pawn의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}