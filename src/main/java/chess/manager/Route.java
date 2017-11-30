package chess.manager;

public class Route {
	public enum ChessRoute {
		N(0, 1), NE(1, 1), E(1, 0), SE(1, -1), S(0, -1), SW(-1, -1), W(-1, 0), NW(-1, 1);

		private int xPosition;
		private int yPosition;

		private ChessRoute(int x, int y) {
			this.xPosition = x;
			this.yPosition = y;
		}

		public int getxPosition() {
			return xPosition;
		}

		public int getyPosition() {
			return yPosition;
		}

		@Override
		public String toString() {
			return xPosition + "," + yPosition;
		}
	}

	public enum KnightRoute {
		NNE(1, 2), NEE(2, 1), SEE(2, -1), SSE(1, -2), SSW(-1, -2), SWW(-2, -1), NWW(-2, 1), NNW(-1, 2);

		private int yPosition;
		private int xPosition;

		private KnightRoute(int x, int y) {
			xPosition = x;
			yPosition = y;
		}

		public int getxPosition() {
			return xPosition;
		}

		public int getyPosition() {
			return yPosition;
		}

		@Override
		public String toString() {
			return xPosition + "," + yPosition;
		}
	}
}
