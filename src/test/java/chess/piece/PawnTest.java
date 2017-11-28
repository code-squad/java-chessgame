package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.Position;
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
	public void getPosition() {
		Piece pawn = Pawn.createWhitePawn(Position.create("a2"));
		assertEquals(4, pawn.getXPosition());
		assertEquals(1, pawn.getYPosition());
	}
}
