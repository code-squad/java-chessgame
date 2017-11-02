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

	@Test
	public void 이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Rook.createBlack(new Position("d4")));
		board.move("d4", "d7");
	}

	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Rook.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("d7")));
		board.move("d4", "d7");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Rook.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("d7")));
		board.move("d4", "d7");
	}

	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Rook.createBlack(new Position("d4")));
		board.move("d4", "a7");
	}
}
