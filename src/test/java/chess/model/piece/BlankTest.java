package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.BlankInitStrategy;
import chess.model.board.Board;

public class BlankTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 빈칸인지_확인() {
		Piece piece = Blank.create(position);
		assertTrue(piece.isBlank());
	}

	@Test
	public void 빈칸_생성() {
		Piece piece = Blank.create(position);
		assertEquals('.', piece.getRepresent());
	}

	@Test(expected = InvalidPositionException.class)
	public void 이동() {
		Board board = new Board();
		board.init(new BlankInitStrategy());
		board.move("d4", "d5");
	}
}
