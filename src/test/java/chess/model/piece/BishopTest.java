package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class BishopTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 검은색_비숍_생성() {
		Piece piece = Bishop.createBlack(position);
		assertEquals('b', piece.getRepresent());
	}

	@Test
	public void 흰색_비숍_생성() {
		Piece piece = Bishop.createWhite(position);
		assertEquals('B', piece.getRepresent());
	}

	@Test
	public void 이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Bishop.createBlack(new Position("d4")));
		board.move("d4", "a7");
	}

	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Bishop.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("a7")));
		board.move("d4", "a7");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Bishop.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("a7")));
		board.move("d4", "a7");
	}

	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Bishop.createBlack(new Position("d4")));
		board.move("d4", "d6");
	}
}
