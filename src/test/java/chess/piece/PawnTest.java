package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

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
			pawn = Pawn.createBlackPawn(0);
		} else {
			pawn = Pawn.createWhitePawn(0);
		}
		assertEquals(color, pawn.getColor());
	}

	@Test
	public void getPosition() {
		Piece pawn = Pawn.createWhitePawn(4);
		assertEquals(4, pawn.getXPosition());
		assertEquals(1, pawn.getYPosition());
	}
}
