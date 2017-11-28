package chess.piece;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Position;
import chess.exception.FreezeException;

public class RookTest {

	private static final Logger log = LoggerFactory.getLogger(RookTest.class);

	@Test
	public void getRookPosition() {
		Piece whiteRook0 = Rook.createWhiteRook(0);
		Piece whiteRook1 = Rook.createWhiteRook(1);
		Piece blackRook0 = Rook.createBlackRook(0);
		Piece blackRook1 = Rook.createBlackRook(1);

		log.debug("whiteRook0의 위치 : {}", whiteRook0.getPosition());
		log.debug("whiteRook1의 위치 : {}", whiteRook1.getPosition());
		log.debug("blackRook0의 위치 : {}", blackRook0.getPosition());
		log.debug("blackRook1의 위치 : {}", blackRook1.getPosition());
	}

	@Test
	public void testName() throws Exception {
		Piece whiteRook = Rook.createWhiteRook(0);
		whiteRook.move(Position.create("a8"));
	}

	@Test(expected = FreezeException.class)
	public void 이동실패() throws Exception {
		Piece whiteRook = Rook.createWhiteRook(0);
		whiteRook.move(Position.create("b8"));
	}
}
