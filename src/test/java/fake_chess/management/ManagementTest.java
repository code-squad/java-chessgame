package fake_chess.management;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fake_chess.board.Board;
import fake_chess.management.Management;
import fake_chess.piece.Piece.Color;

public class ManagementTest {

	@Test
	public void scoreCalculator() throws Exception {
		Board board = new Board();
		board.initialize();
		assertEquals(Double.valueOf(38), Management.scoreCalculator(board.getRank(), Color.BLACK));
	}
}
