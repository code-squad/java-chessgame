package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	@Test
	public void createQueen() {
		Queen queen = Queen.create("black");
		assertEquals(queen, Queen.create("black"));
	}

}
