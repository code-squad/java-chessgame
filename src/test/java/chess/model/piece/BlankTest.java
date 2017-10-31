package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlankTest {
	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 빈칸_생성() {
		Piece piece = Blank.create(position);
		assertEquals('.', piece.getRepresent());
	}
}
