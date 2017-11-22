package piece;

import chess.Location;
import exception.InvalidColorException;

public class Queen implements Piece {
	private String color;

	public Queen(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'q';
		if ("black".equals(color))
			return 'Q';
		throw new InvalidColorException("잘못된 Queen의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}