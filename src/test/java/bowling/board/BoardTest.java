package bowling.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

	@Test
	public void 보드생성() {
		Board board = Board.create();
		assertEquals("........\n" + "........\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "........\n" + "........", board.show());
	}

}
