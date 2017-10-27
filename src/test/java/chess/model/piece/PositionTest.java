package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void 위치로_반환_하자() {
		Position position = new Position(2, 1);
		assertEquals(2, position.getX());
		assertEquals(1, position.getY());
	}

	@Test
	public void 인덱스로_반환_하자() {
		Position position = new Position("a1");
		assertEquals(0, position.getXIndex());
		assertEquals(0, position.getYIndex());
	}

}
