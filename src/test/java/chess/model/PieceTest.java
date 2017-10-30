package chess.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.piece.Bishop;
import chess.model.piece.Blank;
import chess.model.piece.Direction;
import chess.model.piece.King;
import chess.model.piece.Knight;
import chess.model.piece.Pawn;
import chess.model.piece.Piece;
import chess.model.piece.Piece.Color;
import chess.model.piece.Position;
import chess.model.piece.Queen;
import chess.model.piece.Rook;

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

	@Test
	public void 검은색_폰_생성() {
		Piece piece = Pawn.createBlack(position);
		assertEquals('p', piece.getRepresent());
	}

	@Test
	public void 흰색_나이트_생성() {
		Piece piece = Knight.createWhite(position);
		assertEquals('N', piece.getRepresent());
	}

	@Test
	public void 검은색_퀸_생성() {
		Piece piece = Queen.createBlack(position);
		assertEquals('q', piece.getRepresent());
	}

	@Test
	public void 흰색_킹_생성() {
		Piece piece = King.createWhite(position);
		assertEquals('K', piece.getRepresent());
	}

	@Test
	public void 검은색_비숍_생성() {
		Piece piece = Bishop.createBlack(position);
		assertEquals('b', piece.getRepresent());
	}

	@Test
	public void 흰색_룩_생성() {
		Piece piece = Rook.createWhite(position);
		assertEquals('R', piece.getRepresent());
	}

	@Test
	public void 빈칸_생성() {
		Piece piece = Blank.create(position);
		assertEquals('.', piece.getRepresent());
	}
}
