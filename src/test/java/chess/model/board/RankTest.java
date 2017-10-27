package chess.model.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankTest {

	@Test
	public void 검은색_말들() {
		Rank rank = Rank.createBlackPieces();
		assertEquals("nrbqkrbn", rank.getRepresents());
	}

	@Test
	public void 검은색_폰들() {
		Rank rank = Rank.createBlackPawns();
		assertEquals("pppppppp", rank.getRepresents());
	}

	@Test
	public void 흰색_폰들() {
		Rank rank = Rank.createWhitePawns();
		assertEquals("PPPPPPPP", rank.getRepresents());
	}

	@Test
	public void 흰색_말들() {
		Rank rank = Rank.createWhitePieces();
		assertEquals("NRBQKRBN", rank.getRepresents());
	}

	@Test
	public void 빈칸들() {
		Rank rank = Rank.createBlank(5);
		assertEquals("        ", rank.getRepresents());
	}

}
