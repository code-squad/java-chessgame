package fake_chess.piece;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fake_chess.piece.Knight;

public class KnightTest {

	@Test
	public void createKnight() {
		Knight knight = Knight.create("white");
		assertEquals(knight, Knight.create("white"));
	}

}
