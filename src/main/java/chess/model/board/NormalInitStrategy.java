package chess.model.board;

import java.util.ArrayList;
import java.util.List;

public class NormalInitStrategy implements InitStrategy {

	@Override
	public List<Rank> setup() {
		List<Rank> ranks = new ArrayList<Rank>();
		ranks.add(Rank.createBlackPieces());
		ranks.add(Rank.createBlackPawns());
		ranks.add(Rank.createBlank(2));
		ranks.add(Rank.createBlank(3));
		ranks.add(Rank.createBlank(4));
		ranks.add(Rank.createBlank(5));
		ranks.add(Rank.createWhitePawns());
		ranks.add(Rank.createWhitePieces());
		return ranks;
	}

}
