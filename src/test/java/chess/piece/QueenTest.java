package chess.piece;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueenTest {

	private static final Logger log = LoggerFactory.getLogger(QueenTest.class);

	@Test
	public void getQueenPosition() {
		Piece whiteQueen = Piece.createWhiteQueen();
		Piece blackQueen = Piece.createBlackQueen();

		log.debug("whiteQueen의 위치 : {}", whiteQueen.getPosition());
		log.debug("blackQueen의 위치 : {}", blackQueen.getPosition());
	}

}
