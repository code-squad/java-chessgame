package pieces;

import static chess.Color.*;
import static chess.Name.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Color;
import chess.Name;
import pieces.Piece;

public class PieceTest {

	@Test
	public void create() {
		verifyPawn(Piece.createWhitePawn(), WHITE, PAWN.getWhiteRepresentation());
		verifyPawn(Piece.createBlackPawn(), BLACK, PAWN.getBlackRepresentation());
		verifyPawn(Piece.createWhiteKnight(), WHITE, KNIGHT.getWhiteRepresentation());
		verifyPawn(Piece.createBlackKnight(), BLACK, KNIGHT.getBlackRepresentation());
		verifyPawn(Piece.createWhiteRook(), WHITE, ROOK.getWhiteRepresentation());
		verifyPawn(Piece.createBlackRook(), BLACK, ROOK.getBlackRepresentation());
		verifyPawn(Piece.createWhiteBishop(), WHITE, BISHOP.getWhiteRepresentation());
		verifyPawn(Piece.createBlackBishop(), BLACK, BISHOP.getBlackRepresentation());
		verifyPawn(Piece.createWhiteQueen(), WHITE, QUEEN.getWhiteRepresentation());
		verifyPawn(Piece.createBlackQueen(), BLACK, QUEEN.getBlackRepresentation());
		verifyPawn(Piece.createWhiteKing(), WHITE, KING.getWhiteRepresentation());
		verifyPawn(Piece.createBlackKing(), BLACK, KING.getBlackRepresentation());
	}
	
	//파라미터가 final인 건 무슨 의미?
	public void verifyPawn(final Piece piece, final Color color, final char representation) {
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
	}
	
	@Test
	public void isWhite() {
		Piece whitePawn = Piece.createWhitePawn();
		assertTrue(whitePawn.isWhite());
		assertFalse(whitePawn.isBlack());
	}
}