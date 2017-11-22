package piece;

import chess.Location;

public interface Piece {
	String getColor();
	char getRepresentation();
	boolean isMovable(Location currentLocation, Location moveLocation);
}