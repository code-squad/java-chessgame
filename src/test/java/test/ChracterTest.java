package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.management.Position;

public class ChracterTest {
	
	private static final Logger log = LoggerFactory.getLogger(ChracterTest.class);

	@Test
	public void test() {
		String source = "a2";
		String target = "a3";
		Position p1 = Position.create(source);
		Position p2 = Position.create(target);
		
		log.debug("p1의 값 : {}", p1);
		log.debug("p2의 값 : {}", p2);
	}

}
