package chess.manager;

public class Route {
	public enum kingRoute {
		N(0, 1), NE(1, 1), E(1, 0), SE(1, -1), S(0, -1), SW(-1, -1), W(-1, 0), NW(-1, 1);

		private int xPosition;
		private int yPosition;

		private kingRoute(int x, int y) {
			this.xPosition = x;
			this.yPosition = y;
		}
	}

	public enum KnightRoute {
		NNE(1, 2), NEE(2, 1), SEE(2, -1), SSE(1, -2), SSW(-1, -2), SWW(-2, -1), NWW(-2, 1), NNW(-1, 2);
		private int xPosition;
		private int yPosition;

		private KnightRoute(int x, int y) {
			this.xPosition = x;
			this.yPosition = y;
		}
	}
}
