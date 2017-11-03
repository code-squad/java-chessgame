package chess.model.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankTest {

	@Test
	public void 검은색_말들() {
		Rank rank = Rank.createBlackPieces();
		StringBuilder sb = new StringBuilder();
		assertEquals("rnbqkbnr", rank.status(sb).toString());
	}

	@Test
	public void 검은색_폰들() {
		Rank rank = Rank.createBlackPawns();
		StringBuilder sb = new StringBuilder();
		assertEquals("pppppppp", rank.status(sb).toString());
	}

	@Test
	public void 흰색_폰들() {
		Rank rank = Rank.createWhitePawns();
		StringBuilder sb = new StringBuilder();
		assertEquals("PPPPPPPP", rank.status(sb).toString());
	}

	@Test
	public void 흰색_말들() {
		Rank rank = Rank.createWhitePieces();
		StringBuilder sb = new StringBuilder();
		assertEquals("RNBQKBNR", rank.status(sb).toString());
	}

	@Test
	public void 빈칸들() {
		Rank rank = Rank.createBlank(5);
		StringBuilder sb = new StringBuilder();
		assertEquals("........", rank.status(sb).toString());
	}

}
