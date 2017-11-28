package test;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.manager.Route.ChessRoute;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

	@org.junit.Test
	public void testName() throws Exception {
		ChessRoute[] pieceRoute = ChessRoute.values();
		for (ChessRoute route : pieceRoute) {
			log.debug("{}", route.toString());
		}
		assertEquals(16, ChessRoute.values().length);
	}

}
