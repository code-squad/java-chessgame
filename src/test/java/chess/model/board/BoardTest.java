package chess.model.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.piece.Bishop;
import chess.model.piece.Blank;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Pawn;
import chess.model.piece.Piece.Color;
import chess.model.piece.Position;
import chess.model.piece.Rook;

public class BoardTest {
	Board board;

	@Before
	public void setup() {
		board = new Board();
		board.init(new NormalInitStrategy());
	}

	@Test
	public void 체스판_생성() {
		board.init(new NormalInitStrategy());
		assertEquals("RNBQKBNR\nPPPPPPPP\n........\n........\n........\n........\npppppppp\nrnbqkbnr\n", board.status());
	}

	@Test
	public void 빈_체스판_생성() {
		board.init(new BlankInitStrategy());
		assertEquals("........\n........\n........\n........\n........\n........\n........\n........\n", board.status());
	}

	@Test
	public void findPiece() {
		board.init(new NormalInitStrategy());
		assertEquals(Pawn.createWhite(new Position("a7")), board.findPiece("a7"));
		assertEquals(Bishop.createBlack(new Position("f1")), board.findPiece("f1"));
		assertEquals(Rook.createWhite(new Position("h8")), board.findPiece("h8"));
		assertEquals(Pawn.createBlack(new Position("c2")), board.findPiece("c2"));
		assertEquals(Blank.create(new Position("c5")), board.findPiece("c5"));
	}

	@Test
	public void movePiece() {
		board.init(new NormalInitStrategy());
		board.move("b2", "b3");
		assertEquals(Blank.create(new Position("b2")), board.findPiece("b2"));
		assertEquals(Pawn.createBlack(new Position("b3")), board.findPiece("b3"));
	}

	@Test(expected = InvalidPositionException.class)
	public void 이동_할_수_없는_곳으로_이동() throws Exception {
		board.init(new NormalInitStrategy());
		board.move("c2", "b2");
	}

	@Test
	public void calScore() {
		board.init(new NormalInitStrategy());
		assertEquals(38, board.calScore(Color.BLACK), 0.1);
		assertEquals(38, board.calScore(Color.WHITE), 0.1);
	}
}
