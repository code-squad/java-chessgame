package chess.piece;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Position;
import chess.exception.FreezeException;

public class KnightTest {

	private static final Logger log = LoggerFactory.getLogger(KnightTest.class);

	@Test
	public void getKnightPosition() {
		Piece whiteKnight0 = Knight.createWhiteKnight(0);
		Piece whiteKnight1 = Knight.createWhiteKnight(1);
		Piece blackKnight0 = Knight.createBlackKnight(0);
		Piece blackKnight1 = Knight.createBlackKnight(1);
		assertEquals(1, whiteKnight0.getXPosition());

		log.debug("whiteKnight0의 위치 : {}", whiteKnight0.getPosition());
		log.debug("whiteKnight1의 위치 : {}", whiteKnight1.getPosition());
		log.debug("blackKnight0의 위치 : {}", blackKnight0.getPosition());
		log.debug("blackKnight1의 위치 : {}", blackKnight1.getPosition());
	}

	@Test
	public void move() throws Exception {
		Piece knight = Knight.createWhiteKnight(0);
		knight = knight.move(Position.create("c3"));
		assertEquals(2, knight.getXPosition());
		assertEquals(2, knight.getYPosition());
	}

	@Test(expected = FreezeException.class)
	public void canNotGo() throws Exception {
		Piece knight = Knight.createWhiteKnight(0);
		knight = knight.move(Position.create("a8"));
	}

	// @Test
	// public void isMove() throws Exception {
	// Piece knight = Knight.createBlackKnight(1);
	// Position targetPosition = Position.create("e7");
	// knight.calculatePosition();
	// assertTrue(knight.isMove(targetPosition));
	// }
}
