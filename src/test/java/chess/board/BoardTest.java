package chess.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.view.ChessResultView;

public class BoardTest {

	private static final Logger log = LoggerFactory.getLogger(BoardTest.class);

	@Test
	public void create() {
		Board board = new Board();
		board.create();
		ChessResultView result = board.result();
		log.debug("현재 board의 모양 {}", result.show());
		assertEquals("RNBQKBNR\n" + "PPPPPPPP\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "pppppppp\n" + "rnbqkbnr\n", result.show());
	}

	@Test
	public void createEmptyBoard() {
		Board board = new Board();
		board.emptyBoard();
		ChessResultView result = board.result();
		log.debug("현재 board의 모양 {}", result.show());
		assertEquals("........\n" + "........\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "........\n" + "........\n", result.show());
	}

	@Test
	public void testName() throws Exception {
		Board board = new Board();
		board.create();
		board.moveTest(Position.create("a1"), Position.create("a5"));
	}
}
