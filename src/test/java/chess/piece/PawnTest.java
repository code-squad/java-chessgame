package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.Position;
import chess.exception.FreezeException;
import chess.piece.Piece.Color;

public class PawnTest {

	@Test
	public void create() {
		verifyPawn(Color.BLACK);
		verifyPawn(Color.WHITE);
	}

	private void verifyPawn(Color color) {
		Piece pawn;
		if (color == Color.BLACK) {
			pawn = Pawn.createBlackPawn(Position.create("a6"));
		} else {
			pawn = Pawn.createWhitePawn(Position.create("a2"));
		}
		assertEquals(color, pawn.getColor());
	}

	@Test
	public void move() {
		Piece pawn = Pawn.createWhitePawn(Position.create("a2"));
		pawn = pawn.move(Position.create("a3"));
		assertEquals(0, pawn.getXPosition());
		assertEquals(2, pawn.getYPosition());
	}

	@Test(expected = FreezeException.class)
	public void canNotGo() {
		Piece pawn = Pawn.createWhitePawn(Position.create("a2"));
		pawn = pawn.move(Position.create("b2"));
	}
}
