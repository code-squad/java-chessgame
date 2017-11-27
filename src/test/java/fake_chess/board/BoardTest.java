package fake_chess.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.board.Board;
import fake_chess.management.Management;
import fake_chess.piece.Piece;
import fake_chess.piece.Piece.Color;
import fake_chess.piece.Piece.Type;

public class BoardTest {

	private static final Logger log = LoggerFactory.getLogger(BoardTest.class);

	Board board = new Board();

	@Before
	public void setup() {
		board = new Board();
	}

	@Test
	public void print() throws Exception {
		board.initialize();
		assertEquals(8, board.getSize());
		String blankRank = Management.appendNewLine("........");
		assertEquals(Management.appendNewLine("RNBQKBNR") + Management.appendNewLine("PPPPPPPP") + blankRank + blankRank
				+ blankRank + blankRank + Management.appendNewLine("pppppppp") + Management.appendNewLine("rnbqkbnr"),
				board.show());
	}

	@Test
	public void pieceOnBoard() throws Exception {
		board.initialize();
		assertEquals(8, board.pieceOnBoard(Type.PAWN, Color.BLACK));
	}

	@Test
	public void findPiece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlack(Type.ROOK), board.findPiece("a8"));
		assertEquals(Piece.createBlack(Type.KNIGHT), board.findPiece("b8"));
		assertEquals(Piece.createBlack(Type.BISHOP), board.findPiece("c8"));
		assertEquals(Piece.createBlack(Type.QUEEN), board.findPiece("d8"));
		assertEquals(Piece.createBlack(Type.KING), board.findPiece("e8"));
		assertEquals(Piece.createBlack(Type.BISHOP), board.findPiece("f8"));
		assertEquals(Piece.createBlack(Type.KNIGHT), board.findPiece("g8"));
		assertEquals(Piece.createBlack(Type.ROOK), board.findPiece("h8"));
		assertEquals(Piece.createBlack(Type.PAWN), board.findPiece("h7"));

		assertEquals(Piece.createBlack(Type.BLANK), board.findPiece("a6"));
		assertEquals(Piece.createBlack(Type.BLANK), board.findPiece("h3"));
		assertEquals(Piece.createBlack(Type.BLANK), board.findPiece("d6"));
		assertEquals(Piece.createBlack(Type.BLANK), board.findPiece("f3"));

		assertEquals(Piece.createWhite(Type.ROOK), board.findPiece("a1"));
		assertEquals(Piece.createWhite(Type.KNIGHT), board.findPiece("b1"));
		assertEquals(Piece.createWhite(Type.BISHOP), board.findPiece("c1"));
		assertEquals(Piece.createWhite(Type.QUEEN), board.findPiece("d1"));
		assertEquals(Piece.createWhite(Type.KING), board.findPiece("e1"));
		assertEquals(Piece.createWhite(Type.BISHOP), board.findPiece("f1"));
		assertEquals(Piece.createWhite(Type.KNIGHT), board.findPiece("g1"));
		assertEquals(Piece.createWhite(Type.ROOK), board.findPiece("h1"));
		assertEquals(Piece.createWhite(Type.PAWN), board.findPiece("c2"));
	}

	@Test
	public void blankInitialize() throws Exception {
		String blankRank = Management.appendNewLine("........");
		board.blankInitialize();
		assertEquals(blankRank + blankRank + blankRank + blankRank + blankRank + blankRank + blankRank + blankRank,
				board.show());
	}

	@Test
	public void addPiece() throws Exception {
		board.blankInitialize();
		board.addPiece(Type.KING, Color.BLACK, "e8");
		assertEquals(Piece.createBlack(Type.KING), board.findPiece("e8"));
	}

	@Test
	public void move() throws Exception {
		board.initialize();
		board.move("b2", "a8");
		assertEquals(Piece.createWhite(Type.PAWN), board.findPiece("a8"));
		log.debug(board.show());
	}

	@Test
	public void caculcatePoint() {
		board.initializeEmpty();
		addPiece("b6", Piece.createBlackPawn());
		addPiece("e6", Piece.createBlackQueen());
		addPiece("b8", Piece.createBlackKing());
		addPiece("c8", Piece.createBlackRook());
		addPiece("f2", Piece.createWhitePawn());
		addPiece("f3", Piece.createWhitePawn());
		addPiece("e1", Piece.createWhiteRook());
		addPiece("f1", Piece.createWhiteKing());
		assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
		// assertEquals(6.0, board.caculcatePoint(Color.WHITE), 0.01);

		log.debug(board.show());
	}

	private void addPiece(String position, Piece piece) {
		board.move(position, piece);
	}
}
