package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {
	Position position;
	
	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 검은색_비숍_생성() {
		Piece piece = Bishop.createBlack(position);
		assertEquals('b', piece.getRepresent());
	}
	
	@Test
	public void 흰색_비숍_생성() {
		Piece piece = Bishop.createWhite(position);
		assertEquals('B', piece.getRepresent());
	}
}
