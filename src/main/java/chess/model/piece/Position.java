package chess.model.piece;

public class Position {
	private int x;
	private int y;

	public Position(String position) {
		this.x = position.charAt(0) - 'a' + 1;
		this.y = Character.getNumericValue(position.charAt(1));
		isInable(this.x, this.y);
	}

	public Position(int x, int y) {
		this.x = x + 1;
		this.y = y + 1;
		isInable(this.x, this.y);
	}

	private void isInable(int x, int y) {
		if (x < 1 || x > 8 || y < 1 || y > 8) {
			throw new InvalidPositionException("체스판의 허용 위치가 아닙니다.( a~h, 1~8");
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXIndex() {
		return x - 1;
	}

	public int getYIndex() {
		return y - 1;
	}

	public Position ahead(Direction direction) {
		return new Position(x + direction.getxDegree() - 1, y + direction.getyDegree() - 1);
	}

	public int yGap(int y) {
		return this.y - y;
	}

	public int xGap(int x) {
		return this.x - x;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		if (x != other.x)
			return false;
		return y == other.y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
