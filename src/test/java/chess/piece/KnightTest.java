package chess.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Position;

public class KnightTest {

	private static final Logger log = LoggerFactory.getLogger(KnightTest.class);

	@Test
	public void getKnightPosition() {
		Piece whiteKnight0 = Knight.createWhiteKnight(0);
		Piece whiteKnight1 = Knight.createWhiteKnight(1);
		Piece blackKnight0 = Knight.createBlackKnight(0);
		Piece blackKnight1 = Knight.createBlackKnight(1);

		log.debug("whiteKnight0의 위치 : {}", whiteKnight0.getPosition());
		log.debug("whiteKnight1의 위치 : {}", whiteKnight1.getPosition());
		log.debug("blackKnight0의 위치 : {}", blackKnight0.getPosition());
		log.debug("blackKnight1의 위치 : {}", blackKnight1.getPosition());
	}

	@Test
	public void move() throws Exception {
		Piece knight = Knight.createWhiteKnight(0);
		Position targetPosition = Position.create("e7");
		knight = knight.move(targetPosition);
		assertEquals(4, knight.getPosition().getXPosition());
		assertEquals(6, knight.getPosition().getYPosition());
	}

	@Test
	public void isMove() throws Exception {
		Piece knight = Knight.createBlackKnight(1);
		Position targetPosition = Position.create("e7");
		knight.calculatePosition();
		assertTrue(knight.isMove(targetPosition));
	}
}
