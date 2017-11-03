package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class RookTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 흰색_룩_생성() {
		Piece piece = Rook.createWhite(position);
		assertEquals('R', piece.getRepresent());
	}

	@Test
	public void 검은색_룩_생성() {
		Piece piece = Rook.createBlack(position);
		assertEquals('r', piece.getRepresent());
	}
}
