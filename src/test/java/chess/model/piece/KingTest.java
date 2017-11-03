package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class KingTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 검은색_킹_생성() {
		Piece piece = King.createBlack(position);
		assertEquals('k', piece.getRepresent());
	}

	@Test
	public void 흰색_킹_생성() {
		Piece piece = King.createWhite(position);
		assertEquals('K', piece.getRepresent());
	}

}
