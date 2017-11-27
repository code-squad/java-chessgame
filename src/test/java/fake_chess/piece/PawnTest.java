package fake_chess.piece;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.piece.Pawn;

public class PawnTest {

	private static final Logger log = LoggerFactory.getLogger(PawnTest.class);

	@Test
	public void 초기화() {
		Pawn pawn = new Pawn("black");
		assertEquals(pawn, Pawn.createBlackPawn());
		assertEquals("black", pawn.getColor());
		log.debug("{}", pawn);
	}

	@Test
	public void 움직이기() {
		Pawn pawn = new Pawn("black");
		pawn = pawn.move("a2 a4");
		assertEquals(pawn, Pawn.createBlackPawn("a2 a4"));
	}

	@Test
	public void 공격하기() {
		Pawn blackPawn = Pawn.createBlackPawn();
		Pawn whitePawn = Pawn.createWhitePawn();
		whitePawn = whitePawn.move("a1 a2");
		blackPawn = blackPawn.move("a1 b3");
		blackPawn = blackPawn.move("b3 a2");
		// blackPawn = blackPawn.move(position)
	}

}
