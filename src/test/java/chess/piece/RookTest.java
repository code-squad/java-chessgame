package chess.piece;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.piece.Piece.Color;
import chess.piece.Piece.Type;

public class RookTest {

	private static final Logger log = LoggerFactory.getLogger(RookTest.class);

	@Test
	public void getRookPosition() {
		Piece whiteRook0 = Rook.create(Type.ROOK, Color.WHITE, 0);
		Piece whiteRook1 = Rook.create(Type.ROOK, Color.WHITE, 1);
		Piece blackRook0 = Rook.create(Type.ROOK, Color.BLACK, 0);
		Piece blackRook1 = Rook.create(Type.ROOK, Color.BLACK, 1);

		log.debug("whiteRook0의 위치 : {}", whiteRook0.getPosition());
		log.debug("whiteRook1의 위치 : {}", whiteRook1.getPosition());
		log.debug("blackRook0의 위치 : {}", blackRook0.getPosition());
		log.debug("blackRook1의 위치 : {}", blackRook1.getPosition());
	}

}
