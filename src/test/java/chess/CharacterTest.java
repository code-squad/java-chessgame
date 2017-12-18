package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {
	
	@Test
	public void whitespace() {
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
	}

	@Test
	public void identifier() {
		assertFalse(Character.isJavaIdentifierPart('^')); //자바식별자 아님
		assertTrue(Character.isJavaIdentifierPart('a')); //자바식별자 맞음
		assertTrue(Character.isJavaIdentifierPart('_'));
		assertTrue(Character.isJavaIdentifierPart('$'));
		assertTrue(Character.isJavaIdentifierPart('1'));
		assertFalse(Character.isJavaIdentifierPart('-'));
		assertFalse(Character.isJavaIdentifierPart('*'));
		assertTrue(Character.isJavaIdentifierStart('$'));
		assertTrue(Character.isJavaIdentifierStart('_'));
		assertFalse(Character.isJavaIdentifierStart('1'));
	}

}
