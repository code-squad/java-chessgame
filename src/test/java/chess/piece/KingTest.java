package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.Board;
import chess.board.Position;
import chess.exception.FreezeException;
import chess.manager.Manager;
import chess.piece.Piece.Color;

public class KingTest {

	@Test
	public void getQueenPosition() {
		Piece whiteKing = King.create(Color.WHITE, Position.create("e1"));
		Piece blackKing = King.create(Color.BLACK, Position.create("e8"));

		assertEquals(4, whiteKing.getPosition().getXPosition());
		assertEquals(0, whiteKing.getPosition().getYPosition());
		assertEquals(4, blackKing.getPosition().getXPosition());
		assertEquals(7, blackKing.getPosition().getYPosition());
	}

	@Test
	public void move() {
		Piece king = King.create(Color.BLACK, Position.create("e7"));
		Position targetPosition = Position.create("e7");
		king = king.move(targetPosition);
		assertEquals(4, king.getPosition().getXPosition());
		assertEquals(6, king.getPosition().getYPosition());

	}

	@Test(expected = FreezeException.class)
	public void moveException_1() {
		Piece king = King.create(Color.BLACK, Position.create("e7"));
		Position targetPosition = Position.create("A0");
		king.move(targetPosition);
	}

	@Test(expected = FreezeException.class)
	public void moveException_2() {
		Piece king = King.create(Color.BLACK, Position.create("e7"));
		Position targetPosition = Position.create("h3");
		king.move(targetPosition);
	}

	@Test(expected = FreezeException.class)
	public void moveException_3() {
		Piece king = King.create(Color.BLACK, Position.create("e8"));
		Position targetPosition = Position.create("f6");
		king.move(targetPosition);
	}

	@Test(expected = FreezeException.class)
	public void testName() {
		Board board = new Board();
		board.emptyBoard();
		Manager manager = new Manager();
		manager.addPiece(board, Position.create("e8"), King.create(Color.BLACK, Position.create("e7")));
		manager.addPiece(board, Position.create("e7"), Pawn.createBlackPawn(Position.create("e7")));
		board.move(Position.create("e8"), Position.create("e7"));
	}
	// @Test
	// public void isMove_1() throws Exception {
	// Piece king = King.create(Color.WHITE, Position.create("e1"));
	// assertTrue(king.isMove(Position.create("d1")));
	// }
}
