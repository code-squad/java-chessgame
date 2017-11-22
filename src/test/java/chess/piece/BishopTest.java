package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	@Test
	public void createBishop() {
		Bishop bishop = Bishop.create("white");
		assertEquals(bishop, Bishop.create("white"));
	}

}
