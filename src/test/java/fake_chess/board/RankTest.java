package fake_chess.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fake_chess.board.Rank;
import fake_chess.piece.Piece;
import fake_chess.piece.Piece.Type;

public class RankTest {

	@Test
	public void add() throws Exception {
		verifyPawnRank(Rank.createPawnRank(Piece.createBlack(Type.PAWN)));
		verifyPawnRank(Rank.createPawnRank(Piece.createWhite(Type.PAWN)));
		verifySpetialRank(Rank.createSpetialRank(Piece.createWhite(Type.ROOK), Piece.createWhite(Type.KNIGHT),
				Piece.createWhite(Type.BISHOP), Piece.createWhite(Type.QUEEN), Piece.createWhite(Type.KING),
				Piece.createWhite(Type.BISHOP), Piece.createWhite(Type.KNIGHT), Piece.createWhite(Type.ROOK)));
		verifyPawnRank(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		verifyPawnRank(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		verifyPawnRank(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));

	}

	private void verifySpetialRank(Rank rank) {
		assertEquals(8, rank.size());
	}

	private void verifyPawnRank(Rank rank) {
		assertEquals(8, rank.size());
	}
}
