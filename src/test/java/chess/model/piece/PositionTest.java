package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void 체스판의_위치로_반환() {
		Position position = new Position("b1");
		assertEquals(2, position.getX());
		assertEquals(1, position.getY());
	}

	@Test
	public void 리스트의_인덱스로_반환() {
		Position position = new Position(1, 0);
		assertEquals(1, position.getXIndex());
		assertEquals(0, position.getYIndex());
	}

	@Test(expected = InvalidPositionException.class)
	public void 체스판_범위_밖의_위치() {
		new Position("j2");
	}

}
