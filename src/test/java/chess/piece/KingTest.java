package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.Position;
import chess.exception.FreezeException;
import chess.piece.Piece.Color;
import chess.piece.Piece.Type;

public class KingTest {

	@Test
	public void getQueenPosition() {
		Piece whiteKing = Piece.createWhiteKing();
		Piece blackKing = Piece.createBlackKing();

		assertEquals(4, whiteKing.getPosition().getXPosition());
		assertEquals(0, whiteKing.getPosition().getYPosition());
		assertEquals(4, blackKing.getPosition().getXPosition());
		assertEquals(7, blackKing.getPosition().getYPosition());
	}

	@Test
	public void move() {
		Piece king = Piece.createBlackKing();
		Position targetPosition = Position.create("e7");
		king = king.move(targetPosition);
		assertEquals(4, king.getPosition().getXPosition());
		assertEquals(6, king.getPosition().getYPosition());
	}

	@Test(expected = FreezeException.class)
	public void moveException_1() {
		Piece king = Piece.createBlackKing();
		Position targetPosition = Position.create("A0");
		king.move(targetPosition);
	}

	@Test(expected = FreezeException.class)
	public void moveException_2() {
		Piece king = Piece.createBlackKing();
		Position targetPosition = Position.create("h3");
		king.move(targetPosition);
	}

	@Test(expected = FreezeException.class)
	public void moveException_3() {
		Piece king = Piece.createBlackKing();
		Position targetPosition = Position.create("f6");
		king.move(targetPosition);
	}

	@Test
	public void isMove() throws Exception {
		Piece king = King.create(Type.KING, Color.WHITE, Position.create("e1"));
		assertTrue(king.isMove(Position.create("d1")));
	}

}
