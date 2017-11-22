package piece;

import chess.Location;

public interface Piece {
	String getColor();
	char getRepresentation();
	boolean isMoveable(Location currentLocation, Location moveLocation);
}
