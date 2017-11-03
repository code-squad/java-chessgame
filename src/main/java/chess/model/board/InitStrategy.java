package chess.model.board;

import java.util.List;

public interface InitStrategy {
	public List<Rank> setup();
}
