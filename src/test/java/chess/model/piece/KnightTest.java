package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class KnightTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 흰색_나이트_생성() {
		Piece piece = Knight.createWhite(position);
		assertEquals('N', piece.getRepresent());
	}

	@Test
	public void 검은색_나이트_생성() {
		Piece piece = Knight.createBlack(position);
		assertEquals('n', piece.getRepresent());
	}

	@Test
	public void 이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Knight.createBlack(new Position("d4")));
		board.move("d4", "c6");
	}

	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Knight.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("c6")));
		board.move("d4", "c6");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Knight.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("c6")));
		board.move("d4", "c6");
	}

	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Knight.createBlack(new Position("d4")));
		board.move("d4", "d6");
	}

}
