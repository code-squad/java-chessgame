package fake_chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import fake_chess.piece.Piece;
import fake_chess.piece.Piece.Color;
import fake_chess.piece.Piece.Type;

public class PiecesTest {
	@Test
	public void create() {
		verifyPawn(Piece.Color.WHITE);
		verifyPawn(Piece.Color.BLACK);
	}

	private void verifyPawn(Color color) {
		Piece Pawn = Piece.createPiece(color);
		assertEquals(color, Pawn.getColor());
	}

	@Test
	public void pieceInit() throws Exception {
		Piece whitePawn = Piece.createPiece(Type.PAWN, Color.WHITE, Type.PAWN.getRepresentation(Color.WHITE));
		Piece whiteKnight = Piece.createPiece(Type.KNIGHT, Color.WHITE, "n");
		Piece whiteRook = Piece.createPiece(Type.ROOK, Color.WHITE, Type.ROOK.getRepresentation(Color.WHITE));
		Piece whiteBishop = Piece.createPiece(Type.BISHOP, Color.WHITE, "b");
		Piece whiteQueen = Piece.createPiece(Type.QUEEN, Color.WHITE, "q");
		Piece whiteKing = Piece.createPiece(Type.KING, Color.WHITE, "k");
		Piece blackPawn = Piece.createPiece(Type.PAWN, Color.BLACK, "P");
		Piece blackRook = Piece.createPiece(Type.ROOK, Color.BLACK, "R");
		Piece blackKnight = Piece.createPiece(Type.KNIGHT, Color.BLACK, Type.KNIGHT.getRepresentation(Color.BLACK));
		Piece blackBishop = Piece.createPiece(Type.BISHOP, Color.BLACK, "B");
		Piece BlackQueen = Piece.createPiece(Type.QUEEN, Color.BLACK, Type.QUEEN.getRepresentation(Color.BLACK));
		Piece blackKing = Piece.createPiece(Type.KING, Color.BLACK, "K");
		assertEquals("p", whitePawn.getRepresentation());
		assertEquals("r", whiteRook.getRepresentation());
		assertEquals("n", whiteKnight.getRepresentation());
		assertEquals("b", whiteBishop.getRepresentation());
		assertEquals("q", whiteQueen.getRepresentation());
		assertEquals("k", whiteKing.getRepresentation());
		assertEquals("P", blackPawn.getRepresentation());
		assertEquals("R", blackRook.getRepresentation());
		assertEquals("N", blackKnight.getRepresentation());
		assertEquals("B", blackBishop.getRepresentation());
		assertEquals("Q", BlackQueen.getRepresentation());
		assertEquals("K", blackKing.getRepresentation());
	}

	@Test
	public void isColor() throws Exception {
		Piece whitePawn = Piece.createPiece(Type.PAWN, Color.WHITE, "p");
		Piece blackKing = Piece.createPiece(Type.KING, Color.BLACK, "K");
		verifyPiece(whitePawn, blackKing);
	}

	private void verifyPiece(Piece piece1, Piece piece2) {
		assertTrue(Piece.isWhite(piece1.getColor()));
		assertTrue(Piece.isBlack(piece2.getColor()));
	}

	@Test
	public void getRepresentationPerPiece() throws Exception {
		assertEquals("p", Type.PAWN.getRepresentation(Color.WHITE));
		assertEquals("P", Type.PAWN.getRepresentation(Color.BLACK));
	}

	@Test
	public void create_piece() {
		verifyPiece(Piece.createWhite(Type.PAWN), Piece.createBlack(Type.PAWN), Type.PAWN);
		verifyPiece(Piece.createWhite(Type.ROOK), Piece.createBlack(Type.ROOK), Type.ROOK);
		verifyPiece(Piece.createWhite(Type.KNIGHT), Piece.createBlack(Type.KNIGHT), Type.KNIGHT);
		verifyPiece(Piece.createWhite(Type.BISHOP), Piece.createBlack(Type.BISHOP), Type.BISHOP);
		verifyPiece(Piece.createWhite(Type.QUEEN), Piece.createBlack(Type.QUEEN), Type.QUEEN);
		verifyPiece(Piece.createWhite(Type.KING), Piece.createBlack(Type.KING), Type.KING);

	}

	private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test
	public void checkPiece의_위치() {
		Piece whitePawn1 = Piece.createWhitePawn();
		Piece whitePawn2 = Piece.createWhitePawn();
		whitePawn1.setPosition("a2");
		whitePawn2.setPosition("a3");
		assertTrue(whitePawn1.getXPosition() == whitePawn2.getXPosition());
	}
}