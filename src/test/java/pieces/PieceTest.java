package pieces;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PieceTest {
	Piece piece;

	@Test
	public void getColorTest() throws Exception {
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
		verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
		verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
	}
	
	@Test
	public void checkColorTest() throws Exception {
		Piece black = new Piece(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
		assertTrue(black.isBlack());
		Piece white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
		assertTrue(white.isWhite());
	}

	private void verifyPawn(final String color, final String representation) {
		Piece piece = new Piece(color, representation);
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
	}
}
