package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.piece.Pawn;
import chess.model.piece.Piece;
import chess.model.piece.Position;

public class PieceTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 색_확인() {
		Piece piece = Pawn.createBlack(position);
		assertTrue(piece.isBlack());
		assertFalse(piece.isWhite());
	}

	@Test
	public void 위치_확인() {
		Piece piece = Pawn.createBlack(position);
		assertEquals(3, piece.getX());
		assertEquals(2, piece.getY());
	}

}
