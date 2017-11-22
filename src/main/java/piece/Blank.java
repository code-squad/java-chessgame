package piece;

import chess.Location;
import exception.PickBlankPieceException;

public class Blank implements Piece {
	private String color = "none";

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		return '.';
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		throw new PickBlankPieceException("해당 위치에 말이 존재하지 않습니다.");
	}

}