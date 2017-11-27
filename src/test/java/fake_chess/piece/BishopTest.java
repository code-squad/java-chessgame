package fake_chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import fake_chess.piece.Bishop;

public class BishopTest {

	@Test
	public void createBishop() {
		Bishop bishop = Bishop.create("white");
		assertEquals(bishop, Bishop.create("white"));
	}

}
