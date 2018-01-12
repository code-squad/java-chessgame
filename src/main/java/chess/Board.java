package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class Board implements Initialize {
	private List<Rank> ranks = new ArrayList<Rank>();
	
	public List<Rank> getRanks() {
		return ranks;
	}

	int getMatchCountsOfPiece(Color color, Type type) {
		int matchCountsOfPiece = 0;
		for (Rank rank : ranks) {
			matchCountsOfPiece += rank.getCountsOfPiece(color, type);
		}
		return matchCountsOfPiece;
	}

	@Override
	public void initialize() {
		ranks.add(Rank.initializeBlackPieces(8));
		ranks.add(Rank.initializeBlackPawns(7));
		ranks.add(Rank.initializeBlank(6));
		ranks.add(Rank.initializeBlank(5));
		ranks.add(Rank.initializeBlank(4));
		ranks.add(Rank.initializeBlank(3));
		ranks.add(Rank.initializeWhitePawns(2));
		ranks.add(Rank.initializeWhitePieces(1));
	}
	
	public double calculcatePoint(Color color) {
		double point = 0;
		for (Rank rank : ranks) {
			point += rank.calculatePoint(color);
		}
		return point;
	}
}
