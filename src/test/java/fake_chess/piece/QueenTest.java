package fake_chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import fake_chess.piece.Queen;

public class QueenTest {

	@Test
	public void createQueen() {
		Queen queen = Queen.create("black");
		assertEquals(queen, Queen.create("black"));
	}

}
