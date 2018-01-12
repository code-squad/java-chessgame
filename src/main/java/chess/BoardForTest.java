package chess;

import java.util.ArrayList;
import java.util.List;


public class BoardForTest implements Initialize {
	private List<Rank> ranks = new ArrayList<Rank>();
	
	@Override
	public void initialize() {
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.initializeBlank(8 - i));
		}
	}
}
