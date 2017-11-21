package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidMoveException;

public class PawnMoveRuleTest {
	private Board board;
	
	@Before
	public void boardSetup() {
		board = new Board();
		board.initialize();
	}
	
	@Test
	public void pawnMoveTest() {
//		assertEquals(
//		appendNewLine("........") + 
//		appendNewLine("pppppppp") + 
//		appendNewLine("........") + 
//		appendNewLine("........") + 
//		appendNewLine("........") + 
//		appendNewLine("........") + 
//		appendNewLine("pppppppp") + 
//		appendNewLine("........"), board.showBoard());
		board.move("B2", "B4");
		assertEquals(
		appendNewLine("........") + 
		appendNewLine("p.pppppp") + 
		appendNewLine("........") + 
		appendNewLine(".p......") + 
		appendNewLine("........") + 
		appendNewLine("........") + 
		appendNewLine("pppppppp") + 
		appendNewLine("........"), board.showBoard());
	}
	
	@Test(expected = InvalidMoveException.class)
	public void pawnMoveExceptionTest() {
//		assertEquals(
//				appendNewLine("........") + 
//				appendNewLine("pppppppp") + 
//				appendNewLine("........") + 
//				appendNewLine("........") + 
//				appendNewLine("........") + 
//				appendNewLine("........") + 
//				appendNewLine("pppppppp") + 
//				appendNewLine("........"), board.showBoard());
		board.move("B2", "C3");
	}
	
	private String appendNewLine(String value) {
		return value + "\n";
	}
}
