package chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RookTest {

	private static final Logger log = LoggerFactory.getLogger(RookTest.class);

	@Test
	public void createLook() {
		Rook look = Rook.create("black");
		assertEquals(look, Rook.create("black"));
	}

	@Test
	public void checkColor() {
		Rook blackRook = Rook.create("black");
		Rook whiteRook = Rook.create("white");
		log.debug("{}, {}", blackRook.equals(whiteRook));
	}

}
