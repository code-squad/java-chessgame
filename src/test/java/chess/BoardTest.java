package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class BoardTest {
	private UpperBoard upperBoard;

	@Before
	public void setUp() {
		upperBoard = new UpperBoard();
	}

	@Test
	public void getMatchCountOfPieceTest() throws Exception {
		upperBoard.initialize(new Board());
		assertEquals(8, upperBoard.getMatchCountsOfPiece(Color.WHITE, Type.PAWN));
		assertEquals(2, upperBoard.getMatchCountsOfPiece(Color.BLACK, Type.BISHOP));
		assertEquals(2, upperBoard.getMatchCountsOfPiece(Color.WHITE, Type.KNIGHT));
		assertEquals(2, upperBoard.getMatchCountsOfPiece(Color.BLACK, Type.ROOK));
		assertEquals(1, upperBoard.getMatchCountsOfPiece(Color.WHITE, Type.KING));
		assertEquals(32, upperBoard.getMatchCountsOfPiece(Color.NO_COLOR, Type.NO_PIECE));
	}

	@Test
	public void calculcatePoint() throws Exception {
		upperBoard.initialize(new BoardForTest());

		addPiece("b6", Pawn.createBlack(null));
		addPiece("e6", Queen.createBlack(null));
		addPiece("b8", King.createBlack(null));
		addPiece("c8", Rook.createBlack(null));

		addPiece("f2", Pawn.createWhite(null));
		addPiece("g2", Pawn.createWhite(null));
		addPiece("e1", Rook.createWhite(null));
		addPiece("f1", King.createWhite(null));

		assertEquals(15.0, upperBoard.calculcatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, upperBoard.calculcatePoint(Color.WHITE), 0.01);
	}

	private void addPiece(String position, Piece piece) {
		ChessGame game = new ChessGame(upperBoard);
		game.move(new Position(position), piece);
	}
}
