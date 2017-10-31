package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.board.Board;

public class PawnTest {

	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 흰색_폰_생성() {
		Piece piece = Pawn.createWhite(position);
		assertEquals('P', piece.getRepresent());
	}

	@Test
	public void 검은색_폰_생성() {
		Piece piece = Pawn.createBlack(position);
		assertEquals('p', piece.getRepresent());
	}

	@Test
	public void 이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Pawn.createBlack(new Position("d4")));
		board.move("d4", "d5");
	}

	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Pawn.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("d5")));
		board.move("d4", "d5");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Pawn.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("d5")));
		board.move("d4", "d5");
	}

	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Pawn.createBlack(new Position("d4")));
		board.move("d4", "d6");
	}

}
