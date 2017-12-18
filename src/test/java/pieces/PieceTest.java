package pieces;

import static org.junit.Assert.*;
import org.junit.Test;
import pieces.Piece;
import pieces.Piece.Type;

public class PieceTest {

	@Test
	public void create() {
		verifyPawn(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
		verifyPawn(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
		verifyPawn(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
		verifyPawn(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
		verifyPawn(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
		verifyPawn(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

		Piece blank = Piece.createBlank();
		assertFalse(blank.isWhite());
		assertFalse(blank.isBlack());
		assertEquals(Type.NO_PIECE, blank.getType());
	}
	
	//파라미터가 final인 건 무슨 의미?
	public void verifyPawn(final Piece whitePiece, final Piece blackPiece, final Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}