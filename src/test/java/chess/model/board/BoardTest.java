package chess.model.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void show() {
		Board board = new Board();
		board.init();
		assertEquals("nrbqkrbn\npppppppp\n        \n        \n        \n        \nPPPPPPPP\nNRBQKRBN\n", board.show());
	}

}
