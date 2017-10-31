package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 흰색_나이트_생성() {
		Piece piece = Knight.createWhite(position);
		assertEquals('N', piece.getRepresent());
	}
	
	@Test
	public void 검은색_나이트_생성() {
		Piece piece = Knight.createBlack(position);
		assertEquals('n', piece.getRepresent());
	}
}
