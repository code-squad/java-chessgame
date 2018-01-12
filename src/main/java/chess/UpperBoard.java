package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class UpperBoard {
	private List<Rank> ranks = new ArrayList<Rank>();
	
	public void initialize(Initialize Initialize) {
		Initialize.initialize();
	}

	int getMatchCountsOfPiece(Color color, Type type) {
		int matchCountsOfPiece = 0;
		for (Rank rank : ranks) {
			matchCountsOfPiece += rank.getCountsOfPiece(color, type);
		}
		return matchCountsOfPiece;
	}
	
	public double calculcatePoint(Color color) {
		double point = 0;
		for (Rank rank : ranks) {
			point += rank.calculatePoint(color);
		}
		return point;
	}

	public List<Rank> getRanks() {
		return this.ranks;
	}
}
