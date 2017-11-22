package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {

	@Test
	public void createKing() {
		King king = King.create("white");
		assertEquals(king, King.create("white"));
	}

}
