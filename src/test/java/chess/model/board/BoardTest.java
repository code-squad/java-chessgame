package chess.model.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.piece.Blank;
import chess.model.piece.Knight;
import chess.model.piece.Pawn;
import chess.model.piece.Piece.Color;
import chess.model.piece.Position;
import chess.model.piece.Rook;

public class BoardTest {
	Board board;

	@Before
	public void setup() {
		board = new Board();
		board.init();

	}

	@Test
	public void show() {
		board.init();
		System.out.println(board.show());
		assertEquals("NRBQKRBN\nPPPPPPPP\n        \n        \n        \n        \npppppppp\nnrbqkrbn\n", board.show());
	}

	@Test
	public void findPiece() {
		board.init();
		assertEquals(new Pawn(new Position("a7"), Color.WHITE), board.findPiece("a7"));
		assertEquals(new Rook(new Position("f1"), Color.BLACK), board.findPiece("f1"));
		assertEquals(new Knight(new Position("h8"), Color.WHITE), board.findPiece("h8"));
		assertEquals(new Pawn(new Position("c2"), Color.BLACK), board.findPiece("c2"));
		assertEquals(new Blank(new Position("c5")), board.findPiece("c5"));
	}

	@Test
	public void movePiece() {
		board.init();
		board.move("b2", "b4");
		assertEquals(new Blank(new Position("b2")), board.findPiece("b2"));
		assertEquals(new Pawn(new Position("b4"), Color.BLACK), board.findPiece("b4"));
	}
}
