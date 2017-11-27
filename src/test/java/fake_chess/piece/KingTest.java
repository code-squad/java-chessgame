package fake_chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import fake_chess.piece.King;

public class KingTest {

	@Test
	public void createKing() {
		King king = King.create("white");
		assertEquals(king, King.create("white"));
	}

}
