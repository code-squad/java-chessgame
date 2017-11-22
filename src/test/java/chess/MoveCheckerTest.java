package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidMoveException;

public class MoveCheckerTest {
	private MoveChecker moveChecker = new MoveChecker();
	private Location a1 = new Location("A1");
	private Location a2 = new Location("A2");
	private Location a3 = new Location("A3");
	private Location b1 = new Location("B1");
	private Location b2 = new Location("B2");
	private Location b3 = new Location("B3");
	private Location c1 = new Location("C1");
	private Location c2 = new Location("C2");
	private Location c3 = new Location("C3");
	private Location d1 = new Location("D1");

	@Test
	public void moveDistanceTest() {
		assertEquals(1, moveChecker.rowDistance(b2, b3));
		assertEquals(4, moveChecker.rowDistance(b2, new Location("B6")));
		assertEquals(1, moveChecker.columnDistance(b2, c2));
		assertEquals(5, moveChecker.columnDistance(b2, new Location("G3")));
	}

	@Test
	public void moveCheckerTest() {
		// 4방향
		assertEquals("S", moveChecker.getDirectionMoveLocation(b2, b3));
		assertEquals("E", moveChecker.getDirectionMoveLocation(b2, c2));
		assertEquals("N", moveChecker.getDirectionMoveLocation(b2, b1));
		assertEquals("W", moveChecker.getDirectionMoveLocation(b2, a2));
		// 4방향 2이상
		assertEquals("S", moveChecker.getDirectionMoveLocation(b2, new Location("B4")));
		assertEquals("E", moveChecker.getDirectionMoveLocation(b2, new Location("D2")));
		assertEquals("N", moveChecker.getDirectionMoveLocation(b3, b1));
		assertEquals("W", moveChecker.getDirectionMoveLocation(c2, a2));
		// 8방향
		assertEquals("NE", moveChecker.getDirectionMoveLocation(b2, c1));
		assertEquals("SW", moveChecker.getDirectionMoveLocation(b2, a3));
		assertEquals("NW", moveChecker.getDirectionMoveLocation(b2, a1));
		assertEquals("SE", moveChecker.getDirectionMoveLocation(b2, c3));
		// 8방향 2이상
		assertEquals("NE", moveChecker.getDirectionMoveLocation(b3, d1));
		assertEquals("SW", moveChecker.getDirectionMoveLocation(c1, a3));
		assertEquals("NW", moveChecker.getDirectionMoveLocation(c3, a1));
		assertEquals("SE", moveChecker.getDirectionMoveLocation(a1, c3));

		// Knight(8개)
		assertEquals("NNE", moveChecker.getDirectionMoveLocation(b3, c1));
		assertEquals("NNW", moveChecker.getDirectionMoveLocation(b3, a1));
		assertEquals("SSE", moveChecker.getDirectionMoveLocation(b3, new Location("C5")));
		assertEquals("SSW", moveChecker.getDirectionMoveLocation(b3, new Location("A5")));
		assertEquals("NEE", moveChecker.getDirectionMoveLocation(b2, d1));
		assertEquals("NWW", moveChecker.getDirectionMoveLocation(c2, a1));
		assertEquals("SEE", moveChecker.getDirectionMoveLocation(b3, new Location("D4")));
		assertEquals("SWW", moveChecker.getDirectionMoveLocation(c3, new Location("A4")));
	}

	@Test(expected = InvalidMoveException.class)
	public void moveCheckerException() {
		moveChecker.getDirectionMoveLocation(b2, b2);
	}
}