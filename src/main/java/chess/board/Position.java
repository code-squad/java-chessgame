package chess.board;

import chess.exception.FreezeException;

public class Position {

	private int xPosition, yPosition;

	private Position(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	private Position(String position) {
		xPosition = position.charAt(0) - 'a';
		if (xPosition < -1 | xPosition > 7) {
			throw new FreezeException();
		}
		yPosition = Character.getNumericValue(position.charAt(1)) - 1;
		if (yPosition < -1 | yPosition > 7) {
			throw new FreezeException();
		}
	}

	public static Position setup(int xPosition, int yPosition) {
		return new Position(xPosition, yPosition);
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	@Override
	public String toString() {
		return xPosition + "," + yPosition;
	}

	public static Position create(String position) {
		return new Position(position);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPosition;
		result = prime * result + yPosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xPosition != other.xPosition)
			return false;
		if (yPosition != other.yPosition)
			return false;
		return true;
	}

}
