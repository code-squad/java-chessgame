package chess.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.Position;
import chess.exception.FreezeException;

public class PositionTest {
	@Test(expected = FreezeException.class)
	public void xOver() {
		Position.create("i6");
	}

	@Test(expected = FreezeException.class)
	public void yOver() {
		Position.create("a9");
	}
	
	@Test
	public void create() {
		Position position = Position.create("b1");
		assertEquals(1, position.getXPosition());
		assertEquals(0, position.getYPosition());
	}
}
