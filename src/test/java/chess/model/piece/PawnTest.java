package chess.model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {

	Position position;

	@Before
	public void setup() {
		position = new Position("c2");
	}

	@Test
	public void 흰색_폰_생성() {
		Piece piece = Pawn.createWhite(position);
		assertEquals('P', piece.getRepresent());
	}

	@Test
	public void 검은색_폰_생성() {
		Piece piece = Pawn.createBlack(position);
		assertEquals('p', piece.getRepresent());
	}

}
