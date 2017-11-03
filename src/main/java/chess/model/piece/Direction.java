package chess.model.piece;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH(0, 1), 
	NORTHEAST(1, 1), 
	EAST(1, 0), 
	SOUTHEAST(1, -1), 
	SOUTH(0, -1), 
	SOUTHWEST(-1, -1), 
	WEST(-1,0), 
	NORTHWEST(-1, 1),

	NNE(1, 2), 
	NNW(-1, 2), 
	SSE(1, -2), 
	SSW(-1, -2), 
	EEN(2, 1), 
	EES(2, -1), 
	WWN(-2, 1), 
	WWS(-2, -1),

	NONE(0, 0);

	private int xDegree;
	private int yDegree;

	
	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}
	
	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}

	public static List<Direction> whitePawnDirections() {
		return Arrays.asList(SOUTHWEST, SOUTH, SOUTHEAST);
	}

	public static List<Direction> blackPawnDirections() {
		return Arrays.asList(NORTHWEST, NORTH, NORTHEAST);
	}

	public static List<Direction> knightDirections() {
		return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
	}

	public static List<Direction> bishopDirections() {
		return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
	}

	public static List<Direction> rookDirections() {
		return Arrays.asList(NORTH, SOUTH, EAST, WEST);
	}

	public static List<Direction> royaltyDirections() {
		return Arrays.asList(NORTH, SOUTH, EAST, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
	}

	public static List<Direction> blankDirections() {
		return Arrays.asList(NONE);
	}

	public static Direction direciton(Position source,Position target) {
		int xDgree = target.getX() - source.getX();
		int yDgree = target.getY() - source.getY();
		if (xDgree == 0) {
			return northOrSouth(yDgree);
		}
		if (yDgree == 0) {
			return eastOrWest(xDgree);
		}
		
		if( xDgree > 0) {
			return northEastOrSouthEast(yDgree);
		}
		
		if( xDgree < 0 ) {
			return northWestOrSouthWest(yDgree);
		}

		throw new InvalidPositionException("이동 할 수 없는 위치 입니다.");
	}

	private static Direction northWestOrSouthWest(int yDgree) {
		return yDgree > 0 ? NORTHWEST : SOUTHWEST;
	}

	private static Direction northEastOrSouthEast(int yDgree) {
		return yDgree > 0 ? NORTHEAST : SOUTHEAST;
	}

	private static Direction eastOrWest(int xDgree) {
		return xDgree > 0 ? EAST : WEST;
	}

	private static Direction northOrSouth(int yDgree) {
		return yDgree > 0 ? NORTH : SOUTH;
	}

	public boolean equals(int xDegree, int yDegree) {
		return this.xDegree == xDegree && this.yDegree == yDegree;
	}

}
