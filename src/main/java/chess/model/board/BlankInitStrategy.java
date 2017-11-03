package chess.model.board;

import java.util.ArrayList;
import java.util.List;

public class BlankInitStrategy implements InitStrategy {

	@Override
	public List<Rank> setup() {
		List<Rank> ranks = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.createBlank(i));
		}
		return ranks;
	}
}
