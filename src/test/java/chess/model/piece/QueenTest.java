package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class QueenTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 검은색_퀸_생성() {
		Piece piece = Queen.createBlack(position);
		assertEquals('q', piece.getRepresent());
	}

	@Test
	public void 흰색_퀸_생성() {
		Piece piece = Queen.createWhite(position);
		assertEquals('Q', piece.getRepresent());
	}
}
