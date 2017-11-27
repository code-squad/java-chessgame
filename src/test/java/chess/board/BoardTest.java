package chess.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardTest {

	private static final Logger log = LoggerFactory.getLogger(BoardTest.class);

	@Test
	public void create() {
		Board board = new Board();
		board.create();
		log.debug("현재 board의 모양 {}", board.show());
		assertEquals("RNBQKBNR\n" + "PPPPPPPP\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "pppppppp\n" + "rnbqkbnr\n", board.show());
	}

	@Test
	public void createEmptyBoard() {
		Board board = new Board();
		board.emptyBoard();
		log.debug("현재 board의 모양 {}", board.show());
		assertEquals("........\n" + "........\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "........\n" + "........\n", board.show());
	}

	@Test
	public void testName() throws Exception {
		Board board = new Board();
		board.create();
		board.moveTest(Position.create("a1"), Position.create("a5"));
	}
}
