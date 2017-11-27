package chess.piece;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.piece.Piece.Color;
import chess.piece.Piece.Type;

public class BishopTest {

	private static final Logger log = LoggerFactory.getLogger(BishopTest.class);

	@Test
	public void getBishopPosition() {
		Piece whiteBishop0 = Bishop.create(Type.ROOK, Color.WHITE, 0);
		Piece whiteBishop1 = Bishop.create(Type.ROOK, Color.WHITE, 1);
		Piece blackBishop0 = Bishop.create(Type.ROOK, Color.BLACK, 0);
		Piece blackBishop1 = Bishop.create(Type.ROOK, Color.BLACK, 1);

		log.debug("whiteBishop0의 위치 : {}", whiteBishop0.getPosition());
		log.debug("whiteBishop1의 위치 : {}", whiteBishop1.getPosition());
		log.debug("blackBishop0의 위치 : {}", blackBishop0.getPosition());
		log.debug("blackBishop1의 위치 : {}", blackBishop1.getPosition());
	}
	
	
}
