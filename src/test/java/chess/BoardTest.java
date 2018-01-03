package chess;

import static org.junit.Assert.*;

import static utils.StringUtils.appendNewLine;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
    public void create() throws Exception {
        board.initialize();
        assertEquals(32, board.getPieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard());
    }
    
    @Test
    public void print() throws Exception {
        board.initialize();
        System.out.println(board.showBoard());
    }

}
