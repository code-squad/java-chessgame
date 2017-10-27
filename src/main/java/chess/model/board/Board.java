package chess.model.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Rank> ranks;

	public Board() {
		ranks = new ArrayList<>();
	}

	public void init() {
		ranks.add(Rank.createBlackPieces());
		ranks.add(Rank.createBlackPawns());
		ranks.add(Rank.createBlank(5));
		ranks.add(Rank.createBlank(4));
		ranks.add(Rank.createBlank(3));
		ranks.add(Rank.createBlank(2));
		ranks.add(Rank.createWhitePawns());
		ranks.add(Rank.createWhitePieces());
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (Rank rank : ranks) {
			sb.append(rank.getRepresents()).append("\n");
		}
		return sb.toString();
	}
}
