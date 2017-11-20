package model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {

	@Test
	public void createPawnTest() {
		verifyPawn("black");
		verifyPawn("white");
	}
	
	private void verifyPawn(final String color) {
		Pawn pawn = new Pawn(color);
		assertEquals(color, pawn.getColor());
	}
}