package chess.piece;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Position;
import chess.piece.Piece.Color;

public class QueenTest {

	private static final Logger log = LoggerFactory.getLogger(QueenTest.class);

	@Test
	public void getQueenPosition() {
		Piece whiteQueen = Queen.create(Color.WHITE, Position.create("d1"));
		Piece blackQueen = Queen.create(Color.BLACK, Position.create("d7"));

		log.debug("whiteQueen의 위치 : {}", whiteQueen.getPosition());
		log.debug("blackQueen의 위치 : {}", blackQueen.getPosition());
	}

}
