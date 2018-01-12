package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece.Color;

public class BoardForTest implements Initialize {
	private List<Rank> ranks = new ArrayList<Rank>();

	@Override
	public void initialize() {
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.initializeBlank(8 - i));
		}
	}
	
	public double calculcatePoint(Color color) {
		double point = 0;
		for (Rank rank : ranks) {
			point += rank.calculatePoint(color);
		}
		return point;
	}
}
