package chess.piece;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BishopTest {

	private static final Logger log = LoggerFactory.getLogger(BishopTest.class);

	@Test
	public void getBishopPosition() {
		Piece whiteBishop0 = Bishop.createWhiteBishop(0);
		Piece whiteBishop1 = Bishop.createWhiteBishop(1);
		Piece blackBishop0 = Bishop.createBlackBishop(0);
		Piece blackBishop1 = Bishop.createBlackBishop(1);

		assertEquals(2, whiteBishop0.getXPosition());
		log.debug("whiteBishop0의 위치 : {}", whiteBishop0.getPosition());
		log.debug("whiteBishop1의 위치 : {}", whiteBishop1.getPosition());
		log.debug("blackBishop0의 위치 : {}", blackBishop0.getPosition());
		log.debug("blackBishop1의 위치 : {}", blackBishop1.getPosition());
	}

}
